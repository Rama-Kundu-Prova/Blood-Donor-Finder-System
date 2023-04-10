package juniv.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import juniv.edu.model.UserDtls;

@Repository
public interface UserRepository extends JpaRepository<UserDtls, Integer> {
	
	public boolean existsByEmail(String email);

	public UserDtls findByEmail(String email);
	
	public UserDtls findByEmailAndUserPhone(String email, String mobno);
	public UserDtls findByVerificationCode(String code);
	

	public List<UserDtls>findByUserUnionAndUserBloodGroupAndStatus(String union,String userBloodGroup,String status);
	public List<UserDtls>findByUserThanaAndUserBloodGroupAndStatus(String thana,String userBloodGroup,String status);

	public List<UserDtls> findByUserDistrictAndUserBloodGroupAndStatus(String userDistrict, String userBloodGroup,
			String status);

	public List<UserDtls> findByUserDivisionAndUserBloodGroupAndStatus(String userDivision, String userBloodGroup,
			String status);

	public List<UserDtls> findByStatus(String status);


	
	

	
	

}
