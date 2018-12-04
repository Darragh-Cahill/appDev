package ie.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Id;

@Entity
public class Pledge {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pledgeId;
	
	@ManyToOne
	@JoinColumn(name="memberId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="projectId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Project project;
	
	
	public Pledge() {}
	
	public Pledge(int pledgeId, Member member, Project project) {
		super();
		this.pledgeId = pledgeId;
		this.member = member;
		this.project = project;
	}
	
	public int getPledgeId() {
		return pledgeId;
	}
	public void setPledgeId(int pledgeId) {
		this.pledgeId = pledgeId;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	
	
}
