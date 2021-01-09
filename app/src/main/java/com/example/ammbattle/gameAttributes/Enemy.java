package com.example.ammbattle.gameAttributes;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.example.ammbattle.Dvizhok.GameItem;
import com.example.ammbattle.graphics.GamePaint;

import static com.example.ammbattle.Dvizhok.Collisions.collisionDetectLengthViaWidth;
import static com.example.ammbattle.Dvizhok.Collisions.createBaseSizeRect;

public class Enemy extends GameItem {
    private int reward;
    private Bitmap img;
    private double health;
    private double k;
    private boolean defeated = false;
    private int speed;

    public Enemy(Bitmap img, int x, int y, double health, int reward, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.img = img;
        this.health = health;
        this.reward = reward;
        k = 50;
        collLength = collisionDetectLengthViaWidth(img, 3.5);
        collisionRect = createBaseSizeRect(x, y);
    }

    @Override
    public void run(GamePaint gamePaint) {
        if (health > 0) {
            repaint();

            gamePaint.setVisibleBitmap(img, x, y);

            gamePaint.createGreenRect(x, y - 10, (int) (x + k), y);
            gamePaint.createLine(x, y - 10, x + 50, y - 10, Color.RED);
            gamePaint.createLine(x, y, x + 50, y, Color.RED);
            gamePaint.createLine(x, y - 10, x, y, Color.RED);
            gamePaint.createLine(x + 50, y - 10, x + 50, y, Color.RED);
        } else defeated = true;

    }

     public void setHealth(double health, double power) {
        double healthCompare = k * 100 / health;
        this.k = (health - power) * healthCompare / 100;
        this.health = health - power;

    }

    @Override
    public void repaint() {
        x -= speed;
        collisionRect = createBaseSizeRect(x, y);
    }

    boolean isDefeated() {
        return defeated;
    }

    int getReward() {
        return reward;
    }

    public double getHealth() {
        return health;
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public double getSpeed() {
        return super.getSpeed();
    }

    @Override
    public void setSpeed(double speed) {
        super.setSpeed(speed);
    }
}
