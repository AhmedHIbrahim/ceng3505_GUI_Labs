package com.example.tictactoe;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Variables
    static final String Player1 = "X";
    static final String Player2 = "O";
    boolean firstPlayerTurn = true;

    byte[][] board = new byte[3][3];


    static final byte Empty_Value = 0;
    static final byte Player_1_Value = 1;
    static final byte Player_2_Value = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout layout = findViewById(R.id.board);
        for (int i = 0; i < 3; i++) {
            TableRow row = (TableRow) layout.getChildAt(i);
            for (int j = 0; j < 3; j++) {
                //Create 0-9 Buttons
                Button btn = (Button) row.getChildAt(j);
                //Link a button to a clickListener method
                btn.setOnClickListener(new CellListener(i, j));
            }
        }
        if (savedInstanceState != null) {
            firstPlayerTurn = savedInstanceState.getBoolean("turn");
            byte[] arr = savedInstanceState.getByteArray("board");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = arr[i * 3 + j];
                }
            }

        }
    }

    class CellListener implements View.OnClickListener {
        int row, column;

        public CellListener(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public void onClick(View v) {

            if (board[row][column] != Empty_Value) {
                //make Toast -- Cell ıs already occupied
                Toast.makeText(MainActivity.this, "Cell is full", Toast.LENGTH_LONG).show();
            } else if (firstPlayerTurn) {
                ((Button) v).setText(Player1);
                board[row][column] = Player_1_Value;
                playerValue = Player_1_Value;
                Log.i("msg", "Clicked" + board[row][column]);
                firstPlayerTurn = !firstPlayerTurn;
            } else {
                ((Button) v).setText(Player2);
                board[row][column] = Player_2_Value;
                playerValue = Player_2_Value;
                Log.i("msg", "Clicked" + board[row][column]);
                firstPlayerTurn = !firstPlayerTurn;
            }

            int gameState = gameEnded(row, column, playerValue);
            if (gameState > 0) {
                Toast.makeText(MainActivity.this, "Player " + playerValue + " Won", Toast.LENGTH_LONG).show();
                setEnabled(false);
            }
        }

        byte playerValue = Empty_Value;
        int gameState = gameEnded(row, column, playerValue);

    }

    public boolean isValidMove(int row, int column) {
        return false;
    }

    public int gameEnded(int row, int column, byte player_Value) {
        boolean win = true;

        //check column
        //0-column
        //1-column
        //2-column
        for (int r = 0; r < 3; r++) {
            if (board[r][column] != player_Value) {
                win = false;
                break;
            }
        }
        if (win) {
            return player_Value;
        }

        //Check row
        //row-0
        //row-1
        //row-2
        win = true;
        for (int c = 0; c < 3; c++) {
            if (board[row][c] != player_Value) {
                win = false;
                break;
            }
        }
        if (win) {
            return player_Value;
        }

        //Check diagonal left to right
        //0-0
        //1-1
        //2-2
        win = true;
        for (int r = 0, c = 0; r < 3 && c < 3; r++, c++) {
            if (board[r][c] != player_Value) {
                win = false;
                break;
            }
        }
        if (win) {
            return player_Value;
        }

        //Check diagonal right to left
        //0-2
        //1-1
        //2-0
        win = true;

        for (int r = 0, c = 2; r < 3; r++, c--) {
            if (board[r][c] != player_Value) {
                win = false;
                break;
            }
        }
        if (win) {
            return player_Value;
        }

        return -1;
    }

    void setEnabled(boolean enable) {
        TableLayout layout = findViewById(R.id.board);
        for (int i = 0; i < 3; i++) {
            TableRow row = (TableRow) layout.getChildAt(i);
            for (int j = 0; j < 3; j++) {
                //Create 0-9 Buttons
                Button btn = (Button) row.getChildAt(j);
                //Link a button to a clickListener method
                btn.setEnabled(enable);
            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putByteArray("board", toArray(board));
        outState.putBoolean("turn", firstPlayerTurn);
    }

    public byte[] toArray(byte[][] b) {
        int row = b.length;
        int col = b[0].length;
        byte[] arr = new byte[row * col];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i * 3 + j] = board[i][j];
            }
        }
        return arr;
    }

    public boolean NewGame(MenuItem item) {
        setEnabled(true);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Empty_Value;
            }
        }
        TableLayout layout = findViewById(R.id.board);
        for (int i = 0; i < 3; i++) {
            TableRow row = (TableRow) layout.getChildAt(i);
            for (int j = 0; j < 3; j++) {
                //Create 0-9 Buttons
                Button btn = (Button) row.getChildAt(j);
                //Link a button to a clickListener method
                btn.setText("");
            }
        }
        return true;
    }

    public boolean SaveGame(MenuItem item) {
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();


        long b = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b += (long) (board[i][j] * Math.pow(10,i*3+j));

            }
        }
        editor.putLong("board",b);
        editor.putBoolean("turn",firstPlayerTurn);
        editor.commit();
        return true;
    }

    public boolean LoadGame(MenuItem item) {
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);

        firstPlayerTurn = preferences.getBoolean("turn",true);
        long b = preferences.getLong("board",0);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (byte) ((b / Math.pow(10,i*3+j)) % 10);
            }
        }

        //update buttons
        TableLayout layout = findViewById(R.id.board);
        for (int i = 0; i < 3; i++) {

            TableRow row = (TableRow) layout.getChildAt(i);
            for (int j = 0; j < 3; j++) {
                Button btn = (Button) row.getChildAt(j);
                switch (board[i][j]){
                    case 0: btn.setText("");
                            break;
                    case 1: btn.setText(Player1);
                            break;
                    case 2: btn.setText(Player2);
                            break;
                }

            }
        }

        return true;
    }
}
