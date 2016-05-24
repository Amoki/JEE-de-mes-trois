package processing;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import validators.EmailValidator;
import validators.LoginValidator;
import validators.UserNameValidator;
import model.LoginBean;
import model.RecipeListModelBean;
import model.RecipeModel;
import model.UserListModelBean;
import model.UserModelBean;
import model.UserSubmissionModelBean;

@ManagedBean
@ApplicationScoped
public class AdminUserControlerBean extends UserControlerBean {
	
	private String hidePanel = "none";
	
	public String goToAdminUsersManagement(){
		return "adminUsersManagement.xhtml";
	}
	
	public String goToAdminRecipesManagement(){
		return "adminRecipesManagement.xhtml";
	}
	
	public String checkUser(LoginBean loginBean) {
		super.checkUser(loginBean);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		UserModelBean user = (UserModelBean) sessionMap.get(LOGGED_LBL);

		if(user != null && !user.getIsAdmin()){
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
		if(user.getSurname().matches(UserNameValidator.USERNAME_PATTERN) 
				&& user.getLastname().matches(UserNameValidator.USERNAME_PATTERN) 
				&& user.getEmail().matches(EmailValidator.EMAIL_PATTERN)
				&& user.getLogin().matches(LoginValidator.LOGIN_PATTERN)
				&& user.getAge() > 0 && user.getAge() <= 100
				&& user.getPwd().equals(user.getPwd2()))
		{
			this.userDao.update(user);
		}
	}
	
	public void deleteUser(UserModelBean user){
		System.out.println("DELETE");
		if(user != null){
			this.userDao.delete(user);
		}
	}
	
	public static void main(String[] args) {
		AdminUserControlerBean controler = new AdminUserControlerBean();
		
		UserSubmissionModelBean sub = new UserSubmissionModelBean("test","test", 10,"test","test","test@test.fr");
		sub.setPwd2(sub.getPwd());
		controler.checkAndAddUser(sub);
		sub.setAdmin(true);
		
		
		sub.setAdmin(true);
		controler.updateUser(sub);
	}

}
