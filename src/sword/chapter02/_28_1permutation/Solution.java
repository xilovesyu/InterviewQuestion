package sword.chapter02._28_1permutation;

public class Solution {
	public static void main(String[] args) {
		String[] test={"a","b","c"};
		permutation(test, 0, test.length);
	}
	public static void permutation(String[] str,int start,int len){
		if(start==len-1){
			for(int i=0;i<len;i++){
				System.out.println(str[i]+" ");
			}
			System.out.println();
		}else{
			for(int i=start;i<len;i++){
				swap(str,start,i);//交换start和i位
				permutation(str, start+1, len);
				swap(str,start,i);
			}
		}
	}
	public static void swap(String[] str, int i, int j)  
    {  
        String temp = new String();  
        temp = str[i];  
        str[i] = str[j];  
        str[j] = temp;  
    } 
}
