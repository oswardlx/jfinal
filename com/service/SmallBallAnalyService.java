package com.service;

import com.dao.SmallBallAnalyDao;
import com.entity.RecentNum;
import com.entity.SmallBallSort;
import com.util.SmallBallAly;

import java.util.List;

public class SmallBallAnalyService {
    public String[] get_sixteen(int mount){
        SmallBallAnalyDao dao = new SmallBallAnalyDao();
        List<SmallBallSort> sbs_list =  dao.get_sixteen();
        List<RecentNum> rn_list = dao.get_recent_num(mount);
        String[] sixteen_arr = new String[sbs_list.size()];
        String[] recent_arr = new String[rn_list.size()];
        for(int i =0;i<sbs_list.size();i++){
            sixteen_arr[i]=String.valueOf(sbs_list.get(i).getNum());
        }
        for(int i = 0;i<rn_list.size();i++){
            recent_arr[i] = String.valueOf(rn_list.get(i).getRecent_num());
        }

        SmallBallAly sba = new SmallBallAly();
        String parity_str = sba.parity_analy(recent_arr);
        String group_str  =sba.group_analy(sixteen_arr,recent_arr);
        String average_str = sba.average_side_analy(recent_arr);
        String[] result = new String[]{parity_str,group_str,average_str};
        return result;
    }
}
