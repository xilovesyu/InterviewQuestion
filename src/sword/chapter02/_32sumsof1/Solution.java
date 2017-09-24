package sword.chapter02._32sumsof1;

public class Solution {
	public static void main(String[] args) {
		int n=2048;
		System.out.println(NumbersOf1(n));
		System.out.println(NumbersOf1Another(n));
	}
	public static int NumbersOf1(int n){
		int count=0;
		for(int i=1;i<=n;i++){
			int temp=NumbersOf1InEachValue(i);
			count+=temp;
		}
		//System.out.println(count);
		return count;
	}
	public static int NumbersOf1InEachValue(int a){
		int count=0;
		while(a!=0){
			if(a%10==1){
				count++;
			}
			a=a/10;
		}
		return count;
	}
	
	public static int NumbersOf1Another(int n){
		String nStr=n+"";
		//取第一位
		int firstDigit=nStr.charAt(0)-'0';
		if(firstDigit==0&&nStr.length()==1){
			return 0;
		}
		if(firstDigit>=1&&nStr.length()==1){
			return 1;
		}
		int sumOfFirstDigit=0;
		//先取最高位的
		if(firstDigit==1){
			//11345，首位是1，从10000-11345
			sumOfFirstDigit=(n-(int)Math.pow(10, nStr.length()-1))+1;
		}else if(firstDigit>1){
			//21345,首位是2，大于1,那么就是10^4
			sumOfFirstDigit=(int)Math.pow(10, nStr.length()-1);
		}
		//取其他位（1346-11345）或者（1346-11345和11346-21345）
		//只看后面四位，就是第一位数*（length-1）*10^(length-2)
		int sumOfOtherDigit=firstDigit*(nStr.length()-1)*(int)Math.pow(10, nStr.length()-2);
		
		//看最后1-1345
		int number=Integer.parseInt(String.copyValueOf(nStr.toCharArray(), 1, nStr.length()-1));
		
		int sumOfLastDigit=NumbersOf1Another(number);
		
		//System.out.println(sumOfFirstDigit+","+sumOfOtherDigit+","+sumOfLastDigit);
		return sumOfFirstDigit+sumOfOtherDigit+sumOfLastDigit;
	}
	//public static int 
}
