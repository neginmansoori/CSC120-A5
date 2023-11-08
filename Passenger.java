public class Passenger {
    /**
    * String: passenger name
    */
    private String name;
    
    // constructor
    public Passenger(String name) {
        this.name = name;
    }
    /**
    * accessor for passenger name
    * @return string: passenger name
     */
    public String getName(){
        return this.name;
    }
    /**
    * adds passenger to car's passengers list
    * throws an exception if passenger is already on the car or if it is full
    * @param c
    */
    public void boardCar(Car c){
        try{
            c.addPassenger(this);
        }
        catch (RuntimeException e ){
            System.out.println(e);
        }
    }
    /**
    * removes passenger from car's passengers list
    * @param c
    * @return void
    */
    public void getOffCar (Car c){
        try{
            c.removePassenger(this);
        }
        catch(RuntimeException e){
            System.out.println(this.name+" isn't on this car.");
        }
    }

    
    public static void main(String[] args) {
        Passenger negin = new Passenger("Negin");
        System.out.println(negin);
    }

}
