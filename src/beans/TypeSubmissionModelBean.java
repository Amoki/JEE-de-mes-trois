package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped 
public class TypeSubmissionModelBean extends TypeModelBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8989510158985356431L;

	public TypeSubmissionModelBean() { }
	
	public TypeSubmissionModelBean(TypeModelBean type){
		super(type.getId(), type.getName());
	}
}
