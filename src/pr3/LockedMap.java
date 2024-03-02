package lab3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedMap<K, V> implements Map<K, V>{
    Map<K, V> map = new HashMap<>();
     public static final Lock lock = new ReentrantLock();
    @Override
    synchronized public int size() {
        int result = map.size();
        return result;
    }

    @Override
    synchronized public boolean isEmpty() {
        boolean result = map.isEmpty();
        return result;
    }

    @Override
    synchronized public boolean containsKey(Object key) {
        boolean result = map.containsKey(key);
        return result;
    }

    @Override
    synchronized public boolean containsValue(Object value) {
        boolean result = map.containsValue(value);
        return result;
    }

    @Override
    synchronized public V get(Object key) {
        V result = map.get(key);
        return result;
    }

    @Override
    synchronized public V put(K key, V value) {
        V result = map.put(key, value);
        return result;
    }

    @Override
    synchronized public V remove(Object key) {
        V result = map.remove(key);
        return result;
    }

    @Override
    synchronized public void putAll(Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    @Override
    synchronized public void clear() {
        map.clear();
    }

    @Override
    synchronized public Set<K> keySet() {
        Set<K> result = map.keySet();
        return result;

    }

    @Override
    synchronized public Collection<V> values() {
        Collection result = map.values();
        return result;
    }

    @Override
    synchronized public Set<Entry<K, V>> entrySet() {
        Set result = map.entrySet();
        return result;
    }

    @Override
    synchronized public String toString() {
        return map.toString();
    }
}
