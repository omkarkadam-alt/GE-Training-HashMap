package data_structures_java.HashMap;

public class LinkedList<K, V> {
    
    MyMapNode<K, V> head;
    MyMapNode<K, V> tail;
    

    LinkedList(){
        this.head = null;
        this.tail = null;
    }

    void add(K key, V value){

        if(head == null){
            head = new MyMapNode<K, V>(key, value);
            tail = head;
            return;
        }
        
        MyMapNode<K, V> newNode = new MyMapNode< K, V>(key, value);
        tail.next = newNode;
        tail = tail.next;
    }

    void delete(K key){
        MyMapNode<K, V> temp = head;
        
        if(head.key.equals(key)){
            head = head.next;
            temp.next = null;
            return;
        }
        
        while(temp.next.key != key){
            temp = temp.next;
        }

        MyMapNode<K, V> temp2 = temp.next;
        temp.next = temp.next.next;
        temp2.next = null;
        return;
    }

    MyMapNode<K, V> search(K key){
        MyMapNode<K, V> temp = head;

        while(temp != null){
            if(temp.key.equals(key)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    int size(){
        MyMapNode<K,V> temp = head;

        int nodeCount = 0;
        while(temp != null){
            temp = temp.next;
            nodeCount++;
        }
        return nodeCount;
    }

    boolean isEmpty(){
        return this.head == null;
    }

    void update(K key, V value){

        MyMapNode<K, V> temp = head;
        
        if(!temp.key.equals(key)){
            temp = temp.next;
        }

        temp.value = value;
    }

    void printMyNodes(){
        System.out.println("My Nodes: " + head);
    }

    @Override
    public String toString() {
        
        return "MyLinkedListNodes{" + head + '}'; 
    }

}
