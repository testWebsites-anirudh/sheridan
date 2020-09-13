package ca.sheridancollege.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Student;
import ca.sheridancollege.database.StudentStorage;

@Controller
public class HomeController {

	@GetMapping("/")
	public String load() {
		return "index.html";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String uName, @RequestParam String pass) {
		if(uName.equals("Anirudh") && pass.equals("ani12345")) {
			return "success.html";
		}else {
			return "fail.html";
		}
	}
	
	
	@PostMapping("/submit")
	public String submit(
			@RequestParam String name, @RequestParam int sID, 
			@RequestParam(required=false)String c1,
			@RequestParam(required=false)String c2,
			@RequestParam(required=false)String c3,
			@RequestParam(required=false)String c4,
			@RequestParam(required=false)String c5,
			@RequestParam(required=false)String c6
			) {
			Student obj = new Student(name,sID,c1,c2,c3,c4,c5,c6);
			
			StudentStorage.studentList.add(obj);
		
		return "index.html";
	}
	
	@GetMapping("/display")
	public String display() {
		for(Student s : StudentStorage.studentList) {
			String courses = s.getC1()+ "\n" + s.getC2() + "\n" + s.getC3() + "\n" +
					s.getC4() + "\n" + s.getC5() + "\n" + s.getC6();
			
			System.out.println("\nName: " + s.getName());
			System.out.println("Student ID: " + s.getID());
			System.out.println("Courses taken: \n" + courses.trim());
			
		}
		return "index.html";
	}
	
}
