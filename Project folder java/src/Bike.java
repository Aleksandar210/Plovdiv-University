import java.util.Date;

public class Bike extends Toy {

    private String bikeColor;
    private int numberWheels;
    private int speedCounter;
    private String bikeCategory;


    public Bike(String createdBy, Date currentDateOfCreation, String... toyDetails) {
        super(createdBy, currentDateOfCreation, null);

        this.setBikeColor(toyDetails[0]);
        this.setNumberWheels(toyDetails[1]);
        this.setSpeedCount(toyDetails[2]);
    }

    private void setBikeColor(String bikeColor){
        this.bikeColor = bikeColor;
    }

    private String getBikeColor(){
        return this.bikeColor;
    }

    private void setNumberWheels(String numberWheels){
        this.numberWheels = Integer.parseInt(numberWheels);
    }

    private int getNumberWheels(){
        return this.numberWheels;
    }

    private void setSpeedCount(String speedCount){
        this.speedCounter = Integer.parseInt(speedCount);
    }

    private int getSpeedCounter(){
        return this.speedCounter;
    }

    private void setBikeCategory(String bikeCategory){
        this.bikeCategory = bikeCategory;
    }

    private String getBikeCategory(){
        return this.bikeCategory;
    }


    @Override
    public String toString() {
        String currentToy = String.format("A %s %s bike with %d and %d modes",
                                            this.getBikeColor().toUpperCase(),
                                            this.getBikeColor(),
                                            this.getNumberWheels(),
                                            this.getSpeedCounter());

        String createdByContent = super.toString();

        return currentToy + System.lineSeparator() + createdByContent;
    }
}
