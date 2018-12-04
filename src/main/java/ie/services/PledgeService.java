package ie.services;

import ie.domain.Pledge;

public interface PledgeService {

	Pledge save(Pledge pledge);

	boolean deletePledge(int id);

	Pledge findByName(String pledgeName);

	Pledge findPledge(int id);

	
	
}
