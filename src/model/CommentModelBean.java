package model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CommentModelBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private UserModelBean user;
	private RecipeModel recipe;
	private String date;
	private String detail;
	private int rate;
	
	public CommentModelBean(){}
	
	public String getUser() {return user.getLastname();}
	public String getRecipe() {return recipe.getTitle();}
	public String getDate() {return date;}	
	public String getDetail() {return detail;}	
	public String getRate() {return String.valueOf(rate);}
	public void setUser(UserModelBean user) {this.user = user;}	
	public void setRecipe(RecipeModel recipe) {this.recipe = recipe;}
	public void setDate(String date) {this.date = date;}
	public void setDetail(String detail) {this.detail = detail;}
	public void setRate(int rate) {this.rate = rate;}
}
