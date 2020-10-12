package com.pranavadarsh.RestaurantManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pranavadarsh.RestaurantManagementSystem.Entity.Reservation;
import com.pranavadarsh.RestaurantManagementSystem.Entity.Restaurant;
import com.pranavadarsh.RestaurantManagementSystem.Model.RequestReservation;
import com.pranavadarsh.RestaurantManagementSystem.Service.ReservationService;

@Controller
@RequestMapping("/ReservationDetail")
public class RequestReservationController {

	@Autowired
	ReservationService reservationService;

	public RequestReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping("/sayHello")
	public String sayHello() {
		
		return "Hello user";
	}
	
	
	 @GetMapping("/getALLReservations")
	   public String findAllReservations(Model theModel){
		  
		   List<Reservation> theReservation= reservationService.findAllReservations();
		   System.out.println("Inside getALLReservations ");
		   theModel.addAttribute("reservations",theReservation);
		   return "AdminControlledReservation";
	   }
	
	
	
	
	
	@PostMapping("/bookReservation")
	public String bookReservation(@ModelAttribute("Reservation") RequestReservation Reservation,Model theModel) {
		System.out.println("Inside bookReservation");
		
		Reservation reservation=reservationService.bookReservation(Reservation);
	         
	        
	 		theModel.addAttribute("Find_Reservation_id", reservation.getId());
	 		
	 		System.out.println("Find_User_id "+reservation.getId());
	         
	         return "RESERVATIONSUCCESSFULLYBOOKED";
	}
	
	/*
	@PostMapping("/bookReservation")
	public Reservation bookReservation(@RequestBody RequestReservation requestReservation) {
		
		 
	        return reservationService.bookReservation(requestReservation);
	}
    */
	@RequestMapping("/getReservation")
	@ResponseBody
	public Reservation getReservation(@RequestParam("id") int reservationId) {
		
		return reservationService.getReservation(reservationId);
	}
	
	
	 @RequestMapping("/updateReservationforAdmin")
	   public String updateReservationforAdmin(@ModelAttribute("editAdminReservation")Reservation editAdminReservation) {
		
		 System.out.println("Inside method updateReservationforAdmin");
		 
		 reservationService.updateReservationforAdmin(editAdminReservation);
		 
		 return "redirect:/ReservationDetail/getALLReservations";
	   }
	
	
	

	@PutMapping("/updateReservation/{OldreservationId}")
	public Reservation updateReservation(@RequestBody RequestReservation requestReservation,@PathVariable int OldreservationId) {
		
		return reservationService.updateReservation(requestReservation, OldreservationId);
	}
	
	
	@RequestMapping("/deleteReservation")// Admin provided method for Reservation deletion
	  public String deleteReservation( int reservationId) {
	  System.out.println("Inside delete");
	  reservationService.deleteReservation(reservationId); 
	  return "redirect:/ReservationDetail/getALLReservations";
	  }
	
	

	
	
	 @RequestMapping("/updateAdminReservationBefore")
	   public String editReservation(int id, ModelMap model ) {
		   
		   System.out.println("in editReservation"+id);
		    model.put("editAdminReservation", reservationService.getReservation(id));
		    return  "AdminReservationEdit";
		}
	 
	
	   
	   @RequestMapping("/updateAdminReservationAfter")
	   @ResponseBody
	   public String saveReservation(@ModelAttribute("editAdminReservation") Reservation editAdminReservation) {
	      System.out.println("In saveReservation");
	      reservationService.saveReservation(editAdminReservation);
	       return "redirect:/ReservationDetail/getALLReservations";
	   }
	
	   
	
}
