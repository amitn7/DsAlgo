/**
 * Given two strings find minimum cost to convert one string to other
 * ALlowed operations are delete , replace add
 */
public class MinimumEditDistance {

//    public static int insertCost = 1;
//    public static int delCost = 1;
//    public static int replaceCost = 1;

    public static int minimumEditDist(String str1, String str2){
        int distCost[][] = new int[str1.length()+1][str2.length()+1];

        for(int i = 0; i <= str1.length(); ++i){
            for(int j =0 ; j <= str2.length(); ++j) {
                if(i == 0 && j == 0) distCost[i][j]=0;
                else if(i== 0 ) {
                    distCost[0][j] = j;

                } else if(j==0) {
                    distCost[i][0] = i;
                } else {
                    if(str1.charAt(i-1) == str2.charAt(j-1)) {
                        distCost[i][j] = distCost[i-1][j-1];
                    } else {
                        distCost[i][j] = Math.min(distCost[i-1][j-1] + 1, Math.min(distCost[i-1][j]+1, distCost[i][j-1]+1));
                    }
                }
            }
        }
        return distCost[str1.length()][str2.length()];
    }
    
    public static void main(String args[]){
        String str1 ="mon", str2 = "rtue";
        System.out.println("The minimum cost to convert string from on string to other is : "+ minimumEditDist(str1, str2));
    }
}
