
/**
 * Write a description of class gamestate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gamestate
{
    boolean finished;
    int[][] boardState;
    victory v;
    int winner;
    /**
     * Constructor for objects of class gamestate
     */
    public gamestate()
    {
       finished = false;
       this.boardState = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
       v = new victory();
       winner = 0;
    }
     public gamestate(int[][] bs)
    {
       finished = false;
       this.boardState = bs;
       v = new victory();
       winner = 0;
    }
    public boolean move(int i, int x, int y, gamestate gs){
        try{
        if(gs.boardState[x][y] != 0){
            //System.out.println("; " + gs.boardState[x][y]);
            return false;
            
        }else{
            
            gs.boardState[x][y] = i;
            return true;
        }}catch(ArrayIndexOutOfBoundsException e){ System.out.println(e + "I");return false;}
        
    }
    public gamestate potentialMove(int i, int x, int y){
        int[][] newBS = new int[3][3];
        int j = 0;
        int h = 0;
        for(int[] ii : boardState){
            for(int o : ii){
                newBS[h][j] = boardState[h][j];
                j++;
            }
            j = 0;
            h++;
        }
        gamestate gs = new gamestate(newBS);
        int[][] ii = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        if(!gs.move(i,x,y,gs)){
            return null;
        }
        return gs;
    }
    public void close(){
        finished = false;
        
    }
    public int state(){
        try{return v.check(boardState);}
        catch(NullPointerException e){
            return 0;
        }
        
    }
    public gamestate[] legalMoves(int player){
        int c = 0;
        for(int[] ii : boardState){
            for(int i : ii){
                if(i == 0){
                    c++;
                }
            }
        }
        gamestate[] gs = new gamestate[c];
        //System.out.println(c);
        int j = 0;
        int h = 0;
        int k = 0;
        display d = new display();
        for(int[] ii : boardState){
            for(int i : ii){
                gamestate gsP = potentialMove(player,h,k);
                if(gsP != null){
                    gs[j] = gsP;
                    //d.display(gs[j]);
                    j++;
                   // System.out.println();
                }
             
             k++;
            }
        h++;
        k = 0;
        }
        for(gamestate g : gs){
           // d.display(g);
        }
        return gs;
    }
}
