package springbootapplication.girahuunhan.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootapplication.girahuunhan.common.util.ResponseHelper;
import springbootapplication.girahuunhan.role.Dto.GiraRoleDTO;
import springbootapplication.girahuunhan.role.model.GiraRole;
import springbootapplication.girahuunhan.role.service.GiraRoleService;


@RestController
@RequestMapping("roles")
public class GiraRoleController {
	@Autowired
	private GiraRoleService service;
	
	@GetMapping
	public Object findAll() {
		List<GiraRole> roles = service.findAllEntity();
		return new ResponseEntity<>(roles,HttpStatus.OK);
	}
	
	@PostMapping
	public Object createNewRole(@Valid @RequestBody GiraRoleDTO dto,
								BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHelper.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		//test nên mình trả về entity luôn 
		GiraRole role = service.save(dto);
		
		return ResponseHelper.getResponse(role, HttpStatus.CREATED);
	}
	
	
}
