import java.util.HashMap;
import java.util.Map;

public class Tondeuse {


    public HashMap<OrientationEnum, int[][]> tondeuse = new HashMap<>();

    private Map grille;
    private static int[] taille = new int[2];
    private static int l;
    private static int L;
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
                    if(getOrientation().equals("N")) {
                        setCoord(getX(), getY() -1);
                        System.out.println(getX()+" "+ getY());
                    }else if(getOrientation().equals("E")) {
                        setCoord(getX()+ 1, getY());
                        System.out.println(getX()+" "+ getY());

                    }else if(getOrientation().equals("S")) {
                        setCoord(getX(), getY()+1);
                        System.out.println(getX()+" "+ getY());
                    }else if(getOrientation().equals("W")) {
                        setCoord(getX()-1, getY());
                        System.out.println(getX()+" "+ getY());
                    }

                }
            }

//			else if (== "D")
//			{
//				if (direction == "N" && y < 20)
//				{
//					direction = "E";
//				}
//				else if (direction == "E" && y < 20)
//				{
//					direction = "S";
//				}
//				else if (direction == "S" && y < 20)
//				{
//					direction = "W";
//				}
//				else if (direction == "W" && y < 20)
//				{
//					direction = "N";
//				}
//			}*/
//            }
        }


//		// Getter
//		private HashMap<OrientationEnum, int[][]> getPosTondeuse()
//		{
//			return this.tondeuse;
//		}
//
//		// Setter
//		private void setPosTondeuse(HashMap<OrientationEnum, int [][]> posTondeuse)
//		{
//			this.tondeuse = posTondeuse;
//		}

        System.out.println(grille.get("Y").toString());


    }
}
