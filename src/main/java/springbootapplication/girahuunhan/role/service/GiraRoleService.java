package springbootapplication.girahuunhan.role.service;

import java.util.List;

import springbootapplication.girahuunhan.role.Dto.GiraRoleDTO;
import springbootapplication.girahuunhan.role.model.GiraRole;

public interface GiraRoleService {
	List<GiraRoleDTO> findAllEntity();
	GiraRole save(GiraRoleDTO dto);
}
