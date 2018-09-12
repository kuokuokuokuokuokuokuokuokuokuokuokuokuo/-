package com.ikats.scheduler.util;

/**
 * @Author : liu kuo
 * @Date : 2017/11/23 11:08.
 * @Description : Indulge in study , wasting away
 */
public class SystemOutMessage
{
    public static void start(String job,String date)
    {
        System.out.println("++++++++++   " + job + "   start   " + date + "   ++++++++++");
    }

    public static void body(String message)
    {
        System.out.println("-----------   " + message + "   -----------");
    }

    public static void end(String job,String date)
    {
        System.out.println("++++++++++   " + job + "   end   " + date + "   ++++++++++");
    }
}
