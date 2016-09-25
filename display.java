
/**
 * Write a description of class display here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class display
{
    public void display(gamestate gs){
        int j = 0;
        int h = 0;
        
        for(int[] ii : gs.boardState){
             
            for(int i : ii){
               j++;
                if(i == 0){
                    if(h != 2){System.out.print("_");}else{System.out.print(" ");}
                } else if(i == 1){
                    System.out.print("O");
                } else if(i == 2){
                    System.out.print("X");
                }
                if(j != 3){System.out.print("|");}
                
            }
            h++;
            j = 0;
            System.out.println();
        }
    }
}
