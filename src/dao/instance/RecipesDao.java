package dao.instance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.RecipeModelBean;
import model.SearchRecipeBean;

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

	public void addRecipe(RecipeModelBean recipe) {
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:postgresql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			java.sql.PreparedStatement query = connection.prepareStatement("INSERT INTO recipes(title,description,expertise,duration,nbpeople,type) VALUES(?,?,?,?,?,?)");

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

	public ArrayList<RecipeModelBean> getAllRecipes() {
		ArrayList<RecipeModelBean> recipeList=new ArrayList<RecipeModelBean>();
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:postgresql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			java.sql.PreparedStatement query = connection.prepareStatement("SELECT * FROM \"recipes\"");

			ResultSet res = query.executeQuery();

			while(res.next()){
				recipeList.add(new RecipeModelBean(res.getInt("id"), res.getString("title"),res.getString("description"),res.getInt("expertise"),res.getInt("nbPeople"),res.getInt("duration"),res.getString("type")));
			}			

			res.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recipeList;
	}

	public ArrayList<RecipeModelBean> getSearchedRecipes(RecipeModelBean recipe) {
		ArrayList<RecipeModelBean> recipeList=new ArrayList<RecipeModelBean>();
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:postgresql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			String querySQL = "SELECT * FROM recipes";
			boolean begin = true;

			if(recipe.getExpertise() != SearchRecipeBean.MIN_EXPERTISE_VALUE){
				if(begin){
					begin = false;
					querySQL += " WHERE ";
				}
				querySQL += "expertise=" + recipe.getExpertise() + " ";
			}
			if(recipe.getNbpeople() != SearchRecipeBean.ALL_VALUES_INT){
				if(begin){
					begin = false;
					querySQL += " WHERE ";
				}
				else{
					querySQL += "AND ";
				}
				querySQL += "nbPeople=" + recipe.getNbpeople() + " ";
			}
			if(recipe.getDuration() !=SearchRecipeBean.ALL_VALUES_INT){
				if(begin){
					begin = false;
					querySQL += " WHERE ";
				}
				else{
					querySQL += "AND ";
				}
				querySQL += "duration=" + recipe.getDuration() + " ";
			}
			if(!recipe.getType().equals(SearchRecipeBean.ALL_VALUES_STRING)){
				if(begin){
					begin = false;
					querySQL += " WHERE ";
				}
				else{
					querySQL += "AND ";
				}
				querySQL += "type='" + recipe.getType() + "' ";
			}

			java.sql.PreparedStatement query = connection.prepareStatement(querySQL);

			ResultSet res = query.executeQuery();

			while(res.next()){
				recipeList.add(new RecipeModelBean(res.getInt("id"), res.getString("title"),res.getString("description"),res.getInt("expertise"),res.getInt("nbPeople"),res.getInt("duration"),res.getString("type")));
			}			

			res.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recipeList;
	}

	public void delete(RecipeModelBean recipe) {
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:postgresql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			java.sql.PreparedStatement query = connection.prepareStatement("DELETE FROM \"recipes\" WHERE id=?");

			query.setInt(1, recipe.getIdRecipe());

			query.execute();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(RecipeModelBean recipe) {
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:postgresql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			java.sql.PreparedStatement query = connection.prepareStatement("UPDATE \"recipes\" SET title=?,description=?,expertise=?,nbpeople=?,duration=?,type=? WHERE id=?");

			query.setString(1, recipe.getTitle());
			query.setString(2, recipe.getDescription());
			query.setInt(3, recipe.getExpertise());
			query.setInt(4, recipe.getNbpeople());
			query.setInt(5, recipe.getDuration());
			query.setString(6, recipe.getType());

			query.setInt(7, recipe.getIdRecipe());

			query.execute();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
