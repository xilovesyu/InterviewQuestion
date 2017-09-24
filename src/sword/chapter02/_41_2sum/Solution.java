package sword.chapter02._41_2sum;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
	public static void main(String[] args) {
		int[] test={1,2,4,7,8,11,15};
		
		findNumbersIn2Sum(test, 15);
		
	}
	public static boolean findNumbersIn2Sum(int data[],int sum){
		ArrayList<int[]> list=new ArrayList<>();
		if(data==null||data.length==0){
			return false;
		}
		boolean flag=false;
		int start=0;
		int end=data.length-1;
		while(start<=end){
			if(data[start]+data[end]==sum){
				list.add(new int[]{data[start],data[end]});
				flag=true;
				start++;end--;
			}else if(data[start]+data[end]<sum){
				start++;
			}else{
				end--;
			}
		}
		Iterator<int[]> iterator=list.iterator();
		while(iterator.hasNext()){
			int[] temp=iterator.next();
			System.out.println(temp[0]+","+temp[1]);
		}
		return flag;
	}
}
