package com.example.ammbattle.views;

import android.graphics.Color;
import com.example.ammbattle.Dvizhok.BasicButton;
import com.example.ammbattle.Dvizhok.BitmapLoader;
import com.example.ammbattle.Dvizhok.GameView;
import com.example.ammbattle.Dvizhok.MainRunActivity;

import java.io.IOException;

import static com.example.ammbattle.Dvizhok.BitmapLoader.baseButton;
import static com.example.ammbattle.Dvizhok.BitmapLoader.baseButtonClicked;
import static com.example.ammbattle.Dvizhok.BitmapLoader.movingSpaceBackground;

public class StartView extends GameView {

    private BasicButton basicButton;

    public StartView(MainRunActivity mainRunActivity) {
        super(mainRunActivity);
        basicButton = new BasicButton(mainRunActivity, 290, 300, "Play", Color.WHITE, 35, baseButton, baseButtonClicked, 50, 35);
    }

    @Override
    public void run() {
        repaint();
        super.getGamePaint().setVisibleBitmap(movingSpaceBackground, 0, 0);
        super.getGamePaint().write("ПММ Battle(Demo)", 160, 200, Color.WHITE, 60);

        basicButton.run(getGamePaint());
    }

    @Override
    public void repaint() {
        if (basicButton.isClicked()){
            getMainRunActivity().setView(new MenuView(getMainRunActivity()));
            try {
                BitmapLoader.marioMusic.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
