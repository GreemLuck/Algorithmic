package Serie8;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value>
        implements ISortedSymbolTable<Key, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int n;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
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
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) { return null; }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            } else {
                Node t = node;
                node = min(t.right);
                node.right = deleteMin(t.right);
                node.left = t.left;
            }
        }

        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

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
    public void deleteMin() {
        if(!isEmpty()) {
            root = deleteMin(root);
        }
    }

    private Node deleteMin(Node node) {
        if(node.left == null) {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
            node.n = size(node.left) + size(node.right) + 1;
            return node;
        }
    }

    @Override
    public void deleteMax() {
        if(!isEmpty()) {
            root = deleteMax(root);
        }
    }

    private Node deleteMax(Node node) {
        if(node.right == null) {
            return node.left;
        } else {
            node.right = deleteMax(node.right);
            node.n = size(node.left) + size(node.right) + 1;
            return node;
        }
    }

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
