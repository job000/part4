import java.util.Calendar;
import java.util.*;
import java.text.*;

public class Car extends Vehicle implements Driveable{
	
	private int power;
	private java.util.Calendar productionDate;

	//Empty Constructor
	public Car(){}

	public Car(String colour, String name, String serialNr, int model, int price,int power, int direction){

		super();
		super.setName(name);
		super.setColour(colour);
		super.setSerialNr(serialNr);
		super.setModel(model);
		super.setPrice(price);
		super.setDirection(direction);

		productionDate = new GregorianCalendar();
		
		this.power = power;
	}

	@Override
	public void setAllFields(){
		super.setAllFields();
	}

	public void turnRight(int degrees){

		if (degrees>=0 && degrees <=360) {
			//degrees=degrees;
			System.out.println("Turning "+degrees+" degrees.");
			super.setDirection(degrees);

		}else{
			//Converts negativ and positiv value that is 
			//less than 0 and more than 360 into between 0-360
			degrees = Math.abs(degrees);
			while(degrees > 360){
				degrees-=360;
			}
			System.out.println("Turning "+degrees+" degrees.");
			super.setDirection(degrees);
		}
	}

	public void turnLeft(int degrees){
		if (degrees>=0 && degrees <=360) {
			//degrees=degrees;
			System.out.println("Turning "+degrees+" degrees.");
			super.setDirection(degrees);
		}else{
			
			degrees = Math.abs(degrees);
			while(degrees > 360){
				degrees-=360;
			}
			System.out.println("Turning "+degrees+" degrees.");
			super.setDirection(degrees);
		}
	}

	public java.util.Calendar getProductionDate(){ return this.productionDate; }

	public void setProductionDate(java.util.Calendar productionDate){
		this.productionDate = productionDate;
	}

	public int getPower(){ return power; }

	public void setPower(int power){ this.power = power; }

	@Override 
	public String toString(){
		return String.format(super.toString() + ", Power: "+getPower() + String.format(", Production date: %tF ", getProductionDate())+"\n");
 	}

 	public void accelerate(int factor){
 		double tempValue = 0.0;
 	
 		if (super.getSpeed() == 0) {

 			super.setSpeed(0.5* factor);
 			
 		}else if(super.getSpeed() > 0 && super.getSpeed() <= MAX_SPEED_CAR ){

 			tempValue = super.getSpeed() * factor;
 			if (tempValue < MAX_SPEED_CAR) {
 				super.setSpeed(super.getSpeed() * factor);
 			}else{
 				super.setSpeed(MAX_SPEED_CAR);
 			}
 		}else{
 			super.setSpeed(MAX_SPEED_CAR);
 			
 		}
 	}

 	public void breaks(int factor){

 		if (super.getSpeed()>=0 && super.getSpeed()<= MAX_SPEED_CAR) {
 			super.setSpeed(super.getSpeed() / factor);
 		}else{
 			System.out.println("Not defined speed.");
 		}
 	}

 	@Override
 	public void writeData(java.io.PrintWriter out){

 		out.printf("%s,",getClass().getName());
		super.writeData(out);
		out.printf("%s,",getPower());
		out.printf("%s,",String.format("%tF",getProductionDate()));

 	}

 	@Override
 	public void readData(Scanner in){
 		super.readData(in);
 		Calendar cal = Calendar.getInstance();

 		setPower(Integer.parseInt(in.next()));
 		try{
			Date pd = new SimpleDateFormat("yyyy-MM-dd").parse(in.next());
			cal.setTime(pd);
			setProductionDate(cal);
		}catch(ParseException ex){
			ex.printStackTrace();
		}
 	}
}
