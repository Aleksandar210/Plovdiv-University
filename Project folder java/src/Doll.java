import java.util.Date;

public class Doll extends Toy {

    private String hairColor;
    private double dollHeight;
    private double dollWidth;

    public Doll(String createdBy, Date currentDateOfCreation, String... toyDetails) {
        super(createdBy, currentDateOfCreation, null);
    }

    private void setHairColor(String hairColor){
        this.hairColor = hairColor;
    }

    private String getHairColor(){
        return this.hairColor;
    }

    private void setDollHeight(String dollHeight){
        this.dollHeight = Double.parseDouble(dollHeight);
    }

    private double getDollHeight(){
        return this.dollHeight;
    }

    private void setDollWidth(String dollWidth){
        this.dollWidth = Double.parseDouble(dollWidth);
    }

    private double getDollWidth(){
        return this.dollWidth;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
