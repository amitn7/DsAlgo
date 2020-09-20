
public class SortNum {

	public static void exch(int[] num, int l, int r) {
		int temp = num[l] ;
		num[l] =num[r];
		num[r]= temp;
	}
	//public static int numArr[] = new int[20];
	//------------------------------QUICK SORT------------------------------>



	public static int partition(int numArr[], int l, int r){
		int partVal = numArr[l];
		int hi = r+1;

		int i = l;
		while(true){
			while(numArr[++l] < partVal)
				if(l == r) break;
			while(partVal < numArr[--hi])
				if( hi == i	) break;
			if(l>=hi) {
				exch(numArr,i,hi);
				break;
			}
			exch(numArr,l,hi);
		}


		return hi;


	}
	public static void quickSort(int numArr[], int l, int r) {

		if(r<=l) return;
		int q = partition(numArr, l, r);

		quickSort(numArr, l, q-1);
		quickSort(numArr, q+1, r);
	}
	
	//------------------------------------HEAP SORT--------------------->
	public static void heapify(int numArr[], int k, int len) {

		while(2*k + 1 < len) {
			int lc = 2*k + 1;		
			if(lc + 1 < len && numArr[lc] < numArr[lc+1]) {
				lc = lc+1;
			}
			if(numArr[k] <numArr[lc]) {
				exch(numArr, lc, k);
				k =lc;
			}else break;	
		}
	}
	
	public static void heapSort(int numArr[]) {
		if (numArr.length ==1 || numArr.length == 0) return ;
		int k = numArr.length/2;
		for(int i = k;i>=0; i--) {
			heapify(numArr, i, numArr.length);
		}
		int len = numArr.length;
		exch(numArr, 0, --len);
		while(len > 0) {
			heapify(numArr, 0,len);
			exch(numArr,0, --len);
		}
	}
	
	//------------------------------------ MERGE SORT-------------------
	public static void merge(int[] numArr, int auxArr[], int l, int m, int r) {

		for(int i = 0;i<numArr.length; ++i) auxArr[i] = numArr[i];
		
		int k = l,  j = m;
		
		for(int i = l; i<=r;i++) {
			if(k==m) numArr[i] = auxArr[j++];
			else if(j>r) numArr[i] = auxArr[k++];
			else if(auxArr[k] > auxArr[j]) numArr[i] = auxArr[j++];
			else numArr[i] = auxArr[k++];
		}
	}
	
	public static void mergeSortHelper(int[] numArr, int[] auxArr, int l, int r) {
		
		if(l>=r) return ;
		int m = l+(r-l)/2;

		mergeSortHelper(numArr, auxArr, l,m);
		mergeSortHelper(numArr, auxArr, m+1, r);
		merge(numArr, auxArr, l,m+1, r);

	}
	

	public static void mergeSort(int numArr[]) {
		int auxArr[] = new int[numArr.length];
		mergeSortHelper(numArr, auxArr, 0, numArr.length-1);

	}
	
	//------------------------------------  MAIN -------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len =21;
		int numArr[] =//{388, 880 ,583, 427, 57, 410, 664, 407, 465, 673, 76, 631, 529, 568, 828, 2, 796, 583, 716, 568};
				new int[len];
		for(int i =0;i<len;++i) {
			numArr[i] = (int)(Math.random() * 1000 + 1);
			System.out.print(numArr[i] + " ");
		}
		//mergeSort(numArr);
		//quickSort(numArr, 0, numArr.length-1);
		heapSort(numArr);
		System.out.println("Sorted Array is" );
		for(int i =0;i<len;++i) {
			System.out.print(numArr[i] + " ");
		}
	}

}
