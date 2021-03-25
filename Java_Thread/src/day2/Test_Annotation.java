package day2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**�������ڲ����Զ���ע��
 * ��Ϊ@Target���Թ涨��ע���������ΪElementType.METHOD,
 * ����ֻ���ڷ�������һ�м��Զ���ע�� 
 * ��Ա����: Element.FIELD
 * ����: Element.METHOD
 * ��,�ӿ�: Element.TYPE
 * ���캯��: Element.CONSTRUCTOR
 */
@Test(age=18)
public class Test_Annotation {
	
	String name;
	@Test("Value��ֵ����ֱ��д")
	public void eat() {
		System.out.println("�Է�");
	}
}

//1.�����Զ������ǣ�ע����ΪTest
/**
 * 1. ע���������ʱ����Ҫʹ��@interfaceע�����ķ�ʽ������
 *  1.2 ͨ��@targetע������ʾ���Զ���ע�����ʹ�õ�λ��
 *      @target ע��ʹ��ʱ����Ҫ����
 *  1.3 ͨ��ElementType�ľ�̬����ֵ����ָ���Զ���ע��ʹ�õ�λ��
 *      ����ж���λ�ã�������{ , }�ķ�ʽ����
 *  1.4 ͨ��@Retentionע���ʾ���Զ���ע�����������
 *      @Retention ע��ʹ�õ�ʱ����Ҫ����
 *      ͨ��RetentionPolicy.��̬���� ��ȷ���Զ���ע�����������
 *      Ҳ�����Զ���ע����Դ��ĸ��׶�, Դ�ļ�/�ֽ����ļ�/����ʱ
 *      ֻ����ѡһ,����ѡ���
 *      
 * */
@Retention(RetentionPolicy.SOURCE)//.SOURCEָ����������Դ����
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@interface Test{
	/**
	 * 2. �Զ���ע�⻹������ӹ��� -- ��ע���������
	 *    2.1	int age(); ���Ƿ����Ķ���.���Ǹ�ע���ж���age���﷨
	 *    2.2	���������ʱ��, @Test �ᱨ��,��ʱ����Ҫ��Test�����ȱʧ����: @Test(age=18)
	 *    2.3	Ϊ��ʹ�÷���,����ֱ�ӽ�age��ֵ ����, ����Ĭ��ֵ֮��,���Բ�������ֱ��ʹ��,����ֵ����Ĭ��ֵ
	 * */
	int age() default 0;
	String name() default "����";
	String value() default "value";
	/**
	 * 3. �Զ���ע���п�����ӹ��� -- ������������value
	 *    �������ԵĶ��巽ʽ����ͨ���ԵĶ��巽ʽ��ͬ,ֻ��ʹ�÷�ʽ��ͬ
	 *    ʹ�ô����Ը�ֵ��ʱ��,���Բ���д��"@Test(value="A")
	 *    ��ʽ���Լ򻯳�@Test("A"),����ֱ��дֵ
	 *    
	 * 4. ��Ϊ����Ĭ��ֵ,���Բ��ø���������value��ֵ,ֱ��ʹ��   
	 */
}