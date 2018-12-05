package ie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ie.domain.Member;


public interface MemberDao extends JpaRepository<Member, Integer>{

	boolean existsByMemberName(String memberName);

	Member findByMemberName(String memberName);

	@Query("SELECT m.authenticated FROM Member m where m.memberId = :id") 
	boolean findAuthenticated(@Param("id") int id);
	
	
}
