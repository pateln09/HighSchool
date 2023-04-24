import java.util.*;
import java.io.*;

public class Dawn {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("dawn.dat"));
		int noSets = scan.nextInt();
		System.out.println("     Amount                             Monthly        Total of");
		System.out.println("....Invested........APR......Years......Payment........Payments............Profit..");
		while (noSets-- > 0) {
			double price = scan.nextDouble();
			double rate1 = scan.nextDouble();
			double rate = rate1/12/100;
			int year = scan.nextInt();
			double mPay = price*rate/(1-Math.pow(1+rate, -year*12));
			double total = mPay*year*12;
			double profit = total-price;
			System.out.printf("$%,12.2f  |%9.3f%%  |%5d  |  $%,9.2f  |%,12.2f  |  $%,12.2f\n",
				price,rate1,year,mPay,total,profit	);
			
			

		}

	}
}