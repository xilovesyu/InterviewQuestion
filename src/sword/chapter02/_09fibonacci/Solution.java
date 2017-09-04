package sword.chapter02._09fibonacci;

public class Solution {
	public static void main(String[] args) {
		int n=60;
		System.out.println(nth(n));
		System.out.println(nthByTongxiang(n));
	}
	public static long nth(int n){
		long firstPart=1;
		long secondPart=0;
		long nth=0;
		for(int i=2;i<=n;i++){
			nth=firstPart+secondPart;
			secondPart=firstPart;
			firstPart=nth;
		}
		return nth;
	}
	
	public static double nthByTongxiang(int n){
		return ((Math.pow((1+Math.sqrt(5))/2, n)-Math.pow((1-Math.sqrt(5))/2,n))/Math.sqrt(5));
	}
}
