package src.com.test;

import src.com.service.SmallBallAnalyService;

public class demo2 {
    public static void main(String[] args){
        SmallBallAnalyService smallBallAnalyService = new SmallBallAnalyService(64);
        smallBallAnalyService.get_smallball_list();
    }
}
