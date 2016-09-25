
/**
 * Write a description of class computerChoice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class computerChoice extends choice
{
   
    gamestate gschoice;
    /**
     * Constructor for objects of class computerChoice
     */
    public computerChoice()
    {
       gschoice = new gamestate();
    }

    public int nextMove(gamestate gs, int player, boolean root){
       //System.out.print("C");
        gamestate[] moves = gs.legalMoves(player);
       // System.out.print("D");
        for(gamestate g : moves){
            //while(!g.finished){
             
                if(g.state() != 0){
                    
                   // System.out.print("*");
                    g.close();
                    g.winner = g.state();
                } else{
                   // System.out.println("!");
                    g.winner = nextMove(g,(player%2) + 1, false);
                    g.close();
                }
            //}
                        
            
        }
        int score = 0;
        for(gamestate g : moves){
            if(g.winner == player){
                score = 2;
            } else if(g.winner == 3 && score < 2){
                score = 1;
            }
        }
        if(root){
            display d = new display();
           // System.out.println("E");
            for(gamestate g : moves){
                if(score == 2 && g.winner == player){
                    gschoice = g;
                } else if(score == 1 && g.winner == 3){
                    gschoice = g;
                    
                    
                } else if(score == 0){
                    gschoice = g;
                    System.out.print("Something went horribly wrong :(");
                }
            }
            // d.display(gschoice);
        }
       
        if(score == 2){
            return player;
        }else if(score == 1){
            return 3;
        } else{
            return (player%2) + 1;
        }
    }
    
}
