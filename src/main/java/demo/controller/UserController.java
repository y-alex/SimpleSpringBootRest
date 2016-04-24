package demo.controller;

import javax.inject.Inject;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.User;
import demo.repository.UserRepository;

@RestController
public class UserController {
	@Inject
	private UserRepository mUserRepository;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<Iterable<User>> getAllUsers() {		
		Iterable<User> allPolls = mUserRepository.findAll();
		return new ResponseEntity<Iterable<User>>(mUserRepository.findAll(),	HttpStatus.OK);
	}

}

