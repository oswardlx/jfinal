package com.controller;

import com.jfinal.core.Controller;
import com.service.SmallBallAnalyService;

import java.util.HashMap;
import java.util.Map;

public class GetBallListController extends Controller {
    public void index(){
        int mount = getParaToInt("mount");
        SmallBallAnalyService sbas = new SmallBallAnalyService(mount);
        int x =0;
        Map<String,Object> map = new HashMap<>();
        System.out.println(22221111);
        for(String str :sbas.get_smallball_list()){
            System.out.println(33322);
            System.out.println(str);
            map.put(x+"",str);
            x++;
        }
        Map<String,Object>map2 = new HashMap<>();
        map2.put("list",map);
        map2.put("success",true);
        renderJson(map2);
    }
}
