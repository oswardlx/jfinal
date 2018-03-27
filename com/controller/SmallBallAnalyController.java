package com.controller;

import com.entity.SmallBallSort;
import com.jfinal.core.Controller;
import com.service.SmallBallAnalyService;

import java.util.List;

public class SmallBallAnalyController extends Controller {
    public void index() {
        int mount = getParaToInt("mount");
        SmallBallAnalyService sbas = new SmallBallAnalyService();
        String[] smallball_aly_result = sbas.get_sixteen(mount);
        for(int i=0;i<smallball_aly_result.length;i++){
            setAttr("result"+i,smallball_aly_result[i]);
        }
        renderJson();
    }
}
