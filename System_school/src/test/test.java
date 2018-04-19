//package test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import Dao.CourseDao;
//import Dao.StudentDao;
//import Dao.TeacherDao;
//import entity.Course;
//import entity.Student;
//import entity.Teacher;
//
//public class test {
//	public static void main(String[] args) {
//		StudentDao sd = new StudentDao();
//		CourseDao cd = new CourseDao();
//		TeacherDao td = new TeacherDao();
//		
//		Student student1 = sd.findStudentByNamePwd("Tom", "123456");
//		Student student2 = sd.findStudentByNamePwd("Jack", "123456");
//		Teacher teacher = td.findTeacherByNamePwd("zhangsan", "123456");
//		
//		List<Course> courses = new ArrayList<>();
//		
//		Course course1 = new Course(1001,"java");
//		Course course2 = new Course(1002,"php");
//		
//		System.out.println(student1);
//		System.out.println(student2);
//		System.out.println(teacher); 
//
//		
////		cd.addCourseByTeacher(teacher,course1);
////		cd.addCourseByTeacher(teacher, course2);
//		
//		courses = cd.FindAllCourse();
//		System.out.println(courses);
//		
////		cd.addCourseByStudent(student1, course1);
////		cd.addCourseByStudent(student2, course1);
////		cd.addCourseByStudent(student2, course2);
//		
//		courses = cd.FindAllCourseByStudent(student1);
//		System.out.println(courses);
//		
//		courses = cd.FindAllCourseByTeacher(teacher);
//		System.out.println(courses);
//	}
//}
