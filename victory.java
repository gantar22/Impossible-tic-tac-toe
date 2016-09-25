
/**
 * Write a description of class victory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class victory
{
    // instance variables - replace the example below with your own
    int winner;
    boolean full;
    boolean tie;
    
    
    /**
     * Constructor for objects of class victory
     */
    public victory()
    {
         winner = 0;
         boolean full = true;
        boolean tie = false;
    }
    
    public int check(int[][] gs){try{
          boolean full = true;
        boolean tie = false;
        for(int i = 0; i < 3; i++){
            if(gs[0][i] == gs[1][i] && gs[1][i] == gs[2][i] && gs[0][i] != 0){
                //    System.out.println("K");
                winner = gs[0][i];
            }
        }
        for(int[] ii : gs){
            if(ii[0] != 0 && ii[0] == ii[1] && ii[2] == ii[1]){
                //System.out.println("G");
                winner = ii[0];
            }
            
        }
        if(gs[0][0] == gs[1][1] && gs[1][1] == gs[2][2] && gs[1][1] != 0){
            //System.out.println("P");
            winner = gs[0][0];
        }
        if(gs[0][2] == gs[1][1] && gs[1][1] == gs[2][0] && gs[1][1] != 0){
            //System.out.println("R");
            winner = gs[1][1];
        }
        for(int[] ii : gs){
            for(int i : ii){
                if(i == 0){
                    full = false;
                }
            }
        }
        if(full && winner == 0){
            tie = true;
        }
        if(tie){
           // System.out.print("tie");
            
            return 3;
        } else{
            if(winner == 1){
               // System.out.println("O");
               
                return 1;
            }
            if(winner == 2){
               // System.out.println("X");
                
                return 2;
            }
        }
        return 0;}catch(NullPointerException e){System.out.println("nullP"); return 0;}
        
    }
    
}
