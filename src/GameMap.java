
public class GameMap {
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;

	public static Tile[][] map = new Tile[WIDTH][HEIGHT];
	public static Point start;
	public static Point end;

	public static int currentGeneration=0;

	public static void start(Point start, Point end){
		map[start.x][start.y] = new Tile(null,0,new Point(start.x,start.y));

		GameMap.start=start;
		GameMap.end = end;
	}

	public static Tile getTile(Point p){
		return map[p.x][p.y];
	}

	public static Tile findClosestTile(){		
		Point curMin = null;
		float curMinLength = 0;

		// Go through all the tiles
		for(int i=0;i<map.length;i++){
			for(int k=0;k<map.length;k++){
				// Make sure that it isn't null
				if(map[i][k]!=null){
					// Check to see if it hasn't been expanded yet
					if(!map[i][k].spent){
						// If this is the first iteration,
						if(curMin==null){
							curMin=new Point(i,k);
							curMinLength = map[i][k].generation+curMin.getDistance(end);
						}
						else{
							Point local = new Point(i,k);
							float dist = local.getDistance(end)+map[i][k].generation;
							if(dist<curMinLength){
								curMin=local;
								curMinLength=dist;
							}
						}
					}
				}
			}				
		}
		return getTile(curMin);
	}

	public static void extend(Tile t){
		for(Point n:t.location.getNeighbors()){
			if(n.x>=0&&n.y>=0){
				if(map[n.x][n.y]==null){
					map[n.x][n.y]=new Tile(t,t.generation+1,new Point(n.x,n.y));
				}
			}
		}

		t.spent = true;
	}
	
	public static Tile run(){
		while(true){
			extend(findClosestTile());
			if(getTile(end)!=null){
				return getTile(end);
			}
		}
	}

	public static void main(String... args){
		Point start = new Point(0,0);
		Point end = new Point(5,5);

		start(start,end);

		run();

		//System.out.println(findClosestTile().toString());
		printMap();
	}

	public static void printMap(){
		for(int i=0;i<map.length+2;i++){
			System.out.print("▓");
		} System.out.println();
		
		for(int i=0;i<map.length;i++){
			System.out.print("▓");
			for(int k=0;k<map.length;k++){
				if(map[i][k]==null){
					System.out.print("-");
				}
				else{
					System.out.print(map[i][k].generation);
				}
			}
			System.out.print("▓\n");
		}
		
		for(int i=0;i<map.length+2;i++){
			System.out.print("▓");
		} System.out.println();
	}
}
