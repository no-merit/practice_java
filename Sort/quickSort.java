public class  practice {
	/* 하나의 리스트를 피벗을 기준으로 두 개의 부분 리스트로 나누어서 피벗보다 작은 값의 리스트.
	 * 피벗보다 큰 값의 리스트로 정렬해서 각 부분 리스트에 대해 재뒤적으로 수행해서 정렬하는 방식
	 * 
	 * 분할 정복 알고리즘.
	 * 병합정렬은 절반을 기준으로 분할 정복하고 퀵정렬은 피벗을 기준으로 분할 정복하므로 피벗에 따라 효율이 바뀜
	 * 
	 * 일반적으로는 병합정렬이 더 빠름.
	 * 
	 * 퀵 정렬은 데이터를 비교하면서 찾기 때문에 비교 정렬.
	 * 정렬 대상이 되는 데이터 외에는 추가적인 공간을 필요로 하지 않으므로 제자리 정렬.
	 * 하나의 피벗을 두고 두개의 부분리스트를 만들 때 서로 떨어진 원소끼리 교환이 일어나기 때문에 불안정 정렬.
	 * 
	 * 
	 * <장점>
	 * 특정 상태()가 아닌 이상 평균 시간 복잡도는 NlogN이며, 다른 NlogN 알고리즘에 비해 대체적으로 속도가 매우 빠음
	 * 추가적은 메모리를 필요로 하지 않으며 재귀 호출 스택프레임에 의한 공간복잡도는 logN으로 메모리를 적게 소비
	 * <단점>
	 * 피벗을 기준으로 정렬을 하니까 피벗이 한쪽으로 치우쳐있으면 나뉜 리스트들의 크기가 한쪽으로 치중되고
	 * 최악의 경우 O(N^2)의 시간 복잡도를 가진다
	 * 
	 * 그 때문에 중간 피벗을 사용해서 이런 경우의 수를 줄인다.
	 * --------------------------------------------------------------------
	 * 피벗을 설정하고 피벗보다 큰 요소와 작은 요소를 각 끝단에서 시작해서 탐색하는 것은 
	 * 현재 리스트의 요소들을 탐색하기 때문에 O(N)이다.
	 * 
	 * --------------------------------------------------------------------
	 * 
	 * 순서대로 정렬이 될 경우 9876543 처럼 요소가 이동되었다면
	 * 불안정정렬의 경우 9143 처럼 요소가 있어야 할 위지에 근접하게 이동되므로 효율이 좋음.
	 * 
	 * i번 째 레벨에서 노드의 개수가 2^i이고 노드의 크기(size)는 N/2^i 이니까 탐색하는데 드는 시간은 O(N).
	 * */

    public static void sort(int [] a) {
    	m_pivot_sort(a, 0, a.length-1);
    }
    
    private static void m_pivot_sort(int[] a, int lo, int hi) {
    	if(lo>=hi) { // 원소가 1개인 경우
    		return;
    	}
    	//세개의 값을 골라서 그 중간 값을 pivot으로 정함
    	
    	int pivot = partition(a, lo, hi);
    	
    	m_pivot_sort(a, lo, pivot);
    	//왼쪽 리스트
    	m_pivot_sort(a, pivot+1, hi);
    	//오른쪽 리스트
    	
    }
    
    
    private static int partition(int[] a, int left, int right) {
    	//lo와 hi를 각각 배열의 끝에서 1 벗어난 위치부터 시작
    	int lo= left-1;
    	int hi = right+1;
    	int pivot = a[(left+right)/2];//부분리스트의 중간요소
    	
    	while(true) {
    		
    		
    		do {
    			lo++;
    		}while(a[lo]<pivot);
    		
    		
    		do {
    			hi--;
    		}while(a[hi]>pivot&&lo<=hi);
    		
    		
    		if(lo>=hi) {
    			return hi;
    		}
    		
    		swap(a, lo, hi);
    	}
    }
    
    
    
    private static void swap(int[] a, int i, int j) {
    	int tmp = a[i];
    	a[i]=a[j];
    	a[j]=tmp;
    }

}// class
