package com.dao;

import com.entity.StageInfo;
import com.jfinal.plugin.activerecord.Db;

import java.util.ArrayList;
import java.util.List;

public class TicketDao {
    public void saveTicketDao(List<StageInfo> list) {
        System.out.println(list.get(0).toString());
        if (list.size() > 0) {
            try {
                int index;
                String appendsql = "";
                String singleParam = "";
                List<String> paramList = new ArrayList<>();
                System.out.println("list.size:"+list.size());
                for (index = 0; index < list.size(); index++) {
                    singleParam = "(" + listToString(list.get(index).getBigBallList(), ',') +","+ list.get(index).getSmallBall() + ")";
                    paramList.add(singleParam);
                }
                if(paramList.size()<0){
                    throw new RuntimeException("paramlist为空");
                }
                appendsql = listToString(paramList, ',');
                String sql = "INSERT INTO tickes_base (bigball1,bigball2,bigball3,bigball4,bigball5,bigball6,smallball) VALUES " + appendsql;

            } catch (Throwable t) {
                t.printStackTrace();
                throw new RuntimeException("数据库操作失败");
            }
        }else{
            throw new RuntimeException("list为空");
        }
    }

    private String listToString(List list, char separator) {
        System.out.println("ggggg");
        System.out.println(list.toString());
        System.out.println("ggggg");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(String.valueOf(list.get(i))).append(separator);
        }
        return sb.toString().substring(0, sb.toString().length() -1);
    }

}

