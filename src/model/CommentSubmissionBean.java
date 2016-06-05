package model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CommentSubmissionBean extends CommentModel {
	public CommentSubmissionBean(){
		this.setDate(new Date().toString());
	}
}