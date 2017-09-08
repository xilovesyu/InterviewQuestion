package sword.chapter02._31largestsumofsubarrays;

public class Solution {
	public static void main(String[] args) {
		int[] test={1,-2,3,10,-4,7,2,-5};
		try {
			System.out.println(FindLargestSumofSubArray(test));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	public static int FindLargestSumofSubArray(int[] array) throws Exception{
		if(array==null||array.length==0){
			throw new Exception("array is null");
		}
		int CurrentSum=0;
		int LargestSum=Integer.MIN_VALUE;
		for(int i=0;i<array.length;i++){
			if(CurrentSum<=0){
				CurrentSum=array[i];
			}else{
				CurrentSum+=array[i];
			}
			if(CurrentSum>LargestSum){
				LargestSum=CurrentSum;
			}
		}
		return LargestSum;
	}
}
