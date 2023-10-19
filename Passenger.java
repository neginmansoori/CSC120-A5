public class Passenger {
    
    String name;

    public Passenger(String name) {
        this.name = name;
    }
/**
 * adds passenger to car's passengers list
 * @param c
 * @return void
 */
    public void boardCar(Car c){
        try{
            c.addPassenger(this);
        }
        catch (RuntimeException e ){
            System.out.println("The car is full.");
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

}
