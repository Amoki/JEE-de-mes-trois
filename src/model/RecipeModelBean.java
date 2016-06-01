package model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

public class RecipeModelBean implements Serializable {

	private int idRecipe;
	private String title;
	private String description;
	private int expertise;
	private int nbpeople;
	private int duration;
	private String type;
	private List<Type> types;
	private Type typeModel;

	@ManagedProperty("#{typeService}")
	private TypeService service;

	public RecipeModelBean() {}
	
	public RecipeModelBean(String title,String description,int expertise,int duration,int nbpeople,String type) {
		this.title = title;
		this.description = description;
		this.expertise = expertise;
		this.duration = duration;
		this.nbpeople = nbpeople;
		this.type = type;
	}

	public RecipeModelBean(int idRecipe, String title,String description,int expertise,int duration,int nbpeople,String type) {
		this.idRecipe = idRecipe;
		this.title = title;
		this.description = description;
		this.expertise = expertise;
		this.duration = duration;
		this.nbpeople = nbpeople;
		this.type = type;
	}

	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public int getExpertise() {return expertise;}
	public void setExpertise(int expertise) {this.expertise = expertise;}
	public int getNbpeople() {return nbpeople;}
	public void setNbpeople(int nbpeople) {this.nbpeople = nbpeople;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	public int getDuration() {return duration;}
	public void setDuration(int duration) {this.duration = duration; }
	public int getIdRecipe() {return idRecipe;}
	public void setIdRecipe(int idRecipe) {this.idRecipe = idRecipe;}

	public String toString() {
		return "[TITLE]:"+this.getTitle()+",[DESCRIPTION]:"+this.getDescription()+",[EXPERTISE]:"+this.getExpertise()+",[DURATION]:"+this.getDuration()+",[NBPEOPLE]:"+this.getNbpeople()+",[TYPE]:"+this.getType()+",[ID_RECIPE]:"+this.getIdRecipe();
	}
	
	public List<Type> getTypes() {return types;}
	public void setTypes(List<Type> types) {this.types = types;}
	public void setService(TypeService service) {this.service = service;}

	public void setTypeModel(Type typeModel) {
		if(typeModel != null){
			this.typeModel = typeModel;
			this.setType(typeModel.getValue());
		}
	}

	public Type getTypeModel() {
		return this.typeModel;
	}

	@PostConstruct
	public void init() {
		types = service.getTypes();
		typeModel = service.getType(getType());
	}
}