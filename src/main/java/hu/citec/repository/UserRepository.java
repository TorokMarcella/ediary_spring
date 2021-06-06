package hu.citec.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import hu.citec.entity.Subject;
import hu.citec.entity.SubjectGrade;
import hu.citec.entity.User;
import hu.citec.entity.UserRole;

@Repository
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addRole(UserRole userRole) {
		String query = "INSERT INTO user_roles(user_id, role_id) VALUES (?, ?)";
		jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(UserRole.class));
	}
	
	//	---------------------------ADMIN ROLE---------------------------
	//	ALL USER LIST //
	public List<User> listAllUser() {
		String query = "select * from users";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(User.class));
	}

	//	LIST OF A USER
	public User findUserById(int id) {
		String query = "select * from users where user_id = ?";
		return jdbcTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(User.class), id);
	}
	
	//	UPDATE USER
	public void editUser(User user) {
		String query = "update users set username = ?, user_password = ?, fullname = ?, email = ? where user_id = ?";
		jdbcTemplate.update(query, p -> {
			p.setString(1, user.getUsername());
			p.setString(2, user.getPassword());
			p.setString(3, user.getFullName());
			p.setString(4, user.getEmail());
		});
	}
	
	//	ADD NEW USER //
	public void addUser(User user) {
		String query = "insert into users (username, user_password, fullname, email, activated, blocked) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(
				query,
				user.getUsername(),
				user.getPassword(),
				user.getFullName(),
				user.getEmail(),
				user.isActivated(),
				user.isBlocked());
	}
	
	//	DELETE USER //
	public void deleteUserById(int id) {
		String query = "delete from users where user_id = ? and username = ?";
		jdbcTemplate.update(query, p -> p.setInt(1, id));
	}
	
	public void deleteUserByRole(int id) {
		String query = "delete from user_roles where user_id = ?";
		jdbcTemplate.update(query, p -> p.setInt(1, id));
	}
	
	//	---------------------------STUDENT/PARENT ROLE---------------------------
	//	FIND ALL SUBJECTS //
	public List<Subject> findSubjectsByUserId(int id){
		String query = "select s.subject_name from subject s join subject_grade sg on s.subject_id = sg.subject_id "
				+ "join users u on u.user_id = sg.user_id where u.user_id = ?";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Subject>>() {
			@Override
			public List<Subject> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Subject> subjects = new ArrayList<Subject>();
				while (rs.next()) {
					subjects.add(new Subject(rs.getInt(1), rs.getString(2)));
				}
				return subjects;
			}
		});
	}
	
	//	FIND ALL GRADES //
	public List<SubjectGrade> findSubjectGrades(String username) {
		String query = "select subject_grade.grade_date, subject_grade.descrioption,"
				+ "subject_grade.grade from subject_grade JOIN users on users.user_id = subject_grade.user_id"
				+ "where users.fullname = ?";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(SubjectGrade.class), username);
	}
	
	//	---------------------------TEACHER ROLE---------------------------
	//	LIST OF STUDENTS //
	public List<User> listAllStudents(){
		String query = "SELECT * FROM user_roles ur JOIN users u ON ur.user_id = u.user_id WHERE ur.role_id = 2";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<User>>() {
			@Override
			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> users = new ArrayList<User>();
				while (rs.next()) {
					users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				}
				return users;
			}
		});
	}
	
	//	ADD NEW GRADE //
	public void addGrade(SubjectGrade grade) {
		List<SubjectGrade> grades = new ArrayList<SubjectGrade>();
		String query = "insert into subject_grade(subject_id, user_id, grade_date, description, teacher_id, grade_int)"
				+ "values (?,?,?,?,?,?)";
		jdbcTemplate.update(
				query,
				grade.getSubjectId(),
				grade.getUserId(),
				grade.getDate(),
				grade.getDescription(),
				grade.getTeacherId(),
				grade.getGrade());
		
		grades.add(grade);
	}
	
	
}
