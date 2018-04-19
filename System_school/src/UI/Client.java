package UI;

import java.util.List;
import java.util.Scanner;

import Dao.CourseDao;
import Dao.StudentDao;
import Dao.TeacherDao;
import entity.Course;
import entity.Student;
import entity.Teacher;


/**
 * author:Lionel-Messi
 * date:18-04-19
 * 
 * */

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentDao sd = new StudentDao();
		TeacherDao td = new TeacherDao();
		CourseDao cd = new CourseDao();
		
		System.out.println("***********************");
		System.out.println("      欢迎使用xxx选课系统");
		System.out.println("***********************");
		
		//1、登录
		System.out.println("请选择你的身份");
		System.out.println("1、学生  2、教师");
		int role = sc.nextInt();
		sc.nextLine();
		System.out.println("请输入用户名和密码");
		System.out.println("以空格区分");
		String inp = sc.nextLine();
		String[] inps = inp.split(" ");
		Teacher t = null;
		Student s = null;
		
		//学生操作
		if(role == 1){
			s = sd.findStudentByNamePwd(inps[0], inps[1]);
			while(true){
				System.out.println("请选择你的操作");
				System.out.println("1、查看所有课程    2、查看已选课程    3、选择课程   4、退出");
				int choose = sc.nextInt();
				sc.nextLine();
				switch(choose){
				    case 1:{
				    	List<Course> cous = cd.FindAllCourse();
				    	for(Course c:cous){
				    		System.out.print(c.getId()+"\t\t");
				    		System.out.print(c.getName()+"\t\t");
				    		System.out.println(c.getTeacher().getName());
				    	}
				    	break;
				    }
				    	
				    case 2:{
				    	List<Course> cous = cd.FindAllCourseByStudent(s);
				    	for(Course c:cous){
				    		System.out.print(c.getId()+"\t\t");
				    		System.out.print(c.getName()+"\t\t");
				    		System.out.println(c.getTeacher().getName());
				    	}
				    	break;
				    }
				    	
				    case 3:{
				    	System.out.println("请输入课程号");
				    	String cid = sc.nextLine();
				    	Course course = new Course();
				    	course.setId(cid);
				    	boolean flag = cd.addCourseByStudent(s, course);
				    	if(flag){
				    		System.out.println("选课成功");
				    	}else{
				    		System.out.println("选课失败");
				    	}
				    	break;
				    }
				    	
				    case 4:{
				    	System.out.println("欢迎下次继续使用");
				    	System.exit(0);
				    }
				}
			}
		}
		//教师操作
		else if(role == 2){
			t = td.findTeacherByNamePwd(inps[0], inps[1]);
			while(true){
				System.out.println("请选择你的操作");
				System.out.println("1、添加课程    2、查看已添加课程    3、选择选课学生   4、退出");
				int choose = sc.nextInt();
				sc.nextLine();
				switch(choose){
			    case 1:{
			    	System.out.println("请输入课程号");
			    	String cid = sc.nextLine();
			    	System.out.println("请输入课程名");
			    	String cname = sc.nextLine();
			    	Course course = new Course();
			    	course.setId(cid);
			    	course.setName(cname);
			    	boolean flag = cd.addCourseByTeacher(t, course);
			    	if(flag){
			    		System.out.println("添加成功");
			    	}else{
			    		System.out.println("添加失败");
			    	}
			    	break;
			    	
			    }
			    	
			    case 2:{
			    	List<Course> cous = cd.FindAllCourseByTeacher(t);
			    	for(Course c:cous){
			    		System.out.print(c.getId()+"\t\t");
			    		System.out.print(c.getName()+"\t\t");
			    		System.out.println(c.getTeacher().getName());
			    	}
			    	break;
			    }
			    	
			    case 3:{
			    	System.out.println("请输入课程号");
			    	String cid = sc.nextLine();
			    	Course course = new Course();
			    	course.setId(cid);
			    	List<Student> stus = sd.findStudentByCourse(course);
			    	for(Student stu:stus){
			    		System.out.print(stu.getId()+"\t\t");
			    		System.out.println(stu.getName());
			    		 
			    	}
			    	break;
			    }
			    	
			    case 4:{
			    	System.out.println("欢迎下次继续使用");
			    	System.exit(0);
			    }
			}
			}
		}else{
			System.out.println("指令错误");
		}
		
		
		

	}

}
