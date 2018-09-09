package examples.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {
	public static void main(String[] args) {
		// 공 45개를 준비한다.
		List<LottoBall> list = LottoBallFactory.createBalls();
		
		// 머신에 넣는다.
		LottoMachine machine = new LottoMachineImpl();
		machine.put(list);
		
		// 섞는다.
		machine.mix();
		
		// 뽑는다. 
		List<LottoBall> result = machine.getBalls();
		
		for(LottoBall ball : result) {
			System.out.print(ball.getNumber() + "  ");
		}
	}
}
