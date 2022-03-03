package ro.ase.cts.g1099.lab1.exceptions;
//doar a pus extends Exception si boom a iesit exceptia
public class InsufficientFundsException extends Exception{
	
 public InsufficientFundsException(String msg){
	 super(msg);//the constructor will intialise the message
	 
 }
 public InsufficientFundsException() {
	 //super(); the compiler has this
 }
}
