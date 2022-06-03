package com.company;
import java.util.Random;
public class Monster {
    private String name;
    private int health;
    private int defense;
   static private int monsterStrength;

    public Monster(String name, int health, int defense, int monsterStrength){
        this.name = name;
        this.health = health;
        this.defense = defense;
        Monster.monsterStrength = monsterStrength;
    }
    public String monsterStats(){
        return ("The " + getName() + " has " + getHealth() + " Health, " + getDefense() + " Defense, and " + getmonsterStrength() + " Attack power.");
    }

    public String handle(String command) {
        if(command.equals("a")) {
            Random parryChance = new Random();
            int upperbound = 6;
            int parry = parryChance.nextInt(upperbound);
            if (parry == 1){
                Player.takeDamage(getmonsterStrength());
                return "The " + getName() + " Blocked your attack and struck you! You have " + Player.getplayerHealth() + " Health left.";
            }

                setHealth(getHealth() - (Player.getAttackPower() - getDefense()));
                return "You cut the " + getName() + "! The " + getName() + " has " + getHealth() + " health left.";
        }
        else if(command.equals("b")){
            Random blockChance = new Random();
            int upperbound = 10;
            int block = blockChance.nextInt(upperbound);
            if (block == 1){
                Player.takeDamage(getmonsterStrength() * 2);
                return "The monster broke your parry! You were hit badly! " + "You have " + Player.getplayerHealth() + " health left.";
            }
            Player.setplayerHealth(Player.getplayerHealth() + 10);
            return "You used your sword to parry the " + getName() + "'s attack! You regenerated some health!";

        }
        else if(command.equals("d")){
            Random dodgeChance = new Random();
            int upperbound = 25;
            int dodge = dodgeChance.nextInt(upperbound);
                    if(dodge == 1){
                        Player.takeDamage(getmonsterStrength());
                        return "You failed to dodge the attack! You were struck by the monster! You have " + Player.getplayerHealth() + "health left.";
                    }
            return "You dodged the " + getName() + "'s attack! You regenerated a small amount of health";

        }
        else if(command.equals("f")){
            return "";
        }
        else {
            return "Not an option.";
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public static int getmonsterStrength() {
        return monsterStrength;
    }

    public void setAttackPower(int monsterStrength) {
        Monster.monsterStrength = monsterStrength;
    }
}
