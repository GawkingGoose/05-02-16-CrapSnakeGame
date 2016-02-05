import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

//		DrawPanel panel = new DrawPanel();
//		JFrame frame = panel.drawItNow();
		
		System.out.println("sweet");
		
		Grid grid = new Grid(50,50);
		
		GridRenderer renderer = new GridRenderer(grid);
//		frame.setContentPane(renderer);
		Snake snake = new Snake();

        JFrame window = new JFrame();
        window.setSize(700,700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(renderer);
        window.setVisible(true);
		
		System.out.println("done");
		boolean run = true;
		int score = 0;
		while (run) {
			NodeState state = grid.setSnakePosition(snake.snakeNewRandomMove(score));
			System.out.println(state);
			if(state.equals(NodeState.empty)){
//				continue;
			}else if(state.equals(NodeState.food)){
				score++;
			}else if(state.equals(NodeState.snake)){
				run = false;
			}
			window.repaint();
			try{
			  Thread.sleep(1000);
			}catch(InterruptedException ex){
			  System.out.println("thread broke");
			}
		}
		
		
		
	}

}
