package com.example.ammbattle.Dvizhok;


import com.example.ammbattle.graphics.GamePaint;

public interface Loopable {

    void run(GamePaint gamePaint);
    void repaint();
    void repaint(double speed, double jumSpeed);
}
