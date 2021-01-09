package com.example.ammbattle.views;

import android.graphics.Color;

import com.example.ammbattle.Dvizhok.GameView;
import com.example.ammbattle.Dvizhok.MainRunActivity;

import static com.example.ammbattle.Dvizhok.BitmapLoader.win;

public class WinView extends GameView {
    public WinView(MainRunActivity mainRunActivity) {
        super(mainRunActivity);
    }

    @Override
    public void run() {
        getGamePaint().setVisibleBitmap(win,0,0);
        getGamePaint().write("Prosvetov DEFEATED", 170, 150, Color.WHITE,60);
    }

    @Override
    public void repaint() {

    }
}
