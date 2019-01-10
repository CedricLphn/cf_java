import java.util.HashMap;
import java.util.Map;

public class TondeuseManager {
    private Map grille;
    private static int[] taille = new int[2];
    private static int l;
    private static int L;

    TondeuseManager(Map map) {

        this.grille = map;

        System.out.println("=== Tondeuse Manager ===");
        System.out.println(grille);
        String[] explode = grille.get("X").toString().split(",");
        l = Integer.parseInt(explode[0]);
        L = Integer.parseInt(explode[1]);

        System.out.println("l = " + l+" L = "+L);

    }



    public static boolean setTaille(int[] cdn) {

        cdn = new int[2];

        taille = cdn;

        return true;
    }

    public static int[] getTaille() {
        return taille;
    }


}