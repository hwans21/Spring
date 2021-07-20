package basic.ex02;

public class MainClass {
	public static void main(String[] args) {
		MemberDAO mdao = new MemberDAO();
		DataBaseInfo dbinfo = new DataBaseInfo();
		mdao.setDbInfo(dbinfo);
		dbinfo.setUid("test");
		dbinfo.setUpw("test123");
		dbinfo.setUrl("com.test");
		mdao.showDBInfo();
	}
}
