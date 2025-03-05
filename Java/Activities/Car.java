package activities;

public class Car {

	String color;
	String transmission;
	int make;
	int tyres=4;
	int doors=4;
	// initialise values for a variable we use Constructor
	
	//Constructor
	public Car(String color,String transmission ,int make ) { 
		this.color=color;
		this.transmission=transmission;
		this.make=make;
	}
	
	public void displayChataristics() {
	System.out.println("Color of the Car is: " + this.color);
	System.out.println("tranmission of the Car is: " + this.transmission);
	System.out.println("Car is made in the year: " + this.make);
	System.out.println("No of doors:" + this.doors );
	System.out.println("No of tyres:" + this.tyres);

	}
	public void accelerate() {
		System.out.println("Car moves forward");	
	}
	public void brake () {
		System.out.println("Car stops");
}
}
