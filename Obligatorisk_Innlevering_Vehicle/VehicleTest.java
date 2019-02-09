import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;


public class VehicleTest {

  public static void main(String[] args) {

	  VehicleTest vtest = new VehicleTest();
    try {
      vtest.menuLoop();
    } catch(IOException e) {
      System.out.println("IO Exception!");
      System.exit(1);
    } catch(CloneNotSupportedException e) {
      System.out.println("CloneNotSupportedException");
      System.exit(1);
    }
  }

  private void menuLoop() throws IOException, CloneNotSupportedException {
    Scanner scan = new Scanner(System.in);
    ArrayList<Vehicle> arr = new ArrayList<Vehicle>();
    Vehicle vehicle;
    Vehicle bicycle;
     

    //Cars
    arr.add(new Car("Black","Volvo","1010-11",2010,85000,390,0));
    arr.add(new Car("red","Ferrari Testarossa","A112",1996,1200000,350,0));
    vehicle = new Car();
    Car car = new Car();
    
    //Bicycle
    bicycle = new Bicycle();
    Bicycle cycle = new Bicycle();

    arr.add(new Bicycle("yellow","Diamant","BC100",1993,4000,10,0));
    arr.add(new Bicycle("pink","DBS","42",1994,5000,10,0));

    while(true) {
      System.out.println("1...................................New car");
      System.out.println("2...............................New bicycle");
      System.out.println("3......................Find vehicle by name");
      System.out.println("4..............Show data about all vehicles");
      System.out.println("5.......Change direction of a given vehicle");
      System.out.println("6.........................Test clone method");
      System.out.println("7..................Test driveable interface");
      System.out.println("8..............................Exit program");
      System.out.printf(".............................Your choice? ");
      int choice = scan.nextInt();
      System.out.println();
    

      switch (choice) {
      case 1:
        //legg til en ny bil

      vehicle.setAllFields();
      System.out.println("Power: ");
      int power = scan.nextInt();
      car.setPower(power);

      arr.add(new Car(vehicle.getColour(),vehicle.getName(),vehicle.getSerialNr(),vehicle.getModel(),vehicle.getPrice(),car.getPower(),vehicle.getDirection()));

        break;
      case 2:
        //legg til en ny sykkel
      bicycle.setAllFields();
      System.out.println("Gears: ");
      int gears = scan.nextInt();
      car.setPower(gears);

      arr.add(new Bicycle(bicycle.getColour(),bicycle.getName(),bicycle.getSerialNr(),bicycle.getModel(),bicycle.getPrice(),cycle.getGears(),bicycle.getDirection()));

        break;
      case 3:
        //vis info om gitt kjøretøy
        Scanner scIn = new Scanner(System.in);
        System.out.printf("Name of vehicle: ");
        String searching = scIn.nextLine();

        //Temporary variables: 
        int counter = 0;
        String result="";

        for (int i = 0; i < arr.size() ; i++ ) {
          if (arr.get(i).getName().toUpperCase().contains(searching.toUpperCase()) ){
            result+=arr.get(i).toString();
            counter+=1; //Counts number of hit

          }else{
            continue;
          }

        }
        System.out.println("We found "+counter+" that contains '"+searching+"' in there name from our list.");
        System.out.println(result);


    
        break;

      case 4:
        //vis info om alle kjøretøy
        //vehicle = new Car();
        //for(int i=0; i< arr.size(); i++){
        //  System.out.println(arr.get(i));
        //}
      try{
        java.io.File file = new java.io.File("datafile.txt");
        java.util.Scanner in = new java.util.Scanner(file).useLocale(Locale.US);
        in.useDelimiter(",");
        String vehClass = in.next();
        Class veh1 = Class.forName(vehClass);
        Vehicle veh = (Vehicle)veh1.newInstance();
      }catch(ClassNotFoundException ex){
        System.out.println("Test 1");
      }catch(InstantiationException ex){
        System.out.println("Test 2");
      }catch(IllegalAccessException ex){
        System.out.println("Test 3");
      }

        break;
      
      case 5:
        // Finn kjøretøy med gitt navn, sett ny retning

        Scanner sc = new Scanner(System.in);
        System.out.println("Name of vehicle: ");
        String direction = "";
        String search = sc.nextLine();

        for (int i=0;i<arr.size() ;i++ ) {

          if (arr.get(i).getName().toUpperCase().equals(search.toUpperCase()) ){
            System.out.println("Vehicle registered name: "+ arr.get(i).getName());
            System.out.printf("Direction [L/R]: ");
            direction = sc.nextLine();
            
            if (direction.toUpperCase().contains("L")) {
              System.out.println("Turning Left.");
              System.out.printf("Enter degree: ");
              int deg = scan.nextInt();
              vehicle.turnLeft(deg);
            }else if (direction.toUpperCase().contains("R")) {
              System.out.println("Turning Right.");
              System.out.printf("Enter degree: ");
              int deg = scan.nextInt();
              vehicle.turnRight(deg);
            }
            
          }else{
            
          }
        }

        break;
      case 6:

      //Skriv test clone method her.
      java.util.Calendar cal = new GregorianCalendar(2018,2,10);
      Vehicle c = new Car("blue","Toyota","YE-1234",2010,1234567,350,0);
      arr.add(c);
      //Car vcopy = new Car();//Car();
      try{

        Car xcopy = (Car) c.clone();
        
        //Bruker compareTo for å vise prisen.
        //System.out.println(xcopy.compareTo(c));
        System.out.printf("%tF",xcopy.getBuyingDate());
        System.out.println();
        c.setBuyingDate(cal);
        System.out.println();
        System.out.printf("%tF",c.getBuyingDate());
        System.out.println();

        if(xcopy.getBuyingDate() != c.getBuyingDate()){
          System.out.println("Date objects are separate, deep copy.");
        }else{
          System.out.println("Date objects are not separate");
        }
        //System.out.println(xcopy.getBuyingDate().equals(c.getBuyingDate()));

        
        System.out.println();

      }catch(CloneNotSupportedException ex){
        System.err.println("Error Cloning...");
      }

      break;
      case 7:
      //Test driveable interface
      
      Vehicle car1 = new Car();
      Vehicle car2 = new Car();
      System.out.println("Car: ");
      //Car 1
      car1.setSpeed(0);
      car1.accelerate(10);
      System.out.println("Vehicle accelerated to: "+car1.getSpeed() +" km/h");
      
      //Car 2:
      car2.setSpeed(100);
      car2.accelerate(10);
      System.out.println("Vehicle accelerated to: "+car2.getSpeed() +" km/h");

      car2.breaks(1000);
      System.out.println("Vehicle slowed down to: "+car2.getSpeed()+" km/h");
      System.out.println();
      car1.stop();

      Vehicle b1 = new Bicycle();
      Vehicle b2 = new Bicycle();
      

      System.out.println("Bicycle");
      //Bicycle 1:
      b1.setSpeed(0);
      b1.accelerate(10);
      System.out.println("Vehicle accelerated to: "+b1.getSpeed() +" km/h");
      //Bicycle 2:
      b2.setSpeed(10);
      b2.accelerate(10);
      System.out.println("Vehicle accelerated to: "+b2.getSpeed() +" km/h");

      b1.breaks(30);
      System.out.println("Vehicle slowed down to: "+b1.getSpeed() +" km/h");
      b1.stop();
      
      
      break;
      case 8:
      	scan.close();
        System.exit(0);
      default:
        System.out.println("Wrong input!");
      }
    }
  }
}
