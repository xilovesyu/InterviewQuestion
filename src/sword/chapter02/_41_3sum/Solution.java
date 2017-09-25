package sword.chapter02._41_3sum;

/*
 * 求3个数字的和
 * */
public class Solution {
	public static void main(String[] args) {
		int[] test={1,2,4,7,8,10,14,15};
		find3Sum(test,25);
	}
	public static void find3Sum(int[] array,int sum){
		if(array==null||array.length<3){
			return;
		}
		for(int i=0;i<array.length-2;i++){
			int temp1=array[i];
			int twosum=sum-temp1;
			int[] result=find2Sum(array, i+1, array.length, twosum);
			if(result[0]+result[1]==twosum){
				System.out.println(temp1+" "+result[0]+" "+result[1]);
			}
		}
	}
	public static int[] find2Sum(int[] array,int start,int end,int sum){
		int pointA=start;
		int pointB=end-1;
		int[] result=new int[2];
		while(pointA<pointB){
			int temp=array[pointA]+array[pointB];
			if(temp==sum){
				result[0]=array[pointA];
				result[1]=array[pointB];
				break;
			}else if(temp<sum){
				pointA++;
			}else{
				pointB--;
			}
			
		}
		return result;
	}
}
