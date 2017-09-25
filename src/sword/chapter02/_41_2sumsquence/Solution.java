package sword.chapter02._41_2sumsquence;

public class Solution {
	public static void main(String[] args) {
		int[]test={1,2,3,4,5,6};
		findContinusSquence(test, 9);
	}
	public static void findContinusSquence(int[] array,int sum){
		if(array==null||array.length<2){
			//序列必须包含两个元素称为序列
			return;
		}
		int small=0;
		int big=1;
		while(big<array.length){
			int currentSum=0;
			for(int i=small;i<big;i++){
				currentSum+=array[i];
			}
			if(currentSum==sum){
				//System.out.println("从"+small+"到"+big);
				for(int i=small;i<big;i++){
					System.out.print(array[i]+" ");
				}
				System.out.println();
				big++;
			}else if(currentSum<sum){
				big++;
			}else{
				small++;
			}
		}
	}
}
