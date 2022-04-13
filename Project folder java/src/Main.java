import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
       Scanner scan = new Scanner(System.in);

       System.out.print("Enter file location/path: ");
       String fileLocation = scan.nextLine();

       SantaClaus santa = new SantaClaus();
       santa.readCommandsFromFile(fileLocation);
       santa.executeCommandsFromSanta();



    }
}
