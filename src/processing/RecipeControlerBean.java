package processing;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.RecipeListModelBean;
import model.RecipeModel;
import dao.fabric.DaoFabric;
import dao.instance.RecipesDao;

@ManagedBean
@ApplicationScoped
public class RecipeControlerBean {
	private RecipesDao recipeDao;

	public RecipeControlerBean() {
		this.recipeDao=DaoFabric.getInstance().createRecipesDao();
	}

	public void loadAllRecipe(){
		ArrayList<RecipeModel> list = this.recipeDao.getAllRecipes();
		RecipeListModelBean recipeList=new RecipeListModelBean();

		for(RecipeModel recipe:list){
			recipeList.addRecipeList(recipe);
		}
		//récupère l'espace de mémoire de JSF
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		//place la liste de recette dans l'espace de mémoire de JSF
		sessionMap.put("recipeList", recipeList);
	}

	public String addRecipe(RecipeModel recipe){
		//TODO ajouter la recette provenant du formulaire
		this.recipeDao.addRecipe(recipe);
		//Redirection vers une page de confirmation
		return "successfulRegister.xhtml";
	}

	public String searchRecipe(RecipeModel recipe){
		//TODO effectuer une recherche des recettes répondant aux critères passés en parametre, récupérer la liste des recettes correspondantes et demander à recipeResultList.xhtml d’afficher les recettes trouvées
		ArrayList<RecipeModel> list = this.recipeDao.getSearchedRecipes(recipe);
		RecipeListModelBean recipeList=new RecipeListModelBean();

		for(RecipeModel rec:list){
			recipeList.addRecipeList(rec);
		}
		//récupère l'espace de mémoire de JSF
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		//place la liste de recette dans l'espace de mémoire de JSF
		sessionMap.put("recipeList", recipeList);

		return "recipeResultList.xhtml";
	}
	
	public String displayRecipeDetail(RecipeModel recipe){
		//TODO demander à recipeDetail.jsf d’afficher les details de la recette passée en paramètre
		return "recipeDetail.jsf";
	}
}