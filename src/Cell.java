public class Cell {

   private int x,y;
   private int state;
   private int nextState;



    Cell(int x, int y, int state){
       this.x=x;
       this.y=y;
       this.state=state;
   }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setNextState(int nextState){
        this.nextState=nextState;
    }

    public void changeState(){state=nextState;}

    public void dead(){ this.state=0; }
    public void alive(){this.state=1; }
}

