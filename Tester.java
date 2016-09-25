
/**
 * This game plays tic tac toe
 * 
 * 
 * @author Nathan Williams
 * @version April 17 2016
 */
import java.util.*;
public class Tester
{
    int[][] pseudogs;
    public static void Main(String[] args){
        Scanner in = new Scanner(System.in);
        gamestate gs = new gamestate();
        
        int[][] pseudogs = {{1,2,1},{2,1,2},{2,1,0}};
        //gs.boardState = pseudogs;
            
       
        
        game(in,gs);
        
    }
    public static int promptTurn(Scanner in){
        int answer = 0;
       boolean stop = false;
        while(!stop){
        System.out.println("Do you want to go first (1) or second (2)?");
        answer = in.nextInt();
        if(answer == 1 || answer == 2){
            stop = true;
        } else{
            System.out.println("Whoops, try a 1 or a 2");
        }
       }
       return answer;
    }
    public static void game(Scanner in, gamestate gs){
        display d = new display();
         victory v = new victory();
        computerChoice cpu = new computerChoice();
        int cpuTurn = 2;
        int playerTurn = 1;
        boolean again = true;
        String strA;
        int x;
        int y;
        String wait;
        while(again){
            cpu = new computerChoice();
            v = new victory();
            cpuTurn = 2;
            playerTurn = 1;
            
          if(promptTurn(in) == 2){
              cpuTurn = 1;
              playerTurn = 2;
            cpu.nextMove(gs,1,true);
            gs = cpu.gschoice;
        }
        
        d.display(gs);
        
        
        while(v.check(gs.boardState) == 0){
            
            boolean stop = false;
            while(!stop){
                System.out.println("enter your move as the location (with the origin{0,0} in the bottom left corner): x y ");
                try{
                x = in.nextInt();
                y = 2 - in.nextInt();
            }catch(InputMismatchException e){x = 3; y =3;}
               
                if(gs.move(playerTurn,y,x,gs)){
                    stop = true;
                    //gs = gs.potentialMove(playerTurn,y,x);
                  
                } else{
                    System.out.println("That seems to not be a valid move, please try again");
                }
            }
            System.out.println();
            d.display(gs);
            
            System.out.println();
            wait = in.nextLine();
            cpu.nextMove(gs,cpuTurn,true);
            gs = cpu.gschoice;
            d.display(gs);
           // System.out.print(v.check(gs.boardState));
            System.out.println();
        }
        if(v.check(gs.boardState) == 3){
            System.out.println("It was a tie! Good job. Do you want to play again? (y/n)");                 
        }
        if(v.check(gs.boardState) == cpuTurn){
            System.out.println("The cpu won! Nice try. Do you want to play again? (y/n)");
        }
          boolean yn = true;
            while(yn){
                    strA = in.nextLine();
            if(strA.equals("n")){
                again = false;
                yn = false;
            } else if(!strA.equals("y")){
                System.out.println("That was not a proper response, please try a y or an n.");
            } else{
                gs = new gamestate();
                yn = false;
            }
        }
    }
    }
}
