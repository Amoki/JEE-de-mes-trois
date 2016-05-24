package model;

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
	public void setRecipeId(int recipeId) {this.recipeId = recipeId;}
	public void setUserLogin(String userLogin) {this.userLogin = userLogin;}
	public void setDate(String date) {this.date = date;}
	public void setDetail(String detail) {this.detail = detail;}
	public void setRate(int rate) {this.rate = rate;}

	@Override
	public String toString() {
		return "[RECIPE_ID]:"+this.getRecipeId()+",[USER_LOGIN]:"+this.getUserLogin()+",[DATE]:"+this.getDate()+",[DETAIL]:"+this.getDetail()+",[RATE]:"+this.getRate();
	}
	
	public static void main(String[] args) {
		CommentModel comment1 = new CommentModel(5, "JordanChase", "15/02/2017", "Recette DE GUEU LA CE", 1);
		System.out.println(comment1);
		
		CommentModel comment2 = new CommentModel(5, "Manio", "15/03/2021", "Je m'en suis mit plein le bide", 5);
		System.out.println(comment2);
		
		CommentModel comment3 = new CommentModel();
		comment3.setRecipeId(57);
		comment3.setUserLogin("Liarick");
		comment3.setDate("21/01/1994");
		comment3.setDetail("PARFAIT !");
		comment3.setRate(8);
		System.out.println(comment3);
	}
}
