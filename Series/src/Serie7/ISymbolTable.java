package Serie7;

public interface ISymbolTable<Key, Value> {
    void put(Key key, Value value);

    Value get(Key key);

    boolean contains(Key key);

    void delete(Key key);

    boolean isEmpty();

    int size();

    Iterable<Key> keys();
}
