public class Task8 {
	public static void main(String[] args) {
		int n = 10;
		int[][] matrix = new int[n][n];

		magic(n/2, matrix, 0, 0);
		magic(n/2, matrix, n/2, 0);
		magic(n/2, matrix, 0, n/2);
		magic(n/2, matrix, n/2, n/2);

		printMatrix(matrix);
	}

	private static void magic(int n, int[][] matrix, int startX, int startY) {
		int index = 0;
		int y = 1;
		int x = -1;

		while (index < n*n) {
			while ((y > 0) && (x < n - 1)) {
				y -= 1;
				x += 1;
				index += 1;
				matrix[startY + y][startX + x] = index;
			}
			if ((y == 0) && (x < n - 1)) {
				x += 1;
			} else {
				y += 1;
			}
			index += 1;
			matrix[startY + y][startX + x] = index;

			while ((y < n - 1) && (x > 0)) {
				y += 1;
				x -= 1;
				index += 1;
				matrix[startY + y][startX + x] = index;
			}
			if ((x == 0) && (y < n - 1)) {
				y += 1;
			} else {
				x += 1;
			}
			index += 1;
			matrix[startY + y][startX + x] = index;
		}
	}
	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "	");
			}
			System.out.println();
		}
	}
}
