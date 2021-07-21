package basic.ex01;

public class Hotel {
	private Restaurant res;
	
	public Hotel(Restaurant res) {
		System.out.println("호텔이 생성됨");
		this.res = res;
		// TODO Auto-generated constructor stub
	}
	
	public void reserveRestaurant() {
		System.out.println("레스토랑을 예약합니다.");
		res.orderDinner();
	}
}
