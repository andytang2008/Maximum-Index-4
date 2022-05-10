import java.util.*;
class FindMaximum4 {
    /* Utility Functions to get max and minimum of two integers */
    int max(int x, int y)
    {
        return x > y ? x : y;
    }

    int min(int x, int y)
    {
        return x < y ? x : y;
    }

    /* For a given array arr[], returns the maximum j-i such that
       arr[j] > arr[i] */
    int maxIndexDiff(int arr[], int n)
    {
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i){
            LMin[i] = min(arr[i], LMin[i - 1]);
			System.out.println("LMin["+i+"] = "+LMin[i]);
			}
			System.out.println("LMin[]= "+Arrays.toString(LMin));

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j){
            RMax[j] = max(arr[j], RMax[j + 1]);
			System.out.println("RMax["+j+"] = "+RMax[j]);
			}
			System.out.println("RMax[]= "+Arrays.toString(RMax));
			
			
        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0;
        j = 0;
        maxDiff = -1;
		
		System.out.println("n =  "+n);
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = max(maxDiff, j - i);
				System.out.println("  LMin["+i+"]="+LMin[i]+"   RMax["+j+"]="+RMax[j] +"     max(maxDiff, j - i) = "+maxDiff);
                j = j + 1;
				
            }
            else{
			// System.out.println("The situation happened!");
			 System.out.println("**  LMin["+i+"]="+LMin[i]+"   RMax["+j+"]="+RMax[j] +"     max(maxDiff, j - i) = "+maxDiff);
                i = i + 1;
				}
        }

        return maxDiff;
    }

    /* Driver program to test the above functions */
    public static void main(String[] args)
    {
        FindMaximum4 max = new FindMaximum4();
        int arr[] = { 9, 2, 5, 3, 6, 18, 8, 7, 0 };
		System.out.println("arr[]= "+Arrays.toString(arr));
        int n = arr.length;
        int maxDiff = max.maxIndexDiff(arr, n);
        System.out.println("Max difference="+maxDiff);
    }
}