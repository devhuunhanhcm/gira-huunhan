package springbootapplication.girahuunhan.role.Dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GiraRoleDTO {
	private UUID id;
	
	@Size(min = 5, max = 30, message = "Role Code must be 5 characters.")
	private String code;
	
	@NotBlank(message = "Description must be not blank.")
	private String description;

}
