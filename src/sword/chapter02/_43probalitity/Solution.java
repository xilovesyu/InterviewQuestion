package sword.chapter02._43probalitity;
/*
 * 给n个骰子，求出现和为s的概率是多少
 * */
public class Solution {
	public static int MaxPoint=6;
	public static void main(String[] args) {
		int n=6;
		int s=7;
		int[] result=probability(n, s);
		printProbability(n, s, result);
	}
	public static int[] probability(int n,int s){
		int[] sarray=new int[5*n+1];//保存各个点的和
		
		for(int i=0;i<6;i++){
			probability(n,n,i+1,sarray);
		}
		return sarray;
	}
	public static void probability(int originN,int currentN,int sum,int[] sarray){
		if(currentN==1){
			//最后一位
			sarray[sum-originN]++;
		}else{
			for(int i=0;i<6;i++){
				probability(originN, currentN-1, sum+(i+1), sarray);
			}
		}
	}
	public static void printProbability(int n,int s,int[] result){
		double maxOptions=Math.pow(6, n);
		int countS=result[s-n];
		System.out.println(countS/maxOptions);
		
	}
}
