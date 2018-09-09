package examples.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBallFactory {
	
	// private 생성자 지정하면.인스턴스 생성 불가.
	private LottoBallFactory() {
	}
	
	
	public static List<LottoBall> createBalls() {
		List<LottoBall> list = new ArrayList<LottoBall>();
		for(int i=1 ; i < 46 ; i++) {
			LottoBall ball = new LottoBall(i);
			list.add(ball);
		}
		return list;
	}
}
