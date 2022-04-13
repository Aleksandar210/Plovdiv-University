import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SantaClaus {

    private ArrayList<String> commands;

    //commands Santa claus will give
    ISantaCommand dollCommand;
    ISantaCommand bikeCommand;

    //method to read commands from file
    public void readCommandsFromFile(String fileLocation){

        try (Stream<String> lines = Files.lines(Paths.get(fileLocation))) {
            this.commands = (ArrayList<String>) lines.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void executeCommandsFromSanta(){
        for(String command : commands){

            String[] commandParts = command.split("::");

            String commandType = commandParts[0];
            String toyType = commandParts[1];

            if (commandType.equalsIgnoreCase("create")){

                if(toyType.equalsIgnoreCase(("doll"))){
                    this.dollCommand.execute();

                }else if(toyType.equalsIgnoreCase("bike")){
                    this.bikeCommand.execute();
                }

            }
        }
    }

    private int getCommandCount(){
        return this.commands.size();
    }
}
