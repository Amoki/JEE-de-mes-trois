package main;

import java.util.List;

import model.RecipeModelBean;
import model.UserModelBean;
import dao.fabric.DaoFabric;
import dao.instance.RecipesDao;
import dao.instance.UserDao;

public class Launcher {
	public static void main(String[] args) {
		UserDao userDao=DaoFabric.getInstance().createUserDao();
		RecipesDao recipesDao=DaoFabric.getInstance().createRecipesDao();
		UserModelBean user1=new UserModelBean("Doe", "John",55, "jdoe", "pwd","j@gmail.com");
		RecipeModelBean recipe1=new RecipeModelBean(1, "Fish Salad", "bla bla bal bla", 5, 180, 10, "salad");
		RecipeModelBean recipe2=new RecipeModelBean(2, "Fresh Meat", "bla bla bal bla", 1, 20, 1, "meat");
		userDao.addUser(user1);
		recipesDao.addRecipe(recipe1);
		recipesDao.addRecipe(recipe2);
		List<UserModelBean> userList=userDao.getAllUser();
		List<RecipeModelBean> recipeList=recipesDao.getAllRecipes();
		for(UserModelBean userTmp:userList){
			System.out.println("User added:"+userTmp);
		}
		for(RecipeModelBean recipeTmp:recipeList){
			System.out.println("User added:"+recipeTmp);
		}
	}
}