package demo.controller;

import javax.inject.Inject;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@RequestMapping(value="/users", method=RequestMethod.POST)
	public ResponseEntity createPoll(@RequestBody User user){
		user = mUserRepository.save(user);
		// Set the location header for the newly created	resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newUserUri = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(user.getmId())
		.toUri();
		responseHeaders.setLocation(newUserUri);
		return new ResponseEntity(null, responseHeaders,
		HttpStatus.CREATED);

	}
}

