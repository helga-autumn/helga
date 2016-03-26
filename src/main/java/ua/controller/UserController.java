package ua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.UserService;

import com.entity.User;
@Controller
public class UserController {
	@Autowired
	private UserService service;
	private String newUser;
	private Object users;
	@RequestMapping(value = "/showAllUsers")
	public String getAllBuyers(Model model){
		List<User> users = service.getAllUsers();
		model.addAttribute ("allUsers", users);
		return "users";
		
		
		
	}
	
	@RequestMapping (value = "/createBuyer")
	public String createBuyerPage(){
		return newUser;
		
	}
	@RequestMapping(value = "/showAllUsers", method =RequestMethod.POST )
	public String createUser(@RequestParam(value = "username") String firstName, @RequestParam(value = "age") String id) {
		int idInt = Integer.parseInt(id);
		service.insertUser(firstName, idInt);
		return "redirect:/showAllUsers";

}

	public Object getUsers() {
		return users;
	}

	public void setUsers(Object users) {
		this.users = users;
	}
}