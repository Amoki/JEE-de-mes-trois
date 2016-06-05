package beans;

import java.sql.Date;

public class CommentModel{
	private int recId;
	private UserModelBean user;
	private Date date;
	private String content;
	private int rating;
	
	public CommentModel(){}
	
	public CommentModel(int recId, UserModelBean user, Date date, String content, int rating){
		this.recId = recId;
		this.user = user;
		this.date = date;
		this.content = content;
		this.rating = rating;
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

	public Date getDate() {
		return date;
	}

	public int getRating() {
		return rating;
	}	
	
	public void setDate(Date date) {this.date = date;}
	public void setContent(String content) {this.content = content;}
	public void setRating(int rating) {this.rating = rating;}

	@Override
	public String toString() {
		return "[RECIPE_ID]:"+this.getRecId()+",[USER_LOGIN]:"+this.getUser().getFirstname()+",[DATE]:"+this.getDate().toString()+",[CONTENT]:"+this.getContent()+",[RATE]:"+this.getRating();
	}
}
