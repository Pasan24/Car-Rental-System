public class Main {
    public static void main(String[] args) {

        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001", "Toyota", "Corolla", 3000.0);
        Car car2 = new Car("C002", "Honda", "Civic", 4000.0);
        Car car3 = new Car("C003", "Alto", "Celario", 3500.0);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    
    }
}