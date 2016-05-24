package processing;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.RecipeListModelBean;
import model.RecipeModel;
import model.RecipeSubmissionModelBean;
import model.SearchRecipeBean;
import dao.fabric.DaoFabric;
import dao.instance.RecipesDao;

@ManagedBean
@ApplicationScoped
public class RecipeControlerBean {
	protected RecipesDao recipeDao;

	public RecipeControlerBean() {
		this.recipeDao=DaoFabric.getInstance().createRecipesDao();
	}

	public void loadAllRecipe(){
		ArrayList<RecipeModel> list = this.recipeDao.getAllRecipes();
		RecipeListModelBean recipeList=new RecipeListModelBean();

		for(RecipeModel recipe:list){
			recipeList.addRecipeList(recipe);
		}
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("recipeList", recipeList);
	}

	public String addRecipe(RecipeSubmissionModelBean recipe){
		//TODO testé les valeurs des champs
		this.recipeDao.addRecipe(recipe);
		return "successfulRegister.xhtml";
	}

	public String searchRecipe(SearchRecipeBean recipe){
		ArrayList<RecipeModel> list = this.recipeDao.getSearchedRecipes(recipe);
		RecipeListModelBean recipeList=new RecipeListModelBean();

		for(RecipeModel rec:list){
			recipeList.addRecipeList(rec);
		}
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("recipeList", recipeList);

		return "recipeResultList.xhtml";
	}
	
	public String displayRecipeDetail(RecipeModel recipe){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("selectedRecipe", recipe);
		
		return "recipeDetail.jsf";
	}
}