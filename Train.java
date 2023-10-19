import java.util.ArrayList;

public class Train {
    private final Engine engine;
    private ArrayList<Car> Cars;

    public Train(FuelType fuel, double max_fuel_level, double nCars, int max_capacity, int order_number){
        this.engine = new Engine (fuel, max_fuel_level);
        for (int i=0; i<nCars; i++){
            Car car = new Car(max_capacity, order_number);
            this.Cars.add(car);
        }
    }
/**
 * returns engine properties
 * @param train
 * @return engine details
 */
    public Engine getEngine(){
        return this.engine;
    }
/**
 * 
 * @param train
 * @return car number i in the train's cars list
 */
    public Car getCar(int i){
        return this.Cars.get(i);
    }
/**
 * prints train's max capacity
 * @param train
 * @return int: max capacity
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
 * @param train
 * @return int: number of vacant seats
 */
    public int trainSeatsRemaining(){
        int remainingSeats = 0;
        try{
            for (int i=0 ; i< Cars.size(); i++ ){
            remainingSeats += Cars.get(i).seatsRemaining();
         }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        return remainingSeats;
    }
//Q: if two methods with the same name but for different classes, can it distinguish between the classes?
/**
 * prints the arraylist of passengers on board on all cars combined
 * @param
 * @return arraylist
 */
    public void trainPrintManifest(){
        for (int i=0 ; i< Cars.size(); i++ ){
            Cars.get(i).printManifest();
        }
    }
}

