package springbootapplication.girahuunhan.role.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import springbootapplication.girahuunhan.common.util.ResponseHelper;
import springbootapplication.girahuunhan.role.Dto.GiraGroupDTO;
import springbootapplication.girahuunhan.role.Dto.GiraGroupWithRolesDTO;
import springbootapplication.girahuunhan.role.mapper.GiraGroupMapper;
import springbootapplication.girahuunhan.role.service.GiraGroupService;
@Slf4j
@RestController
@RequestMapping("/groups")
public class GiraGroupController {
	@Autowired
	private GiraGroupService service;
	
	@GetMapping
	public Object findAllGroups() {
		log.info("Find All Groups");
		List<GiraGroupDTO> groups = service.findAllGroup();
		return ResponseHelper.getResponse(groups, HttpStatus.OK);
	}
	@GetMapping("/group-with-role")
	public Object finAllGroupWithRole() {
		List<GiraGroupWithRolesDTO> groups = service.findAllGroupWithRole();
		return ResponseHelper.getResponse(groups, HttpStatus.OK);
	}
	@PostMapping
	public Object createNewGroups(@Valid @RequestBody GiraGroupDTO dto,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHelper.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		GiraGroupDTO newGroup = service.createNewGroup(dto);
		return ResponseHelper.getResponse(newGroup, HttpStatus.CREATED);
	}
	@PostMapping("add-role/{group-id}/{role-id}")
	public Object addRoleToGroup(@PathVariable(name="group-id") String groupId,
								@PathVariable(name="role-id") String roleId) {
		GiraGroupWithRolesDTO modifiedGroup = service.addRole(groupId, roleId);
		if(modifiedGroup == null ) {
			
			return ResponseHelper.getErrorResponse("Group or Role is not existing", HttpStatus.BAD_REQUEST);
		}
		return ResponseHelper.getResponse(modifiedGroup, HttpStatus.OK);
	}
	@PostMapping("remove/{group-id}/{role-id}")
	public Object removeRole(@PathVariable(name ="group-id") String groupId,
							@PathVariable(name="role-id") String roleId) {
		
		GiraGroupWithRolesDTO modifiedGroup = service.removeRole(groupId,roleId);
		if(modifiedGroup == null) {
			return ResponseHelper.getErrorResponse("Group or Role is not existing", HttpStatus.BAD_REQUEST);
		}
		
		return ResponseHelper.getResponse(modifiedGroup, HttpStatus.OK);
	}
}
