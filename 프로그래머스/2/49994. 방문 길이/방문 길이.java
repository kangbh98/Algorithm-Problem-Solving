class Solution {
    
    static class node{
        boolean u;
        boolean d;
        boolean r;
        boolean l;
        
        public node(){
            
        }
    }

    static node[][] board = new node[11][11];

    public int solution(String dirs) {
 
        for(int i = 0 ; i <= 10 ; i++){
            for(int j = 0 ; j<= 10 ; j++){
                board[i][j] = new node();
            }
        }
        
        int X = 5;
        int Y = 5;
        int firstWay = 0;
        
        for(int i = 0 ; i < dirs.length(); i++){
            
            char char1 = dirs.charAt(i);
            int xd = X;
            int yd = Y;
            
            if(char1 == 'U'){
                xd -= 1;
                
                if(xd > -1 && yd > -1 && xd < 11 && yd < 11){
                
                if(!board[X][Y].u && !board[xd][yd].d){
                    board[X][Y].u = true;
                    firstWay++;
                }  
                X = xd;
                Y = yd;
                }
                
            }else if(char1 == 'D'){
                xd += 1;
                
                if(xd > -1 && yd > -1 && xd < 11 && yd < 11){
                
                if(!board[X][Y].d  && !board[xd][yd].u){
                    board[X][Y].d = true;
                    firstWay++;
                }  
                X = xd;
                Y = yd;
                }
                
            }else if(char1 == 'R'){
                yd += 1;
                
                if(xd > -1 && yd > -1 && xd < 11 && yd < 11){
                
                if(!board[X][Y].r  && !board[xd][yd].l){
                    board[X][Y].r = true;
                    firstWay++;
                }  
                X = xd;
                Y = yd;
                }
                
            }else if(char1 == 'L'){
                yd -= 1;
                
                if(xd > -1 && yd > -1 && xd < 11 && yd < 11){
                
                if(!board[X][Y].l  && !board[xd][yd].r){
                    board[X][Y].l = true;
                    firstWay++;
                }  
                X = xd;
                Y = yd;
                }
                
            }
            

        }
            
        return firstWay;
    }
}