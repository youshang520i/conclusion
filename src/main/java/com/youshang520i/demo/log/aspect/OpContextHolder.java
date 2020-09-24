package com.youshang520i.demo.log.aspect;

public final class OpContextHolder {

    private static ThreadLocal<Object> contextHolder = new ThreadLocal<>();

    public static void set(Object o) {
        contextHolder.set(o);
    }

    public static Object get() {
        return contextHolder.get();
    }

    public static void remove() {
        contextHolder.remove();
    }

}
