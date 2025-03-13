import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("=====Car Rental System =====");
            System.out.println();
            System.out.println("1. Rent a Car ");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println();
            System.out.println("Enter Your Choice");

            int choice = scanner.nextInt();
            scanner.nextLine(); // used to consume the newline character


            if (choice==1){
                System.out.println("\n== Rent a Car == \n");
                System.out.print(" Enter Your Name  : ");
                String customerName = scanner.nextLine();

                System.out.println("\nAvailable Cars : ");
                for (Car car : cars){
                    if(car.isAvailable()){
                        System.out.println(car.getCarID() +" - "+car.getBrand()+" - "+car.getModel());
                    }
                }

                System.out.println("\n Enter the car ID you want to rent ");
                String carID = scanner.nextLine();

                System.out.println("Enter the number of Days for rental");
                int rentalDays= scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer = new Customer("CUS"+(customers.size()+1),customerName);

                addCustomer(newCustomer);

                Car selectedCar= null;
                for(Car car : cars){
                    if(car.getCarID().equals(carID) && car.isAvailable()){
                        selectedCar = car;
                        break;
                    }

                }

                if (selectedCar!=null) {
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n== Rental Information ==  ");
                    System.out.println("Customer ID " + newCustomer.getCustomerID());
                    System.out.println("Customer Name " + newCustomer.getName());
                    System.out.println("Car " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("rental Days : " + rentalDays);
                    System.out.printf("Total Price :$%.2f%n", totalPrice);

                    System.out.println();
                    System.out.println("\n Confirm rental (Y/N)");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\n Car rented  Successfully ");
                    } else {
                        System.out.println("\n Rental Canceld");
                    }
                }
                else{
                        System.out.println("\n Invalid car selection or car not  available for rent ");
                    }
                }else if (choice==2) {
                System.out.println("\n == Return a car ==\n");
                System.out.println("Enter the car ID  you want to return ; ");
                String carId = scanner.nextLine();

                Car carToReturn = null;
                for (Car car : cars) {
                    if (car.getCarID().equals(carId) && !car.isAvailable()) {
                        carToReturn = car;
                        break;
                    }
                }


            if (carToReturn != null) {
                   Customer customer = null ;

                    for (Rental rental : rentals){
                        if (rental.getCar()== carToReturn){
                            customer =rental.getCustomer();
                            break;
                        }
                    }

                    if (customer!=null){
                        returnCar(carToReturn);
                        System.out.println("Car returned successfully by "+ customer.getName());
                    }else{
                        System.out.println("car was not rented or rental informations are missing");
                    }


                }else {
                System.out.println("Car was not rented");

            }


            }
            else if (choice==3){

                break;
            }else{
                System.out.println("Invalid choice. Please enter valid number");
            }
        }

        System.out.println("\n Thank you for using the car rental system ! ");
    }

}
