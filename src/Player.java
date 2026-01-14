public class Player {

    private int health;
    private int maxHP;
    private int speed;

    public Player(){
        health = 25;
        maxHP = health;
        speed = 1;
    }

    public int getHealth(){
        return health;
    }

    public void hurt(){
        health--;
    }

    public void die(){
        health = 0;
    }
}