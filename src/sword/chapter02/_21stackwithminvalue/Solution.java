package sword.chapter02._21stackwithminvalue;

import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		StackWtihMin<Integer> test=new StackWtihMin<>();
		test.push(3);
		System.out.println(test.min());
		test.push(4);
		System.out.println(test.min());
		test.push(2);
		System.out.println(test.min());
		test.push(1);
		System.out.println(test.min());
		test.pop();
		System.out.println(test.min());
		test.pop();
		System.out.println(test.min());
		test.push(0);
		System.out.println(test.min());
	}
	
}
class StackWtihMin<T extends Comparable<T>>{
	ArrayList<T> values=new ArrayList<>();
	ArrayList<T> mins=new ArrayList<>();
	public T pop(){
		T result=values.remove(values.size()-1);
		mins.remove(mins.size()-1);
		return result;
	}
	public void push(T value){
		values.add(value);
		//判断是否是最小值
		if(mins.size()==0||value.compareTo(mins.get(mins.size()-1))<0){
			mins.add(value);
		}else{
			mins.add(mins.get(mins.size()-1));
		}
	}
	public T min(){
		return mins.get(mins.size()-1);
	}
}