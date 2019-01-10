import java.util.HashMap;
import java.util.Map;

public class Tondeuse {


    public HashMap<OrientationEnum, int[][]> tondeuse = new HashMap<>();

    private Map grille;
    private static int[] taille = new int[2];
    private static int l;
    private static int L;
    private int quantity = 0;

    //Items item = new Items();

    Tondeuse(Map map) {

        this.grille = map;

        System.out.println("=== Tondeuse ===");
        System.out.println(grille);
        String[] explode = grille.get("X").toString().split(",");
        l = Integer.parseInt(explode[0]);
        L = Integer.parseInt(explode[1]);

        System.out.println("l = " + l + " L = " + L);

        mvtTondeuse();

    }


    public boolean setOrientation(String orientation) {

        grille.put("Y", orientation);
        return true;
    }

    public String getOrientation() {
        return grille.get("Y").toString();
    }

    public int getX() {
        String[] sp = grille.get("T").toString().split(",");
        return Integer.parseInt(sp[0]);
    }

    public int getY() {
        String[] sp = grille.get("T").toString().split(",");
        return Integer.parseInt(sp[1]);
    }

    public boolean setCoord(int x, int y) {
        String sp = x + "," + y;
        grille.put("T", sp);
        return true;
    }

    // 0 = largeur
    // 1 = Hauteur
    public int getTaille(int key) {
        String[] sp = grille.get("X").toString().split(",");
        return Integer.parseInt(sp[key]);
    }

    public boolean isObstacle(int x, int y) {

        for(Object currentkey : grille.keySet()) {
            String cp = currentkey.toString();
            String[] split = grille.get(cp.toString()).toString().split(",");

            if(cp.charAt(0) == 'O') {
                if(Integer.parseInt(split[0]) == x && Integer.parseInt(split[1]) == y) {
                    if(quantity > 0) {
                        quantity -=1;
                        System.out.println("j'utilise mon item");
                        grille.put(cp, "0,0");
                        return true;
                    }

                }
            }
        }

        return false;
    }

    public boolean isItem(int x, int y) {
        for(Object currentkey : grille.keySet()) {
            String cp = currentkey.toString();
            String[] split = grille.get(cp.toString()).toString().split(",");

            if(cp.charAt(0) == 'I') {
                if(Integer.parseInt(split[0]) == x && Integer.parseInt(split[1]) == y) {
                    System.out.println("il y a un item par terre");
                    quantity += 1;
                    System.out.println("Tu as maintenant "+quantity+" lave vaisselle");

                    return true;
                }
            }
        }

        return false;
    }

    public void mvtTondeuse() {


        String[] split_position = grille.get("T").toString().split(",");
        int x = Integer.parseInt(split_position[0]);
        int y = Integer.parseInt(split_position[1]);


        String mvt = grille.get("M").toString();


        for (int i = 0; i <= mvt.length() - 1; i++) {
            if (mvt.charAt(i) == 'G') {
                System.out.println("je réitère");
                if (getOrientation().equals("N")) {

                    setOrientation("W");

                    System.out.println(getOrientation());


                } else if (getOrientation().equals("W")) {

                    setOrientation("S");

                    System.out.println(getOrientation());

                } else if (getOrientation().equals("S")) {

                    setOrientation("E");

                    System.out.println(getOrientation());

                } else if (getOrientation().equals("E")) {

                    setOrientation("N");

                    System.out.println(getOrientation());

                }
            }
            else if (mvt.charAt(i) == 'D') {
                System.out.println("je pisse");
                if (getOrientation().equals("N")) {

                    setOrientation("E");

                    System.out.println(getOrientation());


                } else if (getOrientation().equals("E")) {

                    setOrientation("S");

                    System.out.println(getOrientation());

                } else if (getOrientation().equals("S")) {

                    setOrientation("W");

                    System.out.println(getOrientation());

                } else if (getOrientation().equals("W")) {

                    setOrientation("N");

                    System.out.println(getOrientation());

                }
            }else if(mvt.charAt(i) == 'A'){
                System.out.println("A detecté");

                if(getY() == 1 && getOrientation().equals("N")) {
                    System.out.println("On peut pas avancer");
                }else if(getX() == getTaille(0) && getOrientation().equals("E")) {
                    System.out.println("on pe pa avancé");
                }else if(getX() == 1 && getOrientation().equals("W")){
                    System.out.println("on pe paaaaaaa avancé");
                }else if(getY() == getTaille(1) && getOrientation().equals("S")) {
                    System.out.println("on pe paaaalelelaaa avancé");

                }else {

                    if(getOrientation().equals("N") && (isItem(getX(), getY()-1) || !isObstacle(getX(), getY()-1) ) ) {

                        setCoord(getX(), getY() -1);
                        isItem()
                        System.out.println(getX()+" "+ getY());
                    }else if(getOrientation().equals("E") && (isItem(getX()+1, getY()) || !isObstacle(getX()+1, getY()) ) ) {
                        setCoord(getX()+ 1, getY());
                        System.out.println(getX()+" "+ getY());

                    }else if(getOrientation().equals("S")  && (isItem(getX(), getY()+1) || !isObstacle(getX(), getY()+1) )) {
                        setCoord(getX(), getY()+1);
                        System.out.println(getX()+" "+ getY());
                    }else if(getOrientation().equals("W") && (isItem(getX()-1, getY()) || !isObstacle(getX()-1, getY()) )) {
                        setCoord(getX()-1, getY());
                        System.out.println(getX()+" "+ getY());
                    }

                }
            }

        }


        System.out.println(grille.get("Y").toString());
        System.out.println(quantity);


    }
}
