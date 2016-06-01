package model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@RequestScoped
public class SearchRecipeBean extends RecipeModelBean{

	public static final String ALL_VALUES_STRING="[ALL]";
	public static final int ALL_VALUES_INT=0;
	public static final int MIN_EXPERTISE_VALUE = 1;
	private List<Type> types;
	private Type typeModel;

	@ManagedProperty("#{typeService}")
	private TypeService service;

	public SearchRecipeBean() {
		this.setDescription(ALL_VALUES_STRING);
		this.setTitle(ALL_VALUES_STRING);
		this.setType(ALL_VALUES_STRING);
		this.setNbpeople(ALL_VALUES_INT);
		this.setDuration(ALL_VALUES_INT);
		this.setExpertise(MIN_EXPERTISE_VALUE);
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