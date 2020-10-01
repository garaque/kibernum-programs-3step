package programs;

public class PivotHandler {
	
	
	public static void main(String args[]) {
		int a[] = {1,2,3,4,6,6,4};
		
		pivoteCalculate(a);
		
	}
	
	public static void pivoteCalculate(int a[]) {
		
		if (a.length > 3) {
		
			int pivot = pivotIndexCalc(a);
			
			if (pivot < 0) {
			 
				System.out.println("There is no pivot");
				
			} else {
				
			 System.out.println("The pivot is in the position: " + pivot + " the value is: " + a[pivot]);
			 
			}
		} else {
			System.out.println("It does not satisfy the restriction: the size of the input collection must be greater than 3");
		}
	}
	
	public static int  pivotIndexCalc(int a[]) {
		int pivote = -1;
		for (int i = 0; i <= a.length; i++) {
			int sD = sumAtRightOfTheIndex(i, a);
			int sI = sumAtLeftOfTheIndex(i, a);				
			if (sD == sI) {
				pivote = i;
			}
		}
		return pivote;
	}	

	
	public static int sumAtRightOfTheIndex(int index, int a[]) {
		int sum =0;
		for (int i = (index + 1); i < a.length; i++) {
			sum = sum + a[i];
		}
		return sum;
	}
	
	public static int sumAtLeftOfTheIndex(int index, int a[]) {
		int sum =0;
		for (int i = (index - 1); i >= 0; i--) {
			sum = sum + a[i];
		}
		return sum;
	}

}
