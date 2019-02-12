
public abstract class Vehicle implements Comparable<Vehicle>, Cloneable, Driveable, Fileable{

	private String colour, name, serialNr;
	private int model, price, direction;
	private double speed;
	protected java.util.Scanner input;
	private java.util.Calendar buyingDate;

	protected Vehicle(){}

	protected Vehicle(String colour, String name, String serialNr, int model, int price, int direction){

		this.name = name;
		this.serialNr = serialNr;
		this.model = model;
		this.price = price;
		this.direction = direction;
		this.colour = colour;

		this.buyingDate = new java.util.GregorianCalendar();
		this.speed = 0.0;
	}

	public void setAllFields(){

		input = new java.util.Scanner(System.in);

		System.out.println("Name: ");
		this.name = input.nextLine();

		System.out.println("Colour: ");
		this.colour = input.nextLine();


		System.out.println("Serial Number: ");
		this.serialNr = input.nextLine();

		System.out.println("Year Model: ");
		this.model = input.nextInt();

		System.out.println("Price: ");
		this.price = input.nextInt();

		this.speed = 0.0;
		this.direction = 0;
	}

	public abstract void turnLeft(int degrees);

	public abstract void turnRight(int degrees);

	public String getColour(){ return colour; }

	public String getName(){ return name; }

	public String getSerialNr(){ return serialNr; }

	public int getModel(){ return model; }

	public int getPrice(){ return price; }

	public int getDirection(){ return direction; }

	public double getSpeed(){ return speed; }

	public void setColour(String colour){ this.colour = colour; }

	public void setName(String name){ this.name = name; }

	public void setSerialNr(String serialNr){ this.serialNr = serialNr; }

	public void setModel(int model){ this.model = model; }

	public void setPrice(int price){ this.price = price; }

	public void setDirection(int direction){ this.direction = direction; }

	public void setSpeed(double speed){ this.speed = speed; }

	public String toString(){
		return "\nName: "+getName()+
		", Colour: "+getColour() + ", Price: "+getPrice()+
		", Model: "+getModel()+ ", Serial #: "+getSerialNr();
	}

	@Override
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}

	public void setBuyingDate(java.util.Calendar buyingDate){
		this.buyingDate = buyingDate;
	}

	public java.util.Calendar getBuyingDate(){
		return buyingDate;
	}

	@Override
	public int compareTo(Vehicle vehicle){
		return vehicle.getPrice();
	}

	public void stop(){
		this.speed = 0;
		System.out.println("Vehicle stops... ");
	}

	
	public void writeData(java.io.PrintWriter out){

		out.println(getName());
		out.println(getColour());
		out.println(getSerialNr());
		out.println(getModel());
		out.println(getPrice());
		out.println(getSpeed());
		
	}

	public void readData(java.util.Scanner in){

		try{
			java.io.File file = new java.io.File("testfile.txt");
			in = new java.util.Scanner(file);
		}catch(java.io.FileNotFoundException ex){
			ex.printStackTrace();
		}finally{
			in.close();
		}
	}
}


