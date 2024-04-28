import java.util.Scanner;

public class Task12 {
	// 1 2	-1  1
	// 2 2	 1 -0,5
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите размерность матрицы:");
		int dimension = scanner.nextInt();

		System.out.println("Введите элементы матрицы A:");
		double[][] matrixA = inputMatrix(dimension, scanner);

		System.out.println("Введите элементы матрицы A^-1:");
		double[][] matrixAInverse = inputMatrix(dimension, scanner);

		double[][] result = multiplyMatrices(matrixA, matrixAInverse);
		boolean isValid = isIdentityMatrix(result);

		if (isValid) {
			System.out.println("Матрицы соответствуют свойству A*(A^-1) = E");
		} else {
			System.out.println("Матрицы не соответствуют свойству A*(A^-1) = E");
		}
	}

	public static double[][] inputMatrix(int dimension, Scanner scanner) {
		double[][] matrix = new double[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				matrix[i][j] = scanner.nextDouble();
			}
		}
		return matrix;
	}

	public static double[][] multiplyMatrices(double[][] matrixA, double[][] matrixB) {
		int m = matrixA.length;
		int n = matrixB[0].length;
		int p = matrixB.length;
		double[][] result = new double[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < p; k++) {
					result[i][j] += matrixA[i][k] * matrixB[k][j];
				}
			}
		}

		return result;
	}

	public static boolean isIdentityMatrix(double[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i == j && matrix[i][j] != 1) || (i != j && matrix[i][j] != 0)) {
					return false;
				}
			}
		}
		return true;
	}
}
