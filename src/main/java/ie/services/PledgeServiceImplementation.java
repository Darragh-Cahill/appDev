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
	ProjectService projectService;
	
	@Override
	public Pledge findPledge(int id) {
		if(pledgeDao.existsById(id)) {
			return pledgeDao.findById(id).get();
		}
		return null;
	}
	
	@Override
	public Pledge findByName(String pledgeName) {
		if(pledgeDao.existsByPledgeName(pledgeName))
			return pledgeDao.findByPledgeName(pledgeName);
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
	public Pledge save(Pledge pledge) {
		if (pledgeDao.existsByPledgeName(pledge.getPledgeName()))
			return null;
		return pledgeDao.save(pledge);
	}
	
	
}
