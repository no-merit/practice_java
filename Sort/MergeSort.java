import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSort {
	
	static int [] A;
	static int [] tmp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NK = br.readLine().split(" ");
		
		int N = Integer.parseInt(NK[0]);
		int M = Integer.parseInt(NK[1]);
		
		String[] As = br.readLine().split(" ");
		
		A = new int [As.length];
		tmp = new int [As.length];
		
		for(int i=0; i<A.length; i++) {
			A[i] = Integer.parseInt(As[i]);
		}
		
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]);
		}
		System.out.println();
		mergeSort(0,A.length-1);
		
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]);
		}
		System.out.println();
	
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static void mergeSort(int st, int ed) {
		if(st==ed) return;
		
		int mid = (st+ed)/2;
		mergeSort(st, mid);
		mergeSort(mid+1, ed);
		merge(st,ed);
		
	}
	static void merge(int st, int ed) {
		int mid =(st+ed)/2;
		int left = st;
		int right = mid+1;
		int idx = st;
		while(left<=mid && right<=ed) {
			
			if(A[left]<=A[right]) {
			tmp[idx++]=A[left++];
			}else {
				tmp[idx++]=A[right++];
				
			}
		}
		
		if(left>mid) {
			while(right<=ed) {
				tmp[idx++]=A[right++];
			}
		}else {
			while(left<=mid) {
				tmp[idx++]=A[left++];
			}
		}
		
		for(int i= st; i<=ed; i++) {
			A[i] = tmp[i];
		}
			
		
	}

}
