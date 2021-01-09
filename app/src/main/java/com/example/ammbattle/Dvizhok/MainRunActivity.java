package com.example.ammbattle.Dvizhok;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ammbattle.graphics.GamePaint;


public class MainRunActivity extends AppCompatActivity {

    private GamePaint gamePaint;
    private TouchListener touchListener;
    private GameView gameView;
    private Media media;
    private GameLoop gameLoop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        Bitmap bmp = Bitmap.createBitmap(800, 600, Bitmap.Config.ARGB_8888);

        float w = (float) 800 / point.x;
        float h = (float) 600 / point.y;

        media = new Media(this);

        gameLoop = new GameLoop(this, bmp);
        gamePaint = new GamePaint(getAssets(), bmp);

        if (w == h) touchListener = new TouchListener(gameLoop, w);
        else touchListener = new TouchListener(gameLoop, w, h);

        gameView = getNewView();

        setContentView(gameLoop);
        gameLoop.startGame();
    }

    public GamePaint getGamePaint() {
        return gamePaint;
    }

    public TouchListener getTouchListener() {
        return touchListener;
    }

    public void setView(GameView gameView) {
        if (gameView == null) {
            throw new IllegalArgumentException("Something went wrong, gameView is null :(");
        }
        this.gameView = gameView;
    }



    public GameView getCurrentView() {
        return gameView;
    }

    public GameView getNewView() {
        return gameView;
    }

    public Media getMedia() {
        return media;
    }


}