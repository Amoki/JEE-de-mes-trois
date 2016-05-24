
package dao.instance;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.fabric.DaoFabric;
import model.CommentModel;

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

			// values (int recipe, String userLogin, String date, String detail, int rate)
			query = connection.prepareStatement("INSERT INTO comments VALUES(?,?,?,?,?)");

			query.setInt(1, comment.getRecipeId());
			query.setString(2, comment.getUserLogin());
			query.setString(3, comment.getDate());
			query.setString(4, comment.getDetail());
			query.setInt(5, comment.getRate());

			query.execute();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<CommentModel> getAllComment(int recipeId) {
		ArrayList<CommentModel> commentList=new ArrayList<CommentModel>();
		
		// Création de la requête
		java.sql.PreparedStatement query;
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			query = connection.prepareStatement("SELECT * FROM comments where recipeId =?");
			query.setInt(1, recipeId);
			
			ResultSet res = query.executeQuery();

			while(res.next()){
				commentList.add(new CommentModel(res.getInt("recipeId"), res.getString("userLogin"),
										res.getString("date"), res.getString("detail"), res.getInt("rate")));
			}			
			res.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return commentList;
	}
	public static void main(String[] args) {
		// Création de quelques commentaires de 2 méthodes différentes
		System.out.println("Création des comments...");
		CommentModel comment1 = new CommentModel(5, "JordanChase", "15/02/2017", "Recette DE GUEU LA CE", 1);
		System.out.println(comment1);

		CommentModel comment2 = new CommentModel(5, "Manio", "15/03/2021", "Je m'en suis mit plein le bide", 5);
		System.out.println(comment2);
		
		CommentModel comment3 = new CommentModel(5, "Liarick", "21/01/1994", "PARFAIT !", 8);
		System.out.println(comment3);
		
		CommentModel comment4 = new CommentModel(18, "Hellsjoke", "30/07/1954", "Vieillot !", 4);
		System.out.println(comment4);
		
		
		// Création de la Dao
		System.out.println("Création de la Dao...");
		CommentDao commentDao;
		commentDao=DaoFabric.getInstance().createCommentDao();

		System.out.println("Insertion 1... recipeId 5");
		commentDao.addComment(comment1);
		for (CommentModel cl: commentDao.getAllComment(5)){
			System.out.println(cl);
		}
		
		System.out.println("Insertion 2... recipeId 5");
		commentDao.addComment(comment2);
		for (CommentModel cl: commentDao.getAllComment(5)){
			System.out.println(cl);
		}
		
		System.out.println("Insertion 3... recipeId 5");
		commentDao.addComment(comment3);
		for (CommentModel cl: commentDao.getAllComment(5)){
			System.out.println(cl);
		}
		
		System.out.println("Insertion 4... recipeId 5");
		commentDao.addComment(comment4);
		for (CommentModel cl: commentDao.getAllComment(5)){
			System.out.println(cl);
		}
		System.out.println("recipeId 18");
		for (CommentModel cl: commentDao.getAllComment(18)){
			System.out.println(cl);
		}
	}
}
