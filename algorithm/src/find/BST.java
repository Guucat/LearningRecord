package find;

/**
 * @author shengyi
 * @create 2021/8/7 - 19:45
 */
public class BST<Key extends Comparable<Key>, Value> {
    //二叉树根结点K
    private Node root;
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        //以该节点为根，子树中结点的总数
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    public Value get(Key key) {
        return  get(root, key);
    }

    private Value get(Node x, Key key) {
        //以 X 为根结点的子树中查找并返回 Key 所对应的值
        //查找不到返回 null
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    public void put(Key key, Value value) {
        //查找 Key 找到则更新它的值，否则为它创建一个新结点
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        //如果 key 存在于以 x 为根结点的子树中则更新它的值
        //否则将以 key 和 value 为键值对的新结点插入到该子树中
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    

}
