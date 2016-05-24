package processing;

import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import validators.AgeValidator;
import validators.EmailValidator;
import validators.LoginValidator;
import validators.UserNameValidator;
import model.LoginBean;
import model.UserModelBean;
import model.UserSubmissionModelBean;
import dao.fabric.DaoFabric;
import dao.instance.UserDao;

@ManagedBean
@ApplicationScoped
public class UserControlerBean {
	protected static String LOGGED_LBL = "loggedUser";
	protected static String ERROR_LBL = "connectionError";

	
	protected UserDao userDao;
	private int nbUsers = 0;
	
	public int getNbUsers() {
		return nbUsers;
	}

	public UserControlerBean() {
		this.userDao=DaoFabric.getInstance().createUserDao();
	}
	
	public String checkUser(LoginBean loginBean){
		UserModelBean user = this.userDao.checkUser(loginBean.getLogin(), loginBean.getPwd());
		if( user!=null){
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put(LOGGED_LBL, user);
			sessionMap.put(ERROR_LBL, false);
			nbUsers++;
			return "";
		}else{ 
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put(ERROR_LBL, true);
			return "";
		}
	}
	
	public String checkAndAddUser(UserSubmissionModelBean userSubmitted){
		if(userSubmitted.getSurname().matches(UserNameValidator.USERNAME_PATTERN) 
				&& userSubmitted.getLastname().matches(UserNameValidator.USERNAME_PATTERN) 
				&& userSubmitted.getEmail().matches(EmailValidator.EMAIL_PATTERN)
				&& userSubmitted.getLogin().matches(LoginValidator.LOGIN_PATTERN)
				&& userSubmitted.getAge() > 0 && userSubmitted.getAge() <= 100
				&& userSubmitted.getPwd().equals(userSubmitted.getPwd2()))
		{
			this.userDao.addUser(userSubmitted);
			return "menu.xhtml";
		}
		return "";
	}
	
	public void logout(UserModelBean loggedUser){
		if( loggedUser!=null){
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.remove(LOGGED_LBL);
			
			nbUsers--;
		}else{
			
		}
	}
}
