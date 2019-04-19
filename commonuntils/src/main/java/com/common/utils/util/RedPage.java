package com.common.utils.util;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class RedPage {
    public static List<BigDecimal> pageList=new ArrayList<>();
    private  volatile  int path;

    public static void redom(int personCount,BigDecimal money) {
        List<BigDecimal> rods=new ArrayList<>();

        BigDecimal count=BigDecimal.ZERO;
        BigDecimal max=new BigDecimal(200);
        BigDecimal min=new BigDecimal(0.01);
        for(int i=0;i<personCount;i++){
            BigDecimal random=BigDecimal.valueOf(Math.random());
            rods.add(random);
            count=count.add(random);
        }
        System.out.println(count);
        BigDecimal counts=BigDecimal.ZERO;

        //先取出大于200的红包
        for (int i=0;i<rods.size();i++){
            BigDecimal a=rods.get(i).divide(count,4,BigDecimal.ROUND_HALF_DOWN);
            BigDecimal b=a.multiply(money);
            if(b.compareTo(max)==1){
                b=max;
                System.out.println("最大值红包:"+b);
                count=count.subtract(rods.get(i));
                money=money.subtract(b);
                rods.remove(i);
                personCount--;
                i--;
                pageList.add(b);
            }
        }

        //先取出小于0.1的红包
        for (int i=0;i<rods.size();i++){
            BigDecimal a=rods.get(i).divide(count,4,BigDecimal.ROUND_HALF_DOWN);
            BigDecimal b=a.multiply(money);
            if(b.compareTo(min)==-1){
                b=min;
                count=count.subtract(rods.get(i));
                money=money.subtract(b);
                rods.remove(i);
                personCount--;
                i--;
                pageList.add(b);
            }
        }
        BigDecimal countMoney=BigDecimal.ZERO;
        for (int i=0;i<rods.size();i++){


            BigDecimal a=rods.get(i).divide(count,4,BigDecimal.ROUND_HALF_DOWN);

            BigDecimal b=a.multiply(money);
            if(b.compareTo(max)==1||b.compareTo(min)==-1){
                money=money.subtract(countMoney);
                redom(personCount, money);
                break;
            }
            countMoney=countMoney.add(b);
            personCount--;
            pageList.add(b);



        }

    }

    public static void main(String[] args) {
        redom(5,new BigDecimal(900));
        System.out.println(pageList.toString());
    }
}
