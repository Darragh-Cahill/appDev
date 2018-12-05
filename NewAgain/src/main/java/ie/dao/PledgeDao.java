package ie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.domain.Pledge;

public interface PledgeDao extends JpaRepository<Pledge, Integer>{

	
	
  /* List<Town> findByCounty_CountyName(String countyName);
  	List<Town> findByCounty_CountyId(int countyId);
  	List<Town> findByTownNameIgnoringCase(String townName);
  	List<Town> findByTownNameIsStartingWith(String s);
  */

}
