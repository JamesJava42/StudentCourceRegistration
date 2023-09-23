package Assignment_algo.DAA;

public class Nqueentask {

    // global variables
    private static int N;
    private static int[] board;

    public static void main(String []args){
        int N = 4;

        // solveQueen methods
        if(solveQueen(N)){

            printSolution();

        }
    }

     public static boolean solveQueen(int n){
        // initilising the global variables
        N = n;
        board = new int[N];

        return queenLogicSolve(0);






     }

    private static boolean queenLogicSolve(int col) {

        if(col == N){
            return true;
        }

        for(int row=0;row < N;row++){
            boolean checkState = isSafe(row,col);

            if(checkState){


                board[col] = row;
                if (queenLogicSolve(col + 1)) {
                    return true;
                }
              
                board[col] = 0;
            }
        }
        return false;

        
    }

    private static boolean isSafe(int row, int col) {
        for(int pcol=0;pcol< col;pcol++){
            if(board[pcol] == row  || 
            Math.abs(board[pcol] - row) == Math.abs(pcol - col)){
                return false;
            }
        }
        return true;
        
    }

    public static void printSolution() {
        for (int row : board) {
            for (int col = 0; col < N; col++) {
                if (row == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
    
}
