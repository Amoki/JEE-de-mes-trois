package models;

import java.sql.Date;

import beans.UserModelBean;

public class CommentModel{
	private int recId;
	private UserModelBean user;
	private Date date;
	private String content;
	private int rate;
	
	public CommentModel(){}
	
	public CommentModel(int recId, UserModelBean user, Date date, String content, int rate){
		this.recId = recId;
		this.user = user;
		this.date = date;
		this.content = content;
		this.rate = rate;
	}

	
	public int getRecId() {
		return recId;
	}

	public void setRecId(int recId) {
		this.recId = recId;
	}

	public UserModelBean getUser() {
		return user;
	}

	public void setUser(UserModelBean user) {
		this.user = user;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public int getRate() {
		return rate;
	}	
	
	public void setDate(Date date) {this.date = date;}
	public void setDetail(String detail) {this.content = detail;}
	public void setRate(int rate) {this.rate = rate;}

	@Override
	public String toString() {
		return "[RECIPE_ID]:"+this.getRecId()+",[USER_LOGIN]:"+this.getUser().getFirstname()+",[DATE]:"+this.getDate().toString()+",[DETAIL]:"+this.getContent()+",[RATE]:"+this.getRate();
	}
}
