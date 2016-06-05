package processing;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import validators.EmailValidator;
import validators.LoginValidator;
import validators.UserNameValidator;
import model.LoginBean;
import model.UserListModelBean;
import model.UserModelBean;
import model.UserSubmissionModelBean;

@ManagedBean
@ApplicationScoped
public class AdminUserControllerBean extends UserControllerBean {
	
	public UserSubmissionModelBean selectedUser = null;
	public Boolean isNewUser = false;
	
	public void setSelectedUser(UserSubmissionModelBean selectedUser) {
		this.selectedUser = selectedUser;
	}

	public UserSubmissionModelBean getSelectedUser() {
		return selectedUser;
	}
	
	public Boolean getIsNewUser() {
		return isNewUser;
	}

	public void setIsNewUser(Boolean isNewUser) {
		this.isNewUser = isNewUser;
	}

	public String goToAdminUsersManagement(){
		return "manageUsers.xhtml";
	}
	
	public String goToAdminRecipesManagement(){
		return "manageRecipes.xhtml";
	}
	
	public String checkUser(LoginBean loginBean) {
		super.checkUser(loginBean);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		UserModelBean user = (UserModelBean) sessionMap.get(LOGGED_LBL);

		if(user != null && !user.getAdmin()){
			sessionMap.remove(LOGGED_LBL);
			sessionMap.put(ERROR_LBL, true);
			return "admin.xhtml";
		}
		else if(user == null){
			sessionMap.put(ERROR_LBL, true);
			return "admin.xhtml";
		}
		return "adminHome.xhtml";
	}

	public ArrayList<UserModelBean> getAllUsers(){
		ArrayList<UserModelBean> list = this.userDao.getAllUser();
		UserListModelBean userList=new UserListModelBean();

		for(UserModelBean user:list){
			userList.addUserlist(user);
		}
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();

		sessionMap.put("userlist", userList);
		return list;
	}
	
	public void updateUser(UserSubmissionModelBean user){
		if(user.getFirstname().matches(UserNameValidator.USERNAME_PATTERN) 
				&& user.getLastname().matches(UserNameValidator.USERNAME_PATTERN) 
				&& user.getEmail().matches(EmailValidator.EMAIL_PATTERN)
				&& user.getLogin().matches(LoginValidator.LOGIN_PATTERN)
				&& user.getAge() > 0 && user.getAge() <= 100
				&& ((user.getPasswordChanged() && user.getPwd().equals(user.getPwd2())) || !user.getPasswordChanged()))
		{
			this.userDao.update(user);
		}
	}
	
	public void deleteUser(UserModelBean user){
		if(user != null){
			this.userDao.delete(user);
		}
	}
	
	public static void main(String[] args) {
		AdminUserControllerBean controller = new AdminUserControllerBean();
		
		UserSubmissionModelBean sub = new UserSubmissionModelBean("test","test", 10,"test","test","test@test.fr");
		sub.setPwd2(sub.getPwd());
		controller.checkAndAddUser(sub);
		sub.setAdmin(true);
		controller.updateUser(sub);
	}
	
	public void showPanel(UserModelBean user){
		if(user != null){
			isNewUser = false;
			setSelectedUser(new UserSubmissionModelBean(user));
		}
		else{
			isNewUser = true;
			setSelectedUser(new UserSubmissionModelBean());
		}
	}
	
	public void hidePanel(){
		setSelectedUser(null);
	}
	
	public void saveUser(UserSubmissionModelBean userSubmissionModelBean){
		if(isNewUser){
			checkAndAddUser(userSubmissionModelBean);
		}
		else{
			updateUser(userSubmissionModelBean);
		}
			
		hidePanel();
	}
	
	
}
