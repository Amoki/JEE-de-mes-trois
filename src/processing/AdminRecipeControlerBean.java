package processing;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import validators.EmailValidator;
import validators.LoginValidator;
import validators.UserNameValidator;
import model.LoginBean;
import model.RecipeListModelBean;
import model.RecipeModel;
import model.SearchRecipeBean;
import model.UserListModelBean;
import model.UserModelBean;
import model.UserSubmissionModelBean;

@ManagedBean
@ApplicationScoped
public class AdminRecipeControlerBean extends RecipeControlerBean {

	public void deleteRecipe(RecipeModel recipe){
		if(recipe != null){
			this.recipeDao.delete(recipe);
		}
	}
	
	public void updateRecipe(SearchRecipeBean recipe){
		//TODO tests des valeurs des champs
		this.recipeDao.update(recipe);
	}

	public static void main(String[] args) {
		AdminRecipeControlerBean controler = new AdminRecipeControlerBean();
	}
}