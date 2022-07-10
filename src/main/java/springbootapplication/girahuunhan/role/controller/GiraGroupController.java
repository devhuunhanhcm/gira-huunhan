package springbootapplication.girahuunhan.role.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootapplication.girahuunhan.common.util.ResponseHelper;
import springbootapplication.girahuunhan.role.Dto.GiraGroupDTO;
import springbootapplication.girahuunhan.role.service.GiraGroupService;

@RestController
@RequestMapping("/groups")
public class GiraGroupController {
	@Autowired
	private GiraGroupService service;
	
	@GetMapping
	public Object findAllGroups() {
		List<GiraGroupDTO> groups = service.findAllGroup();
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
}
