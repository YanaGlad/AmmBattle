package com.example.ammbattle.gameAttributes;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.example.ammbattle.Dvizhok.BitmapLoader;
import com.example.ammbattle.Dvizhok.EasyTimer;
import com.example.ammbattle.Dvizhok.GameItem;
import com.example.ammbattle.graphics.GamePaint;

import java.util.ArrayList;

import static com.example.ammbattle.Dvizhok.Collisions.collisionDetectLengthViaWidth;
import static com.example.ammbattle.Dvizhok.Collisions.createBaseSizeRect;

public class EnemyBoss extends GameItem {
    private int reward;
    private Bitmap img, fire;
    private double health;
    private double k;
    private boolean defeated = false;
    private ArrayList<Bullet> bullets;
    private double power;
    private EasyTimer easyTimer;
    private boolean up, down;

    public EnemyBoss(Bitmap img, int x, int y, double health, int reward, int speed, int power, Bitmap fire) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.img = img;
        this.health = health;
        this.reward = reward;
        this.fire = fire;
        k = 200;
        collLength = collisionDetectLengthViaWidth(img, 3.5);
        collisionRect = createBaseSizeRect(x, y);

        this.delay = 0.8;
        this.power = 10;

        bullets = new ArrayList<>();
        easyTimer = new EasyTimer();
        easyTimer.startTimer();
    }

    @Override
    public void run(GamePaint gamePaint) {
        if (health > 0) {
            repaint();

            gamePaint.setVisibleBitmap(img, x, y);

            gamePaint.createGreenRect(x, y - 10, (int) (x + k), y);
            gamePaint.createLine(x, y - 10, x + 50, y - 10, Color.RED);
            gamePaint.createLine(x, y, x + 200, y, Color.RED);
            gamePaint.createLine(x, y - 10, x, y, Color.RED);
            gamePaint.createLine(x + 200, y - 10, x + 50, y, Color.RED);


        int dy = (int) (Math.random() * (40 - 5) + 5);

        if (easyTimer.timerDelay(delay)) {
            bullets.add(new Bullet(x, y + dy, fire, true));
            easyTimer.startTimer();
        }

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).run(gamePaint);
            if (bullets.get(i).getX() > 1000) bullets.remove(i);
        }

        } else defeated = true;
    }

    // отображает остаток жизней
    public void setHealth(double health, double power) {
        double healthCompare = k * 100 / health;
        this.k = (health - power) * healthCompare / 100;
        this.health = health - power;

    }

    @Override
    public void repaint() {
        // x -= speed;
        if (down)
            y += speed;
        else y -= speed;

        if (y == 450)
            down = false;
        if (y == 100)
            down = true;

        collisionRect = createBaseSizeRect(x, y);
    }

    public boolean isDefeated() {
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

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
