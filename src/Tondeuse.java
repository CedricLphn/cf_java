import java.util.HashMap;

public class Tondeuse {
	initPosTondeuse();
	mvtTondeuse();
		
		
		
		public HashMap<OrientationEnum, int[][]> tondeuse = new HashMap<>();
		
		
		public void mvtTondeuse(OrientationEnum, int x, int y)
		{
			instruction
			getPosTondeuse();
			 
			/*if( == "G") {
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
		}*/
		
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
	}
}
