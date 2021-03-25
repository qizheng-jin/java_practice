package reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnoTest {
	String name;
	int age;
	
	@MyAnnotation(name="hello")
	public void hello() {
		
	}
}


@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD) 
@interface MyAnnotation{
	String name() default "";
}