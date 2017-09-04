package sword.chapter02._07queuewith2stacks;

import sword.util.datastructure.Stack;

public class Solution {
	public Stack<Integer> stack1 = new Stack<>();
	public Stack<Integer> stack2 = new Stack<>();

	public void add(Integer value) {
		this.stack1.push(value);
	}

	public int head() {

		if (stack2.isEmpty()) {
			//
			int sizeOfstack1=stack1.values.size();
			for (int i = 0; i < sizeOfstack1; i++) {
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		} else {
			return stack2.pop();
		}
	}

	public static void main(String[] args) {
		Solution solution=new Solution();
		solution.add(1);
		solution.add(2);
		solution.add(3);
		System.out.println(solution.head());
//		solution.add(4);
//		solution.add(5);
		System.out.println(solution.head());
		System.out.println(solution.head());
		System.out.println(solution.head());
		System.out.println(solution.head());
	}

}
