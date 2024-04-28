import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Введите количество точек (N): ");
		int N = scanner.nextInt();

		double[] coordinates = new double[2 * N];

		for (int i = 0; i < 2 * N; i += 2) {
			System.out.print("["+i+"] Введите координату X точки: ");
			coordinates[i] = scanner.nextDouble();
			System.out.print("["+(i)+"] Введите координату Y точки: ");
			coordinates[i + 1] = scanner.nextDouble();
		}

		System.out.println("Введите координаты и радиус внутренней окружности (Xc1, Yc1, R1): ");
		double Xc1 = scanner.nextDouble();
		double Yc1 = scanner.nextDouble();
		double R1 = scanner.nextDouble();

		System.out.println("Введите координаты и радиус внешней окружности (Xc2, Yc2, R2): ");
		double Xc2 = scanner.nextDouble();
		double Yc2 = scanner.nextDouble();
		double R2 = scanner.nextDouble();

		System.out.println("Точки на границе кольца:");

		for (int i = 0; i < N; i++) {
			double x = coordinates[2 * i];
			double y = coordinates[2 * i + 1];

			double distanceInnerToCenter = Math.sqrt(Math.pow(x - Xc1, 2) + Math.pow(y - Yc1, 2));
			double distanceOuterToCenter = Math.sqrt(Math.pow(x - Xc2, 2) + Math.pow(y - Yc2, 2));

			if (distanceInnerToCenter >= R1 && distanceOuterToCenter <= R2) {
				System.out.println("Точка " + (i / 2 + 1) + ": (" + x + ", " + y + ")");
			}
		}
	}
}
