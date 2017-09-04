package sword.chapter02._24verifysquenceOfBST;

public class Solution {
	public static void main(String[] args) {
		int[] afterOrder1={5,7,6,9,11,10,8};
		int[] afterOrder2={7,4,6,5};
		System.out.println(VerifySquenceOfBST(afterOrder1));;
		System.out.println(VerifySquenceOfBST(afterOrder2));;
	}
	public static boolean VerifySquenceOfBST(int[] squence){
		if(squence==null||squence.length==0){
			return false;
		}
		//the last elemnt
		int rootValue=squence[squence.length-1];
		//找到最后一个小于rootValue的
		int i=0;
		for(i=0;i<squence.length-1;i++){
			if(squence[i]>rootValue){
				break;
			}
		}
		//
		int j=i;
		for(;j<squence.length-1;j++){
			if(squence[j]<rootValue){
				return false;
			}
		}
		
		boolean left=true;
		if(i>0){
			int[] temp=new int[i];
			for(int k=0;k<i;k++){
				temp[k]=squence[k];
			}
			left=VerifySquenceOfBST(temp);
		}
		boolean right=true;
		if(i<squence.length-1){
			int[] temp=new int[squence.length-i-1];
			for(int k=0;k<temp.length;k++){
				temp[k]=squence[i+k];
			}
			right=VerifySquenceOfBST(temp);
		}
		return left&&right;
	}
}
