import java.awt.*;
import java.util.Random;



public class Utility  {
    DataManager dm;
    Utility(DataManager dm) {
        this.dm=dm;
    }

    public void game(String startingStatus,Graphics g, Cell[][] cells) {
        int height = dm.getBoardHeight();
        int width = dm.getBoardWidth();
        Random generator = new Random();
        int sizeCell=dm.getSizeCell();

        if (startingStatus.equals("Oscillator")) { //g.fill3DRect(10,10,10,10,TRUE);
            g.fillRect(width / 2, height / 2, sizeCell, sizeCell);
            g.fillRect(width / 2, (height / 2) + sizeCell, sizeCell, sizeCell);
            g.fillRect(width / 2, (height / 2) + (2 * sizeCell), sizeCell, sizeCell);
            cells[width/20][(height / 20) + 2].alive(); //Size 600x500 , Cells 60x50
            cells[width/20][(height / 20) ].alive();
            cells[width/20][(height / 20) +  1].alive();

        } else if (startingStatus.equals("Glider")) {
            g.fillRect(width / 2, height / 2, sizeCell, sizeCell);
            g.fillRect((width / 2) + sizeCell, (height / 2), sizeCell, sizeCell);
            g.fillRect(width / 2, (height / 2) + sizeCell, sizeCell, sizeCell);
            g.fillRect((width / 2) - sizeCell, (height / 2) + sizeCell, sizeCell, sizeCell);
            g.fillRect((width / 2) + sizeCell, (height / 2) + (2 * sizeCell), sizeCell, sizeCell);
            cells[width/20][(height / 20) ].alive(); //Size 600x500 , Cells 60x50
            cells[(width/20)+1][(height / 20) ].alive();
            cells[width/20][(height / 20)+1 ].alive();
            cells[(width/20)-1][(height / 20)+1 ].alive();
            cells[(width/20)+1][(height / 20)+2 ].alive();

        } else if (startingStatus.equals("Unchanging")) {
            g.fillRect(width / 2, height / 2, sizeCell, sizeCell);
            g.fillRect((width / 2) + sizeCell, (height / 2), sizeCell, sizeCell);
            g.fillRect((width / 2) + sizeCell, (height / 2) + (2 * sizeCell), sizeCell, sizeCell);

            g.fillRect((width / 2), (height / 2) + (2 * sizeCell), sizeCell, sizeCell);
            g.fillRect((width / 2) - sizeCell, (height / 2) + (sizeCell), sizeCell, sizeCell);
            g.fillRect((width / 2) + (2 * sizeCell), (height / 2) + (sizeCell), sizeCell, sizeCell);
            cells[width/20][(height / 20) ].alive();
            cells[(width/20)+1][(height / 20) ].alive();
            cells[(width/20)+1][(height / 20)+2 ].alive();

            cells[width/20][(height / 20)+2 ].alive();
            cells[(width/20)-1][(height / 20)+1 ].alive();
            cells[(width/20)+2][(height / 20)+1 ].alive();


        } else if (startingStatus.equals("Random")) {
            for (int i = 0; i < generator.nextInt(width); i++) {
                int xRandom=generator.nextInt(width/10) * sizeCell;
                int yRandom=generator.nextInt(height/10) * sizeCell;
                g.fillRect(xRandom, yRandom, sizeCell, sizeCell);
                cells[xRandom/sizeCell][yRandom/sizeCell].alive();
            }
        }
    }

    /*
    E F D
    G X C   //W taki sposob oznaczalem punkty w macierzy, X to srodkowy, na dole przypiska zeby sie nie pomylic
    H A B
     */

