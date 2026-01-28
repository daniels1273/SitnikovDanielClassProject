/**
 * This class represents a player object
 *
 * @author Daniel Sitnikov
 */
public class Player {

    /** The player's current health */
    private int health;

    /** The player's max health */
    private final int MAXHP;

    /** The amount of times the player has revived */
    private int revives;

    /** Instantiates a Player object */
    public Player(){
        health = 25;
        MAXHP = health;
        revives = 0;
    }

    /**
     * Returns the player's current health
     *
     * @return The player's current health
     */
    public int getHealth(){
        return health;
    }

    /**
     * Returns the amount of times the player has successfully been revived
     *
     * @return The amount of times the player was revived
     */
    public int getRevives(){
        return revives;
    }

    /**
     * Restores the player's current health to their max health
     */
    public void restoreHealth(){
        health = MAXHP + 1;
    }

    /**
     * Decrements the player's current health by one
     */
    public void hurt(){
        health--;
    }

    /**
     * Kills the player by decreasing their health to 1, also runs the secondChance method
     */
    public void die(){
        health = 1;
        secondChance();
    }

    /**
     * Has a chance of reviving the player
     */
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