
package dao.instance;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		java.sql.PreparedStatement query;
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:postgresql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			query = connection.prepareStatement("INSERT INTO \"comments\" VALUES(?,?,?,?,?)");

			query.setInt(1, comment.getRecId());
			query.setInt(2, comment.getUserId());
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
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:postgresql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			java.sql.PreparedStatement query = connection.prepareStatement("SELECT * FROM \"comments\" where rec_id =?");
			query.setInt(1, recipeId);
			
			ResultSet res = query.executeQuery();

			while(res.next()){
				commentList.add(new CommentModel(
						res.getInt("rec_id"),
						res.getInt("user_id"),
						res.getString("date"),
						res.getString("detail"),
						res.getInt("rate")
				));
			}			
			res.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return commentList;
	}
}
