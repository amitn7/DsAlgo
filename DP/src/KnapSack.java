/**
 *  Knapsack problem:
 *  Given a list of items with their weight and their values and a sack with maxCapacity.
 *  Find the maximum value which can be put in sack
 * @author Amit
 *
 */
public class KnapSack {
	
	public static int val[] = {10,4,5,7};
	
	/**
	 * 
	 */
	public static int weight[] = {2,3,4,5};
	
	public static int maxWeight =7;
	
	public static int  findMaxVal() {
		int dpTable[][] = new int[weight.length +1][maxWeight+1];
		int maxVal = 0;
		for(int i = 0 ; i <= val.length; ++i) {
			for (int j=0; j<= maxWeight; ++j) {
				if(j ==0 || i==0) {
					dpTable[i][j] = 0;
				} else if(j<weight[i-1]) {
					dpTable[i][j] = dpTable[i-1][j];
				} else {
					dpTable[i][j]= Math.max(dpTable[i-1][j], val[i-1] + dpTable[i-1][j-weight[i-1]] );
					maxVal = Math.max(dpTable[i][j], maxVal);
				}
				
			}
		}
		for(int i =0 ;i< dpTable.length;++i) {
			System.out.println("");
			for(int j =0 ;j< dpTable[0].length;++j) {
				System.out.print(dpTable[i][j] + " ");
			}
		}
		return maxVal;
	}
	
	public static void main(String[] args) {
		System.out.println(findMaxVal());
	}
}
