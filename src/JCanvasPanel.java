import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;


public class JCanvasPanel extends JPanel {

    DataManager dm;

    public JCanvasPanel(DataManager dm){
    this.dm=dm;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        fillCells(g2);
        initMesh(g2);
    }
    
    @Override
    public void repaint() {
        super.repaint();
    }

    public void initMesh(Graphics2D g){
        for(int i=0;i<dm.getBoardWidth();i++){
            Line2D line=new Line2D.Double(i*dm.getSizeCell(),0,i*dm.getSizeCell(),dm.getBoardHeight());
            g.draw(line);
        }

        for(int i = 0; i<dm.getBoardHeight(); i++){
            Line2D line=new Line2D.Double(0,i*dm.getSizeCell(),dm.getBoardWidth(),i*dm.getSizeCell());
            g.draw(line);
        }
    }

    public void fillCells(Graphics2D g){
        for(int i=0;i<dm.getNumCellsWidth();i++){
            for(int j=0;j<dm.getNumCellsHeight();j++){
                if(dm.getStateCells()[i][j].getState()==1){
                    int x=dm.getStateCells()[i][j].getX();
                    int y=dm.getStateCells()[i][j].getY();
                    g.fillRect(x,y,dm.getSizeCell(),dm.getSizeCell());
                }
            }
        }
    }
}
