package sword.chapter02._36reversepairs;

public class Solution {
	public static void main(String[] args) {
		int[] test={7,5,6,4};
		System.out.println(ReversePairs(test));
	}
	public static int ReversePairs(int [] array){
		//初始化一个辅助数组
		int[] temp=new int[array.length];
		//这里这样做的目的符合后面的直接交换辅助数组和原数组
		for(int i=0;i<array.length;i++){
			temp[i]=array[i];
		}
		int count=ReversePairsCore(array, temp,0,array.length-1);
		return count;
	}
	public static int ReversePairsCore(int[] array,int[] temp,int start,int end){
		if(start==end){
			temp[start]=array[start];
			return 0;
		}
		int mid=(end+start)/2;
		int left=ReversePairsCore(temp,array,start,mid);//这里反过来，下面就不要像归并一样复制了
		int right=ReversePairsCore(temp, array, mid+1, end);
		
		//
		int i=mid;//钱半段最后一个
		int j=end;//后半段最后一个
		
		int indexCopy=end;//用来记录copy数组在这段的操作
		
		int count=0;
		
		while(i>=start&&j>=(mid+1)){
			if(array[i]>array[j]){
				temp[indexCopy]=array[i];
				indexCopy--;
				i--;
				//统计数量
				count+=j-mid;//后半段到j的数量
			}else{
				temp[indexCopy]=array[j];
				indexCopy--;
				j--;
			}
			
		}
		//把剩下的没加入进来的加进来(剩余一位或者几位)
		for(;i>=start;i--){
			temp[indexCopy]=array[i];
			indexCopy--;
			i--;
		}
		for(;j>=mid+1;j--){
			temp[indexCopy]=array[j];
			indexCopy--;
			j--;
		}
		return count+left+right;
		
		
	}
}
