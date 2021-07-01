package algorithms;

public class CountingSort {
	private void sort(int[] arr) {
		int n = arr.length;
	    int[] freq = new int[n+1];
	    int[] aux = new int[n+1];
	    for(int i=0; i<n; i++){
	        freq[arr[i]]++;
	    }
	    for(int i=1; i<= n; i++){
	        freq[i] += freq[i-1];
	    }
	    for(int j=0, i=n-1; i>=0; j++, i--){
	        aux[freq[arr[i]]--] = arr[i];
	    }
	}

}
