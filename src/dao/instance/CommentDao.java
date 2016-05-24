package dao.instance;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CommentModel;
import model.RecipeModel;
import model.UserModelBean;

public class CommentDao {
	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;

	public CommentDao(String DB_HOST,String DB_PORT, String DB_NAME,String DB_USER,String DB_PWD) {
		dB_HOST = DB_HOST;
		dB_PORT = DB_PORT;
		dB_NAME = DB_NAME;
		dB_USER = DB_USER;
		dB_PWD = DB_PWD;
	}
	
	public void addComment(CommentModel comment) {
		// Création de la requête
		java.sql.PreparedStatement query;
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			// values (String user, String recipe, String date, String detail, int rate)
			query = connection.prepareStatement("INSERT INTO comments VALUES(?,?,?,?,?,?)");
			
			// TODO
			
			/*			
			query.setString(1, recipe.getTitle());
			query.setString(2,recipe.getDescription());
			query.setInt(3, recipe.getExpertise());
			query.setInt(4, recipe.getDuration());
			query.setInt(5, recipe.getNbpeople());
			query.setString(6, recipe.getType());
*/
			query.execute();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<CommentModel> getAllComment() {
		// TODO Auto-generated method stub
		return null;
	}
}
