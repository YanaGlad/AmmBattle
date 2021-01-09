package com.example.ammbattle.gameAttributes;

import android.graphics.Bitmap;

import com.example.ammbattle.Dvizhok.Loopable;
import com.example.ammbattle.graphics.GamePaint;

  public class MovingBackground implements Loopable {
    private int startX, end, secondStartX;
    private int speed;
    private Bitmap background;

    public MovingBackground(Bitmap background, int speed) {
        startX = 0;
        this.speed = speed;
        this.background = background;
        secondStartX = background.getWidth();
        end = background.getWidth();
    }

    @Override
    public void run(GamePaint gamePaint)  {
        repaint();
        gamePaint.setVisibleBitmap(background, startX, 0);
        gamePaint.setVisibleBitmap(background, secondStartX, 0);
      }

    @Override
    public void repaint() {
        startX -= speed;
        secondStartX -= speed;
        if (startX < (-end)) {
            startX = 0;
        }
        if (secondStartX < 0) {
            secondStartX = end;
        }
    }

    @Override
    public void repaint(double speed, double jumSpeed) {}
}
