public class ModifiedCountingSort {

	public static void CountingSort(int[] arr) {
		int outLier = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				outLier = arr[i];
			}
		}
		int[] arr2 = new int[arr.length];
		System.out.println("\nOutlier"+ outLier + "\n");
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != outLier) {
				arr2[i] = arr[i];
			}
		}
		for (int i = 0; i < arr2.length; ++i)
		{
			System.out.print(arr2[i] + " ");
		}
		for (int i = 0; i < arr2.length; ++i)
		{
			if (arr2[i] > max)
				max = arr2[i];
		}
		System.out.println("\n" + max + " Max\n");
		int[] count = new int[max + 1], outArr = new int[arr2.length];
		for (int i = 0; i < max; i++) {
			count[i] = 0;
		}
		for (int i = 0; i < arr2.length - 1; ++i) {
			count[arr2[i]] += 1;
		}
		for (int i = 1; i < count.length; ++i) {
			count[i] += count[i - 1];
		}
		for (int i = arr2.length - 2; i >= 0; --i) {
			outArr[count[arr2[i]] -1] = arr2[i];
			count[arr2[i]]--;
		}
		
		for (int i = 0; i < arr2.length - 1; i++) {
			arr[i+1] = outArr[i];
			arr[0] = outLier;
		}
	}
	public static void CountingSortOL(int[] arr) {
		int outLier = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= arr.length*1000) {
				outLier = arr[i];
			}
		}
		System.out.println("\nOutlier " + outLier + "\n");
		int[] arr2 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != outLier) {
				arr2[i] = arr[i];
			}
		}
		for (int i = 0; i < arr2.length; ++i)
		{
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		int max = 0;
		for (int i = 0; i < arr2.length; ++i)
		{
			if (arr2[i] > max)
				max = arr2[i];
		}
		System.out.println("Max " + max + "\n");
		int[] count = new int[max + 1], outArr = new int[arr2.length];
		for (int i = 0; i < max; i++) {
			count[i] = 0;
		}
		for (int i = 0; i < arr2.length - 1; ++i) {
			count[arr2[i]] += 1;
		}
		for (int i = 1; i < count.length; ++i) {
			count[i] += count[i - 1];
		}
		for (int i = arr2.length - 2; i >= 0; --i) {
			outArr[count[arr2[i]] -1] = arr2[i];
			count[arr2[i]]--;
		}
		
		for (int i = 0; i < arr2.length - 1; i++) {
			arr[i] = outArr[i];
			arr[arr2.length - 1] = outLier;
		}
	}
	public static void main(String[] args) {
		int[] arr = {7, 7, 3, 6, 3, 10, 1,  5,  7, -2400};
		int[] arr2 = {7, 7,  3, 6, 3,  10,  1,  5,  7, 200000};
		for (int i = 0; i < arr.length; ++i)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		CountingSort(arr);
		for (int i = 0; i < arr.length; ++i)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n===========");
		System.out.println();
		for (int i = 0; i < arr2.length; ++i)
		{
			System.out.print(arr2[i] + " ");
		}
		CountingSortOL(arr2);
		for (int i = 0; i < arr2.length; ++i)
		{
			System.out.print(arr2[i] + " ");
		}
	}
}
