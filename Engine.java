import java.util.Scanner;

public class Engine {
    private FuelType fuel;
    double fuel_level;
    double max_fuel_level;

    // constructor
    public Engine(FuelType fuel, double max_fuel_level){
        this.fuel = FuelType.ELECTRIC; //what to do?
        this.fuel_level = max_fuel_level;
        this.max_fuel_level = max_fuel_level;
    }

    // refuel
    public void refuel(double fuel_level, double max_fuel_level){
        this.fuel_level = this.max_fuel_level;
    }

    // going
    Scanner input = new Scanner (System.in);

    public void go(){
         // distance: fuel required to commute the distance
         System.out.println("Enter how much fuel you require to go: ");
         int distance = input.nextInt();
        
         //catch(RuntimeException e){
          //  System.out.println("Enter an integer");
            //int distance = input.nextInt();}
        
         this.fuel_level = this.fuel_level - distance;
         if (this.fuel_level <0){
            System.out.println("You don't have enough fuel to travel.");
            this.fuel_level = this.fuel_level + distance; //resetting fuel to previous value
         }

         else{
            System.out.println("You have" + this.fuel_level + " kg fuel left.");
         }
    }

        
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }
}