package beans.controllers;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import beans.TypeListModelBean;
import beans.TypeSubmissionModelBean;
import dao.fabric.DaoFabric;
import dao.instance.TypeDao;
import models.TypeModelBean;

@ManagedBean
@ApplicationScoped
public class TypeControllerBean {
	protected TypeDao typeDao;
	

	public TypeControllerBean() {
		this.typeDao=DaoFabric.getInstance().createTypeDao();
	}

	public void loadAllTypes(){
		ArrayList<TypeModelBean> list = this.typeDao.getAllTypes();
		TypeListModelBean typeList = new TypeListModelBean();

		for(TypeModelBean type: list){
			typeList.addTypeList(type);
		}
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("typeList", typeList);
	}

	public String addType(TypeSubmissionModelBean type){
		this.typeDao.addType(type);
		return "successfulRegister.xhtml";
	}

}