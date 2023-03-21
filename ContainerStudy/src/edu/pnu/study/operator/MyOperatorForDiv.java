package edu.pnu.study.operator;

public class MyOperatorForDiv extends MyOperator {

	public MyOperatorForDiv() {
		super("/");
	}
	
	@Override
	public int operate(int a, int b) {
		return a / b;
	}

}
