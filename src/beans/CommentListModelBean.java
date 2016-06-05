package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CommentListModelBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5480268938617067946L;
	private List<CommentModel> commentList;
	public CommentListModelBean() {
		commentList=new ArrayList<CommentModel>();
	}
	
	public void addCommentList(CommentModel comment){
		this.commentList.add(comment);
	}
	
	public List<CommentModel> getCommentList() {
		return commentList;
	}


}
