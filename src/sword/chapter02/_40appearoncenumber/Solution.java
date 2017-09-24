package sword.chapter02._40appearoncenumber;

public class Solution {
	public static void main(String[] args) {
		int[] test={2,4,3,2,3,4,5,6,6,7};
		findAppearOnceNumber(test);
	}
	public static int[] findAppearOnceNumber(int[] array){
		if(array==null||array.length==0){
			return null;
		}
		int OR=0;
		for(int i=0;i<array.length;i++){
			OR=OR^array[i];
		}
		int indexOf1=findIndexOf1(OR);
		int num1=0,num2=0;
		for(int j=0;j<array.length;j++){
			if(has1InIndex(array[j], indexOf1)){
				num1=num1^array[j];
			}else{
				num2=num2^array[j];
			}
		}
		
		System.out.println(num1+","+num2);
		return new int[]{num1,num2};
	}
	public static boolean has1InIndex(int k,int index){
		k=k>>index;
		return (k&1)==1;
	}
	public static int findIndexOf1(int OR){
		int indexBit=0;
		while((OR&1)==0&&indexBit<32){
			OR=OR>>1;
			++indexBit;
		}
		return indexBit;
	}
}
