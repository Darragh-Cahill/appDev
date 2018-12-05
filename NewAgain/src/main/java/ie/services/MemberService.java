package ie.services;

import java.time.LocalDate;
import java.util.List;

import ie.domain.Member;
import ie.domain.Project;

public interface MemberService {

	Member findMember(int id);
	Member findByName(String memberName);
	boolean deleteMember(int id);
	boolean registerUser(String name, String email, String password);
	boolean isUserAuthenticated(int id);
	boolean pledgeToAProject(int memberId, int projectId, int pledgeAmount);
	void addProject(int memberId, Project project);
	List<Project> findAllProjectsForMember(int memberId);

	
	
}
