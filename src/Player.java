public class Player {

    private int health;
    private final int MAXHP;
    private int speed;

    public Player(){
        health = 25;
        MAXHP = health;
        speed = 1;
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
        health = 0;
    }
}