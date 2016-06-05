package model;

public class CommentModel{
	private int recId;
	private int userId;
	private String date;
	private String detail;
	private int rate;
	
	public CommentModel(){}
	
	public CommentModel(int recId, int userId, String date, String detail, int rate){
		this.recId = recId;
		this.userId = userId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		return "[RECIPE_ID]:"+this.getRecId()+",[USER_LOGIN]:"+this.getUserId()+",[DATE]:"+this.getDate()+",[DETAIL]:"+this.getDetail()+",[RATE]:"+this.getRate();
	}
}
