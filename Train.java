import java.util.ArrayList;

public class Train {
    /**
    * A final instance of the Engine class
    */
    private final Engine engine;
    /**
    * An arraylist of the cars the train consists of
    */
    private ArrayList<Car> cars;

    // constructor
    public Train(FuelType fuel, double max_fuel_level, int nCars, int passenger_capacity){
        this.engine = new Engine (fuel, max_fuel_level);
        this.cars = new ArrayList<Car> (nCars);
        for (int i=0; i<nCars; i++){
            Car car = new Car(passenger_capacity);
            this.cars.add(car);
        }
    }
    /**
    * Engine accessor
    * @return the instance of the engine
    */
    public Engine getEngine(){
        return this.engine;
    }
    /**
    * Accessor for the i-th car in the Train
    * @return car number i in the train's cars list
    */
    public Car getCar(int i){
        return this.cars.get(i);
    }
    /**
    * prints train's max capacity
    * @return int max capacity
    */
    public int getMaxCapacity(){
        int max_capacity = 0;
        for (int i=0 ; i< cars.size(); i++ ){
            max_capacity += cars.get(i).getCapacity();
        }
        return max_capacity;
    }
    /**
    * prints the number of vacant seats on train
    * @return int: number of vacant seats
    */
    public int seatsRemaining(){
        int remainingSeats = 0;
        for (int i=0 ; i< cars.size(); i++ ){
            remainingSeats += cars.get(i).seatsRemaining();
         }
        return remainingSeats;
    }
    /**
    * prints the name of the passengers with the number of the board they have boarded
    */
    public void printManifest(){
        for (int i=0 ; i< cars.size(); i++ ){
            System.out.println("Printing the manifest for car number " + (i+1) +":");
            cars.get(i).printManifest();
        }
    }
    
    public static void main(String[] args) {
    Train newTrain = new Train(FuelType.OTHER, 100, 2, 80);
    System.out.println("Here are the properties of the engine of this train: " + newTrain.getEngine());
    System.out.println("Here is the train capcity: " + newTrain.getMaxCapacity());
    Passenger negin = new Passenger("Negin");
    negin.boardCar(newTrain.getCar(1));
    newTrain.printManifest();
    }
}

