package com.example.a96399.xo.offline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a96399.xo.R;

public class OffLineActivity extends AppCompatActivity implements View.OnClickListener{

    Button restart;
    Button arrayButton[][];
    char board [][];
    TicTacToe ticTacToe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_off_line);

        arrayButton=new Button[3][3];
        arrayButton[0][0]=findViewById(R.id.b00);
        arrayButton[0][0].setOnClickListener(this);
        arrayButton[0][1]=findViewById(R.id.b01);
        arrayButton[0][1].setOnClickListener(this);
        arrayButton[0][2]=findViewById(R.id.b02);
        arrayButton[0][2].setOnClickListener(this);

        arrayButton[1][0]=findViewById(R.id.b10);
        arrayButton[1][0].setOnClickListener(this);
        arrayButton[1][1]=findViewById(R.id.b11);
        arrayButton[1][1].setOnClickListener(this);
        arrayButton[1][2]=findViewById(R.id.b12);
        arrayButton[1][2].setOnClickListener(this);

        arrayButton[2][0]=findViewById(R.id.b20);
        arrayButton[2][0].setOnClickListener(this);
        arrayButton[2][1]=findViewById(R.id.b21);
        arrayButton[2][1].setOnClickListener(this);
        arrayButton[2][2]=findViewById(R.id.b22);
        arrayButton[2][2].setOnClickListener(this);


        board=new char[][]{
            { '_', '_', '_' },
            { '_', '_', '_' },
            { '_', '_', '_' }
        };



        ticTacToe=new TicTacToe();
        ticTacToe.bestMove(board);



    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.b00:
                board[0][0]='o';
                arrayButton[0][0].setText("X");
                arrayButton[0][0].setEnabled(false);
                break;
            case R.id.b01:
                board[0][1]='o';
                arrayButton[0][1].setText("X");
                arrayButton[0][1].setEnabled(false);
                break;

            case R.id.b02:
                board[0][2]='o';
                arrayButton[0][2].setText("X");
                arrayButton[0][2].setEnabled(false);
                break;

                ////// 1
            case R.id.b10:
                board[1][0]='o';
                arrayButton[1][0].setText("X");
                arrayButton[1][0].setEnabled(false);
                break;

            case R.id.b11:
                board[1][1]='o';
                arrayButton[1][1].setText("X");
                arrayButton[1][1].setEnabled(false);
                break;

            case R.id.b12:
                board[1][2]='o';
                arrayButton[1][2].setText("X");
                arrayButton[1][2].setEnabled(false);
                break;
            ///// 2

            case R.id.b20:
                board[2][0]='o';
                arrayButton[2][0].setText("X");
                arrayButton[2][0].setEnabled(false);
                break;

            case R.id.b21:
                board[2][1]='o';
                arrayButton[2][1].setText("X");
                arrayButton[2][1].setEnabled(false);
                break;

            case R.id.b22:
                board[2][2]='o';
                arrayButton[2][2].setText("X");
                arrayButton[2][2].setEnabled(false);
                break;

        }
        Cell bestCell = ticTacToe.bestMove(board);
        if (bestCell.x!=-1&&bestCell.y!=-1) {
            board[bestCell.x][bestCell.y] = 'x';
            arrayButton[bestCell.x][bestCell.y].setText("O");
            arrayButton[bestCell.x][bestCell.y].setEnabled(false);
        }
    }

    public void restartFunction(View view) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arrayButton[i][j].setEnabled(true);
                arrayButton[i][j].setText("");
                board[i][j]='_';
            }
        }
    }
}
