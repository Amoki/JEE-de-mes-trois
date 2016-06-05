package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import models.TypeModelBean;

@ManagedBean
@RequestScoped
public class TypeListModelBean  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6805050070819482593L;
	private List<TypeModelBean> typeList;
	
	public TypeListModelBean() {
		this.typeList = new ArrayList<TypeModelBean>();
	}
	public void addTypeList(TypeModelBean type){
		this.typeList.add(type);
	}
	public List<TypeModelBean> getRecipeList() {
		return typeList;
	}
}