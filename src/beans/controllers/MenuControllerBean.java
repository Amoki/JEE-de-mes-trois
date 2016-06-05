package beans.controllers;

import java.util.Stack;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="menuControllerBean")
@ApplicationScoped
public class MenuControllerBean {
	
	private Stack<String> history;
	
	@PostConstruct
	public void init(){
		history = new Stack<String>();
	}
	
	public String goRecipes(){
		history.add("/views/recipe/recipesSearch.xhtml");
		return "/views/recipe/recipesSearch.xhtml";
	}
	
	public String goMenu(){
		history.add("/views/menu.xhtml");
		return "/views/menu.xhtml";
	}
	
	public String goRegister(){
		history.add("/views/user/registerUser.xhtml");
		return "/views/user/registerUser.xhtml";
	}
	
	public String goBack(){
		if(history.peek() != null){
			history.pop();
			return history.pop();
		}
		else
			return "/views/menu.xhtml";
	}

	public String goTo(String string) {
		history.add(string);
		return string;
	}
}