package springbootapplication.girahuunhan.user.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;


import springbootapplication.girahuunhan.user.model.GiraUser;
import springbootapplication.girahuunhan.user.repository.GiraUserRepository;
import springbootapplication.girahuunhan.user.validation.annotation.UniqueUsername;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
	private String message;
	
	@Override
	public void initialize(UniqueUsername uniqueUsername) {
		message = uniqueUsername.message();
	}
	
	@Autowired
	private GiraUserRepository repository;
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if(username == null)
			return false;
		
		Optional<GiraUser> userOpt = repository.findByUsername(username);
		
		if(userOpt.isEmpty()) {
			return true;
		}
		context.buildConstraintViolationWithTemplate(message)
				.addConstraintViolation()
				.disableDefaultConstraintViolation();
		
		return false;
	}

}
