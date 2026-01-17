import java.util.Scanner;

public class Game {

    private MapMaker map;
    private Player player;
    private Scanner scan;
    private int curX;
    private int curY;
    private int totalMoves;

    public Game() {
        map = new MapMaker();
        player = new Player();
        scan = new Scanner(System.in);
        curX = 1;
        curY = 0;
        totalMoves = 0;
    }

    public void play(){
        System.out.println("Welcome, player!");
        System.out.println("The goal is simple, survive as long as possible!");
        System.out.println("Use wasd to move, collect the occasionally spawning '.', it's food to heal you! Also avoid the explosions! ( you'll know when you see :) )");
        System.out.println("Don't worry though! If you get blown up, there's a chance you'll be revived! (You're welcome)");
        System.out.println("Also, the '~' to your left will kill you if you touch it, so don't do that");
        map.setCoord(curX,curY,"o");
        makeFood();
        map.printMap();
        System.out.println("Moves left: " + player.getHealth());

        //Main loop of the game, runs while player health is greater than 0
        //Gets user input for direction, then manages hazards and moving the player
        //prints the map, decreases moves left and informs the player of it, then restart loop
        while (player.getHealth() > 0){
            String input = scan.nextLine();
            map.hazardTracker();
            move(input);
            map.printMap();
            player.hurt();
            System.out.println("Moves left: " + player.getHealth());
        }

        System.out.println("Game over!");
        System.out.println("You survived: " + totalMoves + " movements!");
    }

    //This method handles the players movement. It detects which way the player wants to go,
    //moves the player that way, then replaces the tile behind the player with the normal bg ("-").
    //Then it tests if the player is over the ~s,killing the player if so.
    //Otherwise, it increases totalMoves and counter, creating food every 6th totalMove.
    private void move(String str){
        if (str.equals("w") && curY > 0){
            curY--;
            checkTile();
            map.setCoord(curX, curY, "o");
            map.setCoord(curX, curY + 1, "-");
        }
        if (str.equals("s") && curY < map.getMaxRows() - 1){
            curY++;
            checkTile();
            map.setCoord(curX, curY, "o");
            map.setCoord(curX, curY - 1, "-");
        }
        if (str.equals("d") && curX < map.getMaxColumns() - 1){
            curX++;
            checkTile();
            map.setCoord(curX, curY, "o");
            map.setCoord(curX - 1, curY, "-");
        }
        if (str.equals("a") && curX > 0){
            curX--;
            checkTile();
            map.setCoord(curX, curY, "o");
            map.setCoord(curX + 1, curY, "-");
        }
        if (curX == 0){
            player.die();
        } else {
            totalMoves++;
            map.increaseCounter();
            if (totalMoves % 6 == 0){
                makeFood();
            }
        }
    }

    private void makeFood(){
        int rX = (int) (Math.random() * 20) + 1;
        int rY = (int) (Math.random() * 5);
        map.setCoord(rX,rY,".");
    }

    private void checkTile(){
        if (map.getCurIndex(curX, curY).equals(".")){
            player.restoreHealth();
        }
        if (map.getCurIndex(curX,curY).equals("O")){
            player.die();
        }
    }
}