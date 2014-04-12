package net.daum.kong.design;

import org.junit.Test;

interface Duck {
	public void quack();

	public void fly();
}

// Adaptee Interface
interface Turkey {
	public void gobble();

	public void fly();
}

class WildTurky implements Turkey {

	@Override
	public void gobble() {
		System.out.println("Gobble gobble");
	}

	@Override
	public void fly() {
		System.out.println("WileTurky Fly~~");
	}
}

class MallardDuck implements Duck {
	public void quack() {
		System.out.println("Quack quack");
	}

	public void fly() {
		System.out.println("MallardDuck Fly~~~");
	}
}

// Adapter에서는 Target Interface 를 구현하고, Adapter는 Adaptee Interface로 구성되어 있습니다.
// 모든 요청은 Adaptee 에게 위임 됩니다.
class TurkeyAdapter implements Duck {
	Turkey turkey;

	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	public void quack() {
		turkey.gobble();
	}

	public void fly() {
		for (int i = 0; i < 5; i++) {
			turkey.fly();
		}
	}
}

class DuckAdapter implements Turkey {
	Duck duck;

	public DuckAdapter(Duck duck) {
		this.duck = duck;
	}

	public void gobble() {
		duck.quack();
	}

	public void fly() {
		duck.fly();
	}
}

public class AdapterExample {
	@Test
	public void adapterTest() {
		MallardDuck duck = new MallardDuck();

		WildTurky turkey = new WildTurky();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		
		System.out.println("The Turkey says....");
		turkey.gobble();
		turkey.fly();
		
		System.out.println("\nThe Duck says....");
		testDuck(duck);
		
		System.out.println("\nThe TurkeyAdapter says....");
		testDuck(turkeyAdapter);
	}
	
	private void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}
