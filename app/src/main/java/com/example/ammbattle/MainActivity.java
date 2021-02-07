package com.example.ammbattle;

import android.content.Context;

import com.example.ammbattle.Dvizhok.BitmapLoader;
import com.example.ammbattle.Dvizhok.GameView;
import com.example.ammbattle.Dvizhok.MainRunActivity;
import com.example.ammbattle.views.StartView;

import java.io.IOException;

public class MainActivity extends MainRunActivity {
    Context context;

    public GameView getNewView() {
        context = this;
        try {
            BitmapLoader bitmapLoader = new BitmapLoader(this, this.getGamePaint());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new StartView(this);
    }
}