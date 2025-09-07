import java.util.Random;
import java.util.*;

public class Game {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        Random random = new Random();
        
        int[] choice = new int[] {0,1,2};
        int[] score = new int[2];
        
        List<String> userList = new ArrayList<>();
        List<String> computerList = new ArrayList<>();
       
        System.out.println();
        System.out.println();
        System.out.println("*********ROCK,PAPER & SCISSOR*********");
        
        System.out.println();
        System.out.println("Please pick as below!");
        
        System.out.println();
        System.out.println("For Rock --->  '0'");
        System.out.println("For Paper --->  '1'");
        System.out.println("For Scissor ---> '2'");
        System.out.println();
        System.out.println();

     while(true){

        System.out.println("1.Permission");
        System.out.println("2.History");
        System.out.println("3.Score of Computer");
        System.out.println("4.Score of User");
        System.out.println("5.Exit");

        System.out.println("Enter choice:");
        int option = scanner.nextInt();
        
        switch(option){
            
            case 1 : System.out.println("Do you want to play : (0/1)");
            
             int c = scanner.nextInt();
             
             if(c == 1){

             int randomIndex = random.nextInt(choice.length);
             int computer_choice = choice[randomIndex];

             System.out.println("Computer choice is taken!");
             System.out.println("enter user choice!");
             
             int user_choice = scanner.nextInt();

             if(!(user_choice >= 0 && user_choice <= 2)){

              System.out.println("User should enter valid choice!");

            }

         
             Permission(user_choice, computer_choice, userList, computerList, score);

             }

             break;

            case 2 : History(userList, computerList);
            break;

            case 3 : System.out.println();
            System.out.println("Score of User is " + score[0]);
            break;

            case 4 : System.out.println();
            System.out.println("Score of Computer is " + score[1]);
            break;

            case 5 :  scanner.close();
            return;

            default : System.out.println("Enter valid choice");

        }
      }
    }

  public static void Permission(int user_choice ,int computer_choice ,List<String> userList, List<String> computerList, int[] score){       
      
       if(user_choice == computer_choice){

        System.out.println("Draw!");

        userList.add("It's a draw");
        computerList.add("It's a draw");

       }

       else if(user_choice == 2 && computer_choice == 0){

        System.out.println("User Wins!");

        userList.add("User wins");
        computerList.add("Computer loss");
        score[0] += 1;

       }

       else if(user_choice == 0 && computer_choice == 2){

        System.out.println("Computer Wins!");

        userList.add("User loss");
        computerList.add("Computer wins");
        score[1] += 1;

       }

       else if(user_choice > computer_choice){

        System.out.println("User wins!");

        userList.add("User wins");
        computerList.add("Computer loss");
        score[0] += 1;
       
       }

      else if(user_choice < computer_choice){

        System.out.println("Computer Wins!");

        userList.add("User loss");
        computerList.add("Computer wins");
        score[1] += 1;
       
      }
      
      else{

        System.out.println("Enter a valid ehoice!");

        userList.add("User entered wrong option");
        computerList.add("Computer entered wrong option");

       }

    }

    public static void History(List<String> userList, List<String> computerList){
        
        System.out.println();
        System.out.println("User's History:");

        for(String history : userList){

            System.out.println(history);

        }
        
        System.out.println("computer's History:");

        for(String history : computerList){

            System.out.println(history);

        }
     }
}
