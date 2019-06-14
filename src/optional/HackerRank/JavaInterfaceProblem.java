package optional.HackerRank;

import java.util.Scanner;

interface AdvancedArithmetic {
	int divisor_sum(int n);
}

// Write your code here

class MyCalculator implements AdvancedArithmetic {
	public int divisor_sum(int n) {
		int sum = 0;
		for (int i = 1; 2 * i <= n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		sum += n;
		return sum;
	}
}

class JavaInterfaceProblem {
	public static void main(String[] args) {
		MyCalculator my_calculator = new MyCalculator();
		System.out.print("I implemented: ");
		ImplementedInterfaceNames(my_calculator);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(my_calculator.divisor_sum(n) + "\n");
		sc.close();
	}

	/*
	 * ImplementedInterfaceNames method takes an object and prints the name of the
	 * interfaces it implemented
	 */
	static void ImplementedInterfaceNames(Object o) {
		Class[] theInterfaces = o.getClass().getInterfaces();
		for (int i = 0; i < theInterfaces.length; i++) {
			String interfaceName = theInterfaces[i].getSimpleName();
			System.out.println(interfaceName);
		}
	}
}
