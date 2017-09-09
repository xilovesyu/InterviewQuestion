package sword.chapter02._34uglynumber;

public class Solution {
	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
		System.out.println(KthUglyNumber(1500));
		long endTime=System.currentTimeMillis();
		System.out.println("time 1:"+(endTime-startTime));
		startTime=System.currentTimeMillis();
		System.out.println(KthUglyNumber2(1500));
		endTime=System.currentTimeMillis();
		System.out.println("time 2:"+(endTime-startTime));
	}
	public static boolean isUglyNumber(int n){
		//只包含2,3,5.所以我们一直除
		while(n%2==0){
			n=n/2;
		}
		while(n%3==0){
			n=n/3;
		}
		while(n%5==0){
			n=n/5;
		}
		if(n==1){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static int KthUglyNumber(int k){
		int number=0;
		int count=0;
		while(count<k){
			number++;
			if(isUglyNumber(number)){
				count++;
			}
		}
		return number;
	}
	
	public static int KthUglyNumber2(int index){
		int[] uglyNumbers=new int[index];//保存1500个丑数
		uglyNumbers[0]=1;
		int p2=0;
		int p3=0;
		int p5=0;
		int count=0;
		while(count<index-1){
			int min=Min(uglyNumbers[p2]*2, uglyNumbers[p3]*3, uglyNumbers[p5]*5);
			count++;
			uglyNumbers[count]=min;
			
			//更新位置
			while(uglyNumbers[p2]*2<=uglyNumbers[count]){
				p2++;
			}
			while(uglyNumbers[p3]*3<=uglyNumbers[count]){
				p3++;
			}
			while(uglyNumbers[p5]*5<=uglyNumbers[count]){
				p5++;
			}
		}
		
		return uglyNumbers[index-1];
	}
	public static int Min(int a,int b,int c){
		if(a<b){
			if(a<c){
				return a;
			}else{
				return c;
			}
		}else{
			if(b<c){
				return b;
			}else{
				return c;
			}
		}
	}
}
