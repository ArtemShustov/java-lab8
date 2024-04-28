public class Task4 {
	public static void main(String[] args) {
		int[] array = {5, 2, 9, 1, 5, 6, 10, 12, 1, 2, 9, 7, 4, 3, 6, 4, 7, 6, 1, 3, 4, 9, 7, 4, 1, 3, 2, 6, 8, 9, 0};

		shakerSort(array.clone());
		bubbleSort(array.clone());
	}

	private static void shakerSort(int[] array) {
		int count = 0;

		int left = 0;
		int right = array.length - 1;

		do {
			for (int i = left; i < right; i++) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
				}
				count++;
			}
			right--;

			for (int i = right; i > left; i--) {
				if (array[i - 1] > array[i]) {
					swap(array, i - 1, i);
				}
				count++;
			}
			left++;
		} while (left <= right);

		System.out.println("[SnakerSort] count:"+count);
	}
	private static void bubbleSort(int[] array) {
		int count = 0;

		int n = array.length;
		boolean swapped;

		for (int i = 0; i < n - 1; i++) {
			swapped = false;

			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
					swapped = true;
				}
				count++;
			}

			if (!swapped) {
				break;
			}
		}
		System.out.println("[BubbleSort] count:"+count);
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static void printArray(int[] array) {
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
