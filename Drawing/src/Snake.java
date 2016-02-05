import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Snake {

	int snakeLength;
	
	List<Point> snake;
	
	public Snake(){
		snake = new ArrayList<Point>();
		snake.add(new Point(5,5));
		snake.add(new Point(5,6));
		snake.add(new Point(5,7));
	}
	
	public List<Point> snakeNewRandomMove(int score){
		snake.remove(0);
		snake.add(new Point((int) snake.get(snake.size()-1).getX(),(int) snake.get(snake.size()-1).getY()));
		return snake;
	}
	
	
}
