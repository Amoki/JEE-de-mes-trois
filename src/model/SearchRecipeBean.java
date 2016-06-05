package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SearchRecipeBean extends RecipeModelBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5954392368745043064L;
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