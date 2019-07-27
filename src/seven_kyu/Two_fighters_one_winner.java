package seven_kyu;

/**
 * Description:
 * Create a function that returns the name of the winner in a fight between two fighters.
 *
 * Each fighter takes turns attacking the other and whoever kills the other first is victorious. Death is defined as
 * having health <= 0.
 *
 * Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.
 *
 * Both health and damagePerAttack (damage_per_attack for python) will be integers larger than 0. You can mutate the
 * Fighter objects.
 *
 * Example:
 * public class Fighter {
 *   public String name;
 *   public int health, damagePerAttack;
 *   public Fighter(String name, int health, int damagePerAttack) {
 *     this.name = name;
 *     this.health = health;
 *     this.damagePerAttack = damagePerAttack;
 *   }
 * }
 */
public class Two_fighters_one_winner {

    private static class Fighter {
        private String name;
        private int health, damagePerAttack;

        private Fighter(String name, int health, int damagePerAttack) {
            this.name = name;
            this.health = health;
            this.damagePerAttack = damagePerAttack;
        }
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        // Your code goes here. Have fun!
        Fighter first = fighter1.name.equals(firstAttacker) ? fighter1 : fighter2;
        Fighter second = fighter2.name.equals(firstAttacker) ? fighter1 : fighter2;
        System.out.println(first.name);
        System.out.println(second.name);
        while (true) {
            second.health -= first.damagePerAttack;
            System.out.println(second.name + ":" + second.health);
            if (second.health <= 0) return first.name;
            first.health -= second.damagePerAttack;
            System.out.println(first.name + ":" + first.health);
            if (first.health <= 0) return second.name;
            System.out.println("----------------");
        }
    }

    public static void main(String[] args) {
        String win = Two_fighters_one_winner.declareWinner(new Fighter("Jerry", 30, 3),
                new Fighter("Harald", 20, 5), "Jerry");
        System.out.println(win);
    }
}
