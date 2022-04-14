import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //first we create the factory
        Workshop workshop = new Workshop();

       Scanner scan = new Scanner(System.in);

       System.out.print("Enter file location/path: ");
       String fileLocation = scan.nextLine();

       Board magicBoard= new Board();
       Dwarf firstDwarfObject = new Dwarf(magicBoard,"Alexander", workshop);
       Dwarf secondDwarfObject = new Dwarf(magicBoard,"Daniel", workshop);

       magicBoard.assignDwarfToBoard(firstDwarfObject);
       magicBoard.assignDwarfToBoard(secondDwarfObject);

       SantaClaus santa = new SantaClaus(magicBoard);
       santa.readCommandsFromFile(fileLocation);
       try{
           santa.executeCommandsFromSanta();
       }catch(Exception e){
           System.out.println("End of program.");
       }





    }
}
