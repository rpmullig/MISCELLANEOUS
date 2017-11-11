import java.io.*;

public class vendor_machine{
	private double paid;
	
	
	public vendor_machine() { this.paid = 0.0; }
		
	public float paid() {return (float) this.paid; }
	
	public void pay(double a) { this.paid += a; }
	
	public void refund() {
		
		if(this.paid <= 0 ) {System.out.println("No money to return"); this.paid = 0; }
		else {
		System.out.println("Please take your change of " + this.paid + "\n");
		this.paid = 0;
		}	
		}
	
	public void buy(String s) { if(this.paid >= 1.00) {this.paid -= 1.00; System.out.println("You bought " + s); } else {} }
	
	public boolean enough() {if(this.paid >= 1.00) {return true;} else{return false;} } 


	private int[] sodas = new int[6];
    

	
		}







