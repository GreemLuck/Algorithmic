package Serie7;

public interface ISortedSymbolTable<Key extends Comparable<Key>, Value>
        extends ISymbolTable<Key, Value> {
    Key min();

    Key max();

    Key floor(Key key);

    Key ceiling(Key key);

    int rank(Key key);

    Key select(int k);

    void deleteMin();

    void deleteMax();

    int size(Key lo, Key hi);

    Iterable<Key> keys(Key lo, Key hi);
}
