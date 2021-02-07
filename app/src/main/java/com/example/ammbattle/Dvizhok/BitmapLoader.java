package com.example.ammbattle.Dvizhok;

import android.graphics.Bitmap;

import com.example.ammbattle.graphics.GamePaint;

import java.io.IOException;

public class BitmapLoader {

    public static Bitmap pmmPlayer, svet, svetBig, movingSpaceBackground, ogon, heart, gameOver;
    public static Bitmap baseButtonClicked, baseButton, win, uskova, inf;

    public static Bitmap bullet;

    public static Media.Music marioMusic;

    public BitmapLoader(MainRunActivity mainRunActivity, GamePaint gamePaint) throws IOException {

        loadTexture(gamePaint);
        loadSprites(gamePaint);
        loadAudio(mainRunActivity);
    }

    private void loadAudio(MainRunActivity mainRunActivity) throws IOException {
        marioMusic = mainRunActivity.getMedia().setMusic("mario.mp3");

    }


    private void loadSprites(GamePaint gamePaint) {

    }


    private void loadTexture(GamePaint gamePaint) {

        ogon = gamePaint.createNewGraphicsBitmap("ogon2.png");
        heart = gamePaint.createNewGraphicsBitmap("heart.png");
        bullet = gamePaint.createNewGraphicsBitmap("bullet.png");
        movingSpaceBackground = gamePaint.createNewGraphicsBitmap("ooo.png");
        pmmPlayer = gamePaint.createNewGraphicsBitmap("PmmPlayer.png");
        svet = gamePaint.createNewGraphicsBitmap("finalSvet.png");
        svetBig = gamePaint.createNewGraphicsBitmap("svetBig.png");
        gameOver = gamePaint.createNewGraphicsBitmap("gameover.png");
        baseButton = gamePaint.createNewGraphicsBitmap("baseButton.png");
        baseButtonClicked = gamePaint.createNewGraphicsBitmap("baseButtonClicked.png");
        win =  gamePaint.createNewGraphicsBitmap("win.png");
        uskova =  gamePaint.createNewGraphicsBitmap("uzkova.png");
        inf =  gamePaint.createNewGraphicsBitmap("inf.png");


    }

}
