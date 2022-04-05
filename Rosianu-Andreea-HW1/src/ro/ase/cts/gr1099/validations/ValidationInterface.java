package ro.ase.cts.gr1099.validations;

import ro.ase.cts.gr1099.exceptions.InvalidLoanValueException;
import ro.ase.cts.gr1099.exceptions.InvalidRateException;

public interface ValidationInterface {
	public boolean validateLoanValue(double loanValue) throws InvalidLoanValueException;

	public boolean validateRate(double rate) throws InvalidRateException;
}
