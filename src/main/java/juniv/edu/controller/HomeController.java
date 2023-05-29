package juniv.edu.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import juniv.edu.model.UserDtls;
import juniv.edu.repository.UserRepository;
import juniv.edu.service.UserService;

@Controller

public class HomeController {
	
	@Autowired
	
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		
		if(p!=null) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);
		m.addAttribute("user", user);
		}

	}
	
	
	@GetMapping("/index")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/signin")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	


	
	
	@PostMapping("/createUser")
	public String createUser(@ModelAttribute UserDtls user,HttpServletRequest request) {

		
		 String url=request.getRequestURI().toString();
		 url=url.replace(request.getServletPath(), "");
		 
		boolean f = userService.checkEmail(user.getEmail());
		int ok=0;
		
		if (f) {
			// session.setAttribute("msg", "Email Id alreday exists");
			ok=1;
			
		}
		else
		{
			UserDtls userDtls = userService.createUser(user,url);
			

			/*if (userDtls != null) {
				session.setAttribute("msg", "Register Sucessfully");
			} else {
				session.setAttribute("msg", "Something wrong on server");
			}*/
			
		}
		if(ok==1)
		{
			return "redirect:/register";
		}
		else
		{
			return "login";
		}
	

		

		
	}
	@GetMapping("/verify")
	public String verifyAccount(@Param("code") String code)
	{
		if(userService.verifyAccount(code))
		{
			
			return "login";
		}
		else
		{
			
			return "redirect:/register";
		}
		
	}
	
	
	
	
	@GetMapping("/loadForgetPassword")
	
	public String loadForgetPassword()
	{
		return "forget_password";
	}
	
	@GetMapping("/loadResetPassword/{id}")
	public String loadResetPassword(@PathVariable int id, Model m)
	{
		m.addAttribute("id",id);
		return "reset_password";
	}
	
	@PostMapping("/forgetPassword")
	
	public String forgetPassword(@RequestParam String email, @RequestParam String mobileNum)
	{
		UserDtls user=userRepo.findByEmailAndUserPhone(email,mobileNum);
		
		if(user!=null)
		{
			return "redirect:/loadResetPassword/"+user.getId();
		}
		else
		{ 
		//	session.setAttribute("msg", "Invalid email or mobile number");
			
			return "forget_password";
		}
		
		
		
	}
	
	@PostMapping("/changePassword")
	
	public String resetPassword(@RequestParam String psw, @RequestParam Integer id, HttpSession session)
	{
		UserDtls user= userRepo.findById(id).get();
		String encryptPsw=passwordEncoder.encode(psw);
		user.setUserPassword(encryptPsw);
		UserDtls updateUser=userRepo.save(user);		
		if(updateUser!=null)
		{
			session.setAttribute("msg", "Password Change Sucesfully");
		}
		
		return "redirect:/loadForgetPassword";
	}
	
	

}
