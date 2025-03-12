package com.daisypig.common.toolkit;




import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现深度的BeanOfClasssA<->BeanOfClassB复制
 * 不要使用Apache Common BeanUtils进行类复制，每次就行反射查询对象的属性列表, 非常缓慢.
 * orika性能比Dozer快近十倍
 *
 * @author liangjh
 * @date 2019/09/02 16:21
 */
public class BeanToolkit {


    /**
     * 强烈推荐使用单例获取BeanMapper对象
     *
     * @return
     */
    public static BeanToolkit instance() {
        return BeanToolkitHolder.INSTANCE;
    }

    /**
     * 该方法仅限于newInstance()方法构造出来的多例的BeanMapper对象，
     * 不允许直接使用INSTANCE单例的BeanMapper对象，
     * 否则会抛出Cannot register converters after MapperFacade has been initialized异常
     *
     * @param
     * @return
     */
    public <S, D> D copy(S source, Class<D> destinationClass) {
        if (source == null) {
            return null;
        }
        try {
            D target = destinationClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            return null;
        }
    }

    public <S, D> List<D> copyList(Iterable<S> sourceList, Class<D> destinationClass) {
        if (CollectionUtils.isEmpty((List<?>) sourceList)) {
            return new ArrayList<>();
        }
        List<D> targetList = new ArrayList<>();
        for (S source : sourceList) {
            D target = copy(source, destinationClass);
            if (target != null) {
                targetList.add(target);
            }
        }
        return targetList;
    }



    private BeanToolkit(boolean defaultRegisterConverter) {
        // Spring BeanUtils不需要初始化
    }

    /**
     * 使用内部类实现单例
     */
    private static class BeanToolkitHolder {
        private static final BeanToolkit INSTANCE = new BeanToolkit(true);
    }


}
