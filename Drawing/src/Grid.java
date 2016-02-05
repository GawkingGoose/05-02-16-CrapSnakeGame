import java.awt.Point;
import java.util.List;
import java.util.Random;

public class Grid {

	private NodeState[][] gridLayout;
	
	private List<Point> snakePosition;
	
	public Grid(int x, int y){
		gridLayout = new NodeState[x][y];
		for (int i = 0; i < gridLayout.length; i++) {
			for (int j = 0; j < gridLayout[0].length; j++) {
				gridLayout[i][j] = NodeState.empty;
			}
		}
	}
	
	public NodeState setSnakePosition(List<Point> snake){
		snakePosition = snake;
		boolean food = false;
//		for (Point point : snake) {
		Point point = snake.get(snake.size()-1);
			if(getNodeState(point.x,point.y).equals(NodeState.snake)){
//				return NodeState.snake;
			}
			if(getNodeState(point.x,point.y).equals(NodeState.food)){
				food = true;
			}
			setNodeState(point.x, point.y, NodeState.snake);
//		}
		removeSnakeDifferance(snake);
		if(food){
			setRandomFoodPosition();
			return NodeState.food;
		}
		return NodeState.empty;
	}
	
	private void removeSnakeDifferance(List<Point> snake){
		for (Point point : snakePosition) {
			setNodeState(point.x, point.y, NodeState.empty);
		}
		for (Point point : snake) {
			setNodeState(point.x, point.y, NodeState.empty);
		}
		snakePosition = snake;
		for (Point point : snakePosition) {
			setNodeState(point.x, point.y, NodeState.snake);
		}
		System.out.println( snakePosition.size());
	}
	
	public void setRandomFoodPosition(){
		Random rand = new Random();
		boolean run = true;
		int x = 3, y = 5;
		while (run) {
			boolean matched = false;
			 x = rand.nextInt(gridLayout.length);
			 y = rand.nextInt(gridLayout.length);
			if(x != 0 && y != 0){
				for (Point point : snakePosition) {
					if(point.x == x && point.y == y ){
						matched = true;
					}
				}
			}
			if(matched == false){
				run = false;
			}
		}
		setNodeState(x, y, NodeState.food);
	}
	
	public NodeState[][] getGridLayout(){
		return gridLayout;
	}
	
	private void setNodeState(int x, int y, NodeState state){
		gridLayout[x][y] = state;
	}
	
	private NodeState getNodeState(int x, int y){
		return gridLayout[x][y];
	}
}
