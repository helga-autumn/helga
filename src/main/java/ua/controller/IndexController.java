package ua.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.entity.User;

import service.UserService;


@Controller
public class IndexController {

	private List<User> list = new ArrayList<User>();
	@Autowired
	private UserService user;
	

	@RequestMapping("/user")
	public String indexView(Model model) {
		user.toString();
		model.addAttribute("users", list);
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String indexPost(@RequestParam(value="username") int id,
			@RequestParam String username) {
		list.add(new User(id, username));
		return "redirect:/";
	}
	
	@RequestMapping("/{id}")
	public String delete(@PathVariable int id){
		list.remove(id);
		return "redirect:/";
	}
}
