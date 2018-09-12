package com.ikats.scheduler.util;

import redis.clients.jedis.Jedis;

/**
 * @Author : liu kuo
 * @Date : 2017/8/4 13:42.
 * @Description : Indulge in study , wasting away
 */
public class JedisUtil
{
    // expireTime 以秒为单位
    private static int expireTime = 1800;

    private static String index = "quartz_index";

    private static String PAGE_NO = "guan_yi_page_no";

    private static String ORDER_PAGE_NO = "gy_order_page_no";
    /**
     * redis 保存token 过期时间默认 30分钟
     *
     */
    public synchronized static Long getIndex()
    {
        Long quartzIndex = 0L;
        Jedis jedis = JedisClient.getJedis();
        try
        {
            quartzIndex = jedis.incr(index);
        } catch (Exception e) {
            System.out.println("Set key error : " + e);
        }
        JedisClient.returnResource(jedis);
        return quartzIndex;
    }

    public synchronized static Long getGuanYiSkuPageNo()
    {
        Long pageNo = 0L;
        Jedis jedis = JedisClient.getJedis();
        try
        {
            pageNo = jedis.incr(PAGE_NO);
        } catch (Exception e) {
            System.out.println("Set key error : " + e);
        }
        JedisClient.returnResource(jedis);
        return pageNo;
    }

    public synchronized static Long initGuanYiSkuPageNo()
    {
        Long pageNo = 0L;
        Jedis jedis = JedisClient.getJedis();
        try
        {
            jedis.set(PAGE_NO,"0");
        } catch (Exception e) {
            System.out.println("Set key error : " + e);
        }
        JedisClient.returnResource(jedis);
        return pageNo;
    }

    public synchronized static Long getGuanYiOrderPageNo()
    {
        Long pageNo = 0L;
        Jedis jedis = JedisClient.getJedis();
        try
        {
            pageNo = jedis.incr(ORDER_PAGE_NO);
        } catch (Exception e) {
            System.out.println("Set key error : " + e);
        }
        JedisClient.returnResource(jedis);
        return pageNo;
    }

    public synchronized static Long initGuanYiOrderPageNo()
    {
        Long pageNo = 0L;
        Jedis jedis = JedisClient.getJedis();
        try
        {
            jedis.set(ORDER_PAGE_NO,"0");
        } catch (Exception e) {
            System.out.println("Set key error : " + e);
        }
        JedisClient.returnResource(jedis);
        return pageNo;
    }
}
