import java.util.HashMap;
import java.util.Map;

public class Tondeuse {


    private Map grille;
    private static int l;
    private static int L;
    private Items items = new Items();


    Tondeuse(Map map) {

        /*
        On met la Map passée en argument dans la valeur Grille
         */

        this.grille = map;

        System.out.println("=== Tondeuse ===");
        System.out.println(grille);

        // J'explose la grille pour définir la hauteur et la largeur
        String[] explode = grille.get("X").toString().split(",");
        l = Integer.parseInt(explode[0]); // Correspond à la largeur
        L = Integer.parseInt(explode[1]); // Correspond à la longueur

        // On affiche
        System.out.println("l = " + l + " L = " + L);

        // On fait une boucle afin d'envoyer seulement les items dans la classe Items
        for(Object currentkey : grille.keySet()) {

            String cp = currentkey.toString();
            // On souhaite uniquement les items et les obtacles
            if(cp.charAt(0) == 'O' || cp.charAt(0) == 'I') {
                // On ajoute à items;
                items.addItem(cp, grille.get(cp).toString());

            }
        }


    }

    public void run() {

        // On récupère les instructions de la tondeuse
        String mvt = grille.get("M").toString();

        // on boucle
        for (int i = 0; i <= mvt.length() - 1; i++) {

            // On va à gauche
            if (mvt.charAt(i) == 'G') {
                // On regard l'orientation
                if (getOrientation().equals("N")) {
                    // Si c'est au nord, on le positionne à l'ouest
                    setOrientation("W");

                    System.out.println(getOrientation());


                } else if (getOrientation().equals("W")) {
                    // Si c'est au à l'ouest, on va au sud

                    setOrientation("S");

                    System.out.println(getOrientation());

                } else if (getOrientation().equals("S")) {
                    // Si c'est au sud, on le positionne à l'est

                    setOrientation("E");

                    System.out.println(getOrientation());

                } else if (getOrientation().equals("E")) {
                    // Si c'est au l'est, on le positionne au nord

                    setOrientation("N");

                    System.out.println(getOrientation());

                }
            }
            else if (mvt.charAt(i) == 'D') {
                // Sinon c'est à droite

                if (getOrientation().equals("N")) {
                    // Si c'est au nord, on le position à l'est

                    setOrientation("E");

                    System.out.println(getOrientation());


                } else if (getOrientation().equals("E")) {
                    // Si c'est a l'est, on le position au sud

                    setOrientation("S");

                    System.out.println(getOrientation());

                } else if (getOrientation().equals("S")) {

                    // Si c'est au sud, on le position à l'ouest


                    setOrientation("W");

                    System.out.println(getOrientation());

                } else if (getOrientation().equals("W")) {

                    // Si c'est a l'ouest, on le positionne au nord


                    setOrientation("N");

                    System.out.println(getOrientation());

                }
            }else if(mvt.charAt(i) == 'A'){
                // SINON ON AVAAAANCE

                // On vérifie d'abord si y a pas une collision
                if(getY() == 1 && getOrientation().equals("N")) {
                    System.out.println("On peut pas avancer au nord");
                }else if(getX() == getTaille(0) && getOrientation().equals("E")) {
                    System.out.println("on peut pas avancer à l'est");
                }else if(getX() == 1 && getOrientation().equals("W")){
                    System.out.println("on peut pas avancer à l'ouest");
                }else if(getY() == getTaille(1) && getOrientation().equals("S")) {
                    System.out.println("on peut pas avancer le sud");

                }else {

                    // Pas de collision (mur), on check les items/obstacles

                    // Si l'orientation est au nord et qu'il n'y a pas d'obstacle a x et x-1
                    if(getOrientation().equals("N") && !items.isObstacle(getX(), getY()-1) ) {

                        // On update les coordonnées
                        setCoord(getX(), getY() -1);

                        // On vérifie s'il y a un item présent
                        items.isItem(getX(), getY());

                        System.out.println(getX()+" "+ getY());
                    }else if(getOrientation().equals("E") && !items.isObstacle(getX()+1, getY()) ) {
                        setCoord(getX()+ 1, getY());
                        items.isItem(getX(), getY());
                        System.out.println(getX()+" "+ getY());

                    }else if(getOrientation().equals("S")  && !items.isObstacle(getX(), getY()+1) ) {
                        setCoord(getX(), getY()+1);
                        items.isItem(getX(), getY());
                        System.out.println(getX()+" "+ getY());
                    }else if(getOrientation().equals("W") && !items.isObstacle(getX()-1, getY()) ) {
                        setCoord(getX()-1, getY());
                        items.isItem(getX(), getY());
                        System.out.println(getX()+" "+ getY());
                    }

                }
            }

        }

        System.out.println("La tondeuse se situe aux coordonnées " + getX() + ", " + getY() +" "+ getOrientation());


    }

    /*
    Setter
     */
    public boolean setOrientation(String orientation) {

        grille.put("Y", orientation);
        return true;
    }

    public String getOrientation() {
        return grille.get("Y").toString();
    }


    public boolean setCoord(int x, int y) {
        String sp = x + "," + y;
        grille.put("T", sp);
        return true;
    }

    /*
    Getters
     */

    public int getX() {
        String[] sp = grille.get("T").toString().split(",");
        return Integer.parseInt(sp[0]);
    }

    public int getY() {
        String[] sp = grille.get("T").toString().split(",");
        return Integer.parseInt(sp[1]);
    }


    // 0 = largeur
    // 1 = Hauteur
    public int getTaille(int key) {
        String[] sp = grille.get("X").toString().split(",");
        return Integer.parseInt(sp[key]);
    }

}
