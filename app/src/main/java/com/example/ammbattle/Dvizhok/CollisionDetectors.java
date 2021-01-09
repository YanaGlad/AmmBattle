package com.example.ammbattle.Dvizhok;


import static com.example.ammbattle.Dvizhok.Collisions.checkGameItemCollision;

public class CollisionDetectors {

    public static boolean checkTwoItemCollision(GameItem gameItem, GameItem gameItem2) {
        return checkGameItemCollision(gameItem, gameItem2);
    }
}