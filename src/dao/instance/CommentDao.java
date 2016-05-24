package dao.instance;

import java.sql.Connection;
import java.util.ArrayList;

import model.CommentModelBean;

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
	
	public void addComment() {
	// TODO
		
	}

	public ArrayList<CommentModelBean> getAllComment() {
		// TODO Auto-generated method stub
		return null;
	}
}
