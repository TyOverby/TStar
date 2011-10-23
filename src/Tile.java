
public class Tile {
	public final Tile parent;
	public final int generation;
	public final Point location;
	
	public boolean spent = false;
	
	public Tile(Tile parent, int generation,Point location){
		this.parent = parent;
		this.generation = generation;
		this.location = location;
	}
}
