import java.util.*;
class Enemy{
    int hp;
    int damage;
    boolean isAlive;

   Enemy(int hp,int damage) {
       this.hp=hp;
       this.damage=damage;
       isAlive=true;
    }

    public void takeDamage(int amount){
        hp-=amount;
        if(hp<=0) isAlive=false;

    }
}
class Hero{
    int hp;
    int damage;
    boolean isAlive;

    Hero(int hp,int damage) {
        this.hp=hp;
        this.damage=damage;
        isAlive=true;
    }

    public void takeDamage(int amount){
        hp-=amount;
        if(hp<=0) isAlive=false;

    }
}
public class Lab13A {

   public static int numEenmies(Enemy[]enemies){
        int sum=0;
        for(int i=0;i<enemies.length;i++){
            if(enemies[i].isAlive)sum++;
        }
        return sum;
    }
    static void printArray(Enemy[] enemies) {
        for (int i = 0; i < enemies.length; i++) {
            System.out.print("|"+enemies[i].hp);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int numEnemies;
        int enemyDamage;
        int enemyHP;
        int heroDamage;
        int heroHP;
        int numEnemiesLeft;



        System.out.print("Enter the number of enemies: ");
        numEnemies= sc.nextInt();
        System.out.print("Enter the enemy damage: ");
        enemyDamage=sc.nextInt();
        System.out.print("Enter the hero's starting HP: ");
        heroHP=sc.nextInt();
        System.out.print("Enter the hero's damage: ");
        heroDamage=sc.nextInt();


        Enemy[] enemies = new Enemy[numEnemies];
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy(10+(i*2), enemyDamage);
        }
        Hero hero = new Hero(heroHP, heroDamage);
        int roundCount = 1;
        do {
            for(int i = 0; i < enemies.length; i++){
                if(enemies[i].isAlive){
                    enemies[i].takeDamage(hero.damage);
                    hero.takeDamage(enemies[i].damage);
                }
            }
            System.out.println("==== After round " +roundCount+"====");
            numEnemiesLeft = numEenmies(enemies);
            System.out.println("Num enemies left: " +numEnemiesLeft);
            printArray(enemies);
            System.out.println("Hero HP: "+hero.hp);
            roundCount++;
        } while ((numEnemiesLeft > 0)&&(hero.isAlive));
        if (hero.isAlive)
        {
            System.out.println ("Hero wins!");
        }
        else
        {
            System.out.println("Enemies win!");
        }
    }


}