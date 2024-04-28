public class Task2 {
	public static void main(String[] args) {
		var array = new int[] { 1, 2, 3, 4, 0, 1, 2, 7, 3, 2, 1 };

		var areaIndex = 0;
		var areaStart = 0;
		var area = "";
		for (int i = 1; i < array.length; i++) {
			if (array[i-1] >= array[i]) {
				if (Math.abs(areaStart - i) > 1) {
					System.out.print("[" + areaIndex + "] ");
					for (int x = areaStart; x < i; x++) {
						System.out.print(array[x] + " ");
					}
					System.out.println();
				}
				areaIndex += 1;
				areaStart = i;
			}
		}
	}
}