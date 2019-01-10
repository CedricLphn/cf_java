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

            System.out.println("l = " + l+" L = "+L);

            mvtTondeuse();

        }
		
		




		public void mvtTondeuse() {
            String[] split_position = grille.get("T").toString().split(",");
            int x = Integer.parseInt(split_position[0]);
            int y = Integer.parseInt(split_position[1]);
            String orientation = split_position[2];

            String mvt = grille.get("M").toString();

            System.out.println(orientation);

        }


 			initPosTondeuse();
	mvtTondeuse();
			if( == "G") {
				if (direction == "N" && y > 1)
				{
					direction = "W";
				}
				else if (direction == "W" && y > 1)
				{
					direction = "S";
				}
				else if (direction == "S" && y > 1)
				{
					direction = "E";
				}
				else if (direction == "E" && y > 1)
				{
					direction = "N";
				}
			}
			else if (== "D")
			{
				if (direction == "N" && y < 20)
				{
					direction = "E";
				}
				else if (direction == "E" && y < 20)
				{
					direction = "S";
				}
				else if (direction == "S" && y < 20)
				{
					direction = "W";
				}
				else if (direction == "W" && y < 20)
				{
					direction = "N";
				}
			}
		}



		// Getter
		private HashMap<OrientationEnum, int[][]> getPosTondeuse()
		{
			return this.tondeuse;
		}

		// Setter
		private void setPosTondeuse(HashMap<OrientationEnum, int [][]> posTondeuse)
		{
			this.tondeuse = posTondeuse;
		}
	}*/
}
