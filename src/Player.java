public class Player {

    private int health;
    private final int MAXHP;

    public Player(){
        health = 25;
        MAXHP = health;
    }

    public int getHealth(){
        return health;
    }

    public void restoreHealth(){
        health = MAXHP + 1;
    }

    public void hurt(){
        health--;
    }

    public void die(){
        health = 1;
    }
}