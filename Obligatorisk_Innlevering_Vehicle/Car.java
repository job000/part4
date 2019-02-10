import java.util.Calendar;
import java.util.*;

public class Car extends Vehicle implements Driveable{
	
	private int power;
	private java.util.Calendar productionDate;

	//Empty Constructor
	public Car(){}

	public Car(String colour, String name, String serialNr, int model, int price,int power, int direction){
		super(colour, name, serialNr, model, price, direction);

		productionDate = new GregorianCalendar();
		java.util.Calendar cal = new GregorianCalendar(2018,10,10);
		setBuyingDate(cal);
		this.power = power;

		//this.speed = 0;
	}

	@Override
	public void setAllFields(){
		super.setAllFields();
	}

	public void turnRight(int degrees){
		if (degrees>=0 && degrees <=360) {
			degrees=degrees;
			System.out.println("Turning "+degrees+" degrees.");

		}else{

			//Converts negativ and positiv value that is 
			//less than 0 and more than 360 into between 0-360

			degrees = Math.abs(degrees);
			while(degrees > 360){
				degrees-=360;
			}
			System.out.println("Turning "+degrees+" degrees.");
		}
	}

	public void turnLeft(int degrees){
		if (degrees>=0 && degrees <=360) {
			degrees=degrees;
			System.out.println("Turning "+degrees+" degrees.");
		}else{
			
			degrees = Math.abs(degrees);
			while(degrees > 360){
				degrees-=360;
			}
			System.out.println("Turning "+degrees+" degrees.");
		}
	}

	public java.util.Calendar getProductionDate(){
		return this.productionDate;
	}

	public void setProductionDate(java.util.Calendar productionDate){
		this.productionDate = productionDate;
	}

	public int getPower(){
		return power;
	}

	public void setPower(int power){
		this.power = power;
	}

	@Override 
	public String toString(){
		return String.format(super.toString() + "\nPower: "+getPower() + String.format("\nProduction date: %tF ", getProductionDate())+"\n");
 	}

 	public void accelerate(int factor){
 		double tempValue = 0.0;
 	
 		if (getSpeed()<= 0) {

 			setSpeed(0.5* factor);
 			
 		}else if(getSpeed()>0 && getSpeed()<= MAX_SPEED_CAR ){

 			tempValue = getSpeed() * factor;
 			if (tempValue < MAX_SPEED_CAR) {
 				setSpeed(getSpeed() * factor);
 			}else{
 				setSpeed(MAX_SPEED_CAR);
 			}
 			
 		}else{
 			setSpeed(MAX_SPEED_CAR);
 			
 		}
 	}

 	public void breaks(int factor){

 		if (getSpeed()>=0 && getSpeed()<= MAX_SPEED_CAR) {
 			setSpeed(getSpeed() / factor);
 		}else{
 			System.out.println("Not defined speed.");
 		}
 		
 	}

 	@Override
 	public void writeData(java.io.PrintWriter out){
 		
 		try{

			java.io.File file = new java.io.File("datafile.txt");
			out = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(file)));
			out.printf("%s, %s",getPower(),String.format("\nProduction date: %tF ", getProductionDate()));

		}catch(java.io.FileNotFoundException ex){
			System.out.println(ex);
		}catch(java.io.IOException ex){
			ex.printStackTrace();
		}finally{
			out.close();
		}
 	
 	}
 	@Override
 	public void readData(Scanner in){

 		try{
 			in = new Scanner(new java.io.File("datafile.txt"));
 			while(in.hasNext()){
 				System.out.printf(in.next());
 			}
 		}catch(java.io.FileNotFoundException ex){
 			ex.printStackTrace();
 		}finally{
 			in.close();
 		}

 	}
}
