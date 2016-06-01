package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped 
public class RecipeSubmissionModelBean extends RecipeModelBean{
	public RecipeSubmissionModelBean() { }
	
	public RecipeSubmissionModelBean(RecipeModelBean recipe){
		super(recipe.getTitle() ,recipe.getDescription(), recipe.getExpertise(),recipe.getDuration(),recipe.getNbpeople(),recipe.getType());
	}
}