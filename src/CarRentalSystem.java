import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {

    private List<Car> cars ;

    private List<Customer> customers ;
    private List <Rental>   rentals ;


    public CarRentalSystem(){
         cars = new ArrayList<>();
         customers = new ArrayList<>();
         rentals = new ArrayList<>();
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCustomer (Customer customer){
        customers.add(customer);
    }

    public void rentCar(Car car , Customer customer , int days){
        if (car.isAvailable()){
            car.rent();
            rentals.add(new Rental( car , customer,days));
        }else{
            System.out.println("Car is not available for rent ");
        }
    }

    public void returnCar(Car car){

        car.returnCar();
        Rental rentalToRemove = null;
        for(Rental rental : rentals){  // this loop iterate over rental object of rentals list
            if(rental.getCar()==car){
                rentalToRemove =rental;
                break;
            }
        }

        if(rentalToRemove!= null){
            rentals.remove(rentalToRemove);
            System.out.println("Car returned Properly");
        }else{
            System.out.println("Car not returned Properly");
        }

    }

    public void menu(){

    }

}
