package edu.pnu.study.operator;

public class MyOperatorForMul extends MyOperator {

	public MyOperatorForMul() {
		super("*");
	}		
	
	@Override
	public int operate(int a, int b) {
		return a * b;
	}

}
