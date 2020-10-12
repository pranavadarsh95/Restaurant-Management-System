package com.pranavadarsh.RestaurantManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pranavadarsh.RestaurantManagementSystem.Entity.Reservation;
import com.pranavadarsh.RestaurantManagementSystem.Entity.Restaurant;
import com.pranavadarsh.RestaurantManagementSystem.Entity.User;
import com.pranavadarsh.RestaurantManagementSystem.springsecurityjpa.UserServiceRepository;

@Controller
public class TestingController {

	@Autowired
	UserServiceRepository userServiceRepository;

	@GetMapping("/hi")
	public String greetEveryone() {
		return "Hello Everyone";
	}

	@GetMapping("/user")
	public String Users() {
		return "user";
	}

	@GetMapping("/admin")
	public String Admin() {
		return "admin";
	}

	@GetMapping("/restaurant")
	public String Restaurant() {
		return "restaurant";
	}

	@GetMapping("/reservation")
	public String Reservation() {
		return "reservation";
	}

	@GetMapping("/booktable")
	public String index() {
		return "displayBookedReservationToEveryOne";
	}

	@GetMapping("/addUserfromadmin")
	public String callAdminUser(Model theModel) {
     User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		return "AdminControlledUserADD";
	}
	
	@GetMapping("/addUserfromAnyWhere")
	public String callAdminfromAnyWhere(Model theModel) {
     User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		return "AdminControlledUserADDFromAnyWhere";
	}
	
	@GetMapping("/addRestaurantfromadmin")
	public String callAdminRestaurant(Model theModel) {
     Restaurant theRestaurant = new Restaurant();
		
		theModel.addAttribute("restaurant", theRestaurant);
		return "AdminControlledRestaurantADD";
	}
	
	
	/*
	 * @GetMapping("/AdminToUser") public String AdminToUser() { return
	 * "AdminControlledUser"; }
	 */
	
	
	
	/*
	 * 
	 * 
	 * @GetMapping(path = "/booktable") public ModelAndView index () { ModelAndView
	 * modelAndView = new ModelAndView(); modelAndView.setViewName("displaynames");
	 * return modelAndView; }
	 */
}
