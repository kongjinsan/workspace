package net.daum.kong.design;

import org.junit.Test;



public class StrategyExample {
   @Test
   public void strategyTest() {
	   Context context;
	   
	   context = new Context(new ConcreteStrategyAdd());
	   int resultA = context.executeStrategy(3, 4);
   }
}

interface Strategy {
	int execute(int a, int b);
}

class ConcreteStrategyAdd implements Strategy {

public int execute(int a, int b) {
		System.out.println("Called ConcreteStrategyAdd's execute()");
		return a + b;
	}
}

class ConcreteStrategySubtract implements Strategy {

	public int execute(int a, int b) {
		System.out.println("Called ConcreteStrategyMultiply's execute()");
		return a - b;
	}
}

class ConcreteStrategyMultiply implements Strategy {

	public int execute(int a, int b) {
		System.out.println("Called ConcreteStrategyMultiply's execute()");
		return a * b;
	}
	
}

class Context {
	private Strategy strategy;
	
	public Context(Strategy strategy){
		this.strategy = strategy;
	}
	public int executeStrategy(int a, int b) {
		return strategy.execute(a, b);
	}
}