package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserModelBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8913846021477010293L;
	
	private int id;
	private String lastname;
	private String firstname;
	private int age;
	private String email;
	private String login;
	private String pwd;
	private boolean admin;

	public UserModelBean() {
	}

	public UserModelBean(String lastname,String firstname,int age,String login,String pwd, String email)
	{
		this.lastname = lastname;
		this.firstname = firstname;
		this.age = age;
		this.email = email;
		this.login = login;
		this.pwd = pwd;
		this.admin = false;
	}

	public UserModelBean(String lastname,String firstname,int age,String login,String pwd, String email,boolean admin) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.age = age;
		this.email = email;
		this.login = login;
		this.pwd = pwd;
		this.admin = admin;
	}
	public UserModelBean(int id, String lastname,String firstname,int age,String login,String pwd, String email) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.age = age;
		this.email = email;
		this.login = login;
		this.pwd = pwd;
	}
	
	public UserModelBean(int id, String lastname,String firstname,int age,String login,String pwd, String email,boolean admin) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.age = age;
		this.email = email;
		this.login = login;
		this.pwd = pwd;
		this.admin = admin;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAdmin(boolean isAdmin) {
		this.admin = isAdmin;
	}
	public String getLastname() {return lastname;}
	public void setLastname(String lastname) { this.lastname = lastname;}
	public String getFirstname() { return firstname;}
	public void setFirstname(String firstname) {this.firstname = firstname;}
	public int getAge() { return age;}
	public void setAge(int age) {this.age = age;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}
	public String getPwd() {return pwd;}
	public void setPwd(String pwd) {this.pwd = pwd;}
	public boolean getIsAdmin() {return this.admin;	}
	public void setIsAdmin(boolean isAdmin) {this.admin = isAdmin;	}

	@Override
	public String toString() {
		return "[SURNAME]:"+this.getFirstname()+",[LASTNAME]:"+this.getLastname()+",[AGE]:"+this.getAge()+",[EMAIL]:"+this.getEmail()+",[LOGIN]:"+this.getLogin()+",[PWD]:"+this.getPwd()+",[EMAIL]:"+this.getEmail()+",[ISADMIN]:"+this.getIsAdmin();
	}
}