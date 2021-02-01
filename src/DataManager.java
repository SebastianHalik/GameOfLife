


public class DataManager {
    private int boardWidth, boardHeight;
    private int cellSize;
    private int numCellsWidth;
    private int numCellsHeight;
    private Cell [][] stateCells;


    public DataManager(int width, int boardHeight, int sizeCell) {
        this.boardWidth = width;
        this.boardHeight = boardHeight;
        this.cellSize = sizeCell;
        initNumCells();
        initStateCells();
    }

    public void initStateCells(){
        this.stateCells=new Cell[this.numCellsWidth][this.numCellsHeight];
        for(int i=0;i<this.numCellsWidth;i++)
            for(int j=0;j<this.numCellsHeight;j++) {
                this.stateCells[i][j] = new Cell(i * this.cellSize, j * this.cellSize, 0);
            }
    }

    public void initNumCells(){
        this.numCellsWidth= this.boardWidth/cellSize;
        this.numCellsHeight=this.boardHeight /cellSize;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public void setWidth(int width) {
        this.boardWidth = width;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public int getSizeCell() {
        return cellSize;
    }

    public void setSizeCell(int sizeCell) {
        this.cellSize = sizeCell;
    }

    public int getNumCellsWidth() {
        return numCellsWidth;
    }

    public void setNumCellsWidth(int numCellsWidth) {
        this.numCellsWidth = numCellsWidth;
    }

    public int getNumCellsHeight() {
        return numCellsHeight;
    }

    public void setNumCellsHeight(int numCellsHeight) {
        this.numCellsHeight = numCellsHeight;
    }

    public Cell[][] getStateCells() {
        return stateCells;
    }

    public void setStateCells(Cell[][] stateCells) {
        this.stateCells = stateCells;
    }
}
