import java.util.*;

/**
 * Created by yn on 2016/11/3.
 */
public class WeakHashMapTest {


    public void testWeakHashMapAPIs() {
        String w1 = new String("one");
        String w2 = new String("two");
        String w3 = new String("three");

//        Map map = new HashMap();
//        map.put(w1, "w1");
//        map.put(w2, "w2");
//        map.put(w3, "w3");

        Map wmap = new WeakHashMap();
        wmap.put(w1, "w1");
        wmap.put(w2, "w2");
        wmap.put(w3, "w3");

        System.out.printf("\nwmap:%s\n", wmap);

        System.out.printf("contains key two : %s\n", wmap.containsKey("two"));
        System.out.printf("contains key five : %s\n", wmap.containsKey("five"));

        System.out.printf("contains value 0 : %s\n", wmap.containsValue(new Integer(0)));

        wmap.remove("three");

        System.out.printf("wmap: %s\n", wmap);

        //-- 测试WeakHashMap 自动回收特性
//        map.remove(w1);
//        map = null;

        w1 = null;

        System.gc();

        Iterator it = wmap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            System.out.printf("next : %s - %s\n", entry.getKey(), entry.getValue());
        }
        System.out.printf("after gc WeakHashMap size:%s\n", wmap.size());
    }

    public static void main(String[] args) {
        WeakHashMapTest t = new WeakHashMapTest();
        t.testWeakHashMapAPIs();
    }
}

