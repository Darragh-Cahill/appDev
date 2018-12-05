package ie.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int memberId;
	
	@Column(nullable=false)
	private String memberName;
	
	@Column(nullable=false)
	private String memberEmail;
	
	@Column(nullable=false)
	private String  memberPassword;
	
	private boolean authenticated;	
	
	@OneToMany(mappedBy = "member", fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	private List<Pledge> pledges = new ArrayList<Pledge>();
	
	@OneToMany(mappedBy = "member", fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	private List<Project> projects = new ArrayList<Project>();
	
	
	
	public Member() {}

	public Member(String memberName, String memberEmail, String memberPassword) {
		super();
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public List<Pledge> getPledges() {
		return pledges;
	}

	public void addPledge(Pledge pledge) {
		pledges.add(pledge);
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void addProject(Project project) {
		projects.add(project);
	}
	
	
	
}






