package com.example.ammbattle.Dvizhok;

import android.graphics.Bitmap;
import android.graphics.Rect;

 public class Collisions {

    static boolean checkGameItemCollision(GameItem item1, GameItem item2) {
        if (item1 != null && item2 != null) {

            double Xx = itemX(item1, item2);
            double Yy = itemY(item1, item2);

            if (Xx != 0 && Yy != 0) {
                return Math.sqrt(Xx * Xx + Yy * Yy) < item1.getCollLength() + item2.getCollLength();
            }
        }
        return false;
    }

    static boolean collisionDetectEasy(GameItem object1, GameItem object2,
                                       Bitmap bitmap, int maxX, int minX, boolean checkY) {
        if (object1 != null && object2 != null) {
            double widthOfBmp = bitmap.getWidth();
            if (checkY)
                return object2.getX() <= minX && object2.getX() <= minX + widthOfBmp
                        && (object1.getY() > object2.getY())
                        && object2.getX() >= maxX;
            else
                return object2.getX() <= minX && object2.getX() <= minX + widthOfBmp
                        && object2.getX() >= maxX;


        }
        return false;
    }

    private static double itemX(GameItem item1, GameItem item2) {
        if (item1 == null || item2 == null) return 0.0;
        return item1.getCollisionRect().centerX() - item2.getCollisionRect().centerX();
    }

    private static double itemY(GameItem item1, GameItem item2) {
        if (item1 == null || item2 == null) return 0.0;
        return item1.getCollisionRect().centerY() - item2.getCollisionRect().centerY();
    }

    public static Rect createCollisionsRect(int x, int y, Bitmap bmp) {
        return new Rect(x, y, bmp.getWidth(), bmp.getHeight());
    }

    public static Rect createCollisionsRect(double x, double y, Bitmap bmp) {
        return new Rect((int) x, (int) y, bmp.getWidth(), bmp.getHeight());
    }

    public static double collisionDetectLengthViaWidth(Bitmap bmp, double size) {
        return bmp.getWidth() / size;
    }

    public static double collisionDetectLengthViaHeight(Bitmap bmp, double size) {
        return bmp.getHeight() / size;
    }

    public static Rect createBaseSizeRect(int x, int y) {
        return new Rect(x, y, 64, 64);
    }

    public static Rect createBaseSizeRect(double x, double y) {
        return new Rect((int) x, (int) y, 64, 64);
    }
}