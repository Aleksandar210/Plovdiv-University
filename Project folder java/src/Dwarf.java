public class Dwarf implements IObserver {
    Board board;
    private String name;

    private String toyTypeToMake;
    private String[] toyTypeDetails;

    public Dwarf(Board currentBoardAssignedTo,String dwarfName){
        this.board = currentBoardAssignedTo;
        this.setName(dwarfName);
    }

    public String getName(){
        return this.name;
    }

    private void setName(String dwarfName){
        this.name = name;
    }

    //the update method
    @Override
    public void getToyDetails() {
        this.toyTypeToMake = this.board.getToyType();
        this.toyTypeDetails = this.board.getToyDetails();

        //after we get the toy from the board we use the factory (Workshop) to make the toy
    }
}
