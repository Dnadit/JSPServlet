package edu.pnu.study.operator;

public class MyOperatorForAdd extends MyOperator {

	public MyOperatorForAdd() {
		super("+");
	}
	
	@Override
	public int operate(int a, int b) {
		return a + b;
	}

}
