package Serie9;

public interface ISortedSymbolTable<Key extends Comparable<Key>, Value> {

    void put(Key key, Value val);

    Value get(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    Key min();
    
    Key max();
    
    Key floor(Key key);
    
    Key ceiling(Key key);
    
    int rank(Key key);
    
    void deleteMin();
    
    void deleteMax();

    Iterable<Key> keys();   // or:  Iterator<Key> keys();
}
