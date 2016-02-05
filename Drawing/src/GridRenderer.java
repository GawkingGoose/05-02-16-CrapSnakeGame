import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

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
		int x = border;
		NodeState[][] nodes = grid.getGridLayout();
		for (int i = 0; i < nodes.length; i++) {
			int y = border;
			for (int j = 0; j < nodes[0].length; j++) {
				if(nodes[i][j].equals(NodeState.snake)){
//					g.drawOval( i + width + x , j + width + y , width , width ); 
				}else if(nodes[i][j].equals(NodeState.food)){
//					g.drawRect( i + width + x , j + width + y , width , width ); 
					g.drawOval( i + width + x , j + width + y , width , width ); 
				}else{
					g.drawRect( i + width + x , j + width + y , width , width ); 
				}
				y += width;
			}
			x += width;
		}
	}
	
}
