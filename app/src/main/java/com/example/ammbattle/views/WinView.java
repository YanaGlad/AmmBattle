package com.example.ammbattle.views;

import android.graphics.Bitmap;
import android.graphics.Color;

import androidx.annotation.Nullable;

import com.example.ammbattle.Dvizhok.BasicButton;
import com.example.ammbattle.Dvizhok.BitmapLoader;
import com.example.ammbattle.Dvizhok.GameView;
import com.example.ammbattle.Dvizhok.MainRunActivity;
import com.example.ammbattle.levels.Level;

import java.io.IOException;

import static com.example.ammbattle.Dvizhok.BitmapLoader.baseButton;
import static com.example.ammbattle.Dvizhok.BitmapLoader.baseButtonClicked;

public class WinView extends GameView {
    private String msg;
    private Bitmap win;
    private BasicButton basicButton;
    private Level nextLevel;

    public WinView(MainRunActivity mainRunActivity, String msg, Bitmap win, @Nullable Level nextLevel) {
        super(mainRunActivity);
        this.msg = msg;
        this.win = win;
        this.nextLevel = nextLevel;
        basicButton = new BasicButton(mainRunActivity, 290, 300, "Next level", Color.WHITE, 35, baseButton, baseButtonClicked, 50, 35);

    }

    @Override
    public void run() {
        repaint();
        getGamePaint().setVisibleBitmap(win,0,0);
        getGamePaint().write(msg, 170, 150, Color.WHITE,60);

        if (nextLevel!=null)
        basicButton.run(getGamePaint());
    }

    @Override
    public void repaint() {
        if (basicButton.isClicked()){
            getMainRunActivity().setView(new LevelView(getMainRunActivity(), nextLevel));
            try {
                BitmapLoader.marioMusic.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
