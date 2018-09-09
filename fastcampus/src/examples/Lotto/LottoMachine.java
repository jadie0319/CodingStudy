package examples.Lotto;

import java.util.List;

public interface LottoMachine {
	// 공 45개를 넣는다.
	public void put(List<LottoBall> balls);
	
	// 섞는다.
	public void mix();
	
	// 공을 선택한다.
	public List<LottoBall> getBalls();
	

}
