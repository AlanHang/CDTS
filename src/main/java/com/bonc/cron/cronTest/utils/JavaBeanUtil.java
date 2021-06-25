package com.bonc.cron.cronTest.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-24 15:06
 */
public class JavaBeanUtil {
    /**
     * 将一个集合的对象拷贝到另一个对象
     * @param list 需要拷贝的集合
     * @param genericType 目标的类型
     * @return
     */
    public static <T> List<T> copyListBean(List list, Class<T> genericType) {
        List resList = new ArrayList();
        for (Object o1 : list) {
            try {
                T o = genericType.newInstance();
                BeanUtils.copyProperties(o1,o);
                resList.add(o);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return resList;
    }

    /**
     * @param obj 需要拷贝的类
     * @param genericType 目标的类型
     * @return
     * */
    public static <T> T copyBean(Object obj, Class<T> genericType) {

        T newInstance = null;
        try {
            newInstance = genericType.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(obj,newInstance);

        return newInstance;
    }
}
