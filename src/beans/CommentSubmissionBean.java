package beans;

import java.sql.Date;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import models.CommentModel;

@ManagedBean
@RequestScoped
public class CommentSubmissionBean extends CommentModel {
	public CommentSubmissionBean(){
		this.setDate(new Date(Calendar.getInstance().getTime().getTime()));
	}
}