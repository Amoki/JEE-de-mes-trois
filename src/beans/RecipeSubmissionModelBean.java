package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped 
public class RecipeSubmissionModelBean extends RecipeModelBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = -378565738460467632L;
	


	public RecipeSubmissionModelBean() { }
	
	public RecipeSubmissionModelBean(RecipeModelBean recipe){
		super(
				recipe.getRecipeId(), 
				recipe.getTitle() ,
				recipe.getDescription(), 
				recipe.getExpertise(),
				recipe.getDuration(),
				recipe.getNbpeople(),
				recipe.getType()
		);
	}
}