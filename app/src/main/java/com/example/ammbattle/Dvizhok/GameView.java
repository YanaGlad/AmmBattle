package com.example.ammbattle.Dvizhok;



import com.example.ammbattle.graphics.GamePaint;

public abstract class GameView {

    private MainRunActivity mainRunActivity;
    private GamePaint gamePaint;

    public static int screenWidth;
    public static int screenHeight;
    protected int stars;

    public GameView(MainRunActivity mainRunActivity) {
        this.mainRunActivity = mainRunActivity;
        screenWidth = mainRunActivity.getGamePaint().getMainBitmap().getWidth();
        screenHeight = mainRunActivity.getGamePaint().getMainBitmap().getHeight();
        gamePaint = mainRunActivity.getGamePaint();
    }

    public abstract void run();

    public abstract void repaint();

    int getStars() {
        return stars;
    }

    public MainRunActivity getMainRunActivity() {
        return mainRunActivity;
    }

    public GamePaint getGamePaint() {
        return gamePaint;
    }
}
