package com.entity;

import java.util.List;

public class StageInfo {
    private List<Integer> bigBallList;
    private int smallBall;

    public List<Integer> getBigBallList() {
        return bigBallList;
    }

    public void setBigBallList(List<Integer> bigBallList) {
        this.bigBallList = bigBallList;
    }

    public int getSmallBall() {
        return smallBall;
    }

    public void setSmallBall(int smallBall) {
        this.smallBall = smallBall;
    }

    @Override
    public String toString() {
        return "StageInfo{" +
                "bigBallList=" + bigBallList +
                ", smallBall=" + smallBall +
                '}';
    }
}
