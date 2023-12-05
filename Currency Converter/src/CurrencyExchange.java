import java.util.Scanner;

public class CurrencyExchange {

	public static void main(String[] args) {
		Scanner sc = new   Scanner(System.in);
		System.out.println("Choose one from the following options");
		System.out.println("1) USD TO NGN");
		System.out.println("2) NGN TO USD");
		int exchange = sc.nextInt();
		switch (exchange) {
		case 1: {
			System.out.println("Enter the amount of usd");
			
			double usd = sc.nextDouble();
			
			if (usd>=0); {
				System.out.println(usd + "USD is" + usd*1000 + "NGN");
			}
			
		}
		break;
		case 2: {
			System.out.println("Enter the amount of NGN");
			double ngn = sc.nextDouble();
			
			if (ngn>=0); {
				System.out.println(ngn + "NGN is" + "$" + ngn/1000);
			}
			 
		}
		break;
		}
		sc.close();
	}

}
