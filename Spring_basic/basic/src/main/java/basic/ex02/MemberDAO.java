package basic.ex02;

public class MemberDAO {
	private DataBaseInfo dbInfo;

	public void setDbInfo(DataBaseInfo dbInfo) {
		this.dbInfo = dbInfo;
	}
	
	
	public void showDBInfo() {
		System.out.println("URL: "+ dbInfo.getUrl());
		System.out.println("UID: "+ dbInfo.getUid());
		System.out.println("UPW: "+ dbInfo.getUpw());
	}
}
