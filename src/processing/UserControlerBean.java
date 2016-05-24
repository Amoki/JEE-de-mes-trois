package processing;

import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.LoginBean;
import model.UserModelBean;
import model.UserSubmissionModelBean;
import dao.fabric.DaoFabric;
import dao.instance.UserDao;

@ManagedBean
@ApplicationScoped
public class UserControlerBean {
	private static String LOGGED_LBL = "loggedUser";
	private static String ERROR_LBL = "connectionError";
	
	private UserDao userDao;
	private int nbUsers = 0;
	
	public int getNbUsers() {
		return nbUsers;
	}

	public UserControlerBean() {
		this.userDao=DaoFabric.getInstance().createUserDao();
	}
	
	public void checkUser(LoginBean loginBean){
		UserModelBean user = this.userDao.checkUser(loginBean.getLogin(), loginBean.getPwd());
		if( user!=null){
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put(LOGGED_LBL, user);
			sessionMap.put(ERROR_LBL, false);
			nbUsers++;
		}else{ 
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put(ERROR_LBL, true);
		}
	}
	
	public String checkAndAddUser(UserSubmissionModelBean userSubmitted){
		System.out.println("titi");
		//Vérifier les propriétés de l'utilisateur
		//TODO
		//ajout de l'utilisateur à la base de données
		this.userDao.addUser(userSubmitted);
		return "menu.xhtml";
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