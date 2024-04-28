public class Task7 {
	public static void main(String[] args) {
		int n = 5;
		int[][] matrix = new int[n][n];

		int num = 1;
		int startRow = 0;
		int endRow = n - 1;
		int startCol = 0;
		int endCol = n - 1;

		while (num <= n * n) {
			for (int i = startCol; i <= endCol; i++) {
				matrix[startRow][i] = num++;
			}

			for (int i = startRow + 1; i <= endRow; i++) {
				matrix[i][endCol] = num++;
			}

			for (int i = endCol - 1; i >= startCol; i--) {
				matrix[endRow][i] = num++;
			}

			for (int i = endRow - 1; i > startRow; i--) {
				matrix[i][startCol] = num++;
			}

			startRow++;
			endRow--;
			startCol++;
			endCol--;
		}

		printMatrix(n, matrix);
	}

	private static void printMatrix(int n, int[][] matrix) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "	");
			}
			System.out.println();
		}
	}
}
