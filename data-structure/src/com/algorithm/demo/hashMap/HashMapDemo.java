package com.algorithm.demo.hashMap;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author Rosemary
 * @Date: 2022-10-05-9:51
 * @Description: HashMap本质就是在于存放元素的时候，定位数据ID而不是遍历查找
 * 可做唯一码的有HashCode但是HashCode取值范围过大
 * [-2147483648,2147483647]占用过多空间，不方便处理
 * 所以需要散列来存储
 *
 * 扩容是进行了拆分扩容，将数据的新旧hashCode值进行对比，如果是相同的那就在原位，如果不是，那么原位下标上添加16（扩容的大小）
 *
 * 链表与树的转换也是个问题 结构为：数组+链表/红黑树
 * 而转化为树有两个条件：链表长度大于等于8 以及 桶容量大于64，如果没有达到这两个条件，那么是不会被转化为树的、
 * //Node说明代码——去看HashMap源码 主要在于Node之间的转换TreeNode和Node以及链表之间
 * @Version 1.0
 */
public class HashMapDemo<K, V> {

    private static final int MAXIMUM_CAPACITY =  1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("asdf");
        strings.add("awer");
        strings.add("atrj");
        strings.add("ajh");
        strings.add("test");
        strings.add("atrjj");
        strings.add("ajuh");
        strings.add("tpest");
        strings.add("tatrj");
        strings.add("ajhui");
        strings.add("test67");

        //长度为2的幂次方是为了出现除高位以外都是1的特征，方便散列计算。
        //因为只有（2^n）-1才会出现这样的特征
        String[] newTab = new String[16];
        for (String key : strings) {
            System.out.println(key.hashCode());
            //扰动函数获取对应数据
            int hashDemoCode = hash(key);
            //取模运算拿到标准下标
            int index = hashDemoCode & (newTab.length - 1);
            System.out.println("key value = " + key + " index value = " + index);
            if (newTab[index] == null) {
                newTab[index] = key;
                continue;
            }
            newTab[index] = newTab[index] + "->" + key;
        }
        for (String key : newTab) {
            System.out.println(key);
        }
    }

    //扰动函数是为了在存放数据时将数据存放得更加均匀
    public static final int hash(Object key) {
        int index;
        return (key == null) ? 0 : (index = key.hashCode()) ^ (index >>> 16);
    }
    //为了扩容需要计算阈值
    public static final int tableSizeFor(int cap){
        //使用2^n来位移是为了占位，获取到邻近数据的最小倍数
        int n = cap-1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n<0)?1:(n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }



}
