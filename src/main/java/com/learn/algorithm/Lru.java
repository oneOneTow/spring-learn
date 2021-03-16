package com.learn.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: luzhiqing
 * @date: 2021/3/3
 * @version:
 */
public class Lru {
    private static Map<String, Node> CACHE_MAP = new HashMap<>();
    private static Node HEAD;
    private static Node TAIL;
    private static int CAPACITY = 10;

    public static synchronized Object get(String key) {
        Node node = CACHE_MAP.get(key);
        if (null != node) {
            node.setPre(null);
            HEAD.setPre(node);
            node.setPost(HEAD);
            HEAD = node;
            return node.getValue();
        } else {
            Object loadObj = load(key);
            if (CACHE_MAP.size() == CAPACITY) {
                removeNode();
            } else {
                Node insertNode = new Node();
                insertNode.setKey(key);
                insertNode.setValue(loadObj);
                insertNode(insertNode);
            }
            return loadObj;
        }
    }

    private static void insertNode(Node node) {
        if (null == HEAD) {
            HEAD = node;
            TAIL = node;
            node.setPost(node);
            node.setPre(node);
        } else {
            HEAD.setPre(node);
            node.setPost(HEAD);
            HEAD = node;
        }
        CACHE_MAP.put(node.getKey(), node);
    }

    private static void removeNode() {
        Node removeNode = TAIL;
        TAIL = removeNode.getPre();
        TAIL.setPost(null);
        removeNode.setPost(null);
        removeNode.setPre(null);
    }

    public static Object load(String key) {
        return null;
    }
}


class Node {
    private String key;
    private Object value;
    private Node pre;
    private Node post;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getPost() {
        return post;
    }

    public void setPost(Node post) {
        this.post = post;
    }
}
