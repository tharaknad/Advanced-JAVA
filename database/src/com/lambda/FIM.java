package com.lambda;

public class FIM {

	public static void main(String[] args) {

		Runnable r = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("child Method ");
			}
		

		};
		r.run();

		for (int i = 0; i < 10; i++) {
			System.out.println("MAin method ");
		}
	}

}
