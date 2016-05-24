package processing;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.CommentModelBean;
import dao.fabric.DaoFabric;
import dao.instance.CommentDao;


@ManagedBean
@ApplicationScoped
public class CommentControlerBean {
	private CommentDao commentDao;
	
	public CommentControlerBean() {
		this.commentDao=DaoFabric.getInstance().createCommentDao();
	}
	
	public String addComment(){
		// TODO ajouter le commentaire provenant de la zone de saisie de comm
		
		// redirection vers une page de confirmation
		return "successfulRegister.xhtml";
	}
	
	public void loadAllComment(){
		ArrayList<CommentModelBean> list = this.commentDao.getAllComment();
				
		//récupère l'espace de mémoire de JSF
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		//place la liste de recette dans l'espace de mémoire de JSF
		sessionMap.put("commentList", list);
	} 
}
