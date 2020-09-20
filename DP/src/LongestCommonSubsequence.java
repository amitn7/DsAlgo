/**
 * Longest Common Subsequence
 * Given two strings find the longest comon subsequence
 * String a = "Monday"
 * String b = "ofdcykajsy"
 * Answer = 4  (oday )
 * @author Amit
 *
 */
public class LongestCommonSubsequence {

	public static int  lcs(String str1, String str2) {
		int lcs[][] = new int[str1.length()+1][str2.length()+1];
		for(int i = 0; i<=str1.length(); ++i) {
			for(int j =0 ;j<=str2.length(); ++j) {
				if(i==0 || j==0) {
					lcs[i][j]=0;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					lcs[i][j] = Math.max(lcs[i-1][j-1]+1, Math.max(lcs[i-1][j], lcs[i][j-1]));
				}else {
					lcs[i][j] =  Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		int len =  lcs[str1.length()][str2.length()];
		return len;
//		String str = "";
//		int r = str1.length(), c= str2.length();
//		for(int i= len;i>0;i--) {
//			if((lcs[r][c] > lcs[r-1][c-1]) && (lcs[r][c] > lcs[r][c-1] )&& (lcs[r][c] > lcs[r-1][c])){
//				 str = str + str1.charAt(r-1);
//			} else {
//
//			}
//		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1= "Monday",str2 = "ofdcykajsyMeeoeentdyyayy";
		System.out.print("Length of longest common subsequence is : " + lcs(str2, str1));
		
	}

}
