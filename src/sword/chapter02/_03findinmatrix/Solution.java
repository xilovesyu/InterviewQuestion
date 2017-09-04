package sword.chapter02._03findinmatrix;

public class Solution {
	public static void main(String[] args) {
		int[][] matrix={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.println(find(matrix, 7));
	}
	public static boolean find(int[][] matrix,int BeFoundValue){
		boolean isFound=false;
		if(matrix==null||matrix.length==0){
			isFound= false;
		}
		
		int row=0;
		int column=matrix[0].length-1;
		while(row<matrix.length&&column>=0){
			if(BeFoundValue==matrix[row][column]){
				isFound= true;
				System.out.println("find "+BeFoundValue+" at("+row+","+column+")");
				break;
			}else if(BeFoundValue>matrix[row][column]){
				//delete a row
				row++;
			}else{
				column--;
			}
		}
		return isFound;
	}
}
