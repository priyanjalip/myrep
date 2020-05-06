package com.multai.vip.controller;

import com.multai.vip.bean.Person;
import com.multai.vip.service.ILoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({ "login" })
public class LoginController {
	@Autowired
	ILoginService loginService;

	@GetMapping({ "/get/{userId}" })
	public Person getPerson(@PathVariable int userId) {
		return this.loginService.getUserById(userId);
	}

	@GetMapping({ "/add/{userId}/{firstName}/{lastName}/{mobile}/{password}/{email}/{adminType}" })
	public int addUser(@PathVariable int userId, @PathVariable String firstName, @PathVariable String lastName,
			@PathVariable Long mobile, @PathVariable String password, @PathVariable String email,
			@PathVariable String adminType) {
		Person person = new Person();
		person.setUserId(userId);
		person.setEmail(email);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setMobile(mobile);
		person.setPassword(password);
		person.setAdminType(adminType);
		return this.loginService.saveUser(person);
	}
	
	@GetMapping({ "/update/{userId}/{firstName}/{lastName}/{mobile}/{password}/{email}/{adminType}" })
	public String update(@PathVariable int userId, @PathVariable String firstName, @PathVariable String lastName,
			@PathVariable Long mobile, @PathVariable String password, @PathVariable String email,
			@PathVariable String adminType) {
		Person person = new Person();
		person.setUserId(userId);
		person.setEmail(email);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setMobile(mobile);
		person.setPassword(password);
		person.setAdminType(adminType);
		loginService.updateUser(person);
		return "Updated";
	}

	@GetMapping({ "/getAllUser" })
	public List<Person> getAll() {
		return this.loginService.getAllUsers();
	}

	@GetMapping({ "/forgetPassword/{email}/{password}" })
	public String forgetPassword(@PathVariable String email,@PathVariable String password) {
		loginService.setTemporaryPassword(email,password);
		return "Temporary password sent successfully to "+email;
	}
	
	@GetMapping({ "/deleteByUserId/{userId}" })
	public String deleteByUserId(@PathVariable int userId) {
		loginService.deleteByUserId(userId);
		return "Deleted Successfully";
	}

}
