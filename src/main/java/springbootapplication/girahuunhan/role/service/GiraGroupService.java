package springbootapplication.girahuunhan.role.service;

import java.util.List;

import springbootapplication.girahuunhan.role.Dto.GiraGroupDTO;

public interface GiraGroupService {
	List<GiraGroupDTO> findAllGroup();
	GiraGroupDTO createNewGroup(GiraGroupDTO dto);
}
