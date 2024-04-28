
public class Task9 {
	public static void main(String[] args) {
		int n = 5;
		int[][] matrix = new int[n*2][n*2];

		magic1(n, matrix, 1, 0, n-1, 0, n-1);
		magic2(n, matrix, 1, n, 2*n-1, 0, n-1);
		magic1(n, matrix, 1, 0, n-1, n, 2*n-1);
		magic2(n, matrix, 1, n, 2*n-1, n, 2*n-1);

		printMatrix(matrix);
	}

	private static void magic1(int n, int[][] matrix, int startNum, int startRow, int endRow, int startCol, int endCol) {
		int num = 1;

		var x = (endRow - startRow + 1) * (endCol - startCol + 1);
		while (num <= x) {
			for (int i = startCol; i <= endCol; i++) {
				matrix[startRow][i] = num++ + startNum - 1;
			}

			for (int i = startRow + 1; i <= endRow; i++) {
				matrix[i][endCol] = num++ + startNum - 1;
			}

			for (int i = endCol - 1; i >= startCol; i--) {
				matrix[endRow][i] = num++ + startNum - 1;
			}

			for (int i = endRow - 1; i > startRow; i--) {
				matrix[i][startCol] = num++ + startNum - 1;
			}

			startRow++;
			endRow--;
			startCol++;
			endCol--;
		}
	}
	private static void magic2(int n, int[][] matrix, int startNum, int startRow, int endRow, int startCol, int endCol) {
		int num = 1;

		var x = (endRow - startRow + 1) * (endCol - startCol + 1);
		while (num <= n * n) {
			for (int i = startRow; i <= endRow; i++) {
				matrix[i][startCol] = num++ + startNum - 1;
			}

			for (int i = startCol + 1; i <= endCol; i++) {
				matrix[endRow][i] = num++ + startNum - 1;
			}

			for (int i = endRow - 1; i >= startRow; i--) {
				matrix[i][endCol] = num++ + startNum - 1;
			}

			for (int i = endCol - 1; i > startCol; i--) {
				matrix[startRow][i] = num++ + startNum - 1;
			}

			startRow++;
			endRow--;
			startCol++;
			endCol--;
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
