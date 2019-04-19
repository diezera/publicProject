package com.common.utils.util;


import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public int maxArea(int[] height) {
            int max=0;
            for (int i=0;i<height.length;i++){
                for (int j=i;j<height.length;j++){
                    int length=height[i];
                    if(height[i]>height[j]){
                        length=height[j];
                    }
                    int temp=length*(j-i);
                    if(temp>max){
                        max=temp;
                    }
                }
            }
            return  max;
    }


    public static void main(String[] args) {
        System.out.println();
    }
}
