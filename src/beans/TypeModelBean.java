package beans;

import java.io.Serializable;

public class TypeModelBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8438350025088617670L;
	int id;
	String name;
	
	public TypeModelBean() {
	}
	
	public TypeModelBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
