import java.util.ArrayList;
import javax.management.RuntimeErrorException;

public class Car {

    /**
     * ARRAYLIST<Passenger>: the arralist of Passengers on a given car
     */
    private ArrayList<Passenger> passengers_onboard;
    /**
     * int max-_capacity: max capacity of the car
     */
    private int max_capacity;
    
    // constructor
    public Car(int max_capacity){
        this.max_capacity = max_capacity;
        this.passengers_onboard = new ArrayList<Passenger>(max_capacity);
    }
    
    /** checks the seats available in the car
    * @return int: # of seats available
    */
    public int seatsRemaining(){
        int capacity = this.max_capacity - this.passengers_onboard.size();
        System.out.println("the vacancy is " + capacity + "seats.");
        return capacity;
    }

    /**
    * checks the maximum capacity of car
    * @return int: max car capacity
    */
    public int getCapacity(){
        System.out.println(this.max_capacity);
        return this.max_capacity;
    }

    /**
    * adds passenger to the arraylist of passengers on borad
    * @param passenger
    */
    public void addPassenger(Passenger passenger){
         if (this.passengers_onboard.contains(passenger)){
            throw new RuntimeException(passenger.getName()+ " is already on the car.");
        }
         if (this.seatsRemaining() == 0){
            throw new RuntimeErrorException(null, "This car is already full");
         }
        this.passengers_onboard.add(passenger);
    }

    /**
    * removes passenger from arraylist of passengers on board
    * @param passenger
    */
    public void removePassenger(Passenger passenger){
        if (!this.passengers_onboard.contains(passenger)){
            throw new RuntimeException(passenger.getName()+ " is not on the car.");
    }
        this.passengers_onboard.remove(passenger);
    }

    /**
    * prints the arraylist of passengers on board
    */
    public void printManifest(){
        if (this.passengers_onboard.isEmpty()){
           System.out.println("This car is empty");
         }

        else{
            for (Passenger p: this.passengers_onboard){ //for p in the arraylist
                System.out.println("- " + p.getName());
            }
         }
    }

    public static void main(String[] args) {
        Passenger negin = new Passenger("Negin");
        Car testCar = new Car(2);
        testCar.addPassenger(negin);
        testCar.printManifest();
    }
}