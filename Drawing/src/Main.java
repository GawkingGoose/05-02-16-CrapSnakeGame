import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	public static Direction keyDirection = Direction.right;
	
	public static void main(String[] args) {

//		DrawPanel panel = new DrawPanel();
//		JFrame frame = panel.drawItNow();
		
		System.out.println("sweet");
		
		Grid grid = new Grid(50,50);
		
		GridRenderer renderer = new GridRenderer(grid);
//		frame.setContentPane(renderer);
		Snake snake = new Snake();
		
        JFrame window = new JFrame();
        window.setSize(590,610);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(renderer);
        window.setVisible(true);
		window.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
		            keyDirection = Direction.right;
		    } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
		            keyDirection = Direction.left;
		    } else if (e.getKeyCode() == KeyEvent.VK_UP ) {
	            keyDirection = Direction.up;
		    } else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
	            keyDirection = Direction.down;
		    }
			}
		});
        
		System.out.println("done");
		boolean run = true;
		int score = 0;
		while (run) {
			
			//ADd in a way to get direction\/\/\/
			 
//			NodeState state = grid.setSnakePosition(snake.snakeNewRandomMove(score));//random for testing
			NodeState state = grid.setSnakePosition(snake.snakeNewMove(score, keyDirection));//direction need an input method
			
			
//			System.out.println(state);
			if(state.equals(NodeState.empty)){
				//Do nothing
			}else if(state.equals(NodeState.food)){
				score++;
			}else if(state.equals(NodeState.snake)){
				run = false;
				continue;
			}
			window.repaint();
			try{
			  Thread.sleep(1000);
			}catch(InterruptedException ex){
			  System.out.println("thread broke");
			}
		}
		
		if(!run){
			System.out.println("END GAME");
			JOptionPane.showMessageDialog(window, "You lose! Your score is ");
		}
		System.exit(0);
	}

}
