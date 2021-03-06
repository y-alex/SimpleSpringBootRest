package demo.controller;

import javax.inject.Inject;
import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
		return new ResponseEntity<Iterable<User>>(mUserRepository.findAll(),	HttpStatus.OK);
	}

	@RequestMapping(value="/users", method=RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user){
		user = mUserRepository.save(user);
		// Set the location header for the newly created	resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newUserUri = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(user.getmId())
		.toUri();
		responseHeaders.setLocation(newUserUri);
		return new ResponseEntity<User>(null, responseHeaders,
		HttpStatus.CREATED);

	}
	
	@RequestMapping(value="/users/{userId}",
			method=RequestMethod.GET)
			public ResponseEntity<User> getUser(@PathVariable Long userId)			{
			User u = mUserRepository.findOne(userId);
			return new ResponseEntity<User> (u, HttpStatus.OK);
	}
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.PUT)
		public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId) {
			// Save the entity
		
			User u = mUserRepository.save(new User(userId, user.getmUserName(), user.getmUserLastName(), user.getmUserAdress()));
			return new ResponseEntity<User>(HttpStatus.OK);
	   }
			
	@RequestMapping(value="/users/{userId}", method=RequestMethod.DELETE)
			public ResponseEntity<User> deleteUser(@PathVariable Long userId) {
			mUserRepository.delete(userId);
			return new ResponseEntity<User>(HttpStatus.OK);
			}
}

