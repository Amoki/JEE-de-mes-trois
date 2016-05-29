package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped 
public class UserSubmissionModelBean extends UserModelBean{
	@Override
	public void setPwd(String pwd) {
		if(!this.getPwd().equals(pwd)){
			passwordChanged = true;

		}
		super.setPwd(pwd);	}

	private String pwd2;
	private boolean passwordChanged;

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public UserSubmissionModelBean() { }

	public UserSubmissionModelBean(String lastname,String surname,int age,String login,String pwd, String email) {
		super(lastname,surname,age,login,pwd,email);
	}

	public UserSubmissionModelBean(UserModelBean user){
		super(user.getLastname(),user.getSurname(),user.getAge(),user.getLogin(),user.getPwd(),user.getEmail());
	}

	public boolean getPasswordChanged() {
		return passwordChanged;
	}
}