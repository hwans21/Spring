package basic.ex01;

public class MainClass {
	public static void main(String[] args) {
		Chef chef = new Chef();
		Restaurant res = new Restaurant(chef);
		Hotel hotel = new Hotel(res);
		hotel.reserveRestaurant();
	}
}
