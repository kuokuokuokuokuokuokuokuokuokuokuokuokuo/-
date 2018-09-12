package com.ikats.scheduler.util;



/**
 * @Author : liu kuo
 * @Date : 2017/12/7 14:29.
 * @Description : Indulge in study , wasting away
 */
public class JobDataTransferUtil
{
    /**
     * 字符串转换为 int
     * @param arg
     * @return
     */
    public static int stringToInt(String arg)
    {
        try{
            Double dV = Double.parseDouble(arg);
            return dV.intValue();
        }catch (Exception e){
            return 0;
        }
    }
}
