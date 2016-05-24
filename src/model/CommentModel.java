package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CommentModel{
	private int recipeId;
	private String userLogin;
	private String date;
	private String detail;
	private int rate;
	
	public CommentModel(){}
	
	public CommentModel(int recipeId, String userLogin, String date, String detail, int rate){
		this.recipeId = recipeId;
		this.userLogin = userLogin;
		this.date = date;
		this.detail = detail;
		this.rate = rate;
	}

	public int getRecipeId() {return recipeId;}
	public String getUserLogin() {return userLogin;}
	public String getDate() {return date;}	
	public String getDetail() {return detail;}	
	public int getRate() {return rate;}	
	public void setRecipe(int recipeId) {this.recipeId = recipeId;}
	public void setUser(String userLogin) {this.userLogin = userLogin;}
	public void setDate(String date) {this.date = date;}
	public void setDetail(String detail) {this.detail = detail;}
	public void setRate(int rate) {this.rate = rate;}

	@Override
	public String toString() {
		return "[USER_LOGIN]:"+this.getUserLogin()+",[RECIPE_NAME]:"+this.getRecipeId()+",[DATE]:"+this.getDate()+",[DETAIL]:"+this.getDetail()+",[RATE]:"+this.getRate();
	}
	
	
}
