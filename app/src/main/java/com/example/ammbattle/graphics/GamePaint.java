package com.example.ammbattle.graphics;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.io.IOException;
import java.io.InputStream;


public class GamePaint {

    private AssetManager am;
    private Bitmap mainBitmap;
    private Canvas canvas;
    private Paint paint;

    public GamePaint(AssetManager am, Bitmap mainBitmap) {
        this.am = am;
        this.mainBitmap = mainBitmap;
        this.canvas = new Canvas(mainBitmap);
        this.paint = new Paint();

        Typeface mainFont = Typeface.createFromAsset(am, "try3.otf");
        paint.setTypeface(mainFont);
        paint.setAntiAlias(true);
    }

    public void write(String text, int x, int y, int color, int sizeText) {
        paint.setColor(color);
        paint.setTextSize(sizeText);
        canvas.drawText(text, x, y, paint);
    }

    public void setVisibleBitmap(Bitmap textureGame, int x, int y) {
        canvas.drawBitmap(textureGame, x, y, null);
    }

    public Bitmap createNewGraphicsBitmap(String name) {
        InputStream inputStream;
        Bitmap bitmap;
        try {
            inputStream = am.open(name);
            bitmap = BitmapFactory.decodeStream(inputStream);
            if (bitmap == null) {
                throw new RuntimeException("Unable to load file " + name);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to load file " + name);
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public void createGreenRect(int left, int top, int right, int bottom) {
        paint.setColor(Color.GREEN);
        canvas.drawRect(left, top, right, bottom, paint);
    }

    public void createLine(int startX, int startY, int stopX, int stopY, int color) {
        paint.setColor(color);
        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }

    public Bitmap getMainBitmap() {
        return mainBitmap;
    }
}
