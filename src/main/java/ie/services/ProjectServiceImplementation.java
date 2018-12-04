package ie.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.dao.*;
import ie.domain.*;


@Service
public class ProjectServiceImplementation implements ProjectService {

	@Autowired
	ProjectDao projectDao;
	
	
	@Override
	public List<Project> listAllProjects() {
		// TODO Auto-generated method stub
		return projectDao.findAll();
	}
	
	@Override
	public Project findProject(int id) {
		if(projectDao.existsById(id)) {
			return projectDao.findById(id).get();
		}
		return null;
	}
	
	@Override
	public Project findByName(String projectName) {
		if(projectDao.existsByProjectName(projectName))
			return projectDao.findByProjectName(projectName);
		return null;
	}
	
	@Override
	public boolean deleteProject(int id) {
		if (projectDao.existsById(id))
		{
			projectDao.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public Project save(Project project) {
		if (projectDao.existsByProjectName(project.getProjectName()))
			return null;
		return projectDao.save(project);
	}
	
	@Override
	public String findProjectName(int id) {
		if (projectDao.existsById(id))
			return projectDao.findNameById(id);
		return null;
	}
	
	@Override
	public String findProjectDesc(int id) {
		if(projectDao.existsById(id))
			return projectDao.findDescriptionById(id);
		return null;
	}
	
	@Override
	public int findProjectTargetAmount(int id) {
		if(projectDao.existsById(id))
			return projectDao.findTargetAmount(id);
		return 0;
	}
	
	@Override
	public LocalDate findProjectDateCreation(int id) {
		if(projectDao.existsById(id))
			return projectDao.findDateCreation(id);
		return null;
	}
	
	
}
