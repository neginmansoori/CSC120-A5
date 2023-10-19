import java.util.ArrayList;
import javax.management.RuntimeErrorException;

public class Car {
    private ArrayList<Passenger> passengers_onboard;
    private int max_capacity;
    public int order_number;
    
    // constructor
    public Car(int max_capacity, int order_number){
        this.max_capacity = max_capacity;
        this.passengers_onboard = new ArrayList<Passenger>();
        this.order_number = order_number;
    }
 /** checks the seats available in the car
 * @param car
 * @return int: # of seats available
 */
    public int seatsRemaining(){
        int capacity = this.max_capacity - this.passengers_onboard.size();
        System.out.println("the vacancy is " + capacity + "seats.");
        return capacity;
    }
/**
 * checks the maximum capacity of car
 * @param car
 * @return int: max car capacity
 */
    public int getCapacity(){
        System.out.println(this.max_capacity);
        return this.max_capacity;
    }
/**
 * adds passenger to the arraylist of passengers on borad
 * @param passenger
 * @return void
 */
    public void addPassenger(Passenger passenger){
         if (this.passengers_onboard.contains(passenger)){
            throw new RuntimeException(passenger.name+ " is already on the car.");
        }
         if (this.seatsRemaining() == 0){
            throw new RuntimeErrorException(null, "This car is already full");
         }
        this.passengers_onboard.add(passenger);
    }
/**
 * removes passenger from arraylist of passengers on board
 * @param passenger
 * @return void
 */
    public void removePassenger(Passenger passenger){
        if (!this.passengers_onboard.contains(passenger)){
            throw new RuntimeException(passenger.name+ " is not on the car.");
    }
    this.passengers_onboard.remove(passenger);
    }
/**
 * prints the arraylist of passengers on board
 * @param Arraylist<Passenger>
 * @return arraylist
 */
    public ArrayList<Passenger> printManifest(){
        if (this.passengers_onboard.isEmpty()){
           System.out.println("This car is empty");
         }
        return this.passengers_onboard;
    }
}