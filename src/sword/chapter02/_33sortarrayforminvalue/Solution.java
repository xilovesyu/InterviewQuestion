package sword.chapter02._33sortarrayforminvalue;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public static void main(String[] args) {
		String[] values={"3","32","321"};
		sort(values);
		for(int i=0;i<values.length;i++){
			System.out.print(values[i]);
		}
		System.out.println();
	}
	public static void sort(String[] values){
		Arrays.sort(values,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1+o2).compareTo((o2+o1));
			}
		});
	}
}
