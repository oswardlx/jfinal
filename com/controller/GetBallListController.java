package com.controller;

import com.jfinal.core.Controller;
import com.service.SmallBallAnalyService;

import java.util.HashMap;
import java.util.Map;

public class GetBallListController extends Controller {
    public void index() {
        int mount = getParaToInt("mount");
        SmallBallAnalyService sbas = new SmallBallAnalyService(mount);
        int x = 0;
        Map<String, Object> map = new HashMap<>();
        for (String str : sbas.get_smallball_list()) {
            map.put(x + "", str);
            x++;
        }
        System.out.println("result:1111");
        for (int i : get_result()) {
            System.out.println(i);
        }
        System.out.println("result:2222");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("list", map);
        map2.put("success", true);
        renderJson(map2);
    }

    private static int[] get_result() {
        int a1 = 0, a2 = 0, a3 = 0, a4 = 0;
        for (int i = 15; i <= 90; i++) {
            SmallBallAnalyService sbas = new SmallBallAnalyService(i);
            System.out.println("[0]"+sbas.get_smallball_list()[0]);
            if(sbas.get_smallball_list()[0].equals("1")){
                a1++;
            }else if(sbas.get_smallball_list()[0].equals("2")){
                a2++;
            }else if(sbas.get_smallball_list()[0].equals("8")){
                a3++;
            }else if(sbas.get_smallball_list()[0].equals("16")){
                a4++;
            }
        }
        int[] result = new int[]{a1, a2, a3, a4};
        return result;
    }
}
