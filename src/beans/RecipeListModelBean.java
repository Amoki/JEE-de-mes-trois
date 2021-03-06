package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RecipeListModelBean  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2786626726527644903L;
	private List<RecipeModelBean> recipeList;
	public RecipeListModelBean() {
		recipeList=new ArrayList<RecipeModelBean>();
	}
	public void addRecipeList(RecipeModelBean recipe){
		this.recipeList.add(recipe);
	}
	public List<RecipeModelBean> getRecipeList() {
		return recipeList;
	}
}