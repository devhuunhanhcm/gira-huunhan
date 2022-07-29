package springbootapplication.girahuunhan.user.controller;

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
import springbootapplication.girahuunhan.user.dto.GiraUserDTO;
import springbootapplication.girahuunhan.user.service.GiraUserService;

@RestController
@RequestMapping("users")
public class GiraUserController {
	@Autowired
	private GiraUserService service;
	
	@PostMapping
	public Object createNewUser(@Valid @RequestBody GiraUserDTO dto,
								BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHelper.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		GiraUserDTO newUser = service.createNewUser(dto);
		
		return ResponseHelper.getResponse(newUser, HttpStatus.CREATED);
	}
}
