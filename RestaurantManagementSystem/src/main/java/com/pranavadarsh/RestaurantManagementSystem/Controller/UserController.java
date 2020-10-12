package com.pranavadarsh.RestaurantManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pranavadarsh.RestaurantManagementSystem.Entity.User;
import com.pranavadarsh.RestaurantManagementSystem.Service.UserService;
import com.pranavadarsh.RestaurantManagementSystem.springsecurityjpa.MyUserDetails;
import com.pranavadarsh.RestaurantManagementSystem.springsecurityjpa.UserServiceRepository;

@Controller
@RequestMapping("/userDetail")
public class UserController {

	  @Autowired
	  UserService userService;
	  @Autowired
	  UserServiceRepository userServiceRepository;
	  
	   public UserController(UserService userService,UserServiceRepository userServiceRepository) {
		this.userService = userService;
		this.userServiceRepository=userServiceRepository;
	   }
	   
	   @PostMapping("/saveUserWithoutLogin")
	   public String saveUsersWithoutLogin(@ModelAttribute("user") User user,Model theModel) {
		        userService.saveUsers(user);
		
		int User_id = user.getId();
		theModel.addAttribute("Find_User_id", User_id);
		
		System.out.println("Find_User_id "+User_id);
		
		// provide login id and password for Security
		MyUserDetails m = new MyUserDetails(user.getFirstName()+" "+user.getLastName(),user.getPassword(),true,"USER");     
		    userServiceRepository.save(m);
		
		   return "UserREGISTERSUCCESS";
	   }
	   
	   @PostMapping("/saveUser")
	   public String saveUsers(@ModelAttribute("user") User user) {
		        userService.saveUsers(user);
		
		        
		// provide login id and password for Security
		MyUserDetails m = new MyUserDetails(user.getFirstName()+" "+user.getLastName(),user.getPassword(),true,"USER");     
		    userServiceRepository.save(m);
		
		
		   return "redirect:/userDetail/getALLusers";
	   }
	  
	   @GetMapping("/getALLusers")
	   public String findAllUsers(Model theModel){
		   
		   List<User> theUsers= userService.findAllUsers();
		   theModel.addAttribute("users", theUsers);
			
			return "AdminControlledUser";
	   }
	   
	   @RequestMapping("/getUser")
	   @ResponseBody
	   public User findUserById(@RequestParam("id") int userId) {
		   
		   return userService.findUserById(userId);
	   }
	   
	   @RequestMapping("/updateAdminUserBefore")
	   public String editUser(int id, ModelMap model ) {
		   
		   System.out.println("in editUser"+id);
		    model.put("editAdminUser", userService.findUserById(id));
		    return  "AdminUserEdit";
		}
	   
	   
	   @RequestMapping("/updateAdminUserAfter")
	   @ResponseBody
	   public String saveUser(@ModelAttribute("editAdminUser") User editAdminUser) {
	      System.out.println("In saveUser");
	       userService.saveUsers(editAdminUser);
	       return "redirect:/userDetail/getALLusers";
	   }
	   
		  @RequestMapping("/updateUser")
		  public String updateUser(@ModelAttribute("editAdminUser")User editAdminUser) {
		     
		       userService.updateUser(editAdminUser);
		   return "redirect:/userDetail/getALLusers";
		   }
		 
		  @RequestMapping("/deleteUser")//@RequestParam("id")
		  public String deleteUser( int userId) {
		  System.out.println("Inside delete");
		  
		  
		  // finding user to delete from User login database
		  String name=userService.findUserById(userId).getFirstName()+" "+userService.findUserById(userId).getLastName();
		  System.out.println("Inside delete User and name => "+name);
		  System.out.println("and password is "+ userServiceRepository.findByUserName(name).getPassword());
		  userServiceRepository.delete(userServiceRepository.findByUserName(name));
		  
		  userService.deleteUser(userId); 
		  
		  return "redirect:/userDetail/getALLusers";
		  }
		 
}
