package ie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.dao.*;
import ie.domain.*;


@Service
public class PledgeServiceImplementation implements PledgeService {

	@Autowired
	PledgeDao pledgeDao;
	@Autowired
	MemberDao memberDao;
	@Autowired
	ProjectDao projectDao;
	@Autowired
	ProjectService projectService;
	@Autowired
	MemberService memberService;
	
	
	@Override
	public Pledge findPledge(int id) {
		if(pledgeDao.existsById(id)) {
			return pledgeDao.findById(id).get();
		}
		return null;
	}
	
	@Override
	public boolean deletePledge(int id) {
		if (pledgeDao.existsById(id))
		{
			pledgeDao.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public Pledge addPledge(int pledgeAmount, int memberId, int projectId) {
		if(memberDao.existsById(memberId) && projectDao.existsById(projectId)) {	
			Member member = memberService.findMember(memberId); //Get member and project objects and create a pledge associated with them
			Project project = projectService.findProject(projectId);
			Pledge pledge = new Pledge(member, project, pledgeAmount);
			pledgeDao.save(pledge); //Add the pledge to the database
			return pledge;
		}
		return null;
	}
	
	
}
