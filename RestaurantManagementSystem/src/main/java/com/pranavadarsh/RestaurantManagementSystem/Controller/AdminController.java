/*package com.pranavadarsh.RestaurantManagementSystem.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranavadarsh.RestaurantManagementSystem.Security.LoginUsers;
import com.pranavadarsh.RestaurantManagementSystem.Security.LoginUsersRepository;


@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	LoginUsersRepository loginUsersRepository;
  
	@PostMapping("/SaveAdmin")
	public LoginUsers SaveAdminLogin(@RequestBody LoginUsers user) {
		
		return loginUsersRepository.save(user);
	}
	
	@GetMapping("/getALLAdmin")
	public List<LoginUsers> getAllAdmin() {
		List<LoginUsers> finalList = new ArrayList<LoginUsers>();
		
		List<LoginUsers> filter=loginUsersRepository.findAll();
		for(int i=0;i<filter.size();i++) {
			if(filter.get(i).getRoles().equals("ADMIN"))
			{
				finalList.add(filter.get(i));
			}
		}
		return finalList;
	}
	
	@GetMapping("/getAdmin/{adminId}")
	public LoginUsers getAdmin(@PathVariable int adminId) throws Exception {
		Optional<LoginUsers> user=loginUsersRepository.findById(adminId);
		if(user.isPresent())
		{
			user.get().getRoles().equals("ADMIN");
			return user.get();
		}
		throw new Exception("Admin Id is not correct");
	}
	
	@PutMapping("/updateAdmin/{adminId}")
	public LoginUsers updateAdmin(@RequestBody LoginUsers users,@PathVariable int adminId) throws Exception {
		Optional<LoginUsers> user=loginUsersRepository.findById(adminId);
		if(user.isPresent())
		{
			users.setId(adminId);
			return loginUsersRepository.save(users);
		}
		throw new Exception("Admin Id is not Present!!!");
	}
	
	@DeleteMapping("/deleteAdmin/{adminId}")
	public void deleteAdmin(@PathVariable int adminId) throws Exception {
		Optional<LoginUsers> user=loginUsersRepository.findById(adminId);
		if(user.isPresent())
		{
			loginUsersRepository.deleteById(adminId);
		}
		throw new Exception("Admin Id is not Present so, Cann't be deleted!!!");
	}
}
*/