import java.util.Random;


public class Map {

	private MapSpace [][] map;
	private static Random rdm = new Random();
	private int currentX;
	private int currentY;


	public Map (int x, int y) {

		map = new MapSpace[x][y];
		currentX = 0;
		currentY = 0;

		for (int i=0;i<x;i++) {
			for (int j=0;j<y;j++) {
				switch (rdm.nextInt(3)) {
					case(0):
						map[i][j] = new Water();	 
						break;
					case(1):
						map[i][j] = new Sand();	 
						break;
					case(2):
						map[i][j] = new Grass();	 
						break;

				} 

			}
		}
		
	}


	public void travel(int i, int j) {
		if (i>=0 && i<map.length && j>=0 && j<map[i].length) {
			map[currentX][currentY].exit();
			currentX = i;
			currentY = j;
			map[currentX][currentY].enter();
		}
	} 

	public String toString() {
		String s = "";
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map.length;j++) {
				if(i==currentX && j==currentY) {
					s+="*";
				}
				else {
					s += map[i][j].toString();
				}
			}
			s += "\n";
		}
		return s;
	}


}

