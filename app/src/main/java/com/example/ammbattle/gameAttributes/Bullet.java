package com.example.ammbattle.gameAttributes;

import android.graphics.Bitmap;

import com.example.ammbattle.Dvizhok.BitmapLoader;
import com.example.ammbattle.Dvizhok.GameItem;
import com.example.ammbattle.graphics.GamePaint;

import static com.example.ammbattle.Dvizhok.Collisions.collisionDetectLengthViaWidth;
import static com.example.ammbattle.Dvizhok.Collisions.createBaseSizeRect;

public class Bullet extends GameItem {

    private boolean enemy = false;

    Bullet(int x, int y, Bitmap bitmap, boolean enemy) {
        this.x = x;
        this.y = (y + 20);
        this.enemy = enemy;
        this.bitmap = bitmap;
        collLength = 20;
        collisionRect = createBaseSizeRect(x, y);
    }


    Bullet(int x, int y, Bitmap bitmap) {
        this.x = x;
        this.y = (y + 20);
        this.bitmap = bitmap;
        collLength = 20;
        collisionRect = createBaseSizeRect(x, y);
    }

    @Override
    public void run(GamePaint gamePaint) {
        repaint();
        gamePaint.setVisibleBitmap(bitmap, x, y);
    }

    @Override
    public void repaint() {
        if (!enemy)
            x += 10;
        else x -= 8;
        collisionRect = createBaseSizeRect(x, y);
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
    public void setBitmap(Bitmap bitmap) {
        super.setBitmap(bitmap);
    }
}
