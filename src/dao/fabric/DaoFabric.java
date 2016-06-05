package dao.fabric;

import dao.instance.CommentDao;
import dao.instance.RecipesDao;
import dao.instance.UserDao;

public final class DaoFabric {
	private static volatile DaoFabric instance = null;
	private static final String DB_HOST = "db-host";
    private static final String DB_PORT = "5432";
    private static final String DB_NAME = "jee";
    private static final String DB_USER = "jee";
    private static final String DB_PWD = "azerty";

	private DaoFabric() {
		super();
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public final static DaoFabric getInstance() {
		if (DaoFabric.instance == null) {
			synchronized (DaoFabric.class) {
				if (DaoFabric.instance == null) {
					DaoFabric.instance = new DaoFabric();
				}
			}
		}
		return DaoFabric.instance;
	}
	
	public UserDao createUserDao() {
		UserDao userDao = new UserDao(DaoFabric.DB_HOST,DaoFabric.DB_PORT,DaoFabric.DB_NAME,DaoFabric.DB_USER,DaoFabric.DB_PWD);
		return userDao;
	}
	
	public RecipesDao createRecipesDao(){
		RecipesDao receipesDao = new RecipesDao(DaoFabric.DB_HOST,DaoFabric.DB_PORT,DaoFabric.DB_NAME,DaoFabric.DB_USER,DaoFabric.DB_PWD);
		return receipesDao;
	}
	
	public CommentDao createCommentDao(){
		CommentDao commentDao = new CommentDao(DaoFabric.DB_HOST,DaoFabric.DB_PORT,DaoFabric.DB_NAME,DaoFabric.DB_USER,DaoFabric.DB_PWD);
		return commentDao;
	}
}