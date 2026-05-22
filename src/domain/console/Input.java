package domain.console;
import java.util.Scanner;

public abstract class Input {

    private static final Scanner scanner = new Scanner(System.in);

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
                System.out.print("Hour pricing: ");
                int hours = Integer.parseInt(scanner.nextLine());

                return hours;
            } catch(IllegalArgumentException e) {
                System.out.println("Invalid value! Try again.");
            }
        }
    }

}
