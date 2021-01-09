package com.example.ammbattle.Dvizhok;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

 public class GameLoop extends SurfaceView implements Runnable {
    private boolean running = false;
    Thread gameThread = null;
    MainRunActivity mainRunActivity;
    Bitmap mainBitmap;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Rect rect;

    public GameLoop(MainRunActivity mainRunActivity, Bitmap mainBitmap) {
        super(mainRunActivity);
        this.mainBitmap = mainBitmap;
        this.mainRunActivity = mainRunActivity;
        this.surfaceHolder = getHolder();
        rect = new Rect();
        canvas = new Canvas();
    }

    @Override
    public void run() {
        float beginTime = System.nanoTime();
        float delta = 0;
        while (running) {
            int updateTime = 1000000000 / 60;
            delta += (System.nanoTime() - beginTime) / updateTime;
            beginTime = System.nanoTime();
            if (delta > 1) {
                runGame();
                delta--;
            }
        }
    }

    private void runGame() {
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.getClipBounds(rect);
            canvas.drawBitmap(mainBitmap, null, rect, null);
            mainRunActivity.getCurrentView().run();
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }


    public void startGame() {
        if (running) return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGame() {
        if (!running) return;
        running = false;
//        gameThread = new Thread(this);
//        gameThread.start();
    }

}
