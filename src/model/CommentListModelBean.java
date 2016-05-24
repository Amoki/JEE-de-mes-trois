package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CommentListModelBean {
	private List<CommentModel> commentList;
	public CommentListModelBean() {
		commentList=new ArrayList<CommentModel>();
	}
	
	public void addRecipeList(CommentModel comment){
		this.commentList.add(comment);
	}
	
	public List<CommentModel> getRecipeList() {
		return commentList;
	}
}
