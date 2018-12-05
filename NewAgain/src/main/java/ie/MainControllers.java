package ie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainControllers {
	
	@GetMapping(value="/")
	public String handleIndexRequest() {
		return "index";
	}
	
	@GetMapping(value="/addname")
	public String welcomeByName(@RequestParam("myname") String name, Model model){
		model.addAttribute("name", name);
		return "index";
	}
	
	@PostMapping(value="/addname/{name}")
	public String welcomeByNamePathVariablesPost(@PathVariable("name") String name, Model model){
		model.addAttribute("name", name);
		return "index";
	}
	
	@GetMapping(value="/details/{name}/{email}")
	public String showDataProvided(	@PathVariable("name") String name, @PathVariable("email") String email, Model model){
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "datareceived";
	}

	
	
}
