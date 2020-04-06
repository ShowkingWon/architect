package data.structure;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JerryWan
 * @descripion TODO
 * @date 2020-03-04  20:46
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, List> map  = new HashMap(8);
        List<Integer> list1 = Lists.newArrayList(1,2);
        List<Integer> list2 = Lists.newArrayList(1,2,3,4);
        List<Integer> list3 = Lists.newArrayList(1,2,3,4,5,6);
        List<Integer> list4 = Lists.newArrayList(1,2,3,4,5,6,7,8);
        map.put("0", list1);
        map.put("1", list2);
        map.put("2", list3);
        map.put("4", list4);

        //System.out.println("map = " + map);
        System.out.println(map.get("0"));
        System.out.println(map.get("1"));
        System.out.println(map.get("2"));
        System.out.println(map.get("4"));


    }
}
