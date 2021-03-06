package beans.controllers;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import beans.RecipeListModelBean;
import beans.RecipeModelBean;
import beans.RecipeSubmissionModelBean;

@ManagedBean
@ApplicationScoped
public class AdminRecipeControllerBean extends RecipeControllerBean {

	public RecipeSubmissionModelBean selectedRecipe = null;
	public Boolean isNewRecipe = false;
	
	
	public Boolean getIsNewRecipe() {
		return isNewRecipe;
	}

	public void setIsNewRecipe(Boolean isNewRecipe) {
		this.isNewRecipe = isNewRecipe;
	}

	public RecipeSubmissionModelBean getSelectedRecipe() {
		return selectedRecipe;
	}

	public void setSelectedRecipe(RecipeSubmissionModelBean selectedRecipe) {
		this.selectedRecipe = selectedRecipe;
	}

	public void deleteRecipe(RecipeModelBean recipe){
		if(recipe != null){
			this.recipeDao.delete(recipe);
		}
	}

	public ArrayList<RecipeModelBean> getAllRecipes(){
		ArrayList<RecipeModelBean> list = this.recipeDao.getAllRecipes();
		RecipeListModelBean recipeList=new RecipeListModelBean();

		for(RecipeModelBean recipe:list){
			recipeList.addRecipeList(recipe);
		}
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();

		sessionMap.put("recipeList", recipeList);
		return list;
	}
	
	public void updateRecipe(RecipeSubmissionModelBean recipe){
		this.recipeDao.update(recipe);
	}

	public void showPanel(RecipeModelBean recipe){
		if(recipe != null){
			isNewRecipe = false;
			setSelectedRecipe(new RecipeSubmissionModelBean(recipe));
		}
		else{
			isNewRecipe = true;
			setSelectedRecipe(new RecipeSubmissionModelBean());
		}
	}
	
	public void hidePanel(){
		setSelectedRecipe(null);
	}
	
	public void saveRecipe(RecipeSubmissionModelBean recipeSubmissionModelBean){
		if(isNewRecipe){
			addRecipe(recipeSubmissionModelBean);
		}
		else{
			updateRecipe(recipeSubmissionModelBean);
		}
			
		hidePanel();
	}
}