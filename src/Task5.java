public class Task5 {
	public static void main(String[] args) {
		int n = 4;
		int[][] B = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		int product = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				product *= B[i][j];
			}
		}
		System.out.println("Result: " + product);
	}
}
