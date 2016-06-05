package dao.instance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.TypeModelBean;
import beans.UserModelBean;
import models.CommentModel;

public class TypeDao {
	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;

	public TypeDao(String DB_HOST,String DB_PORT, String DB_NAME,String DB_USER,String DB_PWD) {
		dB_HOST = DB_HOST;
		dB_PORT = DB_PORT;
		dB_NAME = DB_NAME;
		dB_USER = DB_USER;
		dB_PWD = DB_PWD;
	}

	public void addType(TypeModelBean type) {
		java.sql.PreparedStatement query;
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:postgresql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			query = connection.prepareStatement("INSERT INTO \"types\" (name) VALUES(?)");

			query.setString(1, type.getName());
			

			query.execute();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<TypeModelBean> getAllTypes() {
		ArrayList<TypeModelBean> typeList = new ArrayList<TypeModelBean>();
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:postgresql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			java.sql.PreparedStatement query = connection.prepareStatement("SELECT * FROM \"types\"");
			
			ResultSet res = query.executeQuery();

			while(res.next()){
				typeList.add(new TypeModelBean(res.getInt("id"), res.getString("name")));
			}			
			res.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return typeList;
	}
}
