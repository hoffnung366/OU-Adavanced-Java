/**
 * This class represent an Association Table that can contain generic contents in sorted order of its keys
 *
 * @author Nadya Balandin (ID 336103726)
 * @version 01/01/2022
 */

import java.util.*;

public class AssociationTable<K,V> {
    private TreeMap<K,V> data;

    //constructors
    /**
     * Constructs an empty association table
     */
    public AssociationTable() {
        data = new TreeMap<K,V>();
    }

    /**
     * Constructs an association table with given key-value pairs
     * @param keys - an array of keys
     * @param values - an array of values, match with the array of keys
     */
    public AssociationTable(K[] keys, V[] values) throws IllegalArgumentException {
        if(keys.length != values.length)
            throw new IllegalArgumentException("Amount of keys and values are not equal.");

        HashMap<K,V> temp = new HashMap<>();
        // Associates the specified value with the specified key in temp map.
        // If the map previously contained a mapping for the key, the old value is replaced.
        for(int i=0; i<keys.length; i++) {
            temp.put(keys[i], values[i]);
        }

        // to sort the key-value pairs by their key
        data = new TreeMap<>(temp);
    }

    /**
     * Returns the array list of keys containing in association table
     * @return the array list of keys containing in association table
     */
    public ArrayList<K> getKeys() {
        Set<K> keys = data.keySet();
        ArrayList<K> res = new ArrayList<>();
        for(K key : keys)
            res.add(key);
        return res;
    }

    /**
     * Adds the specified value with the specified key in this table.
     * If the table previously contained the adding key, the old value is replaced
     * @param key - key with which the specified value is to be associated
     * @param value - value to be associated with the specified key
     */
    public void add(K key,V value) {
        data.put(key, value);
    }

    /**
     * Returns the value for the specified key, or null if this map contains no mapping for the key.
     * @param key - the key whose associated value is to be returned
     * @return the value for the specified key, or null if this map contains no mapping for the key.
     */
    public V get(K key) {
        return data.get(key);
    }

    /**
     * Returns true if this table contains the specified key.
     * @param key - key whose presence in this table is to be tested
     * @return true if this table contains the specified key.
     */
    public boolean contains(K key) {
        return data.containsKey(key);
    }

    /**
     * Removes the instance for this key from this table if present.
     * @param key - key for which instance should be removed
     * @return true if the key-value pair was removed
     */
    public boolean remove(K key) {
        if(data.containsKey(key) == false & data.remove(key) == null)
            return false;
        return true;
    }

    /**
     * Returns the number of key-value instance in this table.
     * @return the number of key-value instance in this table.
     */
    public int size() {
        return data.size();
    }

    /**
     * Returns an iterator over elements of type K.
     * @return an iterator over elements of type K.
     */
    public Iterator<K> keyIterator() {
        return new AssociationTableIterator<K>();
    }

    //This class represents the iterator for an association table
    private class AssociationTableIterator<K> implements Iterator<K> {
        private int current = 0;
        private K[] arr;

        //constructor - creates an array of keys of the table
        public AssociationTableIterator() {
            arr = (K[])data.keySet().toArray();
        }

        //Returns true if the iteration has more elements.
        public boolean hasNext() {
            return current < arr.length;
        }

        //Returns the next element in the iteration.
        public K next() {
            K key = arr[current++];
            return key;
        }
    } // end of private class AssociationTableIterator<K>
} //end of class AssociationTable<K,V>
