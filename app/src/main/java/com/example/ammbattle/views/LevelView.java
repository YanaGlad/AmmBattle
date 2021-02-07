package com.example.ammbattle.views;

import android.graphics.Color;

import com.example.ammbattle.Dvizhok.BasicButton;
import com.example.ammbattle.Dvizhok.BitmapLoader;
import com.example.ammbattle.Dvizhok.GameView;
import com.example.ammbattle.Dvizhok.MainRunActivity;
import com.example.ammbattle.R;
import com.example.ammbattle.gameAttributes.MovingBackground;
import com.example.ammbattle.levels.Level;
import com.example.ammbattle.levels.Level1;
import com.example.ammbattle.levels.Level2;

import java.io.IOException;
import java.util.ArrayList;

public class LevelView extends GameView {
    private BasicButton btn;
    private MovingBackground movingBackground;
    private Level level;

    public LevelView(MainRunActivity mainRunActivity, Level level) {
        super(mainRunActivity);
        movingBackground = new MovingBackground(BitmapLoader.movingSpaceBackground, 1);
        this.level = level;
    }


    @Override
    public void run() {
        repaint();
        movingBackground.run(super.getGamePaint());
        level.run(super.getGamePaint());
    }

    @Override
    public void repaint() {

    }

}
