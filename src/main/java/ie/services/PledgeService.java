package ie.services;

import ie.domain.Pledge;

public interface PledgeService {

	boolean deletePledge(int id);
	Pledge findPledge(int id);
	Pledge addPledge(int pledgeAmount, int memberId, int projectId);

	
	
}
