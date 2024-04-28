import java.util.Scanner;

public class Task11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Введите количество треугольников (N): ");
		int N = scanner.nextInt();

		int[][] coordinates = new int[2][3 * N];

		System.out.println("Введите координаты вершин треугольников:");
		for (int i = 0; i < 3 * N; i += 3) {
			System.out.println("Треугольник " + ((i / 3) + 1) + ":");
			for (int j = 0; j < 3; j++) {
				System.out.print("Введите координату x для вершины " + (j + 1) + ": ");
				coordinates[0][i + j] = scanner.nextInt();
				System.out.print("Введите координату y для вершины " + (j + 1) + ": ");
				coordinates[1][i + j] = scanner.nextInt();
			}
		}

		int[][] results = analyzeTriangles(coordinates);

		displayResults(results);

		checkSameAreaTriangles(results);
	}

	public static int[][] analyzeTriangles(int[][] coordinates) {
		int N = coordinates[0].length / 3;
		int[][] results = new int[3][N];

		for (int i = 0; i < N; i++) {
			int[][] triangle = {{coordinates[0][i * 3], coordinates[0][i * 3 + 1], coordinates[0][i * 3 + 2]},
					{coordinates[1][i * 3], coordinates[1][i * 3 + 1], coordinates[1][i * 3 + 2]}};
			results[0][i] = isTriangleExist(triangle);
			if (results[0][i] == 1) {
				results[1][i] = classifyTriangle(triangle);
				results[2][i] = calculateArea(triangle);
			}
		}

		return results;
	}

	public static int isTriangleExist(int[][] triangle) {
		int[] sideLengths = new int[3];
		sideLengths[0] = calculateDistance(triangle[0][0], triangle[1][0], triangle[0][1], triangle[1][1]);
		sideLengths[1] = calculateDistance(triangle[0][1], triangle[1][1], triangle[0][2], triangle[1][2]);
		sideLengths[2] = calculateDistance(triangle[0][2], triangle[1][2], triangle[0][0], triangle[1][0]);

		if (sideLengths[0] + sideLengths[1] > sideLengths[2] &&
				sideLengths[1] + sideLengths[2] > sideLengths[0] &&
				sideLengths[2] + sideLengths[0] > sideLengths[1]) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int calculateDistance(int x1, int y1, int x2, int y2) {
		return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	public static int classifyTriangle(int[][] triangle) {
		int[] sideLengths = new int[3];
		sideLengths[0] = calculateDistance(triangle[0][0], triangle[1][0], triangle[0][1], triangle[1][1]);
		sideLengths[1] = calculateDistance(triangle[0][1], triangle[1][1], triangle[0][2], triangle[1][2]);
		sideLengths[2] = calculateDistance(triangle[0][2], triangle[1][2], triangle[0][0], triangle[1][0]);

		if (sideLengths[0] == sideLengths[1] && sideLengths[1] == sideLengths[2]) {
			return 1; // Равносторонний
		} else if (sideLengths[0] * sideLengths[0] + sideLengths[1] * sideLengths[1] == sideLengths[2] * sideLengths[2] ||
				sideLengths[1] * sideLengths[1] + sideLengths[2] * sideLengths[2] == sideLengths[0] * sideLengths[0] ||
				sideLengths[2] * sideLengths[2] + sideLengths[0] * sideLengths[0] == sideLengths[1] * sideLengths[1]) {
			return 2; // Прямоугольный
		} else if (sideLengths[0] == sideLengths[1] || sideLengths[1] == sideLengths[2] || sideLengths[2] == sideLengths[0]) {
			return 3; // Равнобедренный
		} else {
			return 4; // Произвольный
		}
	}

	public static int calculateArea(int[][] triangle) {
		int a = calculateDistance(triangle[0][0], triangle[1][0], triangle[0][1], triangle[1][1]);
		int b = calculateDistance(triangle[0][1], triangle[1][1], triangle[0][2], triangle[1][2]);
		int c = calculateDistance(triangle[0][2], triangle[1][2], triangle[0][0], triangle[1][0]);

		double p = (a + b + c) / 2.0;
		return (int) Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}

	public static void displayResults(int[][] results) {
		System.out.println("Результаты анализа треугольников:");
		for (int i = 0; i < results[0].length; i++) {
			System.out.println("Треугольник " + (i + 1) + ":");
			System.out.println("Существует: " + (results[0][i] == 1 ? "Да" : "Нет"));
			if (results[0][i] == 1) {
				System.out.println("Классификация: " + getTriangleType(results[1][i]));
				System.out.println("Площадь: " + results[2][i]);
			}
		}
	}

	public static String getTriangleType(int type) {
		switch (type) {
			case 1:
				return "Равносторонний";
			case 2:
				return "Прямоугольный";
			case 3:
				return "Равнобедрененный";
			case 4:
				return "Произвольный";
			default:
				return "Неизвестный";
		}
	}

	public static void checkSameAreaTriangles(int[][] results) {
		System.out.println("\nПроверка на треугольники с одинаковой площадью:");
		for (int i = 0; i < results[0].length; i++) {
			for (int j = i + 1; j < results[0].length; j++) {
				if (results[0][i] == 1 && results[0][j] == 1 && results[2][i] == results[2][j]) {
					System.out.println("Треугольники " + (i + 1) + " и " + (j + 1) + " имеют одинаковую площадь.");
				}
			}
		}
	}
}
