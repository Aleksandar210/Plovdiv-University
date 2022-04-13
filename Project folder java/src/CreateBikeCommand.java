public class CreateBikeCommand implements ISantaToyCommand {
    private Board board;

    private String bikeColor;
    private String numberWheels;
    private String speedCounter;


    public CreateBikeCommand(Board currentBoard){
        this.board = currentBoard;
    }
    @Override
    public void execute(){
        this.board.setToyToMake("bike",bikeColor,numberWheels,speedCounter);
    }

    @Override
    public void setToyDetails(String... details) {
            this.bikeColor = details[0];
            this.numberWheels = details[1];
            this.speedCounter = details[2];
    }

}
