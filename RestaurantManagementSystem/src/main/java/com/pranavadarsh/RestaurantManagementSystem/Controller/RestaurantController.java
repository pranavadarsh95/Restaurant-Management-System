package com.pranavadarsh.RestaurantManagementSystem.Controller;

import static com.pranavadarsh.RestaurantManagementSystem.Common.ResponseEnum.Restaurant_NOT_PRESENT;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pranavadarsh.RestaurantManagementSystem.Entity.Restaurant;
import com.pranavadarsh.RestaurantManagementSystem.Exception.RestaurantNotFoundException;
import com.pranavadarsh.RestaurantManagementSystem.Service.RestaurantService;

@Controller
@RequestMapping("/RestaurantDetail")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;

	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	
	   @PostMapping("/saveRestaurant")
	   public String saveRestaurants(@Valid @ModelAttribute("restaurant") Restaurant restaurant) throws MethodArgumentNotValidException {
		  
		
		        restaurantService.saveRestaurants(restaurant);
		   return "redirect:/RestaurantDetail/getALLRestaurants";
	   }
	   
	
	   @GetMapping("/getALLRestaurants")
	   public String findAllRestaurants(Model theModel){
		  
		   List<Restaurant> theRestaurant= restaurantService.findAllRestaurants();
		   theModel.addAttribute("restaurants",theRestaurant);
		   return "AdminControlledRestaurant";
	   }
	  
	   
	   @RequestMapping("/getRestaurant")
	   @ResponseBody
	   public Restaurant findRestaurantById(@RequestParam("id") int restaurantid) {
		 
		  return restaurantService.findRestaurantById(restaurantid);
		  
	   }
	   
	   
	   
	   
	   @RequestMapping("/updateRestaurant")
	   public String updateRestaurant(@ModelAttribute("editAdminRestaurant")Restaurant editAdminRestaurant) {
		   
		    restaurantService.updateRestaurant(editAdminRestaurant);
		    return "redirect:/RestaurantDetail/getALLRestaurants";
	   }
	   
	   
	   @RequestMapping("/deleteRestaurant")//@RequestParam("id")
		  public String deleteRestaurant( int restaurantId) {
		  System.out.println("Inside delete");
		  restaurantService.deleteRestaurant(restaurantId); 
		  return "redirect:/RestaurantDetail/getALLRestaurants";
		  }
	   
	   @RequestMapping("/updateAdminRestaurantBefore")
	   public String editRestaurant(int id, ModelMap model ) {
		   
		   System.out.println("in editRestaurant"+id);
		    model.put("editAdminRestaurant", restaurantService.findRestaurantById(id));
		    return  "AdminRestaurantEdit";
		}
	   
	   
	   @RequestMapping("/updateAdminRestaurantAfter")
	   @ResponseBody
	   public String saveRestaurant(@ModelAttribute("editAdminRestaurant") Restaurant editAdminRestaurant) {
	      System.out.println("In saveRestaurant");
	       restaurantService.saveRestaurants(editAdminRestaurant);
	       return "redirect:/RestaurantDetail/getALLRestaurants";
	   }
	   
}
