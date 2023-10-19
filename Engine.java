public class Engine {
    private FuelType fuel;
    private double fuel_level; // how to set a restriction for value here?
    double max_fuel_level;

    // constructor
    public Engine(FuelType fuel, double max_fuel_level){
        this.fuel = fuel;
        this.fuel_level = max_fuel_level;
        this.max_fuel_level = max_fuel_level;
    }

/**
 * sets the current fuel level to the maximum
 * @param fuel_level
 * @param max_fuel_level
 */
    public void refuel(double fuel_level, double max_fuel_level){
        this.fuel_level = this.max_fuel_level;
    }

/**
 * asks how much feul is needed to travel, and reduces the amount from the fuel level if possible.
 * if not, returns an exception
 * @param int distance
 * @return void
 */
    public void go(int distance){
         this.fuel_level -= distance;
         if (this.fuel_level <0){
            System.out.println("You don't have enough fuel to travel."); // how to turn this into exception?
            this.fuel_level += distance; //resetting fuel to previous value
         }

         else{
            System.out.println("You have" + this.fuel_level + " kg fuel left.");
         }
    }

        
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go(120);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }
}