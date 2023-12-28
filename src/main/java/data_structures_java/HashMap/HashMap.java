package data_structures_java.HashMap;

import java.util.ArrayList;

public class HashMap <K,V> {

    int numberOfBuckets;
    ArrayList<LinkedList<K,V>> map;

    public HashMap() {
        numberOfBuckets = 10;
        this.map = new ArrayList<>(numberOfBuckets);

        for(int i = 0; i < numberOfBuckets; i++){
            this.map.add(null);
        }

    }

    public int getBucketIndex(K key){
        int hash = Math.abs(key.hashCode());
        int index = hash % numberOfBuckets;
        System.out.println("Key: " + key + " Hash: " + hash + " Index: " + index);
        return index;
    }

    public V get(K key){

        int bucketIndex = getBucketIndex(key);

        LinkedList<K, V> myLinkedList = this.map.get(bucketIndex);

        if(myLinkedList == null){
            System.out.println("Node not present.");
            return null;
        }
        
        MyMapNode<K,V> searchResult = myLinkedList.search(key);
            
        if(searchResult == null){
            System.out.println("Node not present.");
            return null;
        }
        
        return myLinkedList.search(key).value;
    }

    public boolean find(K key){

        int bucketIndex = getBucketIndex(key);

        LinkedList<K, V> myLinkedList = this.map.get(bucketIndex);
        if(myLinkedList == null)
            return false;

        MyMapNode<K, V> searchResult = myLinkedList.search(key);

        if(searchResult == null){
            return false;
        }
        return true;
    }

    public void put(K key, V value){

        int bucketIndex = getBucketIndex(key);

        LinkedList<K, V> myLinkedList = this.map.get(bucketIndex);

        if(myLinkedList == null){
            System.out.println("Did not found LL for " + key);
            LinkedList<K,V> newLinkedList = new LinkedList<>();
            this.map.set(bucketIndex, newLinkedList);
            this.map.get(bucketIndex).add(key, value);
        }else{

            System.out.println("Found LL for " + key);
            MyMapNode<K,V> searchResult = myLinkedList.search(key);
            
            if(searchResult == null){
                System.out.println("Adding the value");
                myLinkedList.add(key, value);
            }else{
                System.out.println("Updating the value");
                myLinkedList.update(key, value);
            }
        }
    }

    public void remove(K key){
        int bucketIndex = getBucketIndex(key);

        LinkedList<K, V> myLinkedList = this.map.get(bucketIndex);

        if(myLinkedList == null){
            System.out.println("Key not present");
            return;
        }else{
            MyMapNode<K,V> searchResult = myLinkedList.search(key);
            
            if(searchResult == null){
                System.out.println("Key not present");
                return;
            }else{
                myLinkedList.delete(key);
            }
        }
    }

    public void display(){
        if(map.isEmpty())
            System.out.println("Hash Table is empty.");
        else
            System.out.println(toString());
    }
    
    @Override
    public String toString() {
        
        return "MyHashMapNodes{" + map + '}'; 
    }
    
}
