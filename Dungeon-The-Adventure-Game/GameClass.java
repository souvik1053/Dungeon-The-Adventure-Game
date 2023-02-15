import java.util.*;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    //system objects
    Scanner in = new Scanner(System.in);

    Random R = new Random();

    //game variables
    String [] enemies = {"Skeleton", "Zombie", "Warrior", "Assasian"};
    int maxEnemyHealth = 70;
    int enemyAttackDamage = 30;

    //player variable
    int health = 100;
    int attackdamage = 25;
    int numHealthPotions = 4;
    int healthPotionHealAmount = 30;
    int healthPotionDropChance = 50; // percentage

    boolean running = true;;
    System.out.println("WELCOME TO THE DUNGEON");

    GAME:
      while(running){
        System.out.println("************************************");

        int enemyHealth = R.nextInt(maxEnemyHealth);
        String enemy  = enemies[R.nextInt(enemies.length)];
        System.out.print("\t<< " + enemy + " has appeared !  >>\n");

        while(enemyHealth > 0){
          System.out.println("\tYour HP: " + health);
          System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
          System.out.println("\n\tWhat would you like to do with your enemy?");
          System.out.println("\t1. Attack");
          System.out.println("\t2. Drink health potion");
          System.out.println("\t3. Run!!");

          String input = in.nextLine();
          if(input.equals("1")){
            int damageDealt = R.nextInt(attackdamage);
            int damageTaken = R.nextInt(enemyAttackDamage);

            enemyHealth -= damageDealt;
            health -= damageTaken;

            System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage. ");
            System.out.println("\t> You receive " + damageTaken + " in retaliation: ");

            if(health < 1){
              System.out.println("\t> You have taken too much damage, you are too weak to play the game!");
              break;
              
            }
            
          }
          else if(input.equals("2")){
            if(numHealthPotions > 0){
              health += healthPotionHealAmount;
              numHealthPotions--;
              System.out.println("\t> You have healed yourself " + healthPotionHealAmount + "\n\t You have " + health + " amount of HP. " + "\n\t > You have " + numHealthPotions + " health potions left. \n");
            }else{
              System.out.println("\t> You have no health potions left!! Defeat your enemies for a chance to get one!");
            }
          }else if(input.equals("3")){
            System.out.println("\tYou run away from the " + enemy + "!");
            continue GAME;
            
          }else{
            System.out.println("\tInvalid command");
            
          }
        }
        if(health < 1){
          System.out.println("You're too weak to play the battle!!");
          break;
          
        }
        System.out.println("*****************************************************************************");
        System.out.println(" # " + enemy + " was defeated!  # ");
        System.out.println(" # You have " + health + " HP left. # ");

        if(R.nextInt(100) < healthPotionDropChance){
          numHealthPotions++;
          System.out.println(" # The " + enemy + " dropped a health potion! # ");
          System.out.println(" # You have " + numHealthPotions + " health potions # ");
          
        }
        
        System.out.println("*****************************************************************************");
        System.out.println(" What would you like to do now? ");
        System.out.println("1. Continue fighting? ");
        System.out.println("2. Exit game ");
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")){
          System.out.println("Invalid command!");
          input = in.nextLine();
          
        }
        if(input.equals("1")){
          System.out.println("You can continue on your adventure!");
        
        }else if(input.equals("2")){
          System.out.println("You have successfully exited the game!");
          break;
          
        
        }
      }
        System.out.println("THANKS FOR PLAYING THIS GAME");
        
  }
}