package myspring.users.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.dao.UserDao;
import myspring.user.service.UserService;
import myspring.user.vo.DeptVO;
import myspring.user.vo.StudentVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class MyBatisTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory factory;
	
	@Autowired
	SqlSession session;
	
	@Autowired
	UserDao userDa;
	
	@Autowired
	UserService userService;
	
	@Test
	public void student() {
		StudentVO stu = new StudentVO(1004, "학생이름", 30, "1학년", "주간", new DeptVO(20));
		int cnt = session.insert("studentNS.insertStudent",stu);
		System.out.println("등록건수" + cnt);
		
		List<StudentVO> selectList = session.selectList("studentNS.selectStudentDeptById");
		for(StudentVO studentVO : selectList) {
			System.out.println(selectList);
		}
	}
	
	
	@Test @Ignore
	public void service() {
		UserVO user = userService.getUser("test");
		System.out.println(user);
	}
	
	
	@Test @Ignore
	public void dao() {
		UserVO user = userDa.read("test");
		System.out.println(user);
	}
	
	@Test @Ignore
	public void update_list() {
		//update
		UserVO user = new UserVO("test", "테스트22", "남", "서울");
		int cnt = session.update("userNS.updateUser", user);
		System.out.println("수정된 건수 " + cnt);
		//list
		List<UserVO> userList = session.selectList("userNS.selectUserList");
		for(UserVO uservo : userList) {
			System.out.println(uservo);
		}
	}
	
	@Test @Ignore
	public void insert() {
		UserVO user = new UserVO("test", "테스트", "여", "부산");
		int cnt = session.insert("userNS.insertUser", user);
		System.out.println("등록된 건수" + cnt);
	}
	
	@Test
	public void session() {
		UserVO user = session.selectOne("userNS.selectUserById", "gildong");
		System.out.println(user);
		//System.out.println(factory.getClass().getName());
	}
	
	@Test @Ignore
	public void ds() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println(metaData.getURL());
			System.out.println(metaData.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
