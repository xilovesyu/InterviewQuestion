package sword.chapter02._11pow;

public class Solution {
	public static void main(String[] args) {
		double a=0;
		int b=33;
		try{
			System.out.println(pow(a, b));
		}catch(PowException e){
			System.out.println(e.getMessage());;
		}
		//System.out.println(pow(a, b));;
	}
	public static double pow(double base,int exponent){
		if(equals(base,0.0)&&exponent<=0){
			throw new PowException("base 为0 时，指数不能小于等于0");
		}
		double result=0.0;
		if(exponent<0){
			result=powWithoutSign(base, -exponent);
			result=1.0/result;
		}else{
			result=powWithoutSign(base,exponent);
		}
		return result;
	}
	public static double powWithoutSign(double base,int exponent){
		double result=1.0;
		for(int i=0;i<exponent;i++){
			result=result*base;
		}
		return result;
	}
	public static boolean equals(double a,double b){
		return Double.compare(a, b)==0?true:false;
	}
}
