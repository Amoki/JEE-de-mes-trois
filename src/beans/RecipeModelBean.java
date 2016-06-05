package beans;

import java.io.Serializable;

public class RecipeModelBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7539195485588511241L;
	private int recipeId;
	private String title;
	private String description;
	private int expertise;
	private int nbpeople;
	private int duration;
	private TypeModelBean type;

	public RecipeModelBean() {}
	
	public RecipeModelBean(String title,String description,int expertise,int duration,int nbpeople,TypeModelBean type) {
		this.title = title;
		this.description = description;
		this.expertise = expertise;
		this.duration = duration;
		this.nbpeople = nbpeople;
		this.type = type != null ? type: new TypeModelBean();
	}

	public RecipeModelBean(int recipeId, String title,String description,int expertise,int duration,int nbpeople,TypeModelBean type) {
		this.recipeId = recipeId;
		this.title = title;
		this.description = description;
		this.expertise = expertise;
		this.duration = duration;
		this.nbpeople = nbpeople;
		this.type = type != null ? type: new TypeModelBean();
	}

	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public int getExpertise() {return expertise;}
	public void setExpertise(int expertise) {this.expertise = expertise;}
	public int getNbpeople() {return nbpeople;}
	public void setNbpeople(int nbpeople) {this.nbpeople = nbpeople;}
	public TypeModelBean getType() {return type;}
	public void setType(TypeModelBean type) {this.type = type;}
	public int getDuration() {return duration;}
	public void setDuration(int duration) {this.duration = duration; }
	public int getRecipeId() {return recipeId;}
	public void setRecipeId(int recipeId) {this.recipeId = recipeId;}

	public String toString() {
		return "[TITLE]:"+this.getTitle()+
				",[DESCRIPTION]:"+this.getDescription()+
				",[EXPERTISE]:"+this.getExpertise()+
				",[DURATION]:"+this.getDuration()+
				",[NBPEOPLE]:"+this.getNbpeople()+
				",[TYPE]:"+ ((this.getType() != null) ? this.getType().getName() : "aucun")+
				",[ID_RECIPE]:"+this.getRecipeId()
		;
	}
	
	
}