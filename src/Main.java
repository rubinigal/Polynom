import java.util.Arrays;

public class Main {
	// Main
	public static void main(String[] args) {
		testPolynom();
	}
	
	// Test function
	public static void testPolynom() {
		// Variables
		double[] num1 = {2.8, 6.5, -4.9, -12};
		int[] pow1 = {10, 5, 3, 0};
		double[] num2 = {1, 15};
		int[] pow2 = {2, 0};
		double[] num3 = {8, -3, -1, 7};
		int[] pow3 = {3, 2, 1, 0};
		Polynom polynom1 = null, polynom2 = null, polynom3 = null, polynomResult;
		
		// Polynom builder
		System.out.println("Examples of the builder");
		try {
			polynom1 = new Polynom(num1, pow1);
			System.out.println("Numbers array: " + Arrays.toString(num1) + " Power array: " + Arrays.toString(pow1));
			System.out.println("Polynom: " + polynom1.toString());
			polynom2 = new Polynom(num2, pow2);
			System.out.println("Numbers array: " + Arrays.toString(num2) + " Power array: " + Arrays.toString(pow2));
			System.out.println("Polynom: " + polynom2.toString());
			polynom3 = new Polynom(num3, pow3);
			System.out.println("Numbers array: " + Arrays.toString(num3) + " Power array: " + Arrays.toString(pow3));
			System.out.println("Polynom: " + polynom3.toString());
		} catch (Exception e) {
			System.out.println("Error: Two arrays with different lengths!");
		}
		// Plus function
		System.out.println("\nExample of the plus function");
		System.out.println("(" + polynom2.toString() + ") + (" + polynom3.toString() + ")");
		polynomResult = polynom2.plus(polynom3);
		System.out.println("Result: " + polynomResult.toString());
		
		// Minus function
		System.out.println("\nExample of the minus function");
		System.out.println("(" + polynom2.toString() + ") - (" + polynom3.toString() + ")");
		polynomResult = polynom2.minus(polynom3);
		System.out.println("Result: " + polynomResult.toString());
		
		// Derivative function
		System.out.println("\nExample of the derivative function");
		System.out.println("(" + polynom3.toString() + ")'");
		polynomResult = polynom3.derivative();
		System.out.println("Result: " + polynomResult.toString());
		
		// Equals function
		System.out.println("\nExample of the equals function");
		System.out.println(polynom2.toString() + " = " + polynom3.toString() + "?");
		System.out.println(polynom2.equals(polynom3));
		System.out.println(polynom3.toString() + " = " + polynom3.toString() + "?");
		System.out.println(polynom3.equals(polynom3));
		
		// The toString function has many examples above
	}
	
}
