
public class SortNum {
	public static int numArr[] = new int[20];
	//------------------------------QUICK SORT------------------------------>
	public void quickSort() {
		
	}
	
	//------------------------------------HEAP SORT--------------------->
	public void heapSort() {
		
	}
	
	//------------------------------------ MERGE SORT-------------------
	//public static void merge(int[] numArr, int auxArr[], int l, int m, int r) {
	public static void merge( int auxArr[], int l, int m, int r) {
		for(int i = 0;i<numArr.length; ++i) {
			auxArr[i] = numArr[i];
		}
		int k = l,  j = m;
		for(int i = l; i<r;i++) {
			if(k==m) numArr[i] = auxArr[j++];
			else if(j==r) numArr[i] = auxArr[k++];
			else if(auxArr[k] > auxArr[j]) numArr[i] = auxArr[j++];
			else numArr[i] = auxArr[k++];
		}
	}
	
	//public static void mergeSortHelper(int[] numArr, int[] auxArr, int l, int r) {
	public static void mergeSortHelper( int[] auxArr, int l, int r) {
		
		if(l>=r) return ;
		int m = l+(r-l)/2;
//		mergeSortHelper(numArr, auxArr, l,m-1);
//		mergeSortHelper(numArr, auxArr, m, r);
//		merge(numArr, auxArr, l,m, r);
		mergeSortHelper( auxArr, l,m-1);
		mergeSortHelper( auxArr, m, r-1);
		merge( auxArr, l,m, r);
	}
	
//	public static void mergeSort(int numArr[]) {
	public static void mergeSort() {
		int auxArr[] = new int[numArr.length];
		//mergeSortHelper(numArr, auxArr, 0, numArr.length);
		mergeSortHelper( auxArr, 0, numArr.length);
	}
	
	//------------------------------------  MAIN -------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len =20;
		//int numArr[] = new int[len];                         
		for(int i =0;i<len;++i) {
			numArr[i] = (int)(Math.random() * 1000 + 1);
			System.out.print(numArr[i] + " ");
		}
		//mergeSort(numArr);
		mergeSort();
		System.out.println("Sorted Array is" );
		for(int i =0;i<len;++i) {
			System.out.print(numArr[i] + " ");
		}
	}

}
