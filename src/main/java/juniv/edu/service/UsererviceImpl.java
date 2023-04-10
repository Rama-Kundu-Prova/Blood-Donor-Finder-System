package juniv.edu.service;

import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import juniv.edu.model.UserDtls;
import juniv.edu.repository.UserRepository;


@Service
public class UsererviceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public UserDtls createUser(UserDtls user, String url) {
		user.setUserPassword(passwordEncode.encode(user.getUserPassword()));
		user.setRole("ROLE_USER");
		user.setEnable(false);
		
		
	    String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
	    String numbers = "0123456789";
	    String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    int length = 65;

	    for(int i = 0; i < length; i++) {
	      int index = random.nextInt(alphaNumeric.length());

	      char randomChar = alphaNumeric.charAt(index);
	      sb.append(randomChar);
	    }

	    String rn = sb.toString();
		user.setVerificationCode(rn);
		
		sendVerificationMail(user, url);
		return userRepo.save(user);
	}
	
	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}
	
	
	public void sendVerificationMail(UserDtls user, String url)
	{
	
		String from ="azizuljucse27@gmail.com";
		String to=user.getEmail();
		String subject="Account Verification";
		String content="Dear [[name]],<br>"
				+ "Please click the link bellow to verify your registration:<br>"
				+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
				+ "Thank you,<br>"
				+"Blood Management System";
		
		try {
			
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message);
			
			helper.setFrom(from,"Azizul");
			helper.setTo(to);
			helper.setSubject(subject);
			content=content.replace("[[name]]", user.getUserName());
			
			//String siteUrl=url+"/verify?code="+user.getVerificationCode();
			String siteUrl="Http://localhost:8080"+"/verify?code="+user.getVerificationCode();

			
			content =content.replace("[[URL]]", siteUrl);
			helper.setText(content,true);
			mailSender.send(message);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public boolean verifyAccount(String code) {
	    
		UserDtls user= userRepo.findByVerificationCode(code);
		if(user!=null)
		{
			user.setEnable(true);
			user.setVerificationCode(null);
			userRepo.save(user);
			return true;
		}
		return false;
	}

	@Override
	public List<UserDtls> findByUserUnionAndUserBloodGroupAndStatus(String union, String userBloodGroup,String status) {
		// TODO Auto-generated method stub
		return userRepo.findByUserUnionAndUserBloodGroupAndStatus(union, userBloodGroup,status);
	}
	@Override
	public List<UserDtls> findByUserThanaAndUserBloodGroupAndStatus(String thana, String userBloodGroup,String status) {
		// TODO Auto-generated method stub
		return userRepo.findByUserThanaAndUserBloodGroupAndStatus(thana, userBloodGroup,status);
	}

	public List<UserDtls> findByUserDistrictAndUserBloodGroupAndStatus(String userDistrict, String userBloodGroup,
			String status) {
		// TODO Auto-generated method stub
		return userRepo.findByUserDistrictAndUserBloodGroupAndStatus( userDistrict,  userBloodGroup, status);
	}

	public List<UserDtls> findByUserDivisionAndUserBloodGroupAndStatus(String userDivision, String userBloodGroup,
			String status) {
		// TODO Auto-generated method stub
		return userRepo.findByUserDivisionAndUserBloodGroupAndStatus( userDivision,  userBloodGroup, status);
	}

	public List<UserDtls> findByStatus(String status) {
		// TODO Auto-generated method stub
		return userRepo.findByStatus(status);
	}

	@Override
	public List<UserDtls> getBloodDonner(String status) {
		// TODO Auto-generated method stub
		return null;
	}




}
