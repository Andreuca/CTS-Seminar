package ro.ase.cts.gr1099.main;

import ro.ase.cts.gr1099.exceptions.InvalidLoanValueException;
import ro.ase.cts.gr1099.exceptions.InvalidRateException;
import ro.ase.cts.gr1099.main.LoanAccount;
import ro.ase.cts.gr1099.main.LoanAccountType;

public class Main {

	public static void main(String[] args) {
		try {
			LoanAccount la = new LoanAccount(10, 10, LoanAccountType.BUDGET);
			System.out.println(la.toString());
			LoanAccount la2 = new LoanAccount(-1, 10, LoanAccountType.BUDGET);

		} catch (InvalidLoanValueException e) {
			e.printStackTrace();
		} catch (InvalidRateException e) {
			e.printStackTrace();
		}
	}
}
