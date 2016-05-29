package processing;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class MenuControlerBean {
	public String goRecipes(){
		return "/views/recipe/recipesSearch.xhtml";
	}
	
	public String goMenu(){
		return "/views/menu.xhtml";
	}
}