    public void game2(DataManager dm, Cell[][] cells){
        int numberOfAlive=0;
        for(int x=0;x<dm.getNumCellsWidth();x++) {
            for (int y = 0; y < dm.getNumCellsHeight(); y++) {
                //Boundary Conditions
                //Side points
                if(x==0) { //0,0
                    if (y == 0) {
                        if (cells[dm.getNumCellsWidth() - 1][dm.getNumCellsHeight() - 1].getState() == 1){ //F point
                            numberOfAlive++;}
                         if (cells[dm.getNumCellsWidth() - 1][0].getState() == 1){ //G
                            numberOfAlive++;}
                         if (cells[dm.getNumCellsWidth() - 1][y + 1].getState() == 1){//H
                            numberOfAlive++;}
                         if (cells[0][dm.getNumCellsHeight() - 1].getState() == 1){ //F
                            numberOfAlive++;}
                         if (cells[x + 1][dm.getNumCellsHeight() - 1].getState() == 1){ //D
                            numberOfAlive++;}
                         if (cells[x + 1][y + 1].getState() == 1){ //B
                            numberOfAlive++;}
                         if (cells[x][y + 1].getState() == 1){ //A
                            numberOfAlive++;}
                         if (cells[x + 1][y].getState() == 1){ //C
                            numberOfAlive++;}
                    } else if (y == dm.getNumCellsHeight() - 1) { //X=0, Y=max
                        if (cells[x][0].getState() == 1){ //A
                            numberOfAlive++;}
                         if (cells[x + 1][0].getState() == 1){ //B
                            numberOfAlive++;}
                         if (cells[x + 1][y].getState() == 1){ //C
                            numberOfAlive++;}
                         if (cells[x + 1][y - 1].getState() == 1){ //D
                            numberOfAlive++;}
                         if (cells[x][y - 1].getState() == 1){ //E
                            numberOfAlive++;}
                         if (cells[dm.getNumCellsWidth() - 1][y - 1].getState() == 1){ //F
                            numberOfAlive++;}
                         if (cells[dm.getNumCellsWidth() - 1][y].getState() == 1){ //G
                            numberOfAlive++;}
                         if (cells[dm.getNumCellsWidth() - 1][0].getState() == 1){ //H
                            numberOfAlive++;}
                    }
                }
                if(x==dm.getNumCellsWidth()-1) { //max,max
                    if (y == dm.getNumCellsHeight() - 1) {
                        if (cells[dm.getNumCellsWidth() - 1][0].getState() == 1){ //A
                            numberOfAlive++;}
                         if (cells[0][0].getState() == 1){ //B
                            numberOfAlive++;}
                         if (cells[0][dm.getNumCellsHeight() - 1].getState() == 1){ //C
                            numberOfAlive++;}
                         if (cells[0][y - 1].getState() == 1){ //D
                            numberOfAlive++;}
                         if (cells[x][y - 1].getState() == 1){ //E
                            numberOfAlive++;}
                         if (cells[x - 1][y - 1].getState() == 1){ //F
                            numberOfAlive++;}
                         if (cells[x - 1][y].getState() == 1){ //G
                            numberOfAlive++;}
                         if (cells[x - 1][0].getState() == 1){ //H
                            numberOfAlive++;}
                    } else if (y == 0) { //max,0
                        if (cells[x][y + 1].getState() == 1){ //A
                            numberOfAlive++;}
                         if (cells[0][y + 1].getState() == 1){ //B
                            numberOfAlive++;}
                         if (cells[x][0].getState() == 1){ //C
                            numberOfAlive++;}
                         if (cells[0][dm.getNumCellsHeight() - 1].getState() == 1){ //D
                            numberOfAlive++;}
                         if (cells[x][dm.getNumCellsHeight() - 1].getState() == 1){ //E
                            numberOfAlive++;}
                         if (cells[x - 1][dm.getNumCellsHeight() - 1].getState() == 1){ //F
                            numberOfAlive++;}
                         if (cells[x - 1][y].getState() == 1){ //G
                            numberOfAlive++;}
                         if (cells[x - 1][y + 1].getState() == 1){ //H
                            numberOfAlive++;}
                    }

                }
                    //Sides
                    if(x==0 && y!=0 & y!= dm.getNumCellsHeight()-1) { //left side
                        if(cells[x][y+1].getState()==1){ //A
                            numberOfAlive++;}
                         if(cells[x+1][y+1].getState()==1){ //B
                            numberOfAlive++;}
                         if(cells[x+1][y].getState()==1){ //C
                            numberOfAlive++;}
                         if(cells[x+1][y-1].getState()==1){ //D
                            numberOfAlive++;}
                         if(cells[x][y-1].getState()==1){ //E
                            numberOfAlive++;}
                         if(cells[dm.getNumCellsWidth()-1][y-1].getState()==1){ //F
                            numberOfAlive++;}
                         if(cells[dm.getNumCellsWidth()-1][y].getState()==1){ //G
                            numberOfAlive++;}
                         if(cells[dm.getNumCellsWidth()-1][y+1].getState()==1){ //H
                            numberOfAlive++;}
                    }

                    else if(y==dm.getNumCellsHeight()-1 && x!=0 && x!=dm.getNumCellsWidth()-1){ //bottom side
                        if(cells[x][0].getState()==1){ //A
                            numberOfAlive++;}
                         if(cells[x+1][0].getState()==1){ //B
                            numberOfAlive++;}
                         if(cells[x+1][y].getState()==1){ //C
                        numberOfAlive++;}
                         if(cells[x+1][y-1].getState()==1){ //D
                        numberOfAlive++;}
                         if(cells[x][y-1].getState()==1){ //E
                        numberOfAlive++;}
                         if(cells[x-1][y-1].getState()==1){ //F
                        numberOfAlive++;}
                         if(cells[x-1][y].getState()==1){ //G
                        numberOfAlive++;}
                         if(cells[x-1][0].getState()==1){ //H
                        numberOfAlive++;}
                    }
                    else if(x==dm.getNumCellsWidth()-1 && y!=0 && y!=dm.getNumCellsHeight()-1){ //right side0
                        if(cells[x][y+1].getState()==1){ //A
                            numberOfAlive++;}
                         if(cells[0][y+1].getState()==1){ //B
                            numberOfAlive++;}
                         if(cells[0][y].getState()==1){ //C
                            numberOfAlive++;}
                         if(cells[0][y-1].getState()==1){ //D
                            numberOfAlive++;}
                         if(cells[x][y-1].getState()==1){ //E
                            numberOfAlive++;}
                         if(cells[x-1][y-1].getState()==1){ //F
                            numberOfAlive++;}
                         if(cells[x-1][y].getState()==1){ //G
                            numberOfAlive++;}
                         if(cells[x-1][y+1].getState()==1){ //H
                            numberOfAlive++;}
                    }
                    else if(y==0 && x!=0 && x!=dm.getNumCellsWidth()-1){//upper side
                        if(cells[x][y+1].getState()==1){ //A
                            numberOfAlive++;}
                         if(cells[x+1][y+1].getState()==1){ //B
                            numberOfAlive++;}
                         if(cells[x+1][y].getState()==1){ //C
                            numberOfAlive++;}
                         if(cells[x+1][dm.getNumCellsHeight()-1].getState()==1){ //D
                            numberOfAlive++;}
                         if(cells[x][dm.getNumCellsHeight()-1].getState()==1){ //E
                            numberOfAlive++;}
                         if(cells[x-1][dm.getNumCellsHeight()-1].getState()==1){ //F
                            numberOfAlive++;}
                         if(cells[x-1][y].getState()==1){ //G
                            numberOfAlive++;}
                         if(cells[x-1][y+1].getState()==1){ //H
                            numberOfAlive++;}
                    }

                    //Other
                else if(x!=0 && y!=0 && y!=dm.getNumCellsHeight()-1 && x!= dm.getNumCellsWidth()-1){
                    if(cells[x][y+1].getState()==1){ //A
                        numberOfAlive++;}
                     if(cells[x+1][y+1].getState()==1){ //B
                        numberOfAlive++;}
                     if(cells[x+1][y].getState()==1){ //C
                        numberOfAlive++;}
                     if(cells[x+1][y-1].getState()==1){ //D //wrong
                        numberOfAlive++;}
                     if(cells[x][y-1].getState()==1){ //E
                        numberOfAlive++;}
                     if(cells[x-1][y-1].getState()==1){ //F
                        numberOfAlive++;}
                     if(cells[x-1][y].getState()==1){ //G
                        numberOfAlive++;}
                     if(cells[x-1][y+1].getState()==1){ //H
                        numberOfAlive++;}
                    }


                //Change states
                if(cells[x][y].getState()==0 && numberOfAlive==3)
                    cells[x][y].setNextState(1);

                else if(cells[x][y].getState()==1 && (numberOfAlive==2 || numberOfAlive==3))
                    cells[x][y].setNextState(1);

                else if(cells[x][y].getState()==1 && numberOfAlive>3)
                    cells[x][y].setNextState(0);

                else if(cells[x][y].getState()==1 && numberOfAlive<2)
                    cells[x][y].setNextState(0);
                else{
                    cells[x][y].setNextState(cells[x][y].getState());
                }
                numberOfAlive=0;
            }

        }
        refreshState();
    }

    public void checkStatus(){
        int numberOfAlive=0;
        for(Cell[] cells: dm.getStateCells())
            for(Cell cell: cells) {
                if(cell.getState()==1)
                    numberOfAlive++;
            }
        System.out.println("Number of alive:  " +numberOfAlive);
    }

    public void refreshState()
    {
        for(Cell[] cells: dm.getStateCells())
            for(Cell cell: cells)
                cell.changeState();
    }
    public void MouseMakeAlive(int x, int y,Graphics g){
        for(Cell[] cells: dm.getStateCells())
            for(Cell cell: cells)
                if(countDistance(x,y,cell)) {
                    cell.setState(1);
                    g.fillRect(x,y,dm.getSizeCell(), dm.getSizeCell());
                }
    }
    public void reset(){
        for (int i = 0; i < dm.getNumCellsWidth(); i++) {
            for (int j = 0; j < dm.getNumCellsHeight(); j++) {
                dm.getStateCells()[i][j].dead();
            }
        }
    }

    public boolean countDistance(int x, int y,Cell cell){
        if(x> cell.getX() && x< cell.getX()+dm.getSizeCell())
            if(y>cell.getY() && y<cell.getY()+dm.getSizeCell())
                return true;

            return false;
    }
}