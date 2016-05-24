package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CommentModel{
	private UserModelBean user;
	private RecipeModel recipe;
	private String date;
	private String detail;
	private int rate;
	
	public CommentModel(){}
	
	public String getUser() {return user.getLogin();}
	public String getRecipe() {return recipe.getTitle();}
	public String getDate() {return date;}	
	public String getDetail() {return detail;}	
	public String getRate() {return String.valueOf(rate);}
	public void setUser(UserModelBean user) {this.user = user;}	
	public void setRecipe(RecipeModel recipe) {this.recipe = recipe;}
	public void setDate(String date) {this.date = date;}
	public void setDetail(String detail) {this.detail = detail;}
	public void setRate(int rate) {this.rate = rate;}

	@Override
	public String toString() {
		return "[USER_LOGIN]:"+this.getUser()+",[RECIPE_NAME]:"+this.getRecipe()+",[DATE]:"+this.getDate()+",[DETAIL]:"+this.getDetail()+",[RATE]:"+this.getRate();
	}
	
	
}
