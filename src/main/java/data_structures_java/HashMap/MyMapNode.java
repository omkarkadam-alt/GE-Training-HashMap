package data_structures_java.HashMap;

public class MyMapNode <K, V> {
    K key;
    V value;
    MyMapNode<K, V> next;

    MyMapNode(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        StringBuilder myMapNodeString = new StringBuilder();
        myMapNodeString. append ("MyMapNode{" + "K=").append(key).append(" V=").append(value).append('}');
        if (next != null)
            myMapNodeString.append("->").append(next);
        return myMapNodeString.toString();
    }

}
