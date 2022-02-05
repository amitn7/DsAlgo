public class ValidBst {

    public static int findPartition(int[] tree, int l, int r) {
        for(int i = l+1; i<=r; ++i) {
            if(tree[i] > tree[l]) return i;
        }
        return -1;
    }


    public static boolean validateBst(int[] tree, int l , int r , int minVal, int maxVal) {

        if(l>r) return true;
        if(l==r) {
            if(tree[l] > minVal && tree[l] < maxVal) return true;
            return false;
        }
            if(tree[l] < minVal || tree[l] > maxVal) return false;

            int partitionIndex = findPartition(tree, l, r) ;
            boolean right = true;
            boolean left = true;
            if(partitionIndex!=-1) {
                right = validateBst(tree, partitionIndex, r,tree[l], maxVal );
                left = validateBst(tree, l+1, partitionIndex-1, minVal,  tree[l]);
            } else {
                left = validateBst(tree, l+1, r, minVal, tree[l]);
            }
            return left && right;
    }
    public static void main(String[] args) {
//        int [] tree = new int[] {40, 30, 35, 80, 100};
        int [] tree = new int[] {2,4,3,5};
        System.out.println(validateBst(tree, 0, tree.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }
}
