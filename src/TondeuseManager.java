import java.util.HashMap;
import java.util.Map;

public class TondeuseManager {
    private Map<TondeuseEnum, HashMap<Integer, Integer>> grille = new HashMap<>();
    private static int[] taille = new int[2];




    public static boolean setTaille(int[] cdn) {

        cdn = new int[2];

        taille = cdn;

        return true;
    }

    public static int[] getTaille() {
        return taille;
    }


}