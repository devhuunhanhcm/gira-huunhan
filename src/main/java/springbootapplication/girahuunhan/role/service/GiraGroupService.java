package springbootapplication.girahuunhan.role.service;

import java.util.List;

import springbootapplication.girahuunhan.role.Dto.GiraGroupDTO;
import springbootapplication.girahuunhan.role.Dto.GiraGroupWithRolesDTO;

public interface GiraGroupService {
	List<GiraGroupDTO> findAllGroup();
	GiraGroupDTO createNewGroup(GiraGroupDTO dto);
	GiraGroupWithRolesDTO addRole(String groupId,String roleId);
	GiraGroupWithRolesDTO removeRole(String groupId, String roleId);
	List<GiraGroupWithRolesDTO> findAllGroupWithRole();
}
