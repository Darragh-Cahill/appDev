package ie.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.dao.*;
import ie.domain.*;


@Service
public class MemberServiceImplementation implements MemberService {

	@Autowired
	MemberDao memberDao;
	@Autowired
	ProjectService projectService;
	
	@Override
	public Member findMember(int id) {
		if(memberDao.existsById(id)) {
			return memberDao.findById(id).get();
		}
		return null;
	}
	
	@Override
	public Member findByName(String memberName) {
		if(memberDao.existsByMemberName(memberName))
			return memberDao.findByMemberName(memberName);
		return null;
	}
	
	@Override
	public boolean deleteMember(int id) {
		if (memberDao.existsById(id))
		{
			memberDao.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public Member save(Member member) {
		if (memberDao.existsByMemberName(member.getMemberName()))
			return null;
		return memberDao.save(member);
	}
	
	@Override
	public boolean registerUser(String name, String email, String password) {
		if (memberDao.existsByMemberName(name)) {
			return false;
		}
		Member member = new Member(name, email, password);
		save(member);
		return true;
	}
	
	@Override
	public boolean addProject(int memberId, String name, String desc, int target, LocalDate dateCreation) {
		if(isUserAuthenticated(memberId)) {	//First check if member is authenticated to create a project
			Project project = new Project(name, desc, target, dateCreation, memberDao.findById(memberId).get());
			projectService.save(project);
			return true; //When project is added successfully return true
		}
		return false; //Else return false
	}
	
	@Override
	public boolean isUserAuthenticated(int id) {	//Check if member is authenticated
		if(memberDao.existsById(id)) {
			return memberDao.findAuthenticated(id);
		}
		return false;
	}
	
	@Override
	public pledgeToAProject(int projectId) {
		
	}
	
	
}
