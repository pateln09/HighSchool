import java.math.BigInteger;
import java.util.*;

public class CountPrimes {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter an integer: ");
		int n = scan.nextInt();
		
		
		int numPrime = 0; 
		for (int i = 0; i < n; i ++) {
			BigInteger big = new BigInteger(String.valueOf(i));
			if (big.isProbablePrime(99)) {
				numPrime++;
			}
		}
		
		System.out.println(numPrime);
		scan.close();
	}

}
