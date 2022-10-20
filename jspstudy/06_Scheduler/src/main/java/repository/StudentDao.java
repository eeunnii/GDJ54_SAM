package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Student;

public class StudentDao {

	// field - SqlSessionFactory
	private SqlSessionFactory factory;
	
	// singleton pattern
	private static StudentDao dao = new StudentDao();
	private StudentDao() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static StudentDao getInstance() {
		return dao;
	}
	
	// method
	
	String mapper = "mybatis.mapper.student.";
	
	// 1. 학생목록
	public List<Student> selectAllStudents() {
		SqlSession ss = factory.openSession();
		List<Student> students = ss.selectList(mapper + "selectAllStudents");
		ss.close();
		return students;
	}
	
	// 2. 전체학생수
	public int selectAllStudentsCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "selectAllStudentsCount");
		ss.close();
		return count;
	}
	
	// 3. 전체평균
	public double selectAllStudentsAverage() {
		SqlSession ss = factory.openSession();
		double average = ss.selectOne(mapper + "selectAllStudentsAverage");
		ss.close();
		return average;
	}
	
	// 4. 학생등록
	public int insertStudent(Student student) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertStudent", student);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
