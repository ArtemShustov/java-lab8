public class Task10 {
	public static void main(String[] args) {
		var n = 3;
		var points = new int[2][n];

		points[0][0] = 0; // x
		points[1][0] = 0; // y

		points[0][1] = 3; // x
		points[1][1] = 0; // y

		points[0][2] = -1; // x
		points[1][2] = 2; // y

		printMatrix(points);

		CheckPoints(n, points);
	}

	private static void CheckPoints(int n, int[][] points) {
		for (int index = 0; index < n; index++) {
			var pointX = points[0][index];
			var pointY = points[1][index];

			var result = checkArea(pointX, pointY);
			String textedResult = "";
			switch (result) {
				case 1:
					textedResult = "InArea";
					break;
				case 0:
					textedResult = "OnBorder";
					break;
				case -1:
					textedResult = "NotInArea";
					break;
			}

			System.out.println("{"+pointX+";"+pointY+"}\tis\t" + textedResult);
		}
	}

	private static int checkArea(int x, int y) {
		if (x <= -1) {
			var result = inCircle(-1, 3, 2, x, y);
			if (result != -1) {
				return result;
			}
		}
		var shit1 = inShit1(x, y);
		if (shit1 != -1) {
			return shit1;
		}
		if ((x <= 2 && x >= -2) && (y <= 4 && y >= 2)) { // cube
			return 1;
		}
		if (y <= 0) {
			var result = inCircle(5, 0, 2, x, y);
			if (result != -1) {
				return result;
			}
		}
		var shit2 = inShit2(x, y);
		if (shit2 != -1) {
			return shit2;
		}
		if ((x <= 6 && x >= 4) && (y <= 0 && y >= -1)) { // cube 2
			return 1;
		}

		return -1;
	}
	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "	");
			}
			System.out.println();
		}
	}

	public static int inCircle(double circleX, double circleY, double r, double pointX, double pointY) {
		var dist = Math.sqrt(Math.pow(circleX - pointX, 2) + Math.pow(circleY - pointY, 2));
		if (Math.abs(dist - r) < 0.01f) {
			return 0;
		}
		if (dist < r) {
			return 1;
		}
		return -1;
	}
	public static int inShit1(double pointX, double pointY) {
		var inArea =  ( (pointY >= (1/3d * pointX + 4/3d)) && (pointX >= -1 && pointX <= 2) && (pointY >= 1 && pointY <= 2) )
				|| ( (pointY >= (pointX * 2 - 2)) && (pointX <= 3 && pointX >= 2) && (pointY <= 4 && pointY >= 2) )
				|| ( (pointY <= (pointX * -0.25 + 4.75)) && (pointX >= -1 && pointX <= 3) && (pointY >= 4 && pointY <= 5) );
		if (inArea == false) {
			return -1;
		}
		var onLine = ((1/3d * pointX + 4/3d) == pointY) || ((pointX * 2 - 2) == pointY) || ((pointX * -0.25 + 4.75) == pointY);
		if (onLine) {
			return 0;
		} else {
			return 1;
		}
	}
	public static int inShit2(double pointX, double pointY) {
		var inArea = (pointY <= -0.2d * pointX + 1.4d) // big line
				&& (pointY >= 0) // down border
				&& (pointX >= 2 && pointX <= 7) // in x area
				&& (pointY >= (-1 * pointX + 3)) // small line
				&& (pointY <= 1); // up border
		if (inArea == false) {
			return -1;
		}
		var onLine = ((-0.2d * pointX + 1.4d) == pointY) || ((-1 * pointX + 3) == pointY);
		if (onLine) {
			return 0;
		} else {
			return 1;
		}
	}
}
