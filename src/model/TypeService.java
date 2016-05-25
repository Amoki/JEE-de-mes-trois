package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="typeService", eager = true)
@ApplicationScoped
public class TypeService {

	private List<Type> Types;

	@PostConstruct
	public void init() {
		Types = new ArrayList<Type>();
		Types.add(new Type(0, "Salad", "salad"));
		Types.add(new Type(1, "Pastas", "pastas"));
		Types.add(new Type(2, "Meat", "meat"));
		Types.add(new Type(3, "Fish", "fish"));
		Types.add(new Type(4, "Reblochon", "reblochon"));
		Types.add(new Type(5, "Cakes", "cakes"));
		Types.add(new Type(6, "Chicken", "chicken"));
		Types.add(new Type(7, "Hot-dog", "hot_dog"));
		Types.add(new Type(8, "Gratins", "gratins"));
		Types.add(new Type(8, "Dessert", "dessert"));
	}

	public List<Type> getTypes() {
		return Types;
	} 
}
