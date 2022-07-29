package springbootapplication.girahuunhan.user.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import springbootapplication.girahuunhan.user.model.GiraUser;
import springbootapplication.girahuunhan.user.repository.GiraUserRepository;
import springbootapplication.girahuunhan.user.validation.annotation.UniqueEmail;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	@Autowired
	private GiraUserRepository repository;
	private String message;
	
	@Override
	public void initialize(UniqueEmail uniqueEmail) {
		message = uniqueEmail.message();
	}
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		Optional<GiraUser> userOpt = repository.findByEmail(email);
		if(userOpt.isEmpty()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(message)
				.addConstraintViolation()
				.disableDefaultConstraintViolation();
		
		return false;
	}

}
