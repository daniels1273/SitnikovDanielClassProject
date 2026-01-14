import java.util.Scanner;

public class Game {

    private MapMaker map;
    private Player player;
    private Scanner scan;
    private int curX;
    private int curY;
    private int moves;

    public Game() {
        map = new MapMaker();
        player = new Player();
        scan = new Scanner(System.in);
        curX = 1;
        curY = 0;
        moves = 0;
    }

    public void play(){
        map.setCoord(curX,curY,".");
        makeFood();
        map.printMap();
        System.out.println("Moves left: " + player.getHealth());
        while (player.getHealth() > 0){
            String input = scan.nextLine();
            move(input);
            map.printMap();
            player.hurt();
            System.out.println("Moves left: " + player.getHealth());
        }
        System.out.println("Game over!");
        System.out.println("You survived: " + moves + " movements!");
    }

    private void move(String str){
        if (str.equals("w") && curY > 0){
            curY--;
            map.setCoord(curX, curY, ".");
            map.setCoord(curX, curY + 1, "-");
        }
        if (str.equals("s") && curY < map.getMaxRows() - 1){
            curY++;
            map.setCoord(curX, curY, ".");
            map.setCoord(curX, curY - 1, "-");
        }
        if (str.equals("d") && curX < map.getMaxColumns() - 1){
            curX++;
            map.setCoord(curX, curY, ".");
            map.setCoord(curX - 1, curY, "-");
        }
        if (str.equals("a") && curX > 0){
            curX--;
            map.setCoord(curX, curY, ".");
            map.setCoord(curX + 1, curY, "-");
        }
        if (curX == 0){
            player.die();
        } else {
            moves++;
            if (moves % 10 == 0){
                makeFood();
            }
        }
    }

    private void makeFood(){
        int rX = (int) (Math.random() * 21) + 1;
        int rY = (int) (Math.random() * 5);
        map.setCoord(rX,rY,"o");
    }
}