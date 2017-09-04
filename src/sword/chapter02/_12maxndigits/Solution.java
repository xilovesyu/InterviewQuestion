package sword.chapter02._12maxndigits;

public class Solution {
	public static void main(String[] args) {
		int n = 3;
		char[] digitNumbers = new char[n];
		// init
		for (int i = 0; i < digitNumbers.length; i++) {
			digitNumbers[i] = '0';
		}

//		boolean flag;
//		while (flag = increment(digitNumbers)) {
//			print(digitNumbers);
//		}
		incrementByDiGui(digitNumbers, 0);
		
	}

	public static void print(char[] digitNumbers) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < digitNumbers.length; i++) {
			if (digitNumbers[i] == '0' && sb.length() == 0) {

			} else {
				sb.append(digitNumbers[i]);
			}
		}
		System.out.println(sb);

	}

	public static boolean increment(char[] digitNumbers) {

		// increment
		boolean flag = true;
		// while(flag){
		boolean needJinwei = false;
		for (int i = digitNumbers.length - 1; i >= 0; i--) {
			if (i == digitNumbers.length - 1) {
				if (digitNumbers[i] == '9') {
					needJinwei = true;
					digitNumbers[i] = '0';
				} else {
					needJinwei = false;
					digitNumbers[i] += 1;
				}
			} else {
				if (needJinwei) {
					if (digitNumbers[i] == '9') {
						needJinwei = true;
						digitNumbers[i] = '0';
					} else {
						needJinwei = false;
						digitNumbers[i] += 1;
					}
				}
			}
			if (needJinwei && i == 0) {
				flag = false;
			}

		}
		// }
		// System.out.println(String.valueOf(digitNumbers));
		// System.out.println("flag:"+flag);
		return flag;
	}
	
	public static void incrementByDiGui(char[] digitNumbers,int index){
		if(index==digitNumbers.length){
			System.out.println(digitNumbers);
			return;
		}
		for(int i=0;i<10;i++){
			digitNumbers[index]=(char)(i+'0');
			incrementByDiGui(digitNumbers, index+1);
		}
	}
}
