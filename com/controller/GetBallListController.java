package com.controller;

import com.jfinal.core.Controller;
import com.service.SmallBallAnalyService;

public class GetBallListController extends Controller {
    public void index(){
        int mount = getParaToInt("mount");
        SmallBallAnalyService sbas = new SmallBallAnalyService(mount);
        int x =0;
        for(String str :sbas.get_smallball_list()){
            setAttr("result"+x,str);
            x++;
        }
        renderJson();
    }
}
