package com.algorithm.demo.linearlist.linkedlist;

/**
 * 单链表
 */
public class LinkedWithoutHead {
    Object content;
    LinkedWithoutHead back;

    public LinkedWithoutHead() {

    }

    public LinkedWithoutHead(Object content) {
        this.content = content;
    }

    //插入
    public void insert(Object content, LinkedWithoutHead target) {
        if (content != null && target != null) {
            LinkedWithoutHead back = target.back;
            //找到最后的
            while (back != null) {
                back = back.back;
            }
            back.back = new LinkedWithoutHead(content);
        }
    }

    //查找
    public LinkedWithoutHead findContent(Object content, LinkedWithoutHead target) {
        while (target != null) {
            if (content.equals(target.content)) {
                return target;
            }
            target = target.back;
        }
        return null;
    }

    //删除
    public int deleteSingleLinked(Object content, LinkedWithoutHead target) {
        int res = -1;
        LinkedWithoutHead head = target;
        while (target != null) {
            //拆连接
            if (content.equals(target.content)) {
                head = target.back;
                target.content = null;
                res = 1;
                return res;
            } else {
                head = target;
                target = target.back;
            }
        }
        res = 0;
        return res;
    }
}
