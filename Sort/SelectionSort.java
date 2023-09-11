import java.io.IOException;

public class practice {
	/*
	 * 현재 위치에 들어갈 데이터를 찾아 선택하는 정렬
	 * 데이터를 비교하면서 찾기 때문에 비교 정렬
	 * 정렬의 대상이 되는 데이터 외에 추가적인 공간이 필요 하지 않아서 제자리 정렬
	 * 불안정 정렬
	 * 
	 * 
	 * 1. 주어진 리스트에서 최솟값을 찾음
	 * 2. 최솟값을 맨 앞자리의 값과 교환
	 * 3. 맨 앞자리를 제외한 나머지 값들 중 최솟값을 찾아 반복
	 * 
	 * 
	 * */

	public static void main(String[] args) throws IOException {
		int [] a = new int [] {5, 3, 2, 8 ,1};
		
		int size = a.length;
		for(int i=0; i<size -1; i++) {
			int min_index = i;
			for(int j=i+1; j<size; j++) {
				if(a[min_index]>a[j]) {
					min_index=j;
				}
			}
			int temp = a[min_index];
			a[min_index] = a[i];
			a[i] = temp;
			
		}
		
		for(int i=0; i<5; i++) {
			System.out.print(a[i]);
		}
		
	} // main
}
