package sword.chapter02._22isstackpoporder;

import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		int[] pushOrder={1,2,3,4,5};
		int[] popOrder1={4,5,3,2,1};
		int[] popOrder2={4,5,3,1,2};
		System.out.println(isPopOrder(pushOrder,popOrder1));
		System.out.println(isPopOrder(pushOrder,popOrder2));
		
	}
	public static boolean isPopOrder(int[] pushOrder,int[] popOrderTest){
		// 思路，根据出栈元素进行判断
				Stack<Integer> temp2 = new Stack<>();

				int nowindex = -1;
				int preindex = 0;
				// 根据出栈顺序来判断次序
				for (int i = 0; i < popOrderTest.length; i++) {
					// 先判断是否有该元素，如果没有，就要将入栈序列的没有出栈的元素压入栈中
					if (temp2.contains(popOrderTest[i])) {
						// 如果有该元素
						// 判断是否是第一个元素,是的话弹出并看下一个，不是的话返回
						if (temp2.pop().intValue() != popOrderTest[i]) {
							return false;
						} else {
							continue;
						}
					} else {
						// 先压入栈，压入最大次序之后的元素
						for (int j = 0; j < pushOrder.length; j++) {
							if (popOrderTest[0] == pushOrder[j]) {
								nowindex = j;
							}
						}
						if(nowindex==-1){
							return false;
						}
						for (int j = preindex; j <= nowindex; j++) {
							temp2.push(pushOrder[j]);
						}
						preindex = nowindex;

						temp2.pop();
					}
				}
				return true;
	}
}
