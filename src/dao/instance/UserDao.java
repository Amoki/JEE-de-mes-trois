package dao.instance;

import java.sql.Connection;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.fabric.DaoFabric;
import model.UserModelBean;
import model.UserSubmissionModelBean;

public class UserDao {
	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;

	public UserDao(String DB_HOST,String DB_PORT, String DB_NAME,String DB_USER,String
			DB_PWD) {
		dB_HOST = DB_HOST;
		dB_PORT = DB_PORT;
		dB_NAME = DB_NAME;
		dB_USER = DB_USER;
		dB_PWD = DB_PWD;
	}

	public void addUser(UserModelBean user) {
		// Création de la requête
		java.sql.PreparedStatement query;
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			query = connection.prepareStatement("INSERT INTO users (lastname,surname,age,login,pwd,email) VALUES(?,?,?,?,?,?)");

			query.setString(1, user.getLastname());
			query.setString(2, user.getSurname());
			query.setInt(3, user.getAge());
			query.setString(4, user.getLogin());
			query.setString(5, user.getPwd());
			query.setString(6, user.getEmail());

			query.execute();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<UserModelBean> getAllUser(){
		//return value
		ArrayList<UserModelBean> userList=new ArrayList<UserModelBean>();
		// Création de la requête
		java.sql.PreparedStatement query;
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			query = connection.prepareStatement("SELECT * FROM users");

			ResultSet res = query.executeQuery();

			while(res.next()){
				userList.add(new UserModelBean(res.getString("lastname"),res.getString("surname"),res.getInt("age"),res.getString("login"),res.getString("pwd"),res.getString("email"),res.getBoolean("admin")));
			}		

			res.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public UserModelBean checkUser(String login, String pwd){
		//return value
		UserModelBean user = null;
		// Création de la requête
		java.sql.PreparedStatement query;
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			query = connection.prepareStatement("SELECT * FROM users WHERE login=? AND pwd=?");
			query.setString(1, login);
			query.setString(2, pwd);

			ResultSet res = query.executeQuery();

			if(res.next()){
				user = new UserModelBean(res.getString("lastname"),res.getString("surname"),res.getInt("age"),res.getString("login"),res.getString("pwd"),res.getString("email"));
				user.setAdmin(res.getBoolean("admin"));
			}

			res.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void update(UserModelBean user) {
		// Création de la requête
		java.sql.PreparedStatement query;
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			query = connection.prepareStatement("UPDATE users SET lastname=?,surname=?,age=?,login=?,pwd=?,email=?,admin=? WHERE login=?");

			query.setString(1, user.getLastname());
			query.setString(2, user.getSurname());
			query.setInt(3, user.getAge());
			query.setString(4, user.getLogin());
			query.setString(5, user.getPwd());
			query.setString(6, user.getEmail());
			query.setBoolean(7, user.getIsAdmin());

			query.setString(8, user.getLogin());

			query.execute();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(UserModelBean user) {
		// Création de la requête
		java.sql.PreparedStatement query;
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			query = connection.prepareStatement("DELETE FROM users WHERE login=?");

			query.setString(1, user.getLogin());

			query.execute();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UserDao dao = DaoFabric.getInstance().createUserDao();

		UserModelBean user = new UserModelBean("test","test",0,"test","test","test");
		dao.addUser(user);

		user = dao.checkUser("test", "test");
		System.out.println(user);

		ArrayList<UserModelBean> users = dao.getAllUser();
		
		System.out.println(users);

		user.setAdmin(true);
		dao.update(user);
		
		user = dao.checkUser("test", "test");
		System.out.println(user);
		
		dao.delete(user);
		
		user = dao.checkUser("test", "test");
		System.out.println(user);
	}
}