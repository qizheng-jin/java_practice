package MyBatis;

import java.io.IOException;

import org.junit.Test;

public class Test1_jdbc {
	@Test
	public void findAll() throws IOException{
	    //1.读取mybatis的核心配置文件(mybatis-config.xml)
	    //2.通过配置信息获取一个SqlSessionFactory工厂对象
	    //3.通过工厂获取一个SqlSession对象
	    //4.通过namespace+id找到要执行的sql语句(EnoMapper.xml)并执行sql语句
	    //5.输出结果
	}
	
	
}
