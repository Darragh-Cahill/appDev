package ie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.domain.Pledge;

public interface PledgeDao extends JpaRepository<Pledge, Integer>{

	boolean existsByPledgeName(String pledgeName);

	Pledge findByPledgeName(String pledgeName);

}
