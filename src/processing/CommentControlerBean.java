package processing;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.CommentListModelBean;
import model.CommentModel;
import model.CommentSubmissionBean;
import dao.fabric.DaoFabric;
import dao.instance.CommentDao;

@ManagedBean
@ApplicationScoped
public class CommentControlerBean {
	private CommentDao commentDao;

	public CommentControlerBean() {
		this.commentDao=DaoFabric.getInstance().createCommentDao();
	}

	public void addComment(CommentSubmissionBean comment, String loginUser, int idRecipe){
		comment.setRecipeId(idRecipe);
		comment.setUserLogin(loginUser);
		this.commentDao.addComment(comment);
	}

	public ArrayList<CommentModel> loadAllRecipeComments(int recipeId){
		ArrayList<CommentModel> list = this.commentDao.getAllComment(recipeId);
		CommentListModelBean commentList = new CommentListModelBean();

		for(CommentModel comment:list){
			commentList.addCommentList(comment);
		}		

		//récupère l'espace de mémoire de JSF
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();

		//place la liste de recette dans l'espace de mémoire de JSF
		sessionMap.put("commentList", commentList);
		return list;
	} 	
}
