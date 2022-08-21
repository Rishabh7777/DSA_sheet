package sheet.greedy;

public class DieHard {
    public static void main(String[] args) {
        int health = 20, armor = 8, moves = 0;
        boolean moveToAir = true;
        while(health >= 0 && armor >= 0) {
            if(moveToAir) {
                health += 3;
                armor += 2;
            } else if(health > 5 && armor > 10) {
                health += -5;
                armor += -10;
            } else if(health > 20) {
                health += -20;
                armor += 5;
            } else {
                System.out.println(moves);
                break;
            }
            moveToAir = !moveToAir;
            moves++;
        }
    }
}
