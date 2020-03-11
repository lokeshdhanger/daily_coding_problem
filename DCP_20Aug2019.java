

/**
 * Given an array of integers, return a new array 
 * such that each element at index i of the new array 
 * is the product of all the numbers in the original array 
 * except the one at i.
 * 
 * For example, 
 * if our input was [1, 2, 3, 4, 5], 
 * the expected output would be [120, 60, 40, 30, 24]. 
 * If our input was [3, 2, 1], 
 * the expected output would be [2, 3, 6].
 * 
 * @author xarvis
 *
 */
public class DCP_20Aug2019 {
	
	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5};
		print(arr);
		System.out.println();
		
		int[] updatedArray = updatedArray(arr);
		print(updatedArray);
		
		System.out.println();
		int[] updatedArrayOptimised = updatedArrayOptimised(arr);
		print(updatedArrayOptimised);
		
	}
	
	//time complexity: O(n)
	//space complexity: O(1)
	public static int[] updatedArrayOptimised(int arr[]) {
		double EPS = 1e-9;
		double sum=0;
		int []updateArray = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			sum+=Math.log10(arr[i]);
		}
		
		for (int i = 0; i < arr.length; i++) {
			updateArray[i]=(int) (EPS+Math.pow(10.00, sum-Math.log10(arr[i])));
		}
		
		return updateArray;
	}
	
	/**
	 * time complexity: O(n^2)
	 * space complexity: O(n)
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] updatedArray(int arr[]) {
		int updatedArray[] = new int[arr.length];
	
		for (int i = 0; i < arr.length; i++) {
			int sum=1;
			for (int j = 0; j < arr.length; j++) {
				if (i!=j) {
					sum*=arr[j];
				}
			}
			updatedArray[i]=sum;
		}
		return updatedArray;
	}
	
	
	public static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
