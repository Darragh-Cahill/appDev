package ie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ie.dao.*;
import ie.domain.*;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	MemberDao memberDao;
	@Autowired
	PledgeDao pledgeDao;
	@Autowired
	ProjectDao projectDao;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Member david = new Member();
		memberDao.save(david);
		
		
		//County cork = new County("Cork");
		//countyDao.save(cork);
		//townDao.save(new Town("Ballincollig", cork));
		
	}
}