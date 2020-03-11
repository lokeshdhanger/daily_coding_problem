import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * This problem was recently asked by Google.
 * 
 * Given a list of numbers and a number k, 
 * return whether any two numbers from the list add up to k.
 * 
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * 
 * @author xarvis
 *
 */
public class DCP_19Aug2019 {

	public static void main(String[] args) {
		int arr[] = {10, 15, 3, 7};
		int k = 17;
		
		//after sorting (merge sort)
		
		// time complexity: O(nlog(n))
		//space complexity: O(1)
		Arrays.sort(arr);
		boolean bool = checkPairsWithSum(arr, k);
		System.out.println(bool);
		
		
		//time complexity: O(n)
		//space complexity: O(n)
		int arr1[] = {11, 15, 3, 7};
		int k1 = 17;
		boolean bool1 = checkPairsWithSumUsingHashSet(arr1, k1);	
				System.out.println(bool1);
	
	}
	
	//this works on compliment of numbers with K
	private static boolean checkPairsWithSumUsingHashSet(int[] arr1, int k1) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			if (set.contains(k1-arr1[i])) {
				return true;
			} else {
				set.add(arr1[i]);
			}
		}
		return false;
	}




	private static boolean checkPairsWithSum(int[] arr, int k) {
		int low = 0;
		int high = arr.length-1;
		while (low<high) {
			if ((arr[low]+arr[high])==k) {
				return true;
			} else if((arr[low]+arr[high]) > k) {
				high--;
			}else {
				low++;
			}
		}
		return false;
	}
	
}
