import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Toy {

    private String createdBy;
    private Date createdOn;
    private SimpleDateFormat formatter;

    public Toy(String createdBy,Date currentDateOfCreation, String...toyDetails){
        this.setCreatedBy(createdBy);
        this.setCreatedOn(currentDateOfCreation);
        this.formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    }

    private void setCreatedBy(String dwarfName){
        this.createdBy = dwarfName;
    }

    protected String getCreatedBy(){
        return this.createdBy;
    }

    private void setCreatedOn(Date currentDateOfCreation){
        this.createdOn = currentDateOfCreation;
    }

    protected String getCreatedOn(){
        return formatter.format(this.createdOn);
    }

    @Override
    public String toString() {
        return String.format("Created by %s on %s",this.getCreatedBy(), this.getCreatedOn());
    }
}
