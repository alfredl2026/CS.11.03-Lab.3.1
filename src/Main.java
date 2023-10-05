import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        note();
        waitEnter();
        askName();
        String scanned;
        Scanner scanLine = new Scanner(System.in);
        scanned = scanLine.next();
        int mode = 0;
        welcome(scanned);
        waitEnter();
        println("You have an ambition of becoming the strongest trainer in this town, and today is your lucky day.");
        waitEnter();
        println("I'll allow you to choose a starter pokemon now, which will be battling with you along your journey. Pick very wisely.");
        int starterPokemon;
        println("1: Torchic" + " 2: Squirtle" + " 3: Bulbasaur");
        println("Please enter a number (1/2/3)");
        starterPokemon = scanLine.nextInt();
        String pokemon1 = "";
        String type = ""; //ended up not using type advantages because I don't think it will work well in this game since it is 1v1.
        int healPot = 1;
        int pokeBall = 0;
        if (starterPokemon == 1) {
            println("You selected Torchic. (Fire)");
            type = "Fire";
            pokemon1 = "Torchic";
        }
        else if (starterPokemon == 2) {
            println("You selected Squirtle. (Water)");
            type = "Water";
            pokemon1 = "Squirtle";
        }
        else if (starterPokemon == 3) {
            println("You selected Bulbasaur. (Grass)");
            type = "Grass";
            pokemon1 = "Bulbasaur";
        }
        else if (starterPokemon == 0) {
            println("The Power of Arceus emerges...");
            type = "?";
            pokemon1 = "Arceus";
        }
       else {
           println("That doesn't exist, nice try. Torchic will be your buddy then. (Fire)");
            type = "Fire";
            pokemon1 = "Torchic";
        }
        int atk = 10;
        int hp = 60;
        println("Now let's put your " + pokemon1 + " to the test!");
        waitEnter();
        println("\nBattle 1: Professor X");
        waitEnter();
        mode = 1;
        startEncounter(pokemon1, type, healPot, mode, atk, hp);
        waitEnter();
        println("Wow, you are really good at this! Take 3 heal potions as your reward! \n(Items you have will reset each battle, so you don't have to worry about losing them after a battle.)");
        healPot = healPot + 3;
        println("Heal potion + 3");
        waitEnter();
        println("Now you are ready to fight other trainers. You can explore the wild to level up or fight the trainers here. Good luck!");
        waitEnter();
        mode = 2;
        while (true) {
            mode = progress(pokemon1, type, healPot, mode, atk, hp);
        }
    }
    public static int progress(String yourPokemon, String type, int healPot, int mode, int atk, int hp){
        int pickUpgrade = upgrade();
        println("Choose an option (1/2):" + "\n1: Explore the wild" + "\n2: Trainer Battles");
        int scanned = 0;
        Scanner scanInt = new Scanner(System.in);
        scanned = scanInt.nextInt();
        if (scanned == 1){
            startEncounter(yourPokemon, type, healPot, 4, atk, hp);
            return mode;
        }
        if (scanned == 2){
            if(mode == 2){
                println("\nBattle 2: Trainer A");
                waitEnter();
                startEncounter(yourPokemon, type, healPot, 2, atk, hp);
                if (pickUpgrade == 1){
                    atk = atk + 5;
                }
                if (pickUpgrade == 2){
                    hp = hp + 5;
                }
                if (pickUpgrade == 3){
                    healPot = healPot + 5;
                }
                return 3;
            }
            if(mode == 3){
                println("\nBattle 3: Trainer legendary.");
                waitEnter();
                startEncounter(yourPokemon, type, healPot, 3, atk, hp);
                return 5;
            }
            if(mode == 5){
                println("\nBattle 4: CHAMPION champion. THE FINAL BATTLE");
                waitEnter();
                startEncounter(yourPokemon, type, healPot, 5, atk, hp);
                return 6;
            }
        }
            return 0;
    }
    public static void println(String print){
        System.out.println(print);
    }
    public static int upgrade(){
        Scanner pickUpgradeScan = new Scanner(System.in);
        println("Choose an upgrade");
        Random randomUpgrade = new Random();
        int upgrades = randomUpgrade.nextInt(2) + 1;
            println("1: +5 ATK");
            println("2: +5 HP");
            println("3: +1 Heal Pot");
        println("Please pick an upgrade (1/2/3)");
        int pickUpgrade = pickUpgradeScan.nextInt();
        if (pickUpgrade == 1){
            return 1;
        }
        if (pickUpgrade == 2){
            return 2;
        }
        if (pickUpgrade == 3){
            return 3;
        }
        else{
            println("Invalid Choice");
            upgrade();
        }
        return 0;
    }
    public static void waitEnter(){
        Scanner scanLine = new Scanner(System.in);
        scanLine.nextLine();
    }
    public static void endGame(){
        System.exit(1);
    }
    public static void askName(){
        println("What is your name?");
    }
    public static char note(){
        println("Note: Please press Enter to proceed in any sort of events like dialogue and battles, like this for example.");
        return 'a';
    }
    public static void welcome(String name){
        println("Welcome, " + name + ", to the world of Pokemon. You can call me Professor X.");
    }
    public static void startEncounter(String yourPokemon, String type, int healPot, int mode, int atk, int hp) {
        String[] possibleWild = {"Pikachu", "Eevee", "Jigglypuff", "Meowth", "Psyduck"};
        String[] possibleWildMessage = {"You wander in the plains..", "You venture deep in a forest..", "You explore a treacherous cave..."};
        String enemyPokemon = "";
        String wildMessage = "";
        int enemyHP = 0;
        int yourHP = hp;
        int enemyATK = 0;
        int yourATK = atk;
        Random randomMove = new Random();
        Random critChance = new Random();
        Random wildEncounter = new Random();
        Random wildMessageR = new Random();
        int randomWild = wildEncounter.nextInt(possibleWild.length);
        int randomWildMessage = wildMessageR.nextInt(possibleWildMessage.length);
       if(mode == 1){
           enemyPokemon = "Bidoof";
           println("Professor X sent out Bidoof!");
           enemyHP = 60;
           enemyATK = 1;
       }
        if(mode == 2){
            enemyPokemon = "Pikachu";
            println("Trainer A sent out Pikachu!");
            enemyHP = 80;
            enemyATK = 14;
        }
        if(mode == 3){
            enemyPokemon = "Rayquaza";
            println("Trainer legendary sent out Rayquaza!");
            enemyHP = 100 / 1;
            enemyATK = 20;
        }
        if(mode == 5){
            enemyPokemon = "Arceus";
            println("CHAMPION champion sent out Arceus!");
            enemyHP = 220;
            enemyATK = 25;
        }
        if(mode == 4){
            enemyPokemon = possibleWild[randomWild];
            wildMessage = possibleWildMessage[randomWildMessage];
            println(wildMessage);
            waitEnter();
            println("You encountered a wild " + enemyPokemon + "!");
            enemyHP = wildEncounter.nextInt((4) + 1) * (yourHP % wildEncounter.nextInt((10) + 1));
            enemyATK = wildEncounter.nextInt((2) + 1) * (yourHP % wildEncounter.nextInt((10) + 1));
            if (enemyATK <= 1){
                enemyATK = 1;
            }
            if (enemyHP <= 1){
                enemyHP = 1;
            }
        }
        int critCheck = 0;
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
                        waitEnter();
                    }
                    else{
                        println("The opponent " + enemyPokemon + "'s Attack cannot be lowered any more!");
                        waitEnter();
                    }
                }
                if (moveChoose == 2 && yourPokemon == "Torchic") {
                    critCheck = critChance.nextInt(5) + 1;
                    if (critCheck == 5){
                        enemyHP = enemyHP - (yourATK * 2);
                        println("CRITICAL HIT!");
                        println(yourPokemon + " attacked " + enemyPokemon + " for " + (yourATK * 2)+ " damage!");
                        waitEnter();
                    }
                    else {
                        enemyHP = enemyHP - yourATK;
                        println(yourPokemon + " attacked " + enemyPokemon + " for " + yourATK+ " damage!");
                        waitEnter();
                    }
                }
                if (moveChoose == 1 && yourPokemon == "Squirtle"){
                    critCheck = critChance.nextInt(5) + 1;
                    if (critCheck == 5){
                        enemyHP = enemyHP - (yourATK * 2);
                        println("CRITICAL HIT!");
                        println(yourPokemon + " attacked " + enemyPokemon + " for " + (yourATK * 2)+ " damage!");
                        waitEnter();
                    }
                    else {
                        enemyHP = enemyHP - yourATK;
                        println(yourPokemon + " attacked " + enemyPokemon + " for " + yourATK+ " damage!");
                        waitEnter();
                    }
                }
                if (moveChoose == 2 && yourPokemon == "Squirtle") {
                    if(enemyATK >= 2){
                        enemyATK = enemyATK - 1;
                        println("The opponent " + enemyPokemon + "'s Attack is lowered by 1!");
                        waitEnter();
                    }
                    else{
                        println("The opponent " + enemyPokemon + "'s Attack cannot be lowered any more!");
                        waitEnter();
                    }
                }
                if (moveChoose == 1 && yourPokemon == "Bulbasaur"){
                    critCheck = critChance.nextInt(5) + 1;
                    if (critCheck == 5){
                        enemyHP = enemyHP - (yourATK * 2);
                        println("CRITICAL HIT!");
                        println(yourPokemon + " attacked " + enemyPokemon + " for " + (yourATK * 2)+ " damage!");
                        waitEnter();
                    }
                    else {
                        enemyHP = enemyHP - yourATK;
                        println(yourPokemon + " attacked " + enemyPokemon + " for " + yourATK+ " damage!");
                        waitEnter();
                    }
                }
                if (moveChoose == 2 && yourPokemon == "Bulbasaur") {
                    yourATK = yourATK + 1;
                    println("Your " + yourPokemon + "'s Attack is raised by 1!");
                    waitEnter();
                }
                if (moveChoose == 1 && yourPokemon == "Arceus") {
                    println("ARCEUS USED WIN!");
                    waitEnter();
                    break;
                }
            }
            if (move == 2) {
                println("What would you like to use? (1/2)");
                println("1: Heal potion - " + healPot);
                println("2: Back");
                int itemMove = scanLine.nextInt();
                if (itemMove == 1 && healPot >= 1) {
                    yourHP = yourHP + 7;
                    healPot = healPot - 1;
                    println(yourPokemon + " Healed" + " for " + 7 + " health!");
                    waitEnter();
                }
            }
            int enemyMove = randomMove.nextInt(3) + 1;
            int healRandom = randomMove.nextInt(5) + 2;
            if(enemyMove == 1 || enemyMove == 2){
                critCheck = critChance.nextInt(5) + 1;
                if (critCheck == 5){
                    yourHP = yourHP - (enemyATK * 2);
                    println("CRITICAL HIT!");
                    println(enemyPokemon + " attacked " + yourPokemon + " for " + (enemyATK * 2)+ " damage!");
                    waitEnter();
                }
                else{
                    println(enemyPokemon + " attacked your " + yourPokemon + " for " + enemyATK + " damage!");
                    yourHP = yourHP - enemyATK;
                    waitEnter();
                }
            }
            else if(enemyMove == 3){
                println(enemyPokemon + " Healed" + " for " + healRandom + " health!");
                enemyHP = enemyHP + healRandom;
                waitEnter();
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
            waitEnter();
            println("Trainer A: Good game! You are pretty strong, good luck with what comes next.");
            waitEnter();
        }
        else if(mode==3 && yourHP >= 0){
            println("You defeated Trainer legendary!");
            waitEnter();
            println("Trainer legendary: Wow, you are quite good at this, that was a close battle!");
            waitEnter();
            println("It seems like there is 1 more person you need to fight - The CHAMPION.");
            waitEnter();
        }
        else if(mode==4 && yourHP >= 0){
            println("You defeated the wild " + enemyPokemon + "!");
        }
        else if(mode==5 && yourHP >= 0){
            println("You defeated CHAMPION champion!");
            waitEnter();
            println("CHAMPION Champion: Good job. Since you defeated me, I will now give you the title of the champion.");
            waitEnter();
            println("You did it, you defeated all the trainers and the champion! You have become THE CHAMPION.");
            endGame();
        }
        else {
            println("You lost. Better train yourself by exploring the wild before challenging the trainers first!");
            endGame();
        }
    }
}