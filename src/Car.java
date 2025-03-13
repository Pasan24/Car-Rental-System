public class Car {

    private String carID;

    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;


    public Car(String carID, String brand, String model ,double basePricePerDay ){
    this.carID = carID;
    this.brand = brand ;
    this .model = model;
    this.basePricePerDay =basePricePerDay;
    this.isAvailable = true; //goal is to always set isAvailable to true, remove the unnecessary parameter:
}

    public String getCarID(){
        return carID;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public double calculatePrice( int rentalDays){
        return basePricePerDay * rentalDays ;
    }


    public boolean isAvailable(){
        return isAvailable ;
    }


    public void rent(){
         isAvailable= false ;
    }

    public void returnCar(){
        isAvailable= true ;
    }

}
