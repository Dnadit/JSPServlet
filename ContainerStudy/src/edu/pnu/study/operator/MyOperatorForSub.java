package edu.pnu.study.operator;

public class MyOperatorForSub extends MyOperator {

	public MyOperatorForSub() {
		super("-");
	}	
	
	@Override
	public int operate(int a, int b) {
		return a - b;
	}

}
