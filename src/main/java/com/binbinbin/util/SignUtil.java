package com.binbinbin.util;


import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bin on 2017/12/12.
 */
public class SignUtil {
    public static void main(String[] args) {
        final HashMap<String,Object> hashMap=new HashMap<>();
        //hashMap.put("sign","3ec209c352d13016882e7547647712a9");
        hashMap.put("cooperator_user_phone","13201828182");
        hashMap.put("channelStatus","3");
        hashMap.put("status","Success");
        hashMap.put("repayPlanId","19ee54ac23b14b179f6b32b066d9947d");
        hashMap.put("cooperator_item_id","LP454686867440439299");

        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(10);
        for (int i=0;i<1000;i++){
            fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                String mySign= SignUtil.createYJSign(hashMap);
                System.out.println(mySign);
            }
            });
        }
    }
    public static String createYJSign(HashMap<String,Object> hashMap){
        return createYJSign(hashMap, "SGNB");
    }
    public static String createYJSign(HashMap<String,Object> hashMap,String key){
        return MD5Util.getMD5String(convert(hashMap)+"&key="+key);
    }
    public static String convert(HashMap<String, Object> hashMap) {
        if (!hashMap.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            ArrayList<String> rest = new ArrayList<String>();
            Iterator<Map.Entry<String, Object>> iterator = hashMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> next = iterator.next();
                String key = next.getKey();
                rest.add(key);
            }
            Object[] array = rest.toArray();
            Arrays.sort(array, new Comparator<Object>() {
                public int compare(Object o1, Object o2) {
                    return o1.toString().compareTo(o2.toString());
                }
            });
            for (int i = 0; i < array.length; i++) {
                builder.append(array[i] + "=" + hashMap.get(array[i]));
                //builder.append(hashMap.get(array[i]));
                if (i != array.length - 1) {
                    builder.append("&");
                }
            }
            return builder.toString();
        } else {
            return null;
        }
    }
}
