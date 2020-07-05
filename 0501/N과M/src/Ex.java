import java.util.Scanner;

public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = null;
		int n, m;
		Scanner s = new Scanner(System.in);
		
		System.out.print("N 입력: ");
		n = s.nextInt();
		System.out.print("M 입력: ");
		m = s.nextInt();

		if(nmCheck(n,m))
			arr = new int[n];
		else
			return;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		permutation(arr, 0, n, m);
		
	}

	static void permutation(int arr[], int depth, int n, int r) {
		if(depth == r) {
			print(arr, r);
			return ;
		}
		
		for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
	}
	
	static void swap(int arr[], int depth, int i) {
		int temp;
		temp=arr[depth];
		arr[depth] = arr[i];
		arr[i]= temp;
	}
	static void print(int []arr, int r) {
		for(int i=0; i<r; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	static boolean nmCheck(int n, int m) {
		if ((1 <= n && n <= 8) && (m <= n)) {
			return true;
		} else {
			System.out.println("n,m 입력 범위 에러");
			return false;
		}
	}
}
