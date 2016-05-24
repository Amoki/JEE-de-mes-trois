package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validators.email")
public class EmailValidator implements Validator {
	private static final String EMAIL_PATTERN = "[a-zA-Z0-9-._]+@[a-zA-Z0-9-._]+.[a-z]+" ;
	private Pattern pattern;
	private Matcher matcher;
	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component,Object value) throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
			((UIInput) component).setValid(false);
			FacesMessage msg =new FacesMessage("L'email n'est pas correcte.","L'email n'est pas correcte, merci de suivre la contrainte suivante: "+EMAIL_PATTERN);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg); 
			}
		}
}