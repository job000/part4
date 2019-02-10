import java.util.Calendar;
import java.util.*;


public class Bicycle extends Vehicle implements Driveable{

	private int gears;
	private java.util.Calendar productionDate;

	public Bicycle(){

	}

	public Bicycle(String colour, String name, String serialNr, int model, int price,int gears, int direction){
		super(colour, name, serialNr, model, price, direction);
		this.gears = gears;

		productionDate = new GregorianCalendar();
	}

	@Override
	public void setAllFields(){ super.setAllFields(); }

		public void turnRight(int degrees){
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

	public void setGears(int gears){ this.gears = gears; }

	public int getGears(){ return gears; }

	public java.util.Calendar getProductionDate(){ return productionDate; }

	public void setProductionDate(java.util.Calendar productionDate){
		
		this.productionDate = productionDate;
	}


	@Override 
	public String toString(){
	return String.format(super.toString() + "\nGears: "+getGears() + String.format("\nProduction date: %tF ", getProductionDate())+"\n");
 }


 public void accelerate(int factor){
 		double tempValue = 0.0;
 	
 		if (getSpeed()<= 0) {

 			setSpeed(0.3* factor);
 			
 		}else if(getSpeed()>0 && getSpeed()<= MAX_SPEED_CAR ){

 			tempValue = getSpeed() * 0.5;
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
 		if (getSpeed()>0 && getSpeed()<= MAX_SPEED_CAR) {
 			setSpeed(getSpeed() / (factor*0.5));
 		}else{
 			System.out.println("Not defined speed.");
 		}
 		
 	}
}