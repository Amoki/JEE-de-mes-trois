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
import model.RecipeListModelBean;
import model.RecipeModel;
import model.UserListModelBean;
import model.UserModelBean;
import model.UserSubmissionModelBean;

@ManagedBean
@ApplicationScoped
public class AdminUserControlerBean extends UserControlerBean {
	
	@Override
	public void checkUser(LoginBean loginBean) {
		super.checkUser(loginBean);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		UserModelBean user = (UserModelBean) sessionMap.get(LOGGED_LBL);

		if(user != null && !user.getIsAdmin()){
			sessionMap.remove(LOGGED_LBL);
			sessionMap.put(ERROR_LBL, true);
		}
		else if(user == null){
			sessionMap.put(ERROR_LBL, true);
		}
	}

	public void getAllUsers(){
		ArrayList<UserModelBean> list = this.userDao.getAllUser();
		UserListModelBean userList=new UserListModelBean();

		for(UserModelBean user:list){
			userList.addUserlist(user);
		}
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();

		sessionMap.put("userlist", userList);
	}
	
	public void updateUser(UserSubmissionModelBean user){
		if(user.getSurname().matches(UserNameValidator.USERNAME_PATTERN) 
				&& user.getLastname().matches(UserNameValidator.USERNAME_PATTERN) 
				&& user.getEmail().matches(EmailValidator.EMAIL_PATTERN)
				&& user.getLogin().matches(LoginValidator.LOGIN_PATTERN)
				&& user.getAge() > 0 && user.getAge() <= 100
				&& user.getPwd() == user.getPwd2())
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
		AdminUserControlerBean controler = new AdminUserControlerBean();
		
		UserSubmissionModelBean sub = new UserSubmissionModelBean("test","test", 10,"test","test","test@test.fr");
		sub.setPwd2(sub.getPwd());
		controler.checkAndAddUser(sub);
		sub.setAdmin(true);
		
		
		sub.setAdmin(true);
		controler.updateUser(sub);
	}
}