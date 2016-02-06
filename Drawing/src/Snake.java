import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Snake {

	int snakeLength;
	
	List<Point> snake;
	
	int score = 0;
	
	public Snake(){
		snake = new ArrayList<Point>();
		snake.add(new Point(5,5));
		snake.add(new Point(5,6));
		snake.add(new Point(5,7));
		snake.add(new Point(5,8));
		snake.add(new Point(5,9));
		snake.add(new Point(5,10));
	}
	
	public List<Point> snakeNewMove(int score, Direction dir ){
		int x = 0, y = 0;
		if(dir.equals(Direction.up)){
			y = -1;
		}else if(dir.equals(Direction.down)){
			y = 1;
		}else if(dir.equals(Direction.right)){
			x = 1;
		}else if(dir.equals(Direction.left)){
			x = -1;
		}
		if(score == this.score){
			snake.remove(0);
		}
		this.score = score;
		snake.add(new Point((int) snake.get(snake.size()-1).getX() + x,(int) snake.get(snake.size()-1).getY() + y));
		return snake;
	}
	
	public List<Point> snakeNewRandomMove(int score){
//		System.out.println(snake.size());
		snake.remove(0);
		snake.add(new Point((int) snake.get(snake.size()-1).getX() + 1,(int) snake.get(snake.size()-1).getY()));
		return snake;
	}
	
	
}
