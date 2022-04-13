import java.util.Date;

public class Workshop implements IWorkshop {
    private Toy toy;

    private Date getCurrentDate(){
        Date currentDate = new Date();
        return currentDate;
    }

    @Override
    public Toy createToy(String createdBy,String toyType, String... toyDetails) {
        if (toyType.equalsIgnoreCase("Doll")){
            toy = new Doll(createdBy,this.getCurrentDate(),toyDetails);
        }else if(toyType.equalsIgnoreCase("Bike")){
            toy = new Bike(createdBy,this.getCurrentDate(),toyDetails);
        }

        return toy;
    }
}
