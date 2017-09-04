package sword.util.datastructure;

import java.util.ArrayList;

public class Stack<T> {
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
}
