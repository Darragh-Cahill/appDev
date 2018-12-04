package ie.services;

import java.time.LocalDate;

import ie.domain.Member;

public interface MemberService {

	Member findMember(int id);

	Member findByName(String memberName);

	boolean deleteMember(int id);

	Member save(Member member);

	boolean registerUser(String name, String email, String password);

	boolean isUserAuthenticated(int id);

	boolean addProject(int userId, String name, String desc, int target, LocalDate dateCreation);

	
	
}
