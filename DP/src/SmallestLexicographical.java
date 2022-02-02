public class SmallestLexicographical {

    /**
     * https://www.geeksforgeeks.org/lexicographically-smallest-string-formed-by-removing-duplicates/
     * @param str
     */

    public static String findSmallestLexicographically(String str) {

        String res = "";
        int [] count = new int[26];
        int [] vis = new int[26];

        for(int i = 0; i < str.length();++i) {
            count[str.charAt(i)-'a']++;
        }

        for(int i = 0; i<str.length(); ++i) {
            char x = str.charAt(i);
            count[x-'a']--;
            int index = x-'a';
            if(vis[index] == 0) {
                int size = res.length();
                while(size > 0 &&
                res.charAt(size-1) > x &&
                count[res.charAt(size-1)-'a'] > 0) {
                    vis[res.charAt(size-1)-'a'] = 0;
                    res=res.substring(0,size-1);
                    size--;
                }
                res = res + x;
                vis[index] = 1;
            }

        }

        return  res;
    }
    public static void main(String [] args) {
        String str = "yzxyz";
        System.out.println(findSmallestLexicographically(str));
    }
}
