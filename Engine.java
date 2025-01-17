public class Engine {

    /**
     * FuelType can be either of the following: STEAM, INTERNAL_COMBUSTION, ELECTRIC, OTHER
     */
    private FuelType fuel;
    /**
     * fuel_level is the remaining fuel level of the engine
     */
    private double fuel_level; // how to set a restriction for value here?
    /**
     * max_fuel_level is maximum fuel level of the engine
     * */
    private double max_fuel_level;

    // constructor
    public Engine(FuelType fuel, double max_fuel_level){
        this.fuel = fuel;
        this.fuel_level = max_fuel_level;
        this.max_fuel_level = max_fuel_level;
    }

    /**
     * sets the current fuel level to the maximum
     */
    public void refuel(){
        this.fuel_level = this.max_fuel_level;
    }

    /**
     * asks how much feul is needed to travel, and reduces the amount from the fuel level if possible.
     * if not, returns an exception
     * @param int distance
     */
    public void go(int distance){
         this.fuel_level -= distance;
         if (this.fuel_level <0){
            this.fuel_level += distance; //resetting fuel to previous value
            throw new RuntimeException("You don't have enough fuel to travel.");
         }

         else{
            System.out.println("You have" + this.fuel_level + " kg fuel left.");
         }
    }
        
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            if (true) {
                myEngine.go(120);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }
}