package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserListModelBean implements Serializable {
	private List<UserModelBean> userList;
	
	public UserListModelBean() {
		userList=new ArrayList<UserModelBean>();
	}
	
	public void addUserlist(UserModelBean user){
		this.userList.add(user);
	}
	
	public List<UserModelBean> getUserList() {
		return userList;
	}
}