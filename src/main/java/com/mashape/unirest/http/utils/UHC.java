/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.mashape.unirest.http.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @title UHC
 * @desc UHC是UserHeaderContainer的简称，一般通过filter把此次请求的额外header信息放到这里，在该次请求里所有的http请求都会带上这里定义的header
 * @author macrohuang
 * @date Mar 7, 2016
 * @version 1.0
 */
public class UHC {
    private static final InheritableThreadLocal<Map<String, String>> CUSTOM_HEADERS = new InheritableThreadLocal<>();
    public static void put(String key, String value){
        if ( CUSTOM_HEADERS.get()==null){
            CUSTOM_HEADERS.set(new HashMap<String,String>());
        }
        CUSTOM_HEADERS.get().put(key, value);
    }
    
    public static void putAll(Map<String, String> headers){
        CUSTOM_HEADERS.set(headers);
    }
    
    public static void remove(String key){
        if( CUSTOM_HEADERS.get()!=null){
            CUSTOM_HEADERS.get().remove(key);
        }
    }
    
    public static void reset(){
        CUSTOM_HEADERS.remove();
    }
    
    public static String get(String key){
        if( CUSTOM_HEADERS.get()!=null){
            CUSTOM_HEADERS.get().get(key);
        }
        return null;
    }
    
    public static Map<String, String> getAll(){
        return CUSTOM_HEADERS.get();
    }
}
