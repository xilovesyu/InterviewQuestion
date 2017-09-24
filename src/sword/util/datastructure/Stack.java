package sword.util.datastructure;

import java.util.ArrayList;

public class Stack<T extends Comparable<T>> {
	// public int cap;
	public ArrayList<T> values = new ArrayList<>();

	public void push(T value) {
		values.add(value);
	}

	public T pop() {
		if (values.size() > 0) {
			return values.remove(values.size() - 1);
		} else {
			return null;
		}
	}

	public boolean isEmpty() {
		return values.size() == 0 ? true : false;
	}
	public T heap_pop(){
		if(values==null||values.size()==0){
			return null;
		}
		T max=values.get(0);
		for(int i=1;i<values.size();i++){
			if(values.get(i).compareTo(max)>0){
				max=values.get(i);
			}
		}
		values.remove(max);
		return max;
	}
}
