package sword.chapter02._08minnumberinrotatedarray;

public class Solution {
	public static void main(String[] args) {
		int[] array={3,4,5,6,1,2};
		int[] array1={5,6,2,2,3,4};
		int[] array2={2,2,3,4,5,6};
		int[] array3={1,1,0,1,1,1,1};
		System.out.println(min(array));
		System.out.println(min(array1));
		System.out.println(min(array2));
		System.out.println(min(array3));//fail
		System.out.println(minUpdate(array3));//success
	}
	public static int min(int [] array){
		int low=0;
		int high=array.length-1;
		int midIndex=0;
		while(array[low]>=array[high]){
			if(high-low==1){
				midIndex=high;
				break;
			}
			midIndex=(low+high)/2;
			
			if(array[midIndex]>=array[low]){
				low=midIndex;
			}else if(array[midIndex]<=array[high]){
				high=midIndex;
			}
			
		}
		return array[midIndex];
	}
	public static int minUpdate(int[] array){
		int low=0;
		int high=array.length-1;
		int midIndex=0;
		while(array[low]>=array[high]){
			if(high-low==1){
				midIndex=high;
				break;
			}
			midIndex=(low+high)/2;
			if(array[low]==array[midIndex]&&array[midIndex]==array[high]){
				return minNormal(array,low,high);
			}
			if(array[midIndex]>=array[low]){
				low=midIndex;
			}else if(array[midIndex]<=array[high]){
				high=midIndex;
			}
			
		}
		return array[midIndex];
	}
	public static int minNormal(int[] array,int start,int end){
		int min=array[start];
		for(int i=start;i<=end;i++){
			if(min>array[i]){
				min=array[i];
			}
		}
		return min;
	}
}
