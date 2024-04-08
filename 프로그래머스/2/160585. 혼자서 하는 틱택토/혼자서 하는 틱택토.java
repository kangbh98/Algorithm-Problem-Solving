class Solution {
    

    static char board1[][];
    static int oBingo = 0;
    static int xBingo = 0;

    public int solution(String[] board) {
        
        int n = board[0].length();
        board1 = new char[board.length][n];
        int oCount = 0;
        int xCount = 0;

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < n ; j++){
                board1[i][j] = board[i].charAt(j);
                if(board1[i][j] == 'X') xCount++;
                else if(board1[i][j] == 'O') oCount++;
            }
        }

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(board1[i][j]+" ");
            }
            System.out.println();
        }
        
        // 가로
        if(board1[0][0] == 'O' && board1[0][1] == 'O' && board1[0][2] == 'O'){
            oBingo++;
        }else if(board1[0][0] == 'X' && board1[0][1] == 'X' && board1[0][2] == 'X'){
            xBingo++;
        }        
        if(board1[1][0] == 'O' && board1[1][1] == 'O' && board1[1][2] == 'O'){
            oBingo++;
        }else if(board1[1][0] == 'X' && board1[1][1] == 'X' && board1[1][2] == 'X'){
            xBingo++;
        }        
        if(board1[2][0] == 'O' && board1[2][1] == 'O' && board1[2][2] == 'O'){
            oBingo++;
        }else if(board1[2][0] == 'X' && board1[2][1] == 'X' && board1[2][2] == 'X'){
            xBingo++;
        }
        
        //세로
        if(board1[0][0] == 'O' && board1[1][0] == 'O' && board1[2][0] == 'O'){
            oBingo++;
        }else if(board1[0][0] == 'X' && board1[1][0] == 'X' && board1[2][0] == 'X'){
            xBingo++;
        }
        if(board1[0][1] == 'O' && board1[1][1] == 'O' && board1[2][1] == 'O'){
            oBingo++;
        }else if(board1[0][1] == 'X' && board1[1][1] == 'X' && board1[2][1] == 'X'){
            xBingo++;
        }
        if(board1[0][2] == 'O' && board1[1][2] == 'O' && board1[2][2] == 'O'){
            oBingo++;
        }else if(board1[0][2] == 'X' && board1[1][2] == 'X' && board1[2][2] == 'X'){
            xBingo++;
        }

        //대각
        if(board1[0][0] == 'O' && board1[1][1] == 'O' && board1[2][2] == 'O'){
            oBingo++;
        }else if(board1[0][0] == 'X' && board1[1][1] == 'X' && board1[2][2] == 'X'){
            xBingo++;
        }
        if(board1[2][0] == 'O' && board1[1][1] == 'O' && board1[0][2] == 'O'){
            oBingo++;
        }else if(board1[2][0] == 'X' && board1[1][1] == 'X' && board1[0][2] == 'X'){
            xBingo++;
        }
        
        System.out.println(oBingo);
        System.out.println(xBingo);
        
        
        if(xBingo == 0 && oBingo > 0  && oCount == xCount+1){
            return 1;
        }else if(xBingo > 0 && oBingo == 0 && xCount == oCount){
            return 1;
        }else if(xBingo == 0 && oBingo==0 && (oCount == xCount+1 || oCount == xCount)){
            return 1;
        }else{
            return 0;
        }
    }  
}