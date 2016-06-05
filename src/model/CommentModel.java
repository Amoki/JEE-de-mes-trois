package model;

public class CommentModel{
	private int recId;
	private UserModelBean user;
	private String date;
	private String detail;
	private int rate;
	
	public CommentModel(){}
	
	public CommentModel(int recId, UserModelBean user, String date, String detail, int rate){
		this.recId = recId;
		this.user = user;
		this.date = date;
		this.detail = detail;
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

	public String getDate() {
		return date;
	}	
	
	public String getDetail() {
		return detail;
	}	
	
	public int getRate() {
		return rate;
	}	
	
	public void setDate(String date) {this.date = date;}
	public void setDetail(String detail) {this.detail = detail;}
	public void setRate(int rate) {this.rate = rate;}

	@Override
	public String toString() {
		return "[RECIPE_ID]:"+this.getRecId()+",[USER_LOGIN]:"+this.getUser().getFirstname()+",[DATE]:"+this.getDate()+",[DETAIL]:"+this.getDetail()+",[RATE]:"+this.getRate();
	}
}
