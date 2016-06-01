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

	public SearchRecipeBean() {
		this.setDescription(ALL_VALUES_STRING);
		this.setTitle(ALL_VALUES_STRING);
		this.setType(ALL_VALUES_STRING);
		this.setNbpeople(ALL_VALUES_INT);
		this.setDuration(ALL_VALUES_INT);
		this.setExpertise(MIN_EXPERTISE_VALUE);
	}
}