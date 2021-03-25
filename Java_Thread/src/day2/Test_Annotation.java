package day2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**本类用于测试自定义注解
 * 因为@Target属性规定了注解的作用域为ElementType.METHOD,
 * 所以只能在方法上面一行加自定义注解 
 * 成员变量: Element.FIELD
 * 方法: Element.METHOD
 * 类,接口: Element.TYPE
 * 构造函数: Element.CONSTRUCTOR
 */
@Test(age=18)
public class Test_Annotation {
	
	String name;
	@Test("Value的值可以直接写")
	public void eat() {
		System.out.println("吃饭");
	}
}

//1.定义自定义主角，注解名为Test
/**
 * 1. 注解名定义的时候需要使用@interface注解名的方式来定义
 *  1.2 通过@target注解来表示此自定义注解可以使用的位置
 *      @target 注解使用时候需要导包
 *  1.3 通过ElementType的静态常量值可以指定自定义注解使用的位置
 *      如果有多种位置，可以用{ , }的方式隔开
 *  1.4 通过@Retention注解表示此自定义注解的生命周期
 *      @Retention 注解使用的时候需要导包
 *      通过RetentionPolicy.静态常量 来确定自定义注解的生命周期
 *      也就是自定义注解可以存活到哪个阶段, 源文件/字节码文件/运行时
 *      只能三选一,不能选多个
 *      
 * */
@Retention(RetentionPolicy.SOURCE)//.SOURCE指生命周期在源码中
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@interface Test{
	/**
	 * 2. 自定义注解还可以添加功能 -- 给注解添加属性
	 *    2.1	int age(); 不是方法的定义.而是给注解中定义age的语法
	 *    2.2	添加完属性时候, @Test 会报错,这时候需要在Test后面加缺失属性: @Test(age=18)
	 *    2.3	为了使用方便,可以直接将age赋值 如下, 加了默认值之后,可以不加属性直接使用,属性值就是默认值
	 * */
	int age() default 0;
	String name() default "老王";
	String value() default "value";
	/**
	 * 3. 自定义注解中可以添加功能 -- 定义特殊属性value
	 *    特殊属性的定义方式与普通属性的定义方式相同,只是使用方式不同
	 *    使用此属性赋值的时候,可以不用写成"@Test(value="A")
	 *    格式可以简化成@Test("A"),可以直接写值
	 *    
	 * 4. 因为已有默认值,所以不用给特殊属性value赋值,直接使用   
	 */
}