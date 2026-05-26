package domain.console;
import java.util.Scanner;
import domain.console.Console;

public abstract class Input {

    private static final Scanner scanner = new Scanner(System.in);

    public static int choice(int size) {

        while(true){
            
            try{

                int choice = Integer.parseInt(scanner.nextLine());

                if(choice > size || choice < 1) {
                    throw new IllegalArgumentException();
                }

                return choice;

            } catch(IllegalArgumentException e) {
                System.out.println("Invalid value! Try again.");
                System.out.print(">: ");
            }
        }
    }

    public static String model() {

        while(true){
            
            try{

                System.out.print("Vehicle model: ");
                String model = scanner.nextLine();

                return model;

            } catch(IllegalArgumentException e) {
                System.out.println("Invalid value! Try again.");
            }
        }
    }

    public static String brand() {
        
        while(true){
            
            try{

                System.out.print("Vehicle brand: ");
                String brand = scanner.nextLine();

                return brand;

            } catch(IllegalArgumentException e) {
                System.out.println("Invalid value! Try again.");
            }
        }
    }

    public static float pricing() {

        while(true){
            
            try{
                
                System.out.print("Hour pricing: ");
                float pricing = Float.parseFloat(scanner.nextLine());

                return pricing;

            } catch(IllegalArgumentException e) {
                System.out.println("Invalid value! Try again.");
            }
        }
    }

    public static int hour() {

        while(true){
            
            try{

                System.out.print("Hours to be used: ");
                int hours = Integer.parseInt(scanner.nextLine());

                return hours;
                
            } catch(IllegalArgumentException e) {
                System.out.println("Invalid value! Try again.");
            }
        }
    }
}
