package basic.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		MemberDAO mdao = new MemberDAO();
//		DataBaseInfo dbinfo = new DataBaseInfo();
//		mdao.setDbInfo(dbinfo);
//		dbinfo.setUid("test");
//		dbinfo.setUpw("test123");
//		dbinfo.setUrl("com.test");
//		mdao.showDBInfo();
		GenericXmlApplicationContext ct = 
				new GenericXmlApplicationContext("classpath:db-config.xml");
		MemberDAO mdao = ct.getBean("mdao", MemberDAO.class);
		
		mdao.showDBInfo();
	}
}
