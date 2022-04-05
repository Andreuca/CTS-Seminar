package ro.ase.cts.gr1099.main;

import ro.ase.cts.gr1099.exceptions.InvalidAccountVectorException;
import ro.ase.cts.gr1099.exceptions.InvalidLoanValueException;
import ro.ase.cts.gr1099.exceptions.InvalidRateException;
import ro.ase.cts.gr1099.main.LoanAccount;
import ro.ase.cts.gr1099.main.LoanAccountType;
import ro.ase.cts.gr1099.validations.ValidationInterface;

public class LoanAccount implements ValidationInterface{
	public double loanValue, rate;
	public int daysActive;
	public LoanAccountType loanAccountType;
	public static final int NO_DAYS_IN_YEAR = 365;
	public static final float BROKER_FEE = 0.0125f;

	public LoanAccount(double loanValue, double rate, LoanAccountType loanAccountType)
			throws InvalidLoanValueException, InvalidRateException {
		if (!validateLoanValue(loanValue)) {
			throw new InvalidLoanValueException("Loan value should be > 0");
		}
		if (!validateRate(rate)) {
			throw new InvalidRateException();
		}
		this.loanValue = loanValue;
		this.rate = rate;
		this.loanAccountType = loanAccountType;
	}

	public double getLoanValue() {
		return this.loanValue;
	}

	public void setLoanValue(double loanValue) throws Exception {
		if (!validateLoanValue(loanValue))
			throw new Exception();
		else {
			this.loanValue = loanValue;
		}
	}

	public void printLoadValue() {
		System.out.println("The loan value is " + this.loanValue);
	}

	public double getRate() {
		return this.rate;
	}

	public void printRate() {
		System.out.println("The rate is " + rate);
	}

	public double getMonthlyRate() {
		return loanValue * rate;
	}

	public int getDaysActive() {
		return daysActive;
	}

	public void setDaysActive(int daysActive) {
		this.daysActive = daysActive;
	}

	@Override
	public String toString() {
		return "LoanAccount{" + "loanValue=" + loanValue + ", rate=" + rate + ", daysActive=" + daysActive
				+ ", loanAccountType=" + loanAccountType + '}';
	}

	public void printAccount() {
		System.out.println("This is an account");
	}

	@Override
	public boolean validateLoanValue(double loanValue) throws InvalidLoanValueException {
		if (loanValue < 0) {
			throw new InvalidLoanValueException("Loan value should be > 0");
		}
		return true;
	}

	@Override
	public boolean validateRate(double rate) throws InvalidRateException {
		if (rate < 0) {
			throw new InvalidRateException();
		}
		return true;
	}

	public static double computeBrokerTotalFee(LoanAccount[] accounts) throws InvalidAccountVectorException {
		double brokerTotalFee = 0.0;
		LoanAccount account;

		for (int i = 0; i < accounts.length; i++) {
			account = accounts[i];
			if (account.loanAccountType == LoanAccountType.PREMIUM
					|| account.loanAccountType == LoanAccountType.SUPER_PREMIUM)
				brokerTotalFee += BROKER_FEE * computeMathFunction(account);

		}
		return brokerTotalFee;
	}

	public static double computeMathFunction(LoanAccount account) {
		double computedValue = 0.0;
		computedValue = account.loanValue * Math.pow(account.rate, (account.daysActive / NO_DAYS_IN_YEAR))
				- account.loanValue;
		return computedValue;
	}
}
