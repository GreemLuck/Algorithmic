package Serie7;

import java.util.LinkedList;

public class BinarySearchST<Key extends Comparable<Key>, Value>
    extends AbstractSortedSymbolTable<Key, Value> {

    private Key[] keys;
    private Value[] vals;
    private int n;

    @SuppressWarnings("unchecked")
    public BinarySearchST() {
        int initCapa = 100;
        n = 0;
        keys = (Key[]) new Comparable[initCapa];
        vals = (Value[]) new Object[initCapa];
    }


    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[n - 1];
    }

    @Override
    public Key floor(Key key) {
        int i = rank(key);
        if(key.compareTo(keys[0]) < 0){
            return null;
        } else {
            return keys[i - 1];
        }
    }

    @Override
    public Key ceiling(Key key) {
        int i = rank(key);
        if (i == n) {
            return null;
        } else {
            return keys[i];
        }
    }

    @Override
    public int rank(Key key) {
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp <0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        LinkedList<Key> list = new LinkedList<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            list.add(keys[i]);
        }
        if(contains(hi)) {
            list.add(keys[rank(hi)]);
        }
        return list;
    }

    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = value;
            return;
        }

        if(n == keys.length) {
            resize(2 * keys.length);
        }

        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = value;
        n++;
    }

    @SuppressWarnings("unchecked")
    protected void resize(int maxCapa) {
        Key[] tempKeys = (Key[]) new Comparable[maxCapa];
        Value[] tempVals = (Value[]) new Object[maxCapa];

        for (int i = 0; i < n; i++) {
            tempKeys[i] = keys[i];
            tempVals[i] = vals[i];
        }
        keys = tempKeys;
        vals = tempVals;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return n;
    }
}
