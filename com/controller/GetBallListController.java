package com.controller;

import com.jfinal.core.Controller;
import com.service.SmallBallAnalyService;

public class GetBallListController extends Controller {
    public void index(){
        int mount = getParaToInt("mount");
        SmallBallAnalyService sbas = new SmallBallAnalyService(mount);
        sbas.get_smallball_list();

    }
}
