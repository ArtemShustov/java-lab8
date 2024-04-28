import java.util.Arrays;

public class Task6 {
	public static void main(String[] args) {
		int[][] matrix = {
				{5, 12, 8},
				{3, 15, 7},
				{9, 6, 11}
		};
		System.out.println("Было: ");
		printMatrix(matrix);

		int maxRow = 0;
		int maxElement = matrix[0][0];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > maxElement) {
					maxElement = matrix[i][j];
					maxRow = i;
				}
			}
		}

		Arrays.sort(matrix[maxRow]);

		System.out.println("Стало: ");
		printMatrix(matrix);
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
