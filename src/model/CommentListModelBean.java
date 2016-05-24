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
	
	public void addCommentList(CommentModel comment){
		this.commentList.add(comment);
	}
	
	public List<CommentModel> getCommentList() {
		return commentList;
	}
	
	public static void main(String[] args) {
		// Création de quelques commentaires de 2 méthodes différentes
		System.out.println("Création des comments...");
		CommentModel comment1 = new CommentModel(5, "JordanChase", "15/02/2017", "Recette DE GUEU LA CE", 1);
		System.out.println(comment1);
		
		CommentModel comment2 = new CommentModel(17, "Manio", "15/03/2021", "Je m'en suis mit plein le bide", 5);
		System.out.println(comment2);
		
		CommentModel comment3 = new CommentModel();
		comment3.setRecipeId(57);
		comment3.setUserLogin("Liarick");
		comment3.setDate("21/01/1994");
		comment3.setDetail("PARFAIT !");
		comment3.setRate(8);
		System.out.println(comment3);
		
		// Création de la CommentListModelBean
		System.out.println("Création de la liste de comments...");
		CommentListModelBean commentList = new CommentListModelBean();
		commentList.addCommentList(comment1);
		commentList.addCommentList(comment2);
		commentList.addCommentList(comment3);
		
		for (CommentModel cl: commentList.getCommentList()){
			System.out.println(cl);
		}
	}

}
