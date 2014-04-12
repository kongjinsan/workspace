package net.daum.kong.springinaction;

public class App {
	private static final String CONSTANT = "String";
	private Object o;

	/**
	 * Creates a new demo.
	 * 
	 * @param o
	 *            The object to demonstrate.
	 */
	public App() {

	}

	public App(Object o) {
		this.o = o;
		String s = CONSTANT;
		int i = 1;
	}

	public static void main(String[] args) {
		App demo = new App();
		for (int i = 0; i < 10; i++)
			System.out.println("hello world");
		System.out.println("git test");  
	}
}