package examples.templateMethod.Battle;

public class Archer extends Person {

	@Override
	boolean isUsingPrepareOther() {
		return true;
	}

	@Override
	void prepareOther() {
		System.out.println("화살을 준비합니다.");
	}

	@Override
	void prepareWeapon() {
		System.out.println("활을 손질합니다.");
	}

	@Override
	void prepareArmor() {
		
	}
	
}
