package com.util;

public class SmallBallAly {
    private String sixteen_sort;
    private String recent_balls;

    public SmallBallAly() {
    }

    public SmallBallAly(String sixteen_sort, String recent_balls) {
        this.sixteen_sort = sixteen_sort;
        this.recent_balls = recent_balls;
    }

    public String getSixteen_sort() {
        return sixteen_sort;
    }

    public void setSixteen_sort(String sixteen_sort) {
        this.sixteen_sort = sixteen_sort;
    }

    public String getRecent_balls() {
        return recent_balls;
    }

    public void setRecent_balls(String recent_balls) {
        this.recent_balls = recent_balls;
    }
    public String parity_analy(String sixteen_list ){
        String[] str1 = sixteen_list.replace("\n", ",").split(",");
        int even = 0;
        int odd = 0;
        for (String str2 : str1) {
            if (Integer.parseInt(str2) % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return "odd:" + odd + ",even:" + even;
    }
    public String group_analy(String sixteen_list,String recent_list){
        String[] sixteen_list_arr = sixteen_list.replace("\n", ",").split(",");
        String[] recent_list_arr = recent_list.replace("\n", ",").split(",");

        int[] int_arr1 = new int[sixteen_list_arr.length/2];
        int[] int_arr2 = new int[sixteen_list_arr.length/2];
        //分成两组第一个与最后一个绑定。以此类推。十指相扣分开成两组。
        for(int i =0,j=0,k=0;i<sixteen_list_arr.length/2;i++){
            if(i%2==0){
                int_arr1[j] = Integer.parseInt(sixteen_list_arr[i]);
                int_arr1[sixteen_list_arr.length/2-j-1] = Integer.parseInt(sixteen_list_arr[sixteen_list_arr.length-i-1]);
                j++;
            }else {
                int_arr2[k] = Integer.parseInt(sixteen_list_arr[i]);
                int_arr2[sixteen_list_arr.length/2-k-1] = Integer.parseInt(sixteen_list_arr[sixteen_list_arr.length-i-1]);
                k++;
            }
        }
        int x1 = 0;
        int y1 = 0;
        for(String str2:recent_list_arr){
            boolean flag = true;
            for(int index :int_arr1){
                if(Integer.parseInt(str2)==index){
                    x1++;
                    flag=false;
                    break;
                }
            }
            if(flag==false){
                continue;
            }
            for(int index :int_arr2){
                if(Integer.parseInt(str2)==index){
                    y1++;
                    break;
                }
            }
        }
        return "group1:"+x1+",group2:"+y1;
    }
}
