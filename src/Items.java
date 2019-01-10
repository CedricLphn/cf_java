import java.util.HashMap;
import java.util.Map;

public class Items {

    private Map<String, String> items = new HashMap<>();
    private int quantity = 0;



    public void addItem(String id, String coord) {
        // On ajoute dans la map l'item
        this.items.put(id, coord);
        System.out.println(items);
    }

    public boolean isItem(int x, int y) {
        /*
        On boucle la map items
         */
        for(Object currentkey : items.keySet()) {
            /*
            On split
             */
            String cp = currentkey.toString();
            String[] split = items.get(cp.toString()).toString().split(",");

            // On prends que les items (ca commence par I dans la map)
            if(cp.charAt(0) == 'I') {
                // On vérifie les coordonnées des arguments passés par rapport aux coordonnées de l'item
                if(Integer.parseInt(split[0]) == x && Integer.parseInt(split[1]) == y) {
                    // Oui ? alors on le dis et on ajoute 1 item dans la quantité
                    System.out.println("il y a un item par terre ("+x+","+y+")");
                    quantity += 1;
                    items.put(cp, "0,0");


                    System.out.println("Tu as maintenant "+quantity+" lave vaisselle");
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isObstacle(int x, int y) {
        /*
        On boucle la map items
         */
        for(Object currentkey : items.keySet()) {
            /*
            On split
             */
            String cp = currentkey.toString();
            String[] split = items.get(cp.toString()).toString().split(",");

            // On prends que les obstacles (ca commence par O dans la map)

            if(cp.charAt(0) == 'O') {
                if(Integer.parseInt(split[0]) == x && Integer.parseInt(split[1]) == y) {

                    // on vérifie qu'on a au moins 1 item
                    if(quantity > 0) {
                        // Oui ? on décrémente
                        quantity -=1;
                        System.out.println("j'utilise mon item");
                        // On met l'item à null
                        items.put(cp, "0,0");
                        return false;
                    }

                    System.out.println("Obstacle détecté ("+x+","+y+")");
                    return true;

                }
            }
        }

        return false;
    }

}
