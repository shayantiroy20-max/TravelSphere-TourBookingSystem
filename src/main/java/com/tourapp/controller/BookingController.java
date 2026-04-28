package com.tourapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tourapp.model.Booking;
import com.tourapp.service.BookingService;

import jakarta.servlet.http.HttpSession;
@Controller
public class BookingController {
    @Autowired
    BookingService service;
    // HOME PAGE
    @GetMapping("/")
    public String home() {
        return "index";
    }
    // DESTINATION HOTELS
    @GetMapping("/destination-hotels")
    public String hotels(@RequestParam String place, Model model) {
        model.addAttribute("place", place);
        return "destination-hotels";
    }
    // BOOKING PAGE
    @GetMapping("/booking")
    public String bookingPage() {
        return "booking";
    }
    // PAYMENT PAGE
    @PostMapping("/payment")
    public String paymentPage(Booking booking, Model model) {
        model.addAttribute("booking", booking);
        return "payment";
    }
   @PostMapping("/confirmBooking")
public String confirmBooking(Booking booking, Model model){
    System.out.println("Confirm booking method called");
    System.out.println("Name received: " + booking.getName());
    try {
        service.saveBooking(booking);
        System.out.println("Booking saved successfully");
    } catch(Exception e){
        System.out.println("Error saving booking: " + e.getMessage());
    }
    model.addAttribute("booking", booking);
    return "confirmation";
}
    // LOGIN PAGE
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    // LOGIN AUTH
    @PostMapping("/login")
    public String loginCheck(@RequestParam String username,
                             @RequestParam String password,
                             HttpSession session,
                             Model model) {
        if (username.equals("admin") && password.equals("admin123")) {
            session.setAttribute("admin", "true");
            return "redirect:/admin";
        }
        model.addAttribute("error", "Invalid Username or Password");
        return "login";
    }
    // ADMIN DASHBOARD
    @GetMapping("/admin")
public String admin(Model model, HttpSession session){
    if(session.getAttribute("admin")==null){
        return "redirect:/login";
    }
    model.addAttribute("bookings", service.getAllBookings());
    return "admin";
}
    // DELETE BOOKING
    @GetMapping("/delete/{id}")
    public String deleteBooking(@PathVariable int id, HttpSession session) {
        if (session.getAttribute("admin") == null) {
            return "redirect:/login";
        }
        service.deleteBooking(id);
        return "redirect:/admin";
    }
    // BOOKING HISTORY
    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("bookings", service.getAllBookings());
        return "history";
    }
    // ITINERARY
    @GetMapping("/itinerary")
    public String itinerary() {
        return "itinerary";
    }
    // LOGOUT
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}