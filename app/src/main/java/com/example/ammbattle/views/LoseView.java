package com.example.ammbattle.views;

import android.graphics.Color;

import com.example.ammbattle.Dvizhok.BasicButton;
import com.example.ammbattle.Dvizhok.GameView;
import com.example.ammbattle.Dvizhok.MainRunActivity;
import com.example.ammbattle.levels.Level;

import static com.example.ammbattle.Dvizhok.BitmapLoader.baseButton;
import static com.example.ammbattle.Dvizhok.BitmapLoader.baseButtonClicked;
import static com.example.ammbattle.Dvizhok.BitmapLoader.gameOver;

public class LoseView extends GameView {
    private BasicButton tryAgaing, goBack;
    private Level lostLevel;

    public LoseView(MainRunActivity mainRunActivity, Level lostLevel) {
        super(mainRunActivity);
        tryAgaing = new BasicButton(mainRunActivity, 350, 300, "Play again", Color.BLACK, 30, baseButton, baseButtonClicked, 30, 35);
        this.lostLevel = lostLevel;
    }

    @Override
    public void run() {
        repaint();
        getGamePaint().setVisibleBitmap(gameOver,-10,-10);
        tryAgaing.run(super.getGamePaint());
    }

    @Override
    public void repaint() {
        if (tryAgaing.isClicked()) {
            super.getMainRunActivity().setView(new LevelView(getMainRunActivity(),lostLevel));
            tryAgaing.notClicked();
        }

    }
}
