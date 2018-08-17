package com.learnforlife.controller;

import java.awt.Checkbox;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learnforlife.entity.Course;
import com.learnforlife.entity.CourseOffering;
import com.learnforlife.entity.User;
import com.learnforlife.general.CheckBox;
import com.learnforlife.general.Login;
import com.learnforlife.general.Registration;
import com.learnforlife.service.ServiceDao;

@Controller
public class MainController {
	
	@Autowired
	private ServiceDao serviceDao;
	
	@RequestMapping("/")
	public String home() {
			return "home";
	}
	
	@RequestMapping("/registration")
	public String registrationForm(Model m) {
			m.addAttribute("registration",new Registration());
			return "registration";
	}
	
	@RequestMapping("/login")
	public String loginForm(Model model) {
			model.addAttribute("login",new Login());
			return "login";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("registration") Registration registration) {
		serviceDao.add(registration);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/validation",method = RequestMethod.POST)
	public String loginValidation(@ModelAttribute("login") Login login, Model model) {
		User user = serviceDao.validateUser(login);
		Map<String,Long> listOfCoursesAndCount = new HashMap<>();
		if(user.getRole().equals("STUDENT")) {
			model.addAttribute("user",user);
			List<Course> listOfCourses = serviceDao.getAllCourses();
			for (Course course : listOfCourses) {
				listOfCoursesAndCount.put(course.getCourseName(), 
										  serviceDao.getCountOfProfessors(course.getCourseName()));
			}
			model.addAttribute("listOfCoursesAndCount",listOfCoursesAndCount);
			model.addAttribute("coursesOfStudent",serviceDao.getCoursesOfStudent(user.getUsername()));
			return "Student";
		}
		else if(user.getRole().equals("TUTOR")) {
			model.addAttribute("user",user);
			List<Course> listOfCourses = serviceDao.getAllCourses();
			for (Course course : listOfCourses) {
				listOfCoursesAndCount.put(course.getCourseName(), 
										  serviceDao.getCountOfProfessors(course.getCourseName()));
			}
			model.addAttribute("listOfCoursesAndCount",listOfCoursesAndCount);
			model.addAttribute("coursesOfTutor",serviceDao.getCoursesOfTutor(user.getUsername()));
			return "Tutor";
		}
		return null;
	}
	
	@RequestMapping("/appendOffering/{courseName}/{userId}")
	public String getCourseOfferingsOfACourse(
											@PathVariable String courseName,
											@PathVariable int userId,  
											Model model
											  ) {
		model.addAttribute("userId",userId);
		model.addAttribute("courseName",courseName);
		model.addAttribute("courseOfferingFields",new CourseOffering());
		model.addAttribute("listOfCourseOfferings",serviceDao.getCoursesOfName(courseName));
		return "appendOffering";
	}
	
	@RequestMapping("/appendCourse/{courseName}/{userId}")
	public String appendCourse(
							   @ModelAttribute("courseOfferingFields") CourseOffering courseOffering,
      						   @PathVariable String courseName,
							   @PathVariable int userId
							   ) {
		serviceDao.appendCourse(courseName, userId,courseOffering);
		return "redirect:/appendOffering/{courseName}/{userId}";
	}
	
	@RequestMapping("/selectTutors/{courseName}/{userName}")
	public String selectTutors(@PathVariable String courseName,
							   @PathVariable String userName,
							   Model model) {
		List<CourseOffering> tutorsOfACourse = serviceDao.selectTutors(courseName);
		model.addAttribute("tutorsOfACourse",tutorsOfACourse);
		model.addAttribute("courseName",courseName);
		model.addAttribute("userName",userName);
		model.addAttribute("check_box",new CheckBox());
		return "selectTutors";
	}
	
	@RequestMapping("/assignStudent/{userName}")
	public String assignStudentToTutors(@PathVariable("userName") String studentName, @ModelAttribute("check_box") CheckBox checkbox, Model model) {
		String[] tutorsOfACourse = checkbox.getListOfTutors();
		serviceDao.assignStudentToTutors(studentName,tutorsOfACourse);
		return "result";
	}
}
