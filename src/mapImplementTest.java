/**
 * Created by root on 30/03/16.
 */

import org.junit.Test;
import java.io.Console;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class mapImplementTest {
    @Test
    public void mapTest() throws InstantiationException, IllegalAccessException {
        mapImplement<Integer,String> map = new mapImplement<>();
        map.put(3,"f");
        assertEquals(map.size(), 1);
        assertEquals(map.get(3), "f");
        assertEquals(map.get(2), null);
        assertTrue(!map.containsKey(1));
        map.put(27,"Ivan");
        assertTrue(map.containsValue("Ivan"));
        System.out.print(map.values());
        map.put(27, "Cassandra");
        map.remove(3);
        System.out.println(map.values());
        assertFalse(map.containsValue("Ivan"));
        System.out.print(map.entrySet());

    }

}
