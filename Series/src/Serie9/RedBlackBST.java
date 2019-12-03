package Serie9;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackBST<Key extends Comparable<Key>, Value>
        implements ISortedSymbolTable<Key, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int n;
        boolean color;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            this.n = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null) {
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.val;
        }
    }

    public Key select(int k) {
        if (k < 0 || k >= size()) {
            return null;
        } else {
            Node node = select(root, k);
            return node.key;
        }
    }

    private Node select(Node node, int k) {
        if (node == null) {
            return null;
        } else {
            int t = size(node.left);
            if (k == t) {
                return node;
            } else if (k < t) {
                return select(node.left, k);
            } else {
                return select(node.right, k-t-1);
            }
        }
    }

    @Override
    public void delete(Key key) throws NotImplementedException { }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return root.n == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public Key min() {
        if (root == null) {
            return null;
        } else {
            return min(root).key;
        }
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    @Override
    public Key max() {
        if (root == null) {
            return null;
        } else {
            return max(root).key;
        }
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return max(node.right);
        }
    }

    @Override
    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        } else {
            return node.key;
        }
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return floor(node.left, key);
        } else {
            Node t = floor(node.right, key);
            if (t != null) {
                return t;
            } else {
                return node;
            }
        }
    }

    @Override
    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null) {
            return null;
        } else {
            return node.key;
        }
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return ceiling(node.right, key);
        } else {
            Node t = ceiling(node.left, key);
            if (t != null) {
                return t;
            } else {
                return node;
            }
        }

    }

    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if(node == null) {
            return 0;
        } else {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                return size(node.left);
            } else if (cmp < 0) {
                return rank(node.left, key);
            } else {
                return 1 + size(node.left) + rank(node.right, key);
            }
        }
    }

    @Override
    public void deleteMin()throws NotImplementedException {}

    @Override
    public void deleteMax() throws NotImplementedException {}

    private int size(Node node) {
        if(node == null) {
            return 0;
        } else {
            return node.n;
        }
    }

    @Override
    public Iterable keys() {
        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue) {
        if (node == null) {
            return;
        }
        keys(node.left, queue);
        queue.add(node.key);
        keys(node.right, queue);
    }
}
