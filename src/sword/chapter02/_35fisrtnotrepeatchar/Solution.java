package sword.chapter02._35fisrtnotrepeatchar;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Solution {
	public static void main(String[] args) {
		String test="agaccddeeff";
		char[] array=test.toCharArray();
		try {
			System.out.println(FirstNotRepeatChar(array));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static char FirstNotRepeatChar(char[] array) throws Exception{
		Map<Character,Integer> map=new LinkedHashMap<>(26);//默认只有26个英文字母
		for(int i=0;i<array.length;i++){
			if(map.containsKey(array[i])){
				map.put(array[i], map.get(array[i])+1);
			}
			else{
				map.put(array[i], 1);
			}
		}	
		
		boolean isFindfirst=false;
		char result = 0;
		for(Entry<Character, Integer> entry:map.entrySet()){
			if(entry.getValue()==1){
				isFindfirst=true;
				result=entry.getKey();
				break;
			}
		}
		if(isFindfirst){
			return result;
		}else{
			throw new Exception("not found");
		}
		
	}
}
