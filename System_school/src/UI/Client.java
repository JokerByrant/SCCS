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
		System.out.println("      ��ӭʹ��xxxѡ��ϵͳ");
		System.out.println("***********************");
		
		//1����¼
		System.out.println("��ѡ��������");
		System.out.println("1��ѧ��  2����ʦ");
		int role = sc.nextInt();
		sc.nextLine();
		System.out.println("�������û���������");
		System.out.println("�Կո�����");
		String inp = sc.nextLine();
		String[] inps = inp.split(" ");
		Teacher t = null;
		Student s = null;
		
		//ѧ������
		if(role == 1){
			s = sd.findStudentByNamePwd(inps[0], inps[1]);
			while(true){
				System.out.println("��ѡ����Ĳ���");
				System.out.println("1���鿴���пγ�    2���鿴��ѡ�γ�    3��ѡ��γ�   4���˳�");
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
				    	System.out.println("������γ̺�");
				    	String cid = sc.nextLine();
				    	Course course = new Course();
				    	course.setId(cid);
				    	boolean flag = cd.addCourseByStudent(s, course);
				    	if(flag){
				    		System.out.println("ѡ�γɹ�");
				    	}else{
				    		System.out.println("ѡ��ʧ��");
				    	}
				    	break;
				    }
				    	
				    case 4:{
				    	System.out.println("��ӭ�´μ���ʹ��");
				    	System.exit(0);
				    }
				}
			}
		}
		//��ʦ����
		else if(role == 2){
			t = td.findTeacherByNamePwd(inps[0], inps[1]);
			while(true){
				System.out.println("��ѡ����Ĳ���");
				System.out.println("1����ӿγ�    2���鿴����ӿγ�    3��ѡ��ѡ��ѧ��   4���˳�");
				int choose = sc.nextInt();
				sc.nextLine();
				switch(choose){
			    case 1:{
			    	System.out.println("������γ̺�");
			    	String cid = sc.nextLine();
			    	System.out.println("������γ���");
			    	String cname = sc.nextLine();
			    	Course course = new Course();
			    	course.setId(cid);
			    	course.setName(cname);
			    	boolean flag = cd.addCourseByTeacher(t, course);
			    	if(flag){
			    		System.out.println("��ӳɹ�");
			    	}else{
			    		System.out.println("���ʧ��");
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
			    	System.out.println("������γ̺�");
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
			    	System.out.println("��ӭ�´μ���ʹ��");
			    	System.exit(0);
			    }
			}
			}
		}else{
			System.out.println("ָ�����");
		}
		
		
		

	}

}
