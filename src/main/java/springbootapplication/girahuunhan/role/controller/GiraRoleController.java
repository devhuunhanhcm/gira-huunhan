package springbootapplication.girahuunhan.role.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles")
public class GiraRoleController {
	@GetMapping
	public Object welcome() {
		return "wellcome to roles";
	}
}
