import java.util.ArrayList;

public class Train {
    /**
     * Attributes:
     * - A final instance of the Engine class
     * - An arraylist of the cars the train consists of
     */
    private final Engine engine;
    private ArrayList<Car> Cars;

    // constructor
    public Train(FuelType fuel, double max_fuel_level, int nCars, int passenger_capacity){
        this.engine = new Engine (fuel, max_fuel_level);
        this.Cars = new ArrayList<Car> (nCars);
        for (int i=0; i<nCars; i++){
            Car car = new Car(passenger_capacity); //results in double the capacity
            this.Cars.add(car);
        }
    }
/**
 * returns engine properties
 * @return the instance of the engine
 */
    public Engine getEngine(){
        return this.engine;
    }
/**
 * Returns the i-th car in the Train
 * @return car number i in the train's cars list
 */
    public Car getCar(int i){
        return this.Cars.get(i);
    }

    public static void main(String[] args) {
        Train newTrain = new Train(FuelType.OTHER, 100, 2, 80);
        System.out.println("Here are the properties of the engine of this train: " + newTrain.getEngine());
        System.out.println("Here is the train capcity: " + newTrain.getMaxCapacity());
    }
/**
 * prints train's max capacity
 * @return int max capacity
 */
    public int getMaxCapacity(){
        int max_capacity = 0;
        for (int i=0 ; i< Cars.size(); i++ ){
            max_capacity += Cars.get(i).getCapacity();
        }
        return max_capacity;
    }
/**
 * prints the number of vacant seats on train
 * @return int: number of vacant seats
 */
    public int seatsRemaining(){
        int remainingSeats = 0;
        try{
            for (int i=0 ; i< Cars.size(); i++ ){
            remainingSeats += Cars.get(i).seatsRemaining();
         }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        } //catching?

        return remainingSeats;
    }
//Q: if two methods with the same name but for different classes, can it distinguish between the classes?
/**
 * prints the arraylist of passengers on board on all cars combined
 * @return arraylist
 */
    public void printManifest(){
        for (int i=0 ; i< Cars.size(); i++ ){
            Cars.get(i).printManifest();
        }
    }
}

