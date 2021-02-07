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
import static com.example.ammbattle.Dvizhok.BitmapLoader.ogon;
import static com.example.ammbattle.Dvizhok.BitmapLoader.svet;
import static com.example.ammbattle.Dvizhok.BitmapLoader.svetBig;

public class Level1 extends Level implements Loopable {
    private PmmPlayer pmmPlayer;
    private ArrayList<Enemy> svetochs;
    private int lives = 10;
    private EnemyBoss prosvetovOgon;
    private boolean gameOver = false, win = false;
    private MainRunActivity mainRunActivity;
    private EasyTimer easyTimer;

    public Level1(MainRunActivity mainRunActivity) {
        this.mainRunActivity = mainRunActivity;
        pmmPlayer = new PmmPlayer(mainRunActivity);
        svetochs = new ArrayList<>();

        prosvetovOgon = null;
        Random random = new Random();
        int x = 900;
        int y = (int) (Math.random() * (530 - 60) + 60);
        for (byte i = 0; i < 10; i++) {
            svetochs.add(new Enemy(svet, x, y, 30, 50, 3));
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
        for (Enemy enemy : svetochs) {
            enemy.run(gamePaint);
        }

        if (prosvetovOgon != null)
            prosvetovOgon.run(gamePaint);

        int hX = 500;
        for (int i = 0; i < lives; i++) {
            gamePaint.setVisibleBitmap(heart, hX, 30);
            hX += 20;
        }
    }

    @Override
    public void repaint() {
        for (short i = 0; i < pmmPlayer.getBullets().size(); i++)
            if (svetochs.size() > 0) {
                for (byte j = 0; j < svetochs.size(); j++) {
                    if (CollisionDetectors.checkTwoItemCollision(pmmPlayer.getBullets().get(i), svetochs.get(j))) {
                        svetochs.get(j).setHealth(svetochs.get(j).getHealth(), pmmPlayer.getPower());
                        pmmPlayer.getBullets().get(i).setX(900);
                    }
                    if (svetochs.get(j).getHealth() <= 0)
                        svetochs.remove(j);
                    if (svetochs.size() > j) {
                        if (svetochs.get(j).getX() < -70) {
                            svetochs.remove(j);
                            lives--;
                        }
                    }
                }
                System.out.println(svetochs.size());

                if (svetochs.size() == 0 && prosvetovOgon == null)
                    prosvetovOgon = new EnemyBoss(svetBig, 600, 300, 300, 100, 2, 10, ogon);
            }

        if (prosvetovOgon != null) {
            for (short i = 0; i < pmmPlayer.getBullets().size(); i++) {
                if (CollisionDetectors.checkTwoItemCollision(pmmPlayer.getBullets().get(i), prosvetovOgon)) {
                    prosvetovOgon.setHealth(prosvetovOgon.getHealth(), pmmPlayer.getPower());
                    pmmPlayer.getBullets().get(i).setX(900);
                }
            }

            for (short i = 0; i < prosvetovOgon.getBullets().size(); i++) {
                if (prosvetovOgon.getBullets().get(i).getX() < 10 && prosvetovOgon.getBullets().get(i).getX() > 0 && Math.abs(prosvetovOgon.getBullets().get(i).getY() - pmmPlayer.getY()) < 10) {
                    prosvetovOgon.getBullets().get(i).setX(1200);
                    prosvetovOgon.getBullets().get(i).setY(-1200);
                    if (easyTimer.timerDelay(1)) lives--;
                    easyTimer.startTimer();
                }
            }
        }
        if (lives == 0)
            gameOver = true;
        if (prosvetovOgon != null && prosvetovOgon.isDefeated())
            win = true;

        if (gameOver)
            mainRunActivity.setView(new LoseView(mainRunActivity, new Level1(mainRunActivity)));

        if (win)
            mainRunActivity.setView(new WinView(mainRunActivity, "Prosvetov DEFEATED", BitmapLoader.win, new Level2(mainRunActivity)));
    }

    @Override
    public void repaint(double speed, double jumSpeed) {

    }

}
