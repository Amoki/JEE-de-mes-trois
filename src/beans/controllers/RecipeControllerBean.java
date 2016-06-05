package beans.controllers;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import beans.RecipeListModelBean;
import beans.RecipeModelBean;
import beans.RecipeSubmissionModelBean;
import beans.SearchRecipeBean;
import dao.fabric.DaoFabric;
import dao.instance.RecipesDao;

@ManagedBean
@ApplicationScoped
public class RecipeControllerBean {
	protected RecipesDao recipeDao;
	
	@ManagedProperty(value="#{menuControllerBean}")
	private MenuControllerBean menuControllerBean;
	
	public void setMenuControllerBean(MenuControllerBean menuControllerBean) {
		this.menuControllerBean = menuControllerBean;
	}

	public RecipeControllerBean() {
		this.recipeDao=DaoFabric.getInstance().createRecipesDao();
	}

	public void loadAllRecipe(){
		ArrayList<RecipeModelBean> list = this.recipeDao.getAllRecipes();
		RecipeListModelBean recipeList=new RecipeListModelBean();

		for(RecipeModelBean recipe:list){
			recipeList.addRecipeList(recipe);
		}
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("recipeList", recipeList);
	}

	public String addRecipe(RecipeSubmissionModelBean recipe){
		this.recipeDao.addRecipe(recipe);
		return "successfulRegister.xhtml";
	}

	public String searchRecipe(SearchRecipeBean recipe){
		ArrayList<RecipeModelBean> list = this.recipeDao.getSearchedRecipes(recipe);
		RecipeListModelBean recipeList=new RecipeListModelBean();

		for(RecipeModelBean rec:list){
			recipeList.addRecipeList(rec);
		}
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("recipeList", recipeList);
		
		return menuControllerBean.goTo("/views/recipe/recipeResultList.xhtml");
	}
	
	public String displayRecipeDetail(RecipeModelBean recipe){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("selectedRecipe", recipe);
		
		return menuControllerBean.goTo("/views/recipe/recipeDetail.xhtml");
	}
}