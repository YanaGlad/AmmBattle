package com.example.ammbattle.Dvizhok;

import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import com.example.ammbattle.graphics.GamePaint;


public class BasicButton extends GameItem {
    private MainRunActivity mainRunActivity;
    private boolean clicked;
    private String text = null;
    private int size = 0;
    private int stepX = 0, stepY = 0;
    private int color;

    public BasicButton(MainRunActivity mainRunActivity, int x, int y, @Nullable String text, int color, int size, Bitmap button, Bitmap clickedButton, int stepX, int stepY) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.color = color;
        this.size = size;
        this.mainRunActivity = mainRunActivity;
        this.bitmap = button;
        this.bitmapClicked = clickedButton;
        this.stepX = stepX;
        this.stepY = stepY;
        clicked = false;
    }


    @Override
    public void run(GamePaint gamePaint) {
        repaint();

        if (clicked) gamePaint.setVisibleBitmap(bitmapClicked, x, y);
        else gamePaint.setVisibleBitmap(bitmap, x, y);

        if (text != null)
            gamePaint.write(text, x + stepX, y + stepY, color, size);
    }

    @Override
    public void repaint() {
        if (mainRunActivity.getTouchListener().up(x, y + bitmap.getHeight(), bitmap.getWidth(), bitmap.getHeight()))
            clicked = !clicked;

    }

    @Override
    public void repaint(double speed, double jumSpeed) {
    }

    public boolean isClicked() {
        return clicked;
    }

    public void notClicked() {
        this.clicked = false;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Bitmap getBitmap() {
        return super.getBitmap();
    }

    @Override
    public Bitmap getBitmapClicked() {
        return super.getBitmapClicked();
    }


    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public void setBitmap(Bitmap bitmap) {
        super.setBitmap(bitmap);
    }

    @Override
    public void setBitmapClicked(Bitmap bitmapClicked) {
        super.setBitmapClicked(bitmapClicked);
    }
}
