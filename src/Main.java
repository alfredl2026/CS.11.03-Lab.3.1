import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args){
        println("What is your name?");
        String scanned;
        Scanner scanLine = new Scanner(System.in);
        scanned = scanLine.next();
        println("Welcome, " + scanned + ", to the world of Pokemon. You can call me Professor X.");
        println("You can now choose a starter pokemon, which will be battling with you along your journey.");
        int starterPokemon;
        println("1: Torchic" + " 2: Squirtle" + " 3: Bulbasaur");
        println("Please enter a number (1/2/3)");
        starterPokemon = scanLine.nextInt();
        String pokemon1 = "";
        String type = "";
        int healPot = 1;
        int pokeBall = 0;
        if(starterPokemon == 1){
            println("You selected Torchic. (Fire)");
            type = "Fire";
            pokemon1 = "Torchic";
        }
        if(starterPokemon == 2){
            println("You selected Squirtle. (Water)");
            type = "Water";
            pokemon1 = "Squirtle";
        }
        if(starterPokemon == 3){
            println("You selected Bulbasaur. (Grass)");
            type = "Grass";
            pokemon1 = "Bulbasaur";
        }
        if(starterPokemon == 0) {
            println("The Power of Arceus emerges...");
            type = "?";
            pokemon1 = "Arceus";
        }
        println("Now let's put your " + pokemon1 + " to the test!");
        println("\nBattle 1: Professor X");
        startEncounter(pokemon1, type, healPot, 1);
        println("Wow, you are really good at this! Take 3 heal potions as your reward! \n(Items you have will reset each battle, so you don't have to worry about losing them after a battle.)");
        healPot = healPot + 3;
        println("Heal potion + 3");
        println("Now you are ready to fight other trainers, good luck!");
        println("\nBattle 2: Trainer A");
        startEncounter(pokemon1, type, healPot, 2);
        println("\nBattle 3: Trainer legendary. THE FINAL BATTLE");
        startEncounter(pokemon1, type, healPot, 3);
    }
    public static void println(String print){
        System.out.println(print);
    }
    public static void startEncounter(String yourPokemon, String type, int healPot, int mode) {
        String enemyPokemon = "";
        int enemyHP = 0;
        int yourHP = 0;
        int enemyATK = 0;
        int yourATK = 0;
       if(mode == 1){
           enemyPokemon = "Bidoof";
           println("Professor X sent out Bidoof!");
           enemyHP = 120;
           yourHP = 120;
           enemyATK = 1;
           yourATK = 10;
       }
        if(mode == 2){
            enemyPokemon = "Pikachu";
            println("Trainer A sent out Pikachu!");
            enemyHP = 200;
            yourHP = 120;
            enemyATK = 14;
            yourATK = 10;
        }
        if(mode == 3){
            enemyPokemon = "Shiny Mega Rayquaza 100% IV";
            println("Trainer legendary sent out Shiny Mega Rayquaza 100% IV!");
            enemyHP = 248008215;
            yourHP = 120;
            enemyATK = 44901240;
            yourATK = 10;
        }
        Random randomMove = new Random();
        while (true) {
            println(enemyPokemon + " - HP: " + enemyHP);
            println("\n" + yourPokemon + " - HP: " + yourHP);
            println("What would you like to do? (1/2)");
            println("1: Attack");
            println("2: Items");
            Scanner scanLine = new Scanner(System.in);
            int move = scanLine.nextInt();
            if (move == 1) {
                if(yourPokemon == "Torchic"){
                    println("Choose a move (1/2)");
                    println("1: Growl");
                    println("2: Scratch");
                }
                if(yourPokemon == "Squirtle"){
                    println("Choose a move (1/2)");
                    println("1: Tackle");
                    println("2: Tail Whip");
                }
                if(yourPokemon == "Bulbasaur"){
                    println("Choose a move (1/2)");
                    println("1: Tackle");
                    println("2: Growth");
                }
                if(yourPokemon == "Arceus"){
                    println("Choose a move (1)");
                    println("1: Win");
                }
                int moveChoose = scanLine.nextInt();
                if (moveChoose == 1 && yourPokemon == "Torchic"){
                    if(enemyATK >= 2){
                        enemyATK = enemyATK - 1;
                        println("The opponent " + enemyPokemon + "'s Attack is lowered by 1!");
                    }
                    else{
                        println("The opponent " + enemyPokemon + "'s Attack cannot be lowered any more!");
                    }
                }
                if (moveChoose == 2 && yourPokemon == "Torchic") {
                    enemyHP = enemyHP - yourATK;
                    println(yourPokemon + " attacked " + enemyPokemon + " for " + yourATK + " damage!");
                }
                if (moveChoose == 1 && yourPokemon == "Squirtle"){
                    enemyHP = enemyHP - yourATK;
                    println(yourPokemon + " attacked " + enemyPokemon + " for " + yourATK + " damage!");
                }
                if (moveChoose == 2 && yourPokemon == "Squirtle") {
                    if(enemyATK >= 2){
                        enemyATK = enemyATK - 1;
                        println("The opponent " + enemyPokemon + "'s Attack is lowered by 1!");
                    }
                    else{
                        println("The opponent " + enemyPokemon + "'s Attack cannot be lowered any more!");
                    }
                }
                if (moveChoose == 1 && yourPokemon == "Bulbasaur"){
                    enemyHP = enemyHP - yourATK;
                    println(yourPokemon + " attacked " + enemyPokemon + " for " + yourATK + " damage!");
                }
                if (moveChoose == 2 && yourPokemon == "Bulbasaur") {
                    yourATK = yourATK + 1;
                    println("Your " + yourPokemon + "'s Attack is raised by 1!");
                }
                if (moveChoose == 1 && yourPokemon == "Arceus") {
                    println("ARCEUS USED WIN!");
                    break;
                }
            }
            if (move == 2) {
                println("What would you like to use? (1/2)");
                println("1: Heal potion - " + healPot);
                int itemMove = scanLine.nextInt();
                if (itemMove == 1 && healPot >= 1) {
                    yourHP = yourHP + 5;
                    healPot = healPot - 1;
                }
            }
            int enemyMove = randomMove.nextInt(3) + 1;
            int healRandom = randomMove.nextInt(5) + 2;
            if(enemyMove == 1 || enemyMove == 2){
                println(enemyPokemon + " attacked your " + yourPokemon + " for " + enemyATK + " damage!");
                yourHP = yourHP - enemyATK;
            }
            else if(enemyMove == 3){
                println(enemyPokemon + " Healed" + " for " + healRandom + " health!");
                enemyHP = enemyHP + healRandom;
            }
            if(enemyHP <= 0 || yourHP <= 0) {
                break;
            }
        }
        if(mode==1 && yourHP >= 0){
            println("You defeated Professor X!");
        }
        else if(mode==2 && yourHP >= 0){
            println("You defeated Trainer A!");
        }
        else if(mode==3 && yourHP >= 0){
            println("YOU WIN!");
        }
        else {
            println("You died");
            System.exit(0);
        }
    }
}