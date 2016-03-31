import java.util.*;

/**
 * Created by root on 29/03/16.
 */
public class mapImplement<K,V> implements Map {
    private ArrayList<V> values;
    private ArrayList<K> keys;

    public mapImplement() throws IllegalAccessException, InstantiationException {
        values = new ArrayList<>(100);
        keys = new ArrayList<>(100);
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return keys.contains(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return values.contains(o);
    }

    @Override
    public Object get(Object o) {
        if(!keys.contains(o)) return null;
        return values.get(keys.indexOf(o));
    }

    @Override
    public Object put(Object o, Object o2) {
        if(keys.contains(o)){
            V val = values.get(keys.indexOf(o));
            values.set(keys.indexOf(o), (V) o2);
            return val;
        }
        keys.add((K) o);
        values.add(keys.indexOf(o), (V) o2);
        return null;
    }

    @Override
    public Object remove(Object o) {
        if (keys.contains(o)) {
            V v = values.get(keys.indexOf(o));
            values.remove(keys.indexOf(o));
            keys.remove(o);
            return v;
        }
        return null;
    }

    @Override
    public void putAll(Map map) {

    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Set keySet() {
        Set<K> key = new HashSet<>(keys);
        return key;
    }

    @Override
    public Collection values() {
        return values;
    }

    @Override
    public Set<iEntry> entrySet() {
        Set<iEntry> SetEntry = new HashSet<>();
        for(K key: keys){
            iEntry<K,V> entry = new iEntry<>(key, values.get(keys.indexOf(key)));
            SetEntry.add(entry);
        }
        return SetEntry;
    }

    class iEntry<K,V> implements Entry{

        public K k;
        public V v;

        public iEntry(K key, V value){
            this.k = key;
            this.v = value;
        }

        @Override
        public Object getKey() {
            return k;
        }

        @Override
        public Object getValue() {
            return v;
        }

        @Override
        public Object setValue(Object o) {
            return null;
        }
    }
}
