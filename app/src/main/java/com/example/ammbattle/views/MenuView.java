package com.example.ammbattle.views;

import android.graphics.Color;

import com.example.ammbattle.Dvizhok.BasicButton;
import com.example.ammbattle.Dvizhok.BitmapLoader;
import com.example.ammbattle.Dvizhok.GameView;
import com.example.ammbattle.Dvizhok.MainRunActivity;
import com.example.ammbattle.R;
import com.example.ammbattle.gameAttributes.MovingBackground;
import com.example.ammbattle.levels.Level1;
import com.example.ammbattle.levels.Level2;

import java.io.IOException;
import java.util.ArrayList;

public class MenuView extends GameView {
    private BasicButton btn;
    private MovingBackground movingBackground;
    private Level2 level1;

    public MenuView(MainRunActivity mainRunActivity) {
        super(mainRunActivity);
        movingBackground = new MovingBackground(BitmapLoader.movingSpaceBackground, 1);
        level1 = new Level2(mainRunActivity);
    }


    @Override
    public void run() {
        repaint();
        movingBackground.run(super.getGamePaint());
        level1.run(super.getGamePaint());
    }

    @Override
    public void repaint() {

    }

}
