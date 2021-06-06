package hu.citec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.citec.entity.Subject;
import hu.citec.entity.SubjectGrade;
import hu.citec.entity.User;
import hu.citec.entity.UserRole;
import hu.citec.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public void addRole(UserRole userRole) {
		repo.addRole(userRole);
	}
	
	//	---------------------------ADMIN ROLE---------------------------
	public List<User> listAllUser() {
		return repo.listAllUser();
	}
	
	public User findUserById(int id) {
		return repo.findUserById(id);
	}
	
	public void editUser(User user) {
		repo.editUser(user);
	}
	
	public void addUser(User user) {
		repo.addUser(user);
	}
	
	public void deleteUserById(int id) {
		repo.deleteUserById(id);
	}
	
	public void deleteUserByRole(int id) {
		repo.deleteUserByRole(id);
	}
	
	//	---------------------------STUDENT/PARENT ROLE---------------------------
	public List<Subject> findSubjectsByUserId(int id) {
		return repo.findSubjectsByUserId(id);
	}
	
	public List<SubjectGrade> findSubjectGrades(String username) {
		return repo.findSubjectGrades(username);
	}
	
	//	---------------------------TEACHER ROLE---------------------------
	public List<User> listAllStudents() {
		return repo.listAllStudents();
	}
	
	public void addGrade(SubjectGrade grade) {
		repo.addGrade(grade);
	}
}
