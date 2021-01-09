package com.example.ammbattle.gameAttributes;

import android.graphics.Bitmap;

import com.example.ammbattle.Dvizhok.BasicGameSupport;
import com.example.ammbattle.Dvizhok.BitmapLoader;
import com.example.ammbattle.Dvizhok.EasyTimer;
import com.example.ammbattle.Dvizhok.GameItem;
import com.example.ammbattle.Dvizhok.GameView;
import com.example.ammbattle.Dvizhok.Loopable;
import com.example.ammbattle.Dvizhok.MainRunActivity;
import com.example.ammbattle.graphics.GamePaint;

import java.util.ArrayList;

import static com.example.ammbattle.Dvizhok.BitmapLoader.pmmPlayer;
import static com.example.ammbattle.Dvizhok.Collisions.createBaseSizeRect;

public class PmmPlayer extends GameItem implements Loopable {

    private MainRunActivity mainRunActivity;
    private boolean movingUp, movingDown;
    private ArrayList<Bullet> bullets;
    private EasyTimer easyTimer;
    private double power;

    public PmmPlayer(MainRunActivity mainRunActivity) {
        this.bitmap = pmmPlayer;
        this.mainRunActivity = mainRunActivity;
        this.delay = 1;
        power = 10;

        bullets = new ArrayList<>();
        easyTimer = new EasyTimer();
        easyTimer.startTimer();
        collLength = 60;
        collisionRect = createBaseSizeRect(x, y);
    }

    @Override
    public void run(GamePaint gamePaint) {
        repaint();
        gamePaint.setVisibleBitmap(bitmap, x, y);

        if (easyTimer.timerDelay(delay)) {
            bullets.add(new Bullet(x, y, BitmapLoader.bullet));
            easyTimer.startTimer();
        }

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).run(gamePaint);
            if (bullets.get(i).getX() > 1000) bullets.remove(i);
        }
    }

    @Override
    public void repaint() {
        if (mainRunActivity.getTouchListener().down(0, GameView.screenHeight, GameView.screenWidth, GameView.screenHeight)) {
            if (BasicGameSupport.movingLUp(mainRunActivity)) {
                movingUp = true;
                movingDown = false;
            } else {
                movingDown = true;
                movingUp = false;
            }
        } else if (mainRunActivity.getTouchListener().up(0, GameView.screenHeight, GameView.screenWidth, GameView.screenHeight)) {
            movingDown = false;
            movingUp = false;
        }

        if (movingUp && y > 0 ) y -= 10;
        if (movingDown && y < 550) y+= 10;
    }

    @Override
    public void repaint(double speed, double jumSpeed) {

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

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    @Override
    public void setSpeed(double speed) {
        super.setSpeed(speed);
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
    public void setBitmap(Bitmap bitmap) {
        super.setBitmap(bitmap);
    }

    @Override
    public void setBitmapClicked(Bitmap bitmapClicked) {
        super.setBitmapClicked(bitmapClicked);
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
