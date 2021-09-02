package find;

/**
 * @author shengyi
 * @create 2021/8/7 - 17:13
 */


/**
 * @param <Key>
 * @param <Value>
 *基于无序链表的顺序查找
 */
public class SequentialSearch<Key, Value> {
    //链表首结点
    private Node first;
    private class Node{
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {

        for (Node node = first; node != null ; node = node.next) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node node = first; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.value = value;
            }
        }
        //
         first = new Node(key, value, first);
    }

    public static void main(String[] args) {
        SequentialSearch<String, Integer> sequentialSearch = new SequentialSearch<>();
        sequentialSearch.put("a", 2);
        sequentialSearch.put("1",33);
        if (sequentialSearch.get("1") != null) {
            int num = sequentialSearch.get("1");
            System.out.println(num);
        }

        System.out.println(sequentialSearch.get("a"));
    }

}
