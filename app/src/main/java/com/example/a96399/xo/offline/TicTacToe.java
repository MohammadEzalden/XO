package com.example.a96399.xo.offline;

public class TicTacToe {
    public boolean checkComplete(char board[][]) {


        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if(board[i][j]=='_')return false;
            }
        }
        return true;
    }

    public int evaluateBoard(char board[][]) {

        // O -10   // X +10

        //rows
        for(int i=0;i<3;i++){
            if(board[i][0]==board[i][1]&&board[i][1]==board[i][2]){
                if (board[i][0]=='o')return -10;
                if (board[i][0]=='x')return 10;
            }
        }

        //columns
        for(int i=0;i<3;i++){
            if(board[0][i]==board[1][i]&&board[1][i]==board[2][i]){
                if(board[1][i]=='o')return -10;
                if (board[1][i]=='x') return 10;
            }

        }

        //diagonals
        if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]){
            if(board[0][0]=='o')return -10;
            if (board[0][0]=='x') return 10;
        }
        if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]){
            if(board[1][1]=='o')return -10;
            if (board[1][1]=='x') return 10;
        }

        return 0;
    }

    public int heuristic(char board[][]){
        int sum=0;
        for(int i=0;i<3;i++){
            if(board[i][0]!='o'&&board[i][1]!='o'&&board[i][2]!='o')sum++;

            if(board[0][i]!='o'&&board[1][i]!='o'&&board[2][i]!='o')sum++;
        }

        if(board[0][0]!='o'&&board[1][1]!='o'&&board[2][2]!='o')sum++;
        if(board[0][2]!='o'&&board[1][1]!='o'&&board[2][0]!='o')sum++;

        // enemy
        for(int i=0;i<3;i++){
            if(board[i][0]!='x'&&board[i][1]!='x'&&board[i][2]!='x')sum--;

            if(board[0][i]!='x'&&board[1][i]!='x'&&board[2][i]!='x')sum--;
        }

        if(board[0][0]!='x'&&board[1][1]!='x'&&board[2][2]!='x')sum--;
        if(board[0][2]!='x'&&board[1][1]!='x'&&board[2][0]!='x')sum--;

        return sum;

    }

    public int minimax(char board[][], int depth, boolean isMaxTurn) {


        int evalu=evaluateBoard(board);
        if(evalu==10||evalu==-10||depth>4)return evalu+heuristic(board);
        if(checkComplete(board))return 0;

        if(isMaxTurn){
            int best=-99999;
            for (int i=0;i<3;i++)
                for (int j=0;j<3;j++)
                    if(board[i][j]=='_'){
                        board[i][j]='x';
                        best=Math.max(best,minimax(board,depth+1,!isMaxTurn));
                        board[i][j]='_';
                    }
            return best;
        }

        int best=99999;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                if(board[i][j]=='_'){
                    board[i][j]='o';
                    best=Math.min(best,minimax(board,depth+1,!isMaxTurn));
                    board[i][j]='_';
                }
        return best;


    }

    public Cell bestMove(char board[][]) {

        int best=-9999;
        Cell cell=new Cell(-1,-1);
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++){
                if (board[i][j]=='_'){
                    board[i][j]='x';
                    int minmax=minimax(board,0,false);
                    if(minmax>best){
                        best=minmax;
                        cell.x=i;
                        cell.y=j;
                    }
                    board[i][j]='_';
                }
            }

        return cell;
    }
}
