package com.example.ammbattle.Dvizhok;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.ammbattle.graphics.GamePaint;

public abstract class GameItem implements Loopable {
    protected int x, y, controlY;
    protected double speed, jumpingSpeed, collLength, delay;
    protected Rect collisionRect;
    protected Bitmap bitmap, bitmapClicked;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    protected Rect getCollisionRect() {
        return collisionRect;
    }

    protected double getCollLength() {
        return collLength;
    }

    protected int getControlY() {
        return controlY;
    }

    public double getJumpingSpeed() {
        return jumpingSpeed;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Bitmap getBitmapClicked() {
        return bitmapClicked;
    }

    public void setControlY(int controlY) {
        this.controlY = controlY;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public double getDelay() {
        return delay;
    }

    public void setDelay(double delay) {
        this.delay = delay;
    }

    public void setBitmapClicked(Bitmap bitmapClicked) {
        this.bitmapClicked = bitmapClicked;
    }

    @Override
    public void run(GamePaint gamePaint) {

    }

    @Override
    public void repaint() {

    }

    @Override
    public void repaint(double speed, double jumSpeed) {

    }
}
