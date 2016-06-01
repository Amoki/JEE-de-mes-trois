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
		Types.add(new Type(0, "[ALL]", "[ALL]"));
		Types.add(new Type(1, "Salad", "salad"));
		Types.add(new Type(2, "Pastas", "pastas"));
		Types.add(new Type(3, "Meat", "meat"));
		Types.add(new Type(4, "Fish", "fish"));
		Types.add(new Type(5, "Reblochon", "reblochon"));
		Types.add(new Type(6, "Cakes", "cakes"));
		Types.add(new Type(7, "Chicken", "chicken"));
		Types.add(new Type(8, "Hot-dog", "hot_dog"));
		Types.add(new Type(9, "Gratins", "gratins"));
		Types.add(new Type(10, "Dessert", "dessert"));
	}

	public List<Type> getTypes() {
		return Types;
	}
}
