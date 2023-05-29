package juniv.edu.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import juniv.edu.model.UserDtls;
import juniv.edu.repository.UserRepository;
import juniv.edu.service.UsererviceImpl;

@Controller
@RequestMapping("/user/")

public class UserController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UsererviceImpl service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);
		m.addAttribute("user", user);

	}
	public String division="choose",district="choose",thana="choose",union="choose",userBloodGroup="choose",status=null;
	@GetMapping("/")
	public String home()
	{
		return "user/home";
	}
	
	@GetMapping("/search")
	public String search()
	{
		return "user/search";
	}
	
	@GetMapping("/invite")
	public String invite()
	{
		return "user/invite_friend";
		
	}
	
	
	@GetMapping("/changePassword")
	public String loadChangePassword()
	{
		return "user/change_password";
	}
	
	@GetMapping("/updateProfile")
	public String loadUpdateProfile()
	{
		return "user/update_profile";
	}
	@GetMapping("/profile")
	public String loadProfile()
	{
		return "user/profile";
	}
	
	
	@PostMapping("/invitetransfer")
	public String invitetransfer(HttpServletRequest request,Principal p)
	{
		String email=p.getName();
		
		UserDtls LoginUser=userRepo.findByEmail(email);
		String friendemail=request.getParameter("frindEmail");
		LoginUser.setUserfriend(friendemail);
		
		
	/*
		System.out.println("###############################");
		
		System.out.println(email);

		System.out.println(friendemail);

		System.out.println("###############################");
		
	*/	
		
		userRepo.save(LoginUser);
		return "redirect:/user/search";
	}

	@PostMapping("/editProfile")
	
	public String updateProfile(HttpServletRequest request,Principal p)
	{
		String email=p.getName();
		UserDtls loginUser= userRepo.findByEmail(email);
		
		String name=request.getParameter("userName");
		if(name!="")loginUser.setUserName(name);
		String age=request.getParameter("userAge");
		if(age!="")loginUser.setUserAge(age);
		
		String phone=request.getParameter("userPhone");
		if(phone!="")loginUser.setUserPhone(phone);
		String status=request.getParameter("status");
		loginUser.setStatus(status);
		String division=request.getParameter("userDivision");
		if(division!="")
		loginUser.setUserDivision(division);
		String district=request.getParameter("userDistrict");
		if(district!=null)
		loginUser.setUserDistrict(district);
		
		String thana=request.getParameter("userThana");
		if(thana!=null)
		loginUser.setUserThana(thana);
		
		String union=request.getParameter("userUnion");
		if(union!=null)
		loginUser.setUserUnion(union);
		
		
		userRepo.save(loginUser);
		return "redirect:/user/updateProfile";
	}
	@GetMapping("/donner")
	public ModelAndView getBloodDonner()
	{
		status="active";
		String choose="choose";
		int unioncheck=1,thanacheck=1,districtcheck=1,divisioncheck=1;
		if(union==null||union.equals(choose))unioncheck=0;
		if(thana==null||thana.equals(choose))thanacheck=0;
		if(district==null||district.equals(choose))districtcheck=0;
		if(division==""||division.length()==0||division==null||division.equals(choose))divisioncheck=0;
		
	
		if(unioncheck==1) {
			List<UserDtls>list= service.findByUserUnionAndUserBloodGroupAndStatus(union,userBloodGroup,status);
			
			/*
			  HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
			 
			  for(UserDtls b:list){  
		
				System.out.println(b.getUserName());
			 }
			
			
			
			*/
			
			
			return new ModelAndView("user/blood_donner","user_dtls",list);
		}
		else if(thanacheck==1)
		{

			
			List<UserDtls>list= service.findByUserThanaAndUserBloodGroupAndStatus(thana,userBloodGroup,status);
			return new ModelAndView("user/blood_donner","user_dtls",list);
		}
		else if(districtcheck==1)
		{
			List<UserDtls>list= service.findByUserDistrictAndUserBloodGroupAndStatus(district,userBloodGroup,status);
			return new ModelAndView("user/blood_donner","user_dtls",list);
		}
		else if(divisioncheck==1)
		{
			List<UserDtls>list= service.findByUserDivisionAndUserBloodGroupAndStatus(division,userBloodGroup,status);
			return new ModelAndView("user/blood_donner","user_dtls",list);
		}
		else
		{
			List<UserDtls>list= service.findByStatus(status);
			return new ModelAndView("user/blood_donner","user_dtls",list);
			
		}
		
	}
	
	@PostMapping("/finddonner")
	public String bloodDonner(HttpServletRequest request,Principal p)
	{
		 division=request.getParameter("userDivision");
		 district=request.getParameter("userDistrict");
		 thana=request.getParameter("userThana");
		 union=request.getParameter("userUnion");
		 userBloodGroup=request.getParameter("userBloodGroup");
		
		return "redirect:/user/donner";
	}
	
	
	@PostMapping("/updatePassword")
	
	public String changePassword(Principal p,@RequestParam("oldPass") String oldPass,
				@RequestParam("newPass") String newPass,HttpSession session)
	{
		String email=p.getName();
		UserDtls loginUser= userRepo.findByEmail(email);
		
		boolean f=passwordEncode.matches(oldPass, loginUser.getUserPassword());
		
		if(f)
		{
			
			loginUser.setUserPassword(passwordEncode.encode(newPass));
			UserDtls updatePasswordUser= userRepo.save(loginUser);
			if(updatePasswordUser!=null)
			{
				
				session.setAttribute("msg", "Password Change Sucess");
			}
			else
			{
				session.setAttribute("msg", "someThing wrong on server");
			}
		}
		else
		{
			session.setAttribute("msg", "Old password incorrect");
			
		}
		
		
		return "redirect:/user/changePassword";
	}
	


}
