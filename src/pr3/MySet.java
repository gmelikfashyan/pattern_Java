package pr3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class MySet<T> implements Set<T> {
    private Set<T> set;
    private final Semaphore semaphore;

    public MySet() {
        this.set = new HashSet<>();
        this.semaphore = new Semaphore(1);
    }

    @Override
    public int size() {
        int res = 0;
        try {
            semaphore.acquire();
            res = set.size();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            return res;
        }
    }

    @Override
    public boolean isEmpty() {
        boolean res = true;
        try {
            semaphore.acquire();
            res = set.isEmpty();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public boolean contains(Object o) {
        boolean res = true;
        try {
            semaphore.acquire();
            res = set.contains(o);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> res = null;
        try {
            semaphore.acquire();
            res = set.iterator();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] res = null;
        try {
            semaphore.acquire();
            res = set.toArray();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        T1[] res = null;
        try {
            semaphore.acquire();
            res = (T1[]) set.toArray();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public boolean add(T t) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.add(t);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public boolean remove(Object o) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.remove(o);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.containsAll(c);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.addAll(c);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.retainAll(c);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.removeAll(c);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            set.clear();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String s = null;
        try {
            semaphore.acquire();
            s = set.toString();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return s;
        }
    }
}