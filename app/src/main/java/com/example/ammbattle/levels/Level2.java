package com.example.ammbattle.levels;

import com.example.ammbattle.Dvizhok.BitmapLoader;
import com.example.ammbattle.Dvizhok.CollisionDetectors;
import com.example.ammbattle.Dvizhok.EasyTimer;
import com.example.ammbattle.Dvizhok.Loopable;
import com.example.ammbattle.Dvizhok.MainRunActivity;
import com.example.ammbattle.gameAttributes.Enemy;
import com.example.ammbattle.gameAttributes.EnemyBoss;
import com.example.ammbattle.gameAttributes.PmmPlayer;
import com.example.ammbattle.graphics.GamePaint;
import com.example.ammbattle.views.LoseView;
import com.example.ammbattle.views.WinView;

import java.util.ArrayList;
import java.util.Random;

import static com.example.ammbattle.Dvizhok.BitmapLoader.heart;
import static com.example.ammbattle.Dvizhok.BitmapLoader.inf;
import static com.example.ammbattle.Dvizhok.BitmapLoader.ogon;
import static com.example.ammbattle.Dvizhok.BitmapLoader.svet;
import static com.example.ammbattle.Dvizhok.BitmapLoader.svetBig;

public class Level2 implements Loopable {
    private PmmPlayer pmmPlayer;
    private ArrayList<Enemy> infs;
    private int lives = 3;
    private EnemyBoss uskova;
    private boolean gameOver = false, win = false;
    private MainRunActivity mainRunActivity;
    private EasyTimer easyTimer;

    public Level2(MainRunActivity mainRunActivity) {
        this.mainRunActivity = mainRunActivity;
        pmmPlayer = new PmmPlayer(mainRunActivity);
        infs = new ArrayList<>();

        uskova = null;
        Random random = new Random();
        int x = 900;
        int y = (int) (Math.random() * (530 - 60) + 60);
        for (byte i = 0; i < 10; i++) {
            infs.add(new Enemy(inf, x, y, 30, 50, 3));
            y = (int) (Math.random() * 470 + 60);
            x += 500;
        }
        easyTimer = new EasyTimer();
        easyTimer.startTimer();
    }

    @Override
    public void run(GamePaint gamePaint) {
        repaint();
        pmmPlayer.run(gamePaint);
        for (Enemy enemy : infs) {
            enemy.run(gamePaint);
        }

        if (uskova != null)
            uskova.run(gamePaint);

        int hX = 500;
        for (int i = 0; i < lives; i++) {
            gamePaint.setVisibleBitmap(heart, hX, 30);
            hX += 20;
        }
    }

    @Override
    public void repaint() {
        for (short i = 0; i < pmmPlayer.getBullets().size(); i++)
            if (infs.size() > 0) {
                for (byte j = 0; j < infs.size(); j++) {
                    if (CollisionDetectors.checkTwoItemCollision(pmmPlayer.getBullets().get(i), infs.get(j))) {
                        infs.get(j).setHealth(infs.get(j).getHealth(), pmmPlayer.getPower());
                        pmmPlayer.getBullets().get(i).setX(900);
                    }
                    if (infs.get(j).getHealth() <= 0)
                        infs.remove(j);
                    if (infs.size() > j) {
                        if (infs.get(j).getX() < -70) {
                            infs.remove(j);
                            lives--;
                        }
                    }
                }
                System.out.println(infs.size());

                if (infs.size() == 0 && uskova == null)
                    uskova = new EnemyBoss(BitmapLoader.uskova, 600, 300, 300, 100, 2, 10, ogon);
            }

        if (uskova != null) {
            for (short i = 0; i < pmmPlayer.getBullets().size(); i++) {
                if (CollisionDetectors.checkTwoItemCollision(pmmPlayer.getBullets().get(i), uskova)) {
                    uskova.setHealth(uskova.getHealth(), pmmPlayer.getPower());
                    pmmPlayer.getBullets().get(i).setX(900);
                }
            }

            for (short i = 0; i < uskova.getBullets().size(); i++) {
                if (uskova.getBullets().get(i).getX() < 10 && uskova.getBullets().get(i).getX() > 0 && Math.abs(uskova.getBullets().get(i).getY() - pmmPlayer.getY()) < 10) {
                    uskova.getBullets().get(i).setX(1200);
                    uskova.getBullets().get(i).setY(-1200);
                    if (easyTimer.timerDelay(1)) lives--;
                    easyTimer.startTimer();
                }
            }
        }
        if (lives == 0)
            gameOver = true;
        if (uskova != null && uskova.isDefeated())
            win = true;

        if (gameOver)
            mainRunActivity.setView(new LoseView(mainRunActivity));

        if (win)
            mainRunActivity.setView(new WinView(mainRunActivity));
    }

    @Override
    public void repaint(double speed, double jumSpeed) {

    }


}
