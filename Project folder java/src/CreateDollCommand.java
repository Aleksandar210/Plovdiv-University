public class CreateDollCommand implements ISantaToyCommand {
    private Board board;

    private String hairColor;
    private String dollHeight;
    private String dollWidth;


    public CreateDollCommand(Board currentBoard){
        this.board = currentBoard;
    }


    @Override
    public void execute() {
        this.board.setToyToMake("doll", hairColor, dollHeight, dollWidth);
    }

    @Override
    public void setToyDetails(String... details) {
        this.hairColor = details[0];
        this.dollHeight = details[1];
        this.dollWidth = details[2];
    }
}
