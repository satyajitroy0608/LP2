import java.util.ArrayList;
import java.util.Scanner;


class NQueens{
    int counter = 0;
    void NQueensSolver(int n){
        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[2*n - 1];
        boolean[] rdiag = new boolean[2*n - 1];
        ArrayList<Integer> soln = new ArrayList<>();
        
        Solve(board, 0, cols, diag, rdiag, soln);
        System.out.println("Total possibilities : "+counter);

    }

    void Solve(boolean board [][], int row,boolean[] cols, boolean[] diag,boolean[] rdiag, ArrayList<Integer> soln ){
        

        if(row == board.length){
            counter++;

            for(int i =0;i<soln.size();i++){
                System.out.print(soln.get(i)+"  ");
            }
            System.out.println();

        }
        
        
        for(int col = 0;col<board[0].length;col++){
            if(cols[col] ==false && diag[row+col]==false && rdiag[row-col + board[0].length-1]==false ){
                soln.add(col);
                cols[col] = true;
                diag[row+col]=true;
                rdiag[row-col + board[0].length-1] = true;
                board[row][col] = true;
                Solve(board, row+1, cols, diag, rdiag,soln);
                soln.clear();
                board[row][col] = true;
                cols[col] = false;
                diag[row+col]=false;
                rdiag[row-col + board[0].length-1] = false;
            }
        }
    }
}



public class A4{

    

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        boolean doWork = true;

        while(doWork){
            
            
            System.out.println("*****MENU*****");
            System.out.println("1. N-Queens");
            System.out.println("2. Graph Coloring");
            System.out.println("3. Exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    
                    NQueens nq = new NQueens();
                    System.out.println("Enter the value of N: ");
                    int inp2 = sc.nextInt();
                    nq.NQueensSolver(inp2);
                    break;
                
                case 2:


                    break;

                case 3 :

                    doWork = false;
                    break;
                default:
                    System.out.println("Enter Valid Input");
                    break;
            }

        }

        sc.close();


    }

}