import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
     char board[] =new char[]{'1','2','3','4','5','6','7','8','9'};
     char currentPlayer='X';
     System.out.println("Welcome to X and O game");

     System.out.println("Player X goes first");
     System.out.println("The board is numbered as follows");
   print_board(board);
    System.out.println("Do you want to play the game? (Y/N)");
    Scanner input = new Scanner(System.in);
    char choice = input.next().charAt(0);

    while(choice == 'Y' || choice == 'y'){
        X_O_game();
        System.out.println("Do you want to play again? (Y/N)");
        choice = input.next().charAt(0);}
        input.close();
        System.out.println("Thank you for playing!");
    }
    public static char check_winner(char[] board,char currentPlayer){
        if((board[8] == board[5] && board[5] == board[2]) ||
            (board[7] == board[4] && board[4] == board[1]) ||
            (board[6] == board[3] && board[3] == board[0]) ||
            (board[0] == board[1] && board[1] == board[2]) ||
            (board[3] == board[4] && board[4] == board[5]) ||
            (board[6] == board[7] && board[7] == board[8]) ||
            (board[0] == board[4] && board[4] == board[8]) ||
            (board[2] == board[4] && board[4] == board[6])){
                return currentPlayer;
            }
            return 0;
    }
    public static boolean check_finish(char[] board){
        for(int i=0;i<board.length;i++)
            if(board[i]=='X'||board[i]=='O')
                return false;
        return true;
    }
    public static boolean check_valid_move(char[] board,int move){
        if(move<1||move>9){
            System.out.println("Invalid move. Please enter a number between 1 and 9.");
            return false;
        }
        if(board[move-1]=='X'||board[move-1]=='O'){
            System.out.println("Invalid move. The cell is already occupied.");
            return false;
        }
        return true;
    }
    public static void X_O_game(){
        char board[] =new char[]{'1','2','3','4','5','6','7','8','9'};
        char currentPlayer='X';
        System.out.println("Welcome to X and O game");

        System.out.println("Player X goes first");
        System.out.println("The board is numbered as follows");
        print_board(board);
         Scanner input = new Scanner(System.in);
           for(int i=0;i<9;i++){
               System.out.println("your turn player "+currentPlayer+" enter your move");
               int move;
               try{
                move=input.nextInt();
               }
               catch(Exception inputMismatchException){
                   System.out.println("Invalid input");
                   input.next(); // Clear the invalid input
                   i--;
                   continue;
               }
                if(!check_valid_move(board,move)) {
                    i--;
                    continue;
                }
              board[move-1]=currentPlayer;
                print_board(board);
               char winner=check_winner(board,currentPlayer);
               if(winner!=0){
                   System.out.println("Player "+winner+" wins");
                   break;
               }
               if(check_finish(board)){
                   System.out.println("Game is draw");
                   break;
               }
               currentPlayer=(currentPlayer=='X')?'O':'X';
           }
           
    }
    public static void print_board(char[] board){
        for(int i=0;i<9;i+=3){
            System.out.println(" "+board[i]+" | "+board[i+1]+" | "+board[i+2]);
            if(i<6){
                System.out.println("-----------");
            }
        }
    }
    public static void clear_screen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
