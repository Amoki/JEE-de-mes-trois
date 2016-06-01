package model;

public class Type {
	private int id;    
	private String displayName; 
	private String value;

	public Type() {}

	public Type(int id, String displayName, String value) {
		this.id = id;
		this.displayName = displayName;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getValue(){
		return value;
	}

	@Override
	public String toString() {
		return getDisplayName();
	}
}
