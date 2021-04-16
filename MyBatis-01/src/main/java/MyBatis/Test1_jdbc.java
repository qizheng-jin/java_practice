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
//		//1.��ȡmybatis�ĺ��������ļ�(mybatis-config.xml)
//		InputStream	in = Resources.getResourceAsStream("mybatis-config.xml");
//			//2.ͨ��������Ϣ��ȡһ��SqlSessionFactory��������
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//	    //3.ͨ��������ȡһ��SqlSession����
//	    session = factory.openSession();
//	}
	
//	@Before��ǻ���ÿ��@Test��Ƿ���֮ǰִ��
	@Before
	public void beforeMethod() throws IOException{
		//1.��ȡmybatis�ĺ��������ļ�(mybatis-config.xml)
		InputStream	in = Resources.getResourceAsStream("mybatis-config.xml");
			//2.ͨ��������Ϣ��ȡһ��SqlSessionFactory��������
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
	    //3.ͨ��������ȡһ��SqlSession����
	    session = factory.openSession();
	}
	
	@Test
	public void findAll() throws IOException{
	    //4.ͨ��namespace+id�ҵ�Ҫִ�е�sql���(EnoMapper.xml)��ִ��sql���
	    /**
	     * Emp��Ϊ�洢������Ҫ���޲ι���,��Ϊ�ײ�mybatis���÷�����ú������޲ι���
	     */
		beforeMethod();
//		System.out.println(session);
	    List<Emp> list = session.selectList("EmpMapper.findAll");
	    //5.������
	    for( Emp emp: list) {
	    	System.out.println(emp);
	    }
	}
	
	
    @Test
    public void testInsert() throws IOException{
    	int rows = session.update("EmpMapper.insert");
    	session.commit();
    	System.out.println("Ӱ�������:" + rows);
    }
    
    @Test
    public void selectById() throws IOException{
    	System.out.println("���������ѯ��Ա��ID:");
    	Scanner in = new Scanner(System.in);
    	int i = in.nextInt();
    	Emp emp = session.selectOne("EmpMapper.selectById", i);
    	System.out.println(emp);
    }
    
    @Test
    public void testDelete() throws IOException{
    	System.out.println("��������ɾ����Ա������:");
    	Scanner in = new Scanner(System.in);
    	String s = in.nextLine();
    	int rows = session.update("EmpMapper.delete", s);
    	session.commit();
    	System.out.println("Ӱ�������: " + rows);
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
