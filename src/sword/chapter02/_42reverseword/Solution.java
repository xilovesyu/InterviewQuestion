package sword.chapter02._42reverseword;

public class Solution {
	public static void main(String[] args) {
		String test="i am a student";
		//System.out.println(reverse(test));
		System.out.println(reverseWord(test));
	}
	public static String reverseWord(String s){
		s=reverse(s);
		String[] words=s.split(" ");
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<words.length;i++){
			words[i]=reverse(words[i]);
			sb.append(words[i]+" ");
		}
		return sb.toString();
	}
	public static String reverse(String s){
		if(s==null||s.length()==0){
			return null;
		}
		char[] sarray=s.toCharArray();
		int start=0;
		int end=sarray.length-1;
		while(start<end){
			char temp=sarray[start];
			sarray[start]=sarray[end];
			sarray[end]=temp;
			start++;
			end--;
		}
		return String.valueOf(sarray);
	}
}
