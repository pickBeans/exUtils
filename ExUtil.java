package com.datagovernance.devicemanager.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取数学期望
 */
public class ExUtil {

    private ExUtil(){}

    /**
     * 获取期望 保留两位小数
     * 2020.4.19
     * @param list
     * @return
     */
    public static String getDataEx(List<Double> list){
        if(list == null){
            throw new RuntimeException("list is null！！1");
        }
        Map<Double,Integer> map = new HashMap<>();

        for(Double d : list){
            Integer num = map.get(d);
            if(num == null){
                map.put(d, 1);
            }else{
                map.put(d, num + 1);
            }
        }
        double size = (double)list.size();
        Double result = 0d;
        for(Map.Entry<Double,Integer> entry : map.entrySet()){
            Double num = entry.getKey();
            Integer count = entry.getValue();
            result = result + num * (count / size);
        }
        String format = String.format("%.2f", result);
        return format;
    }
}
