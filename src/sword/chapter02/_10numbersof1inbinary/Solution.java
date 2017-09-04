package sword.chapter02._10numbersof1inbinary;

public class Solution {
	public static void main(String[] args) {
		int a = 3;
		int b = -4;
		System.out.println(binaryString(a));
		System.out.println(binaryString(b));// 补码（反码加1）11111111111111111111111111111101
		System.out.println(b >> 1);// 不连符号一起移
		System.out.println(binaryString(b >> 1));
		System.out.println(b >>> 1);// 连符号一起移
		System.out.println(binaryString(b >>> 1));// 31位
		System.out.println(-15 >> 1);// 补码右移，所以是-8

		System.out.println("----------------------");
		// System.out.println(numbersOfOneInBinaryString(a));
		//System.out.println(numbersOfOneInBinaryString(b));// fail,死循环,移到-1死循环
		//System.out.println(numbersOfOneInBinaryString(-8));// fail,死循环,移到-1死循环
		System.out.println(numbersOfOneInBinaryString2(-8));//29,取到的是补码的1的个数
		
	}

	public static String binaryString(int n) {

		return Integer.toBinaryString(n);

	}

	public static int numbersOfOneInBinaryString(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}
	public static int numbersOfOneInBinaryString2(int n){
		int count=0;
		int flag=1;
		while(flag!=-0){
			if((n&flag)!=0){
				count++;
			}
			flag=flag<<1;
//			System.out.println("n:"+n);
//			System.out.println("flag:"+flag);
//			System.out.println("n&flag:"+(n&flag));
//			System.out.println("count:"+count);
		}
		return count;
	}
}
