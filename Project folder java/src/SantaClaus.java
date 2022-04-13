import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SantaClaus {

    private ArrayList<String> commands;

    //commands Santa claus will give
    ISantaToyCommand dollCommand;
    ISantaToyCommand bikeCommand;

    //method to read commands from file
    public void readCommandsFromFile(String fileLocation){

        try (Stream<String> lines = Files.lines(Paths.get(fileLocation))) {
            this.commands = (ArrayList<String>) lines.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //set command properties for toy
    public void executeCommandsFromSanta(){
        for(String command : commands){

            String[] commandParts = command.split("::");

            String commandType = commandParts[0];
            String toyType = commandParts[1];

            if (commandType.equalsIgnoreCase("create")){

                if(toyType.equalsIgnoreCase(("doll"))){
                    // prepare toy Details
                    this.dollCommand.setToyDetails();
                    this.dollCommand.execute();

                }else if(toyType.equalsIgnoreCase("bike")){
                    //prepare bike commands
                    this.bikeCommand.setToyDetails();
                    this.bikeCommand.execute();
                }

            }
        }
    }

    private int getCommandCount(){
        return this.commands.size();
    }
}
