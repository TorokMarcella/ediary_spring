package hu.citec.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import hu.citec.entity.User;

@Repository
public class RegistrationRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//	SIGNUP
	public void registration(User user) {
		String query = "insert into users(username, user_password, fullname, email) values(?,?,?,?)";
		List<User> users = new ArrayList<User>();
		jdbcTemplate.update(query, p -> {
			p.setString(1, user.getUsername());
			p.setString(2, user.getPassword());
			p.setString(3, user.getFullName());
			p.setString(4, user.getEmail());
		});	
		
		users.add(user);
	}
	
	//	VALIDUSER
	public boolean findUser(String username, String password) {
        String query = "select user_id from users where username = ? and user_password = ?";
        Integer currentId = 0;
       
        try {
        	currentId = jdbcTemplate.queryForObject(
        			query, 
        			SingleColumnRowMapper.newInstance(Integer.class), 
        			username,
        			password);
            if(currentId > 0) {
                return true;
            }
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
