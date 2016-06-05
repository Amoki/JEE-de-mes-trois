package processing;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import dao.fabric.DaoFabric;
import dao.instance.CommentDao;
import model.CommentListModelBean;
import model.CommentModel;
import model.CommentSubmissionBean;
import model.UserModelBean;

@ManagedBean
@ApplicationScoped
public class CommentControlerBean {
	private CommentDao commentDao;

	public CommentControlerBean() {
		this.commentDao=DaoFabric.getInstance().createCommentDao();
	}

	public void addComment(CommentSubmissionBean comment, UserModelBean user, int recId){
		comment.setRecId(recId);
		comment.setUser(user);
		this.commentDao.addComment(comment);
	}

	public ArrayList<CommentModel> loadAllRecipeComments(int recipeId){
		ArrayList<CommentModel> list = this.commentDao.getAllComment(recipeId);
		CommentListModelBean commentList = new CommentListModelBean();

		for(CommentModel comment:list){
			commentList.addCommentList(comment);
		}		

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();

		sessionMap.put("commentList", commentList);
		return list;
	} 	
}
