package springbootapplication.girahuunhan.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springbootapplication.girahuunhan.user.model.UserStatus;
import springbootapplication.girahuunhan.user.validation.annotation.UniqueEmail;
import springbootapplication.girahuunhan.user.validation.annotation.UniqueUsername;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class GiraUserDTO {
	
	@Size(min=3,max=100,message="{user.username.size}")
	@UniqueUsername(message="{user.username.existed}")
	private String username;
	
	@NotBlank(message="{user.password.notblank}")
	private String password;
	
	private String displayname;
	
	@UniqueEmail(message="{user.email.existed}")
	private String email;
	
	private UserStatus status;
}
