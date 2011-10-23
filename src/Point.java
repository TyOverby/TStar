
public class Point {
	
	public final int x;
	public final int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public float getDistance(Point p){
		int deltaX = this.x-p.x;
		int deltaY = this.y-p.y;
		
		return 2*(float)Math.sqrt(deltaX*deltaX+deltaY+deltaY);
	}
	
	public Point[] getNeighbors(){
		Point[] toReturn = new Point[4];
		
		toReturn[0] = new Point(this.x+1,this.y);
		toReturn[1] = new Point(this.x-1,this.y);
		toReturn[2] = new Point(this.x,this.y+1);
		toReturn[3] = new Point(this.x,this.y-1);
		
		return toReturn;
	}
	
	public String toString(){
		return "("+this.x+","+this.y+")";
	}
}
