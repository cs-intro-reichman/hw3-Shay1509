// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
		System.out.println(times(0,4));  // 3 * 4
 		System.out.println(times(3,4));  // 3 * 4
		System.out.println(times(3,0));  // 3 * 4
		System.out.println(times(3,15));  // 3 * 4
		System.out.println(times(3,-10));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
		System.out.println(div(0,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
		System.out.println(mod(100,9));   		
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int i = 0;

		if(x2 < 0){
			while(i < x2){
				x1--;
				i++;
			}
		}
		else{
			while(i < x2){
				x1++;
				i++;
			}
		}
		return x1;
	}


	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int i = 0;

		if(x2 < 0){
			while(i < x2){
				x1++;
				i++;
			}}
		else{
			while(i < x2){
				x1--;
				i++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int i = 0;
		int newNum = 0;

		if(x2 == 0 | x1 == 0){
			newNum = 0;
		}

		else if(x2 < 0 && x1 > 0){
			while(i < ((-1) * (x2))){
				newNum = plus(newNum, x1);
				i++;
		}	
			newNum = (-1) * newNum;
		}

		else if(x1 < 0 && x2 > 0){
			while(i < x2){
				newNum = minus(newNum, x1);
				i++;
		}	

		}

		else if(x1 > 0 && x2 > 0){
			while(i < x2){
				newNum = plus(newNum, x1) ;
				i++;
		}
		}
		return newNum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int i = 1;
		int newNum = x;

		if(n == 0){
			newNum = times(1, 1);
		}

		else{
			while(i < n){
			newNum = times(newNum, x);
			i++;
			}
		}
		return newNum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int i = 0;
		int count = 0;
		int newNum = x1;
		
		while(minus(newNum, x2) >= 0){
				newNum = minus(newNum, x2);
				count++;
			}
			i++;
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int num = div(x1, x2);
		int modulo = minus(x1, times(x2, num));
		return modulo;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i = 0;
		while(times(i, i) < x){
			i++;
		}
		if(times(i, i) > x){
			i--;
		}
		return i;
	}	  	  
}