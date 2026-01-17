public class Player {

    private int health;
    private final int MAXHP;
    private int revives;

    public Player(){
        health = 25;
        MAXHP = health;
        revives = 0;
    }

    public int getHealth(){
        return health;
    }

    public int getRevives(){
        return revives;
    }

    public void restoreHealth(){
        health = MAXHP + 1;
    }

    public void hurt(){
        health--;
    }

    public void die(){
        health = 1;
        secondChance();
    }

    //gives the player possibly a second chance to keep going
    //functions off of dnd's death saving throws mechanic
    //rolls a 20-sided dice, a 20 instant succeeds (revives player), a 1 is two failures,
    // 11 or above is one success, 10 or below is one failure
    //if player lives, adds 1 to revives counter
    private void secondChance(){
        int successes = 0;
        int failures = 0;
        while (successes < 3 && failures < 3){
            int r = (int) (Math.random() * 20) + 1;
            if (r == 20){
                successes = 3;
            } else if (successes == 1) {
                failures += 2;
            } else if (r >= 11) {
                successes++;
            } else {
                failures++;
            }
        }
        if (successes == 3){
            restoreHealth();
            revives++;
            System.out.println("You almost died, but you were able to pull through! Don't waste it!");
        }
    }
}