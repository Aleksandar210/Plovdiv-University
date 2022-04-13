public class Dwarf implements IObserver {
    Board board;
    private String name;

    private String toyTypeToMake;
    private String[] toyTypeDetails;

    private Toy createdToy;

    private Workshop currentWorkshop;

    public Dwarf(Board currentBoardAssignedTo,String dwarfName, Workshop workshop){
        this.board = currentBoardAssignedTo;
        this.setName(dwarfName);
        this.currentWorkshop = new Workshop();
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

        createdToy = currentWorkshop.createToy(this.getName(),this.toyTypeToMake,this.toyTypeDetails);

        System.out.println(createdToy);
    }
}
