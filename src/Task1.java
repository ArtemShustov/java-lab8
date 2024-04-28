import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);

		System.out.print("Enter N: ");
		var n = scanner.nextInt();
		var inputArray = new int[n];
		for (int i = 0; i < n; i++) {
			var bit = 0;
			while (true) {
				System.out.print("[bit" + i + "] Enter value (0/1): ");
				bit = scanner.nextInt();
				if (bit == 0 || bit == 1) {
					break;
				}
				System.out.println("Bad input! Only 0 and 1 allowed.");
			}
			inputArray[i] = bit;
		}
		printArray(binaryToSeptenary(inputArray));
	}
	public static int[] binaryToSeptenary(int[] binaryArray) {
		int number = convertBinaryArrayToDecimal(binaryArray);
		return convertDecimalToSeptenaryArray(number);
	}
	public static int convertBinaryArrayToDecimal(int[] binaryArray) {
		int decimalNumber = 0;
		int n = binaryArray.length;

		for (int i = 0; i < n; i++) {
			decimalNumber += binaryArray[i] * Math.pow(2, n - 1 - i);
		}

		return decimalNumber;
	}
	public static int[] convertDecimalToSeptenaryArray(int decimalNumber) {
		ArrayList<Integer> septenaryList = new ArrayList<>();

		if (decimalNumber == 0) {
			septenaryList.add(0);
		} else {
			while (decimalNumber > 0) {
				septenaryList.add(decimalNumber % 7);
				decimalNumber /= 7;
			}
		}
		int[] septenaryArray = new int[septenaryList.size()];
		for (int i = 0; i < septenaryList.size(); i++) {
			septenaryArray[i] = septenaryList.get(septenaryList.size() - 1 - i);
		}

		return septenaryArray;
	}
	public static void printArray(int[] array) {
		for (int value : array) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
}