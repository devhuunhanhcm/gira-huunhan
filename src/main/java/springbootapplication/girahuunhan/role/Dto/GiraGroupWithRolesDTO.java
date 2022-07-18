package springbootapplication.girahuunhan.role.Dto;

import java.util.Set;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GiraGroupWithRolesDTO {
	private UUID id;
	
	private String code;
	private String description;
	private Set<GiraRoleDTO> roles;
}
