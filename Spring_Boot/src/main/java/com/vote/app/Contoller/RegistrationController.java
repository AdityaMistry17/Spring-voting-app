package com.vote.app.Contoller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.vote.app.model.Candidate;
import com.vote.app.model.User;
import com.vote.app.repository.CandidateRepo;
import com.vote.app.repository.UserRepo;
import com.vote.app.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private CandidateRepo candiRepo;
	
    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "Registration";
    }
    
    @GetMapping("/home")
    public String home() {
    	return "login";
    }
    
    @GetMapping("/success")
    public String success() {
    	return "voting";
    }
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestParam String username, @RequestParam String password, HttpSession session) {
    	
    	User user = service.findByUsername(username);
        System.out.println(user);
        if (user != null && user.getPassword().equals(password)) {
            // Successful login
        	try {
        	
        	session.setAttribute("user", user);
        		
        	String redirectUrl = "/success";
        	System.out.println(user);
        	
        	HttpHeaders header = new HttpHeaders();
            header.add("Location", redirectUrl);
            return ResponseEntity.status(HttpStatus.OK)
                    .headers(header)
                    .body("{\"success\": true}");
            }catch (Exception e) {
            	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"success\": false}");
			}
        	
//            model.addAttribute("message", "Login successful!");
//            return "redirect:/dashboard"; // Redirect to a dashboard page
        } else {
            // Failed login
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"success\": false}");
        }
    }
    


    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(
        @RequestParam("username") String username,
        @RequestParam("password") String password,
        @RequestParam("email") String email,
        @RequestParam("phoneNumber") String phoneNumber) {

        try {
            // Your registration logic here
            repo.save(new User(username, password, email, phoneNumber));

            // Prepare a redirection URL (e.g., "/home")
            String redirectUrl = "/home";

            // Create HttpHeaders with the Location header for redirection
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", redirectUrl);

            // Return a JSON response with the Location header
            return ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body("{\"success\": true}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("{\"success\": false}");
        }
    }
    
    

    @PostMapping("/voting")
    public ResponseEntity<Object> votingUser(
        @RequestParam("username") String username,
        @RequestParam("vote") String vote)
    {

        try {
            // Your registration logic here
        	candiRepo.save(new Candidate(username, vote));

            // Prepare a redirection URL (e.g., "/home")
            String redirectUrl = "/home";

            // Create HttpHeaders with the Location header for redirection
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", redirectUrl);

            // Return a JSON response with the Location header
            return ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body("{\"success\": true}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("{\"success\": false}");
        }
    }
    
}

