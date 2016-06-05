package models;

import java.util.ArrayList;
import java.util.Iterator;
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
		Types.add(new Type(0, "All", "[ALL]"));
		Types.add(new Type(1, "Salad", "Salad"));
		Types.add(new Type(2, "Pastas", "Pastas"));
		Types.add(new Type(3, "Meat", "Meat"));
		Types.add(new Type(4, "Fish", "Fish"));
		Types.add(new Type(5, "Reblochon", "Reblochon"));
		Types.add(new Type(6, "Cakes", "Cakes"));
		Types.add(new Type(7, "Chicken", "Chicken"));
		Types.add(new Type(8, "Hot-dog", "Hot"));
		Types.add(new Type(9, "Gratins", "Gratins"));
		Types.add(new Type(10, "Dessert", "Dessert"));
	}

	public List<Type> getTypes() {
		return Types;
	}

	public Type getType(String type) {
		Iterator<Type> it = Types.iterator();
		
		while(it.hasNext()){
			Type t = it.next();
			if(t.getValue().equals(type))
					return t;
		}
		return new Type(0, "All", "[ALL]");
	}
}
