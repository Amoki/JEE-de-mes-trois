package dao.instance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.RecipeModel;

public class RecipesDao {
	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;

	public RecipesDao(String DB_HOST,String DB_PORT, String DB_NAME,String DB_USER,String DB_PWD) {
		dB_HOST = DB_HOST;
		dB_PORT = DB_PORT;
		dB_NAME = DB_NAME;
		dB_USER = DB_USER;
		dB_PWD = DB_PWD;
	}
	
	public void addRecipe(RecipeModel recipe) {
		// Création de la requête
		java.sql.PreparedStatement query;
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			query = connection.prepareStatement("INSERT INTO recipes VALUES(?,?,?,?,?,?)");

			query.setString(1, recipe.getTitle());
			query.setString(2,recipe.getDescription());
			query.setInt(3, recipe.getExpertise());
			query.setInt(4, recipe.getDuration());
			query.setInt(5, recipe.getNbpeople());
			query.setString(6, recipe.getType());

			query.execute();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<RecipeModel> getAllRecipes() {
		//return value
		ArrayList<RecipeModel> recipeList=new ArrayList<RecipeModel>();
		// Création de la requête
		java.sql.PreparedStatement query;
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			query = connection.prepareStatement("SELECT * FROM recipes");

			ResultSet res = query.executeQuery();

			while(res.next()){
				recipeList.add(new RecipeModel(res.getString("title"),res.getString("description"),res.getInt("expertise"),res.getInt("nbPeople"),res.getInt("duration"),res.getString("type")));
			}			

			res.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return recipeList;
	}
	
	public ArrayList<RecipeModel> getSearchedRecipes(RecipeModel recipe) {
		//return value
		ArrayList<RecipeModel> recipeList=new ArrayList<RecipeModel>();
		// Création de la requête
		java.sql.PreparedStatement query;
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			query = connection.prepareStatement("SELECT * FROM recipes where expertise = ? and nbPeople = ? and duration = ? and type = ?");
			
			query.setInt(1, recipe.getExpertise());
			query.setInt(2, recipe.getNbpeople());
			query.setInt(3, recipe.getDuration());
			query.setString(4, recipe.getType());
			
			ResultSet res = query.executeQuery();

			while(res.next()){
				recipeList.add(new RecipeModel(res.getString("title"),res.getString("description"),res.getInt("expertise"),res.getInt("nbPeople"),res.getInt("duration"),res.getString("type")));
			}			

			res.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return recipeList;
	}
}