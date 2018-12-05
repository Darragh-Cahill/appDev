package ie.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.dao.*;
import ie.domain.*;


@Service
public class MemberServiceImplementation implements MemberService {

	@Autowired
	MemberDao memberDao;
	@Autowired
	ProjectDao projectDao;
	@Autowired
	ProjectService projectService;
	@Autowired
	PledgeService pledgeService;
	
	
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
	public List<Project> findAllProjectsForMember(int memberId){	//List all projects for a member
		if(memberDao.existsById(memberId)){
			return findMember(memberId).getProjects();
		}
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
	public boolean registerUser(String name, String email, String password) {
		if (memberDao.existsByMemberName(name)) {
			return false;
		}
		Member member = new Member(name, email, password);
		memberDao.save(member);
		return true;
	}
	
	@Override
	public void addProject(int memberId, Project project) { //Add project to a members project list
		findMember(memberId).addProject(project);
	}
	
	@Override
	public boolean isUserAuthenticated(int id) {	//Check if member is authenticated
		if(memberDao.existsById(id)) {
			return memberDao.findAuthenticated(id);
		}
		return false;
	}
	
	@Override
	public boolean pledgeToAProject(int memberId, int projectId, int pledgeAmount) { //Add pledge to list of pledges for a member, add to projects list of pledges
		if(memberDao.existsById(memberId) && projectDao.existsById(projectId)) {
			Member member = findMember(memberId);
			Project project = projectService.findProject(projectId);
			Pledge pledge = new Pledge(member, project, pledgeAmount);
			member.addPledge(pledge); //Add the pledge to list of pledges
			projectService.addPledgeToProject(pledge, projectId); //Add pledge to project list
		}
		return false;
	}

	
	
}




