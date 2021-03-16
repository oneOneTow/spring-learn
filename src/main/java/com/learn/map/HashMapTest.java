package com.learn.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: luzhiqing
 * @date: 2021/3/12
 * @version:
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("","");
        map.get("");
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.parseInt("1111111111111111111111111111111",2));
        System.out.println(Integer.parseUnsignedInt("11111111111111111111111111110110",2));
        List<CreditDocDatumDTO> relateDocDatumDTOS= new ArrayList<>();
        Map<String, CreditDocDatumDTO> relateDocDatumMap = relateDocDatumDTOS.stream().collect(Collectors.toMap(CreditDocDatumDTO::getFK, Function.identity()));
        relateDocDatumMap.get("");
    }

    class CreditDocDatumDTO{
        private String fk;
        public String getFK(){
            return "";
        }
    }
}
