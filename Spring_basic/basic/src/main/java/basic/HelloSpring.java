package basic;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
//		SpringTest st = new SpringTest();
//		st.hello();
		GenericXmlApplicationContext ct = 
				new GenericXmlApplicationContext("classpath:test-config.xml");
		SpringTest st = ct.getBean("test",SpringTest.class);
		st.hello();
	}
}
