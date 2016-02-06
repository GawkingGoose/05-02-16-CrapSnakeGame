

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class GridRenderer extends JComponent {

//	public int offset = 20;
	public int width = 10;
	
	int border = 10;
	
	Grid grid;
	
	public GridRenderer(Grid grid){
		super();
		this.grid = grid;
	}
	
	public void paint(Graphics g) {
		int x = 0;
		NodeState[][] nodes = grid.getGridLayout();
		for (int i = 0; i < nodes.length; i++) {
			int y = 0;
			for (int j = 0; j < nodes[0].length; j++) {
				if(nodes[i][j].equals(NodeState.snake)){
					g.drawRect( i + width + x , j + width + y , width , width ); 
//					g.drawOval( i + width + x , j + width + y , width , width ); 
				}else if(nodes[i][j].equals(NodeState.food)){
//					g.drawRect( i + width + x , j + width + y , width , width ); 
					g.drawOval( i + width + x , j + width + y , width , width ); 
				}else if(nodes[i][j].equals(NodeState.empty)){
//					g.drawRect( i + width + x , j + width + y , width , width ); 
//					g.drawOval( i + width + x , j + width + y , width , width ); 
				}
				y += width;
			}
			x += width;
		}
	}
	
}
