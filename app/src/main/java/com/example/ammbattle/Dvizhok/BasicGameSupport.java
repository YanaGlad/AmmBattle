package com.example.ammbattle.Dvizhok;


public class BasicGameSupport {
    public static final double SECOND = 1000000000;

    public static boolean movingDown(MainRunActivity mainRunActivity) {
        return mainRunActivity.getTouchListener().getTouchY() > GameView.screenHeight / 2;
    }

    public static boolean movingLUp(MainRunActivity mainRunActivity) {
        return mainRunActivity.getTouchListener().getTouchY() < GameView.screenHeight / 2;
    }

 //    public static int levelsCount = 9;

 //    public static int catsCount = 5;
//
//    public static final int maximumY = GameView.screenHeight - walkRightGray.get(0).getHeight();
//
 //    public static int updateMovesY(GameItem gameItem, double jumSpeed, int y) {
//        if (!timePlayer.isRocketMode()) {
//            if (timePlayer.isJumpingLimit()) {
//                if (timePlayer.isJumping()) y += jumSpeed;
//                if (timePlayer.isFalling() && !timePlayer.isJumping()) y -= jumSpeed;
//            } else {
//                if (y < gameItem.getControlY()) y += jumSpeed;
//                if (y > gameItem.getControlY()) y -= jumSpeed;
//            }
//        }
//        return y;
//    }
//
//    public static boolean movingRight(MainRunActivity mainRunActivity) {
//        return mainRunActivity.getTouchListener().getTouchX() < GameView.screenWidth && mainRunActivity.getTouchListener().getTouchX() > GameView.screenWidth / 2;
//    }
//
//    public static boolean movingLeft(MainRunActivity mainRunActivity) {
//        return mainRunActivity.getTouchListener().getTouchX() < GameView.screenWidth / 2;
//    }
//
 //    public static int updateMovesX(double speedPlayer, int x) {
//        if (!timePlayer.isCollisionDetectedRight())
//            if (timePlayer.isMovingLeft() && TimePlayer.start >= -550) {
//                x += speedPlayer;
//            }
//
//        if (!timePlayer.isCollisionDetectedLeft() && TimePlayer.start >= -550)
//            if (timePlayer.isMovingRight()) {
//                x -= speedPlayer;
//            }
//
//        if (timePlayer.isRocketMode()) {
//            x -= 2000;
//        }
//        return x;
//    }
//
 //    private static void updateTimeStars(double time, int maxThree, int maxTwo, int stars, int whereClause, @Nullable String catId, MainRunActivity mainRunActivity) {
//        ContentValues cv = new ContentValues();
//        if (time < maxThree) stars = 3;
//        if (time > maxThree && time < maxTwo) stars = 2;
//        if (time > maxTwo) stars = 1;
//
//        cv.put("stars", stars);
//
//        if (timeLevels.get(whereClause - 1).getStars() < stars)
//            timeDB.update("time", cv, "_id = " + whereClause, null);
//
//        updateTimeDBHelpers();
//        if ((catId != null) && (listOfCats.get(Integer.parseInt(catId) - 1).getUnlocked() != 1))
//            mainRunActivity.setView(new CongratsView(mainRunActivity, timeLevels.get(whereClause - 1).getNumber(), stars, listOfCats.get((Integer.parseInt(catId) - 1)), mainRunActivity.getString(R.string.time)));
//
//        else
//            mainRunActivity.setView(new CongratsView(mainRunActivity, timeLevels.get(whereClause - 1).getNumber(), stars, null, mainRunActivity.getString(R.string.time)));
//    }
//
 //    public static void updateStrategyMathsStars(int lives, int requestedLives, int stars, int whereClause, @Nullable String catId, MainRunActivity mainRunActivity, String key) {
//        ContentValues cv = new ContentValues();
//        if (lives == requestedLives) stars = 3;
//        if (lives < requestedLives && lives > 1) stars = 2;
//        if (lives == 1) stars = 1;
//        cv.put("stars", stars);
//
//        switch (key) {
//            case "strategy":
//                if (strategyLevels.get(whereClause - 1).getStars() < stars)
//                    strategyDB.update("strategy", cv, "_id = " + whereClause, null);
//                updateStrategyDBHelpers();
//                if ((catId != null) && (listOfCats.get(Integer.parseInt(catId) - 1).getUnlocked() != 1))
//                    mainRunActivity.setView(new CongratsView(mainRunActivity, strategyLevels.get(whereClause - 1).getNumber(), stars, listOfCats.get(Integer.parseInt(catId) - 1), "strategy"));
//                else
//                    mainRunActivity.setView(new CongratsView(mainRunActivity, strategyLevels.get(whereClause - 1).getNumber(), stars, null, "strategy"));
//                break;
//
//            case "maths":
//                if (mathsLevels.get(whereClause - 1).getStars() < stars)
//                    mathsDB.update("maths", cv, "_id = " + whereClause, null);
//                updateMathsDBHelpers();
//                if ((catId != null) && (listOfCats.get(Integer.parseInt(catId) - 1).getUnlocked() != 1))
//                    mainRunActivity.setView(new CongratsView(mainRunActivity, mathsLevels.get(whereClause - 1).getNumber(), stars, listOfCats.get(Integer.parseInt(catId) - 1), "maths"));
//                else
//                    mainRunActivity.setView(new CongratsView(mainRunActivity, mathsLevels.get(whereClause - 1).getNumber(), stars, null, "maths"));
//                break;
//        }
//
//    }
//
 //    public static void unlockCat(int whereClause) {
//        System.out.println("WHERE = " + whereClause);
//        ContentValues cv = new ContentValues();
//        cv.put("unlocked", 1);
//        catsDB.update("cats", cv, "_id = " + whereClause, null);
//        updateCatDBHelpers();
//    }
//
 //    public static void putCatIntoRoom(int room, int whereClause) {
//        ContentValues cv = new ContentValues();
//        cv.put("room", room);
//        catsDB.update("cats", cv, "_id = " + whereClause, null);
//        updateCatDBHelpers();
//    }
//
 //    public static ImageSet checkKey(String key) {
//        for (ImageSet im : imageSets) if (key.equals(im.getKey())) return im;
//        return null;
//    }
//
 //    public static void updateCatDBHelpers() {
//        listOfCats.clear();
//        listOfPets.clear();
//        for (int i = 0; i < catsCount; i++) {
//            catCursor = catsDB.rawQuery("SELECT * from cats WHERE _id = " + (i + 1), null);
//            if (catCursor != null && catCursor.moveToFirst()) {
//                listOfCats.add(new Cat(catCursor.getInt(0), catCursor.getString(1), catCursor.getString(2), catCursor.getInt(3), catCursor.getInt(4), catCursor.getInt(5), catCursor.getInt(6), catCursor.getInt(7), catCursor.getInt(8), catCursor.getInt(9), catCursor.getInt(10)));
//                listOfPets.add(new CatPet(listOfCats.get(i), catCursor.getInt(0), catCursor.getInt(8)));
//            }
//        }
//    }
//
 //    private static void updateTimeDBHelpers() {
//        timeLevels.clear();
//        for (int i = 0; i < levelsCount; i++) {
//            cursor = timeDB.rawQuery("SELECT * from time WHERE _id = " + (i + 1), null);
//            if (cursor != null && cursor.moveToFirst())
//                timeLevels.add(new Level(cursor.getInt(0), cursor.getInt(1)));
//        }
//    }
//
 //    private static void updateStrategyDBHelpers() {
//        strategyLevels.clear();
//        for (int i = 0; i < levelsCount; i++) {
//            strategyCursor = strategyDB.rawQuery("SELECT * from strategy WHERE _id = " + (i + 1), null);
//            if (strategyCursor != null && strategyCursor.moveToFirst())
//                strategyLevels.add(new Level(strategyCursor.getInt(0), strategyCursor.getInt(1)));
//        }
//    }
//
 //    private static void updateMathsDBHelpers() {
//        mathsLevels.clear();
//        for (int i = 0; i < levelsCount; i++) {
//            mathsCursor = mathsDB.rawQuery("SELECT * from maths WHERE _id = " + (i + 1), null);
//            if (mathsCursor != null && mathsCursor.moveToFirst())
//                mathsLevels.add(new Level(mathsCursor.getInt(0), mathsCursor.getInt(1)));
//        }
//    }
//
 //    public static void choosePlayer(int whereClause) {
//        ContentValues cv = new ContentValues();
//        cv.put("chosen", 1);
//
//        boolean unlocked = false;
//
//        catCursor = catsDB.rawQuery("SELECT * from cats WHERE _id = " + whereClause, null);
//        if (catCursor != null && catCursor.moveToFirst())
//            if (catCursor.getInt(7) == 1) unlocked = true;
//
//        if (unlocked) {
//            for (int j = 0; j < catsCount; j++) {
//                catCursor = catsDB.rawQuery("SELECT * from cats WHERE _id = " + (j + 1), null);
//                if (catCursor != null && catCursor.moveToFirst())
//                    if (catCursor.getInt(6) == 1) {
//                        ContentValues cvNot = new ContentValues();
//                        cvNot.put("chosen", 0);
//                        catsDB.update("cats", cvNot, "_id = " + catCursor.getInt(0), null);
//                        updateCatDBHelpers();
//                    }
//            }
//
//            catsDB.update("cats", cv, "_id = " + whereClause, null);
//        }
//        updateCatDBHelpers();
//    }
//
 //    public static void timeLevelFinish(TimeLevel timeLevel, GameView gameView, boolean requirements,
//                                       int levelNum, @Nullable String rewardId, GameView restart, Media.Music music) {
//        if (timeLevel.getPassingDoor().isClicked() && requirements) {
//            BasicGameSupport.updateTimeStars(timeLevel.getEndTime(), timeLevel.getThreeStars(), timeLevel.getTwoStars(), gameView.getStars(), levelNum, rewardId, gameView.getMainRunActivity());
//            TimeLevelsView.levelRunning = false;
//            music.stop();
//            try {
//                BitmapLoader.menuMusic.run();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            timeLevel.getPassingDoor().notClicked();
//        }
//        if (timeLevel.isGameOver()) {
//            TimeLevelsView.levelRunning = false;
//            music.stop();
//            try {
//                BitmapLoader.menuMusic.run();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            timePlayer.setRocketMode(false);
//            gameView.getMainRunActivity().setView(new GameOverView(gameView.getMainRunActivity(), restart, gameView.getMainRunActivity().getString(R.string.time)));
//
//        }
//    }
//
 //    public static SpriteAnimation
//            asteroidItem = new SpriteAnimation(asteroidSprite),
//
//    grayWalkLeft = new SpriteAnimation(walkLeftGray),
//            grayStandRight = new SpriteAnimation(standRightGray),
//            grayStandLeft = new SpriteAnimation(standLeftGray),
//            grayWalkRight = new SpriteAnimation(walkRightGray),
//            grayJumpRight = new SpriteAnimation(jumpRightGray),
//            grayJumpLeft = new SpriteAnimation(jumpLeftGray),
//            grayRocket = new SpriteAnimation(rocketGray),
//
//    orangeStandRight = new SpriteAnimation(standRightOrange),
//            orangeStandLeft = new SpriteAnimation(standLeftOrange),
//            orangeWalkRight = new SpriteAnimation(walkRightOrange),
//            orangeWalkLeft = new SpriteAnimation(walkLeftOrange),
//            orangeJumpRight = new SpriteAnimation(jumpRightOrange),
//            orangeJumpLeft = new SpriteAnimation(jumpLeftOrange),
//            orangeRocket = new SpriteAnimation(rocketOrange),
//
//    greenAlienStandRight = new SpriteAnimation(standRightGreenAlien),
//            greenAlienStandLeft = new SpriteAnimation(standLeftGreenAlien),
//            greenAlienWalkRight = new SpriteAnimation(walkRightGreenAlien),
//            greenAlienWalkLeft = new SpriteAnimation(walkLeftGreenAlien),
//            greenAlienJumpRight = new SpriteAnimation(jumpRightGreenAlien),
//            greenAlienJumpLeft = new SpriteAnimation(jumpLeftGreenAlien),
//            greenAlienRocket = new SpriteAnimation(rocketGreenAlien),
//
//    shadowStandRight = new SpriteAnimation(standRightShadow),
//            shadowStandLeft = new SpriteAnimation(standLeftShadow),
//            shadowWalkRight = new SpriteAnimation(walkRightShadow),
//            shadowWalkLeft = new SpriteAnimation(walkLeftShadow),
//            shadowJumpRight = new SpriteAnimation(jumpRightShadow),
//            shadowJumpLeft = new SpriteAnimation(jumpLeftShadow),
//            shadowCatRocket = new SpriteAnimation(rocketShadow),
//
//    mainCoonStandRight = new SpriteAnimation(standRightMainCoon),
//            mainCoonStandLeft = new SpriteAnimation(standLeftMainCoon),
//            mainCoonWalkRight = new SpriteAnimation(walkRightMainCoon),
//            mainCoonWalkLeft = new SpriteAnimation(walkLeftMainCoon),
//            mainCoonJumpRight = new SpriteAnimation(jumpRightMainCoon),
//            mainCoonJumpLeft = new SpriteAnimation(jumpLeftMainCoon),
//            mainCoonRocket = new SpriteAnimation(rocketMainCoon);
}
