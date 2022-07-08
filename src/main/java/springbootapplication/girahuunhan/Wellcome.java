package springbootapplication.girahuunhan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class Wellcome {
	@GetMapping
	public Object welcome() {
		return "welcome to springboot application version 2";
	}
}
