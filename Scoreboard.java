import java.util.Scanner;

public class Scoreboard {

   // Counts the User's total wins and losses
   private static int wins = 0;
   private static int losses = 0;

   public static void incrementWins() {

      wins++;

   }

   public static void incrementLosses() {

      losses++;

   }

   public static int getWins() {

      return wins;

   }

   public static int getLosses() {

      return losses;

   }

   public static void main(String[] args) {

      boolean check = true;
      Scanner scan = new Scanner(System.in);
      Game g = new Game();

      while (check) {

         // Asks the User if they would like to play
         System.out.println("Would you like to play Pokemon Saleem? Enter y or n.");
         String ans = scan.nextLine();
         System.out.println();

         // The user said yes
         if (ans.equals("y")) {

            // Plays the game
            g.game(scan);

            // Adds 1 to wins if the game's win state was true
            if (g.getWinState() == true) {

               incrementWins();

            }

            // Adds 1 to losses if the game's win state was false
            else {

               incrementLosses();

            }

            boolean examine = true;

            while (examine) {

               // Asks the User if they would like to see their score
               System.out.println();
               System.out.println("Would you like to see your score? Enter y or n.");

               String response = scan.nextLine();

               // The User said yes
               if (response.equals("y")) {

                  // Prints out the User's Win/Loss tallies
                  System.out.println(String.format("WINS: %s  LOSSES: %s", getWins(), getLosses()));

                  examine = false;

               }

               // The User said no
               else if (response.equals("n")) {

                  System.out.println("OK");

                  examine = false;

               }

               /// Invalid response
               else {

                  System.out.println("Invalid entry. Try again.");

               }

            }

         }

         // The User said no
         else if (ans.equals("n")) {

            System.out.println("OK, your loss.");
            check = false;

         }

         // Invalid response
         else {

            System.out.println("Invalid entry. Try again.");

         }

      }

      scan.close();

   }

}