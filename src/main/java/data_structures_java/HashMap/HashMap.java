package data_structures_java.HashMap;

public class HashMap <K,V> {
    public LinkedList<K,V> map;

    public HashMap() {
        this.map = new LinkedList<K, V>();
    }

    public V get(K key){
        
        boolean getResult = find(key);
            
        if(!getResult){
            System.out.println("Node not present.");
            return null;
        }
        
        return map.search(key).value;
    }

    public boolean find(K key){

        MyMapNode<K, V> searchResult = map.search(key);

        if(searchResult == null){
            return false;
        }
        return true;
    }

    public void put(K key, V value){

        if(find(key) == false)
            map.add(key,value);    
        else
            map.update(key, value);
    }

    public void remove(K key){
        if(find(key)){
            map.delete(key);
        } else{
            System.out.println("Key not present");
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
