package MyBatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class Test1_jdbc {
	SqlSession session = null;
//	public Test1_jdbc() throws IOException {
//		//1.读取mybatis的核心配置文件(mybatis-config.xml)
//		InputStream	in = Resources.getResourceAsStream("mybatis-config.xml");
//			//2.通过配置信息获取一个SqlSessionFactory工厂对象
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//	    //3.通过工厂获取一个SqlSession对象
//	    session = factory.openSession();
//	}
	
//	@Before标记会在每个@Test标记方法之前执行
	@Before
	public void beforeMethod() throws IOException{
		//1.读取mybatis的核心配置文件(mybatis-config.xml)
		InputStream	in = Resources.getResourceAsStream("mybatis-config.xml");
			//2.通过配置信息获取一个SqlSessionFactory工厂对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
	    //3.通过工厂获取一个SqlSession对象
	    session = factory.openSession();
	}
	
	@Test
	public void findAll() throws IOException{
	    //4.通过namespace+id找到要执行的sql语句(EnoMapper.xml)并执行sql语句
	    /**
	     * Emp作为存储对象需要有无参构造,因为底层mybatis会用反射调用函数的无参构造
	     */
		beforeMethod();
//		System.out.println(session);
	    List<Emp> list = session.selectList("EmpMapper.findAll");
	    //5.输出结果
	    for( Emp emp: list) {
	    	System.out.println(emp);
	    }
	}
	
	
    @Test
    public void testInsert() throws IOException{
    	int rows = session.update("EmpMapper.insert");
    	session.commit();
    	System.out.println("影响的行数:" + rows);
    }
    
    @Test
    public void selectById() throws IOException{
    	System.out.println("输入你想查询的员工ID:");
    	Scanner in = new Scanner(System.in);
    	int i = in.nextInt();
    	Emp emp = session.selectOne("EmpMapper.selectById", i);
    	System.out.println(emp);
    }
    
    @Test
    public void testDelete() throws IOException{
    	System.out.println("输入你想删除的员工姓名:");
    	Scanner in = new Scanner(System.in);
    	String s = in.nextLine();
    	int rows = session.update("EmpMapper.delete", s);
    	session.commit();
    	System.out.println("影响的行数: " + rows);
    }
    
	public static void main(String[] args) {
		try {
			Test1_jdbc jdbc = new Test1_jdbc();
			jdbc.findAll();
			jdbc.testInsert();
			System.out.println("*****************");
			jdbc.findAll();
			System.out.println("**************");
			jdbc.selectById();
			System.out.println("**************");
			jdbc.testDelete();
			jdbc.findAll();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
