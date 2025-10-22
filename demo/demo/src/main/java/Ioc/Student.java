package Ioc;

public class Student {
	private Course course;

	public Student(Course course) {
		this.course = course;
	}
	public void display() {
		course.display(); 
	}
	

}
