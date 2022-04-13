import java.util.HashMap;

public class Board implements IObservable {
    private String toyType;
    private String[] toyDetails;
    private HashMap<String,IObserver> currentDwarfsAssignedToBoard;

    public void setToyToMake(String toyType,String...toyDetails){
        this.setToyType(toyType);
        this.setToyDetails(toyDetails);
        notifyDwarfs();
    }

    public String getToyType(){
        return this.toyType;
    }

    private void setToyType(String toyType){
        this.toyType = toyType;
    }

    public String[] getToyDetails(){
        return this.toyDetails;
    }

    private void setToyDetails(String[] toyDetails){
        this.toyDetails = toyDetails;
    }

    @Override
    public void assignDwarfToBoard(IObserver dwarf) {
        this.currentDwarfsAssignedToBoard.put(dwarf.getName(),dwarf);
    }

    @Override
    public void releaseDwarfFromBoard(String dwarfName) {
        this.currentDwarfsAssignedToBoard.remove(dwarfName);
    }

    @Override
    public void notifyDwarfs() {
        currentDwarfsAssignedToBoard.forEach((k,v)-> v.getToyDetails());
    }

}
