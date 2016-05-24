package model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
//contrainte BEAN implements Serializable
public class UserModelBean implements Serializable{
	private String lastname;
	private String surname;
	private int age;
	private String email;
	private String login;
	private String pwd;

	private boolean isAdmin;

	//Contrainte BEAN constructeur sans paramètre
	public UserModelBean() {
	}

	public UserModelBean(String lastname,String surname,int age,String login,String pwd, String email)
	{
		this.lastname = lastname;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.login = login;
		this.pwd = pwd;
		this.isAdmin = false;
	}

	public String getLastname() {return lastname;}
	public void setLastname(String lastname) { this.lastname = lastname;}
	public String getSurname() { return surname;}
	public void setSurname(String surname) {this.surname = surname;}
	public int getAge() { return age;}
	public void setAge(int age) {this.age = age;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}
	public String getPwd() {return pwd;}
	public void setPwd(String pwd) {this.pwd = pwd;}
	public boolean getIsAdmin() {return this.isAdmin;	}
	public void setAdmin(boolean isAdmin) {this.isAdmin = isAdmin;	}

	@Override
	public String toString() {
		return "[SURNAME]:"+this.getSurname()+",[LASTNAME]:"+this.getLastname()+",[AGE]:"+this.getAge()+",[EMAIL]:"+this.getEmail()+",[LOGIN]:"+this.getLogin()+",[PWD]:"+this.getPwd()+",[EMAIL]:"+this.getEmail()+",[ISADMIN]:"+this.getIsAdmin();
	}
}