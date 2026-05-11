package user;
import domain.Menus;
import java.util.Scanner;

public class Store {

    private Scanner s = new Scanner(System.in);
    private static Menus menus = new Menus();
    private static int choice;

    public static void main(String[] args) {

        boolean isRunning = true;
        
        do{
            menus.userMenu();

            switch(choice){

                case 1 : 
                    menus.adminMenu();
                    break;
                case 2 :
                    menus.mainMenu();
                    break;
                case 3 :
                    isRunning = false;
            }

        } while(isRunning);
    }

    private static void adminChoice() {

        int choice = 0;

        switch(choice){

            case 1 :
                
                break;
            case 2 :
                break;
            case 3 :
                break;
        } 
    }
}
