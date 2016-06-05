package beans.controllers;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import beans.LoginBean;
import beans.UserModelBean;
import beans.UserSubmissionModelBean;
import validators.EmailValidator;
import validators.LoginValidator;
import validators.UserNameValidator;
import dao.fabric.DaoFabric;
import dao.instance.UserDao;

@ManagedBean
@ApplicationScoped
public class UserControllerBean {
	protected static String LOGGED_LBL = "loggedUser";
	protected static String ERROR_LBL = "connectionError";

	protected UserDao userDao;
	private int nbUsers = 0;
	
	public int getNbUsers() {
		return nbUsers;
	}

	public UserControllerBean() {
		this.userDao=DaoFabric.getInstance().createUserDao();
	}
	
	public String checkUser(LoginBean loginBean){
		UserModelBean user = this.userDao.checkUser(loginBean.getLogin(), loginBean.getPwd());
		if( user!=null){
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put(LOGGED_LBL, user);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Connection Success."));
			nbUsers++;
			return "";
		}else{ 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Connection fail."));
			return "";
		}
	}
	
	public String checkAndAddUser(UserSubmissionModelBean userSubmitted){
		if(userSubmitted.getFirstname().matches(UserNameValidator.USERNAME_PATTERN) 
				&& userSubmitted.getLastname().matches(UserNameValidator.USERNAME_PATTERN) 
				&& userSubmitted.getEmail().matches(EmailValidator.EMAIL_PATTERN)
				&& userSubmitted.getLogin().matches(LoginValidator.LOGIN_PATTERN)
				&& userSubmitted.getAge() > 0 && userSubmitted.getAge() <= 100
				&& userSubmitted.getPwd().equals(userSubmitted.getPwd2()))
		{
			this.userDao.addUser(userSubmitted);
			return "home.xhtml";
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
