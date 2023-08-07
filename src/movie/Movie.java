package movie;

public class Movie {
	// 필드
	String movieName; // 영화명
	int price; // 금액
	int age; // 나이
	int money; // 실구매금액
	double rate; // 할인율
	String way; // 구매방법(현장, 인터넷, 쿠폰)

	// 생성자
	public Movie(String movieName, int price, int age, String way ) {
	// 매개변수로 값을 받아서 멤버변수에 넣기
	this.movieName = movieName;
	this.price = price;
	this.age = age;
	this.way = way;
	}

	/*
	 메소드 사용하기
	 1. 할인율 ->void rateCal()
	 2. 실구매금액 ->void moneyCal()
	 3. 제목인쇄하기 ->void titlePrint()
	 4. 내용 출력하기 ->void dataPrint() 
	 */
	void moneyCal() {
		money = (int)(price - (price * rate)); // 원래 가격에서 할인된 값을 빼준다.
	}
	void titlePrint() {
		// 콘솔창에 영화명 금액 나이 실구매금액이 찍히도록 하기 위해서
		System.out.println("영화명" + "\t\t" + "금액" + "\t\t" + "나이" + "\t\t" + "실구매금액"); 
	}
	void dataPrint() {
		rateCal();
		moneyCal();
		// 콘솔창에 각각에 해당하는 영화명, 금액, 나이, 할인된 값을 뺀 실구매금액을 출력하기 위해서
		System.out.println(movieName + "\t\t" + price + "\t\t" + age + "\t\t" + money); 
	}
	/*
	   - 할인율 -
	   나이가 20미만이면 25% 할인, 
	   나이가 20~30이면 20% 할인, 
	   30이상이면 15% 할인
	 */
	void rateCal() {
		rate = 0; // 써도 되고 안써도 됨
		
		/*
		   switch ~ case 를 사용하여
		   현장구매인 경우 0% 할인, 
		   인터넷 구매인 경우 추가 5% 할인, 
		   쿠폰구매인 경우 10% 할인율 구한다.
		 */
		switch(way) {
		case "현장" :
			rate = 0.00; // 현장일 경우 할인율이 없다.
			break;
		case "인터넷" :
			rate = 0.05; // 인터넷으로 예매할 경우 5%할인
			break;
		case "쿠폰" :
			rate = 0.10; // 쿠폰을 사용할 경우 10%할인
			break;
		} // end switch
		if (age < 20) // 나이가 20세 미만일 경우 25% 할인
			rate += 0.25;
		else if (age >= 20 && age <= 30) // 나이가 20세부터 30세까지 20% 할인
			rate += 0.20;
		else // 나머지 30세 이상이면 15% 할인
			rate += 0.15;
	}
}
