package dao.instance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.fabric.DaoFabric;
import model.RecipeModel;
import model.SearchRecipeBean;
import model.UserModelBean;

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

			query = connection.prepareStatement("INSERT INTO recipes(title,description,expertise,duration,nbpeople,type) VALUES(?,?,?,?,?,?)");

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

			String querySQL = "SELECT * FROM recipes";
			boolean begin = true;

			if(recipe.getExpertise() != SearchRecipeBean.ALL_VALUES_INT){
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

			query = connection.prepareStatement(querySQL);

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
	
	public void delete(RecipeModel recipe) {
		// Création de la requête
		java.sql.PreparedStatement query;
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			query = connection.prepareStatement("DELETE FROM recipes WHERE title=?");

			query.setString(1, recipe.getTitle());

			query.execute();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		RecipesDao dao = DaoFabric.getInstance().createRecipesDao();

		RecipeModel recipe = new RecipeModel("Tartiflette", "Du rebloch des patates et des lardons", 5, 30, 6, "Plat");
		RecipeModel recipe1 = new RecipeModel("Cochon de lait", "Un bon dieu de cochon à la broche", 5, 480, 56, "Plat");
		RecipeModel recipe2 = new RecipeModel("Tarte au pommes", "Des pommes de la compote et de la pate feuilleté", 5, 30, 6, "Dessert");

		dao.addRecipe(recipe);
		dao.addRecipe(recipe1);
		dao.addRecipe(recipe2);
		
		System.out.println(dao.getAllRecipes());
		System.out.println(dao.getSearchedRecipes(recipe));		
		System.out.println(dao.getSearchedRecipes(recipe1));
		System.out.println(dao.getSearchedRecipes(recipe2));
		
		SearchRecipeBean searchrecipe = new SearchRecipeBean();
		searchrecipe.setType("Plat");
		System.out.println(dao.getSearchedRecipes(searchrecipe).size());
		
		dao.delete(recipe);
		dao.delete(recipe1);
		dao.delete(recipe2);
		
		System.out.println(dao.getAllRecipes());
	}
}