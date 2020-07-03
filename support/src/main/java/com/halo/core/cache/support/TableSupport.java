package com.halo.core.cache.support;

import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: 对redis的table表格存储的支持工具类
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-05-20 15:39
 */
public class TableSupport<T extends  Serializable> {
    public static void main(String[] args) {

    }

    public Map<String,T> buildRecordData(List<T> tableData){
//        return tableData.stream().collect(Collectors.toMap(HashMap::new))
        return null;
    }
}
