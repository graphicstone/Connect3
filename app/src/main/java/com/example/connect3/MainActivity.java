package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int chance = 0;
    int[] pos = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    public void dropIn(View view) {
        Log.i("info", "Button Pressed");
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);
        counter.animate().translationYBy(1500).rotation(300).setDuration(300);
        int fill = Integer.parseInt(counter.getTag().toString());
        //Log.i("position", counter.getTag().toString());
        if(chance == 0) {
            counter.setImageResource(R.drawable.yellow);
            pos[fill] = 0;
            chance = 1;
            if(check1() == 0)
            {
                Toast.makeText(this, "Player1 is the winner.", Toast.LENGTH_SHORT).show();
                gameReset();
            }
        }
        else {
            counter.setImageResource(R.drawable.red);
            pos[fill] = 1;
            chance = 0;
            if(check2() == 0) {
                Toast.makeText(this, "Player2 is the winner.", Toast.LENGTH_SHORT).show();
                gameReset();
            }
        }
        if(tie()) {
            Toast.makeText(this, "That's a Tie.", Toast.LENGTH_SHORT).show();
            gameReset();
        }
    }

    public boolean tie() {
        int ct = 0;
        for(int i=0; i<pos.length; i++) {
            if(pos[i] != 2)
                ct++;
        }
        if(ct == 9)
            return  true;
        return false;
    }

    public void gameReset() {
        chance = 0;
        for(int i=0; i<pos.length; i++) {
            pos[i] = 2;
        }
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView reset = (ImageView) gridLayout.getChildAt(i);
            reset.setImageDrawable(null);
        }
    }

    public int check1() {
        if(pos[0] == 0 && pos[1] == 0 && pos[2] == 0)
            return 0;
        else if(pos[3] == 0 && pos[4] == 0 && pos[5] == 0)
            return  0;
        else if(pos[6] == 0 && pos[7] == 0 && pos[8] == 0)
            return  0;
        else if(pos[0] == 0 && pos[3] == 0 && pos[6] == 0)
            return  0;
        else if(pos[1] == 0 && pos[4] == 0 && pos[7] == 0)
            return  0;
        else if(pos[2] == 0 && pos[5] == 0 && pos[8] == 0)
            return  0;
        else if(pos[0] == 0 && pos[4] == 0 && pos[8] == 0)
            return  0;
        else if(pos[2] == 0 && pos[4] == 0 && pos[6] == 0)
            return  0;
        return 1;
    }

    public int check2() {
        if(pos[0] == 1 && pos[1] == 1 && pos[2] == 1)
            return 0;
        else if(pos[3] == 1 && pos[4] == 1 && pos[5] == 1)
            return  0;
        else if(pos[6] == 1 && pos[7] == 1 && pos[8] == 1)
            return  0;
        else if(pos[0] == 1 && pos[3] == 1 && pos[6] == 1)
            return  0;
        else if(pos[1] == 1 && pos[4] == 1 && pos[7] == 1)
            return  0;
        else if(pos[2] == 1 && pos[5] == 1 && pos[8] == 1)
            return  0;
        else if(pos[0] == 1 && pos[4] == 1 && pos[8] == 1)
            return  0;
        else if(pos[2] == 1 && pos[4] == 1 && pos[6] == 1)
            return  0;
        return 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
