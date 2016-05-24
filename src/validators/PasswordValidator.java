package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validators.pwd")
public class PasswordValidator implements Validator {
	public PasswordValidator() {

	}
	
	@Override
	public void validate(FacesContext context, UIComponent component,Object value) throws ValidatorException {
		 FacesContext.getCurrentInstance().getViewRoot().findComponent(component.getId()) ;

		}
}

 