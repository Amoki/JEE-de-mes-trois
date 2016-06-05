package beans.controllers;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import beans.CommentListModelBean;
import beans.CommentModel;
import beans.CommentSubmissionBean;
import beans.UserModelBean;
import dao.fabric.DaoFabric;
import dao.instance.CommentDao;

@ManagedBean
@ApplicationScoped
public class CommentControllerBean {
	private CommentDao commentDao;

	public CommentControllerBean() {
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
