package beans.controllers;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import beans.TypeListModelBean;
import beans.TypeModelBean;
import beans.TypeSubmissionModelBean;

@ManagedBean
@ApplicationScoped
public class AdminTypeControllerBean extends TypeControllerBean {

	public TypeSubmissionModelBean selectedType = null;
	public Boolean isNewType = false;
	
	
	public Boolean getIsNewType() {
		return isNewType;
	}

	public void setIsNewType(Boolean isNewType) {
		this.isNewType = isNewType;
	}

	public TypeSubmissionModelBean getSelectedType() {
		return selectedType;
	}

	public void setSelectedType(TypeSubmissionModelBean selectedType) {
		this.selectedType = selectedType;
	}

	public void deleteRecipe(TypeModelBean type){
		if(type != null){
			this.typeDao.delete(type);
		}
	}

	public ArrayList<TypeModelBean> getAllTypes(){
		ArrayList<TypeModelBean> list = this.typeDao.getAllTypes();
		TypeListModelBean typeList = new TypeListModelBean();

		for(TypeModelBean type: list){
			typeList.addTypeList(type);
		}
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();

		sessionMap.put("recipeList", typeList);
		return list;
	}
	
	public void updateRecipe(TypeSubmissionModelBean type){
		this.typeDao.update(type);
	}

	public void showPanel(TypeModelBean type){
		if(type != null){
			isNewType = false;
			setSelectedType(new TypeSubmissionModelBean(type));
		}
		else{
			isNewType = true;
			setSelectedType(new TypeSubmissionModelBean());
		}
	}
	
	public void hidePanel(){
		setSelectedType(null);
	}
	
	public void saveType(TypeSubmissionModelBean typeSubmissionModelBean){
		if(isNewType){
			addType(typeSubmissionModelBean);
		}
		else{
			updateRecipe(typeSubmissionModelBean);
		}
			
		hidePanel();
	}
}