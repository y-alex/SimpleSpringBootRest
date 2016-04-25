package demo.controller;

import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import demo.domain.Shop;
import demo.domain.User;
import demo.repository.ShopRepository;
import demo.repository.UserRepository;



@RestController
public class ShopController {
	@Inject
	private ShopRepository mShopRepository;
	@Inject
	private UserRepository mUserRepository;
	
		
	@RequestMapping(value="/users/{userId}/shops/{shopId}", method=RequestMethod.GET)
	public ResponseEntity<Shop> getOneShop(@PathVariable Long userId, @PathVariable Long shopId) {	
		Shop s = mShopRepository.findOne(shopId);
		if(s.getmUser().getmId() == userId){
			return new ResponseEntity<Shop> (s, HttpStatus.OK);
		}else{
			return new ResponseEntity<Shop>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	

	
	@RequestMapping(value="/users/{userId}/shops", method=RequestMethod.POST)
			public ResponseEntity<Shop> createShop(@PathVariable Long userId, @RequestBody Shop shop) {
		 User u = mUserRepository.findOne(userId);
		 if(u != null){
			 
			 shop = mShopRepository.save(new Shop(shop.getmShopName(),shop.getmShopImgUri(), 
					shop.getmShopLonCoord(),shop.getmShopLatCoord(), u));
			// Set the headers for the newly created resource
			HttpHeaders responseHeaders = new 	HttpHeaders();
			responseHeaders.setLocation(ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(shop.getmId())
					.toUri());
			return new ResponseEntity<Shop>(null, responseHeaders, HttpStatus.CREATED);
		 }else{
			 return new ResponseEntity<Shop>(HttpStatus.BAD_REQUEST);
		 }
		 
			
			}
	
	@RequestMapping(value="/users/{userId}/shops/{shopId}", method=RequestMethod.PUT)
	public ResponseEntity<Shop> updateShop(@RequestBody Shop shop, @PathVariable Long userId, @PathVariable Long shopId) {
		// Save the entity
		//Shop s = mShopRepository.save(shop);
		 User u = mUserRepository.findOne(userId);
		if(u != null){		
		 shop = mShopRepository.save(new Shop(shopId, shop.getmShopName(),shop.getmShopImgUri(), 
					shop.getmShopLonCoord(),shop.getmShopLatCoord(), u));
		return new ResponseEntity<Shop>(HttpStatus.OK);
		}else{
			 return new ResponseEntity<Shop>(HttpStatus.BAD_REQUEST);
		 }
   }
		
	@RequestMapping(value="/users/{userId}/shops/{shopId}", method=RequestMethod.DELETE)
		public ResponseEntity<Shop> deleteUser(@PathVariable Long userId, @PathVariable Long shopId) {
		Shop s = mShopRepository.findOne(shopId);
		if(s!=null && s.getmUser().getmId() == userId){
			mShopRepository.delete(shopId);
			return new ResponseEntity<Shop> (HttpStatus.OK);
		}else{
			return new ResponseEntity<Shop>(HttpStatus.BAD_REQUEST);
		}
		}

}
