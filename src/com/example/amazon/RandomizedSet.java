//Design a data structure that supports all following operations in average O(1) time.

//insert(val): Inserts an item val to the set if not already present.
//remove(val): Removes an item val from the set if present.
//getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

//Example:
// Init an empty set.
//RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
//randomSet.insert(1);

// Returns false as 2 does not exist in the set.
//randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
//randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
//randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
//randomSet.remove(1);

// 2 was already in the set, so return false.
//randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
//randomSet.getRandom();

package com.example.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> values;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        values.add(val);
        map.put(val, values.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int elementPosition = map.get(val);
        int lastPosition = values.size() - 1;
        if (elementPosition < lastPosition) {
            swapElements(elementPosition, lastPosition);
            map.put(values.get(elementPosition), elementPosition);
        }

        map.remove(val);
        values.remove(lastPosition);
        return true;
    }

    private void swapElements(int i, int j) {
        int currentElement = values.get(i);
        values.set(i, values.get(j));
        values.set(j, currentElement);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (values.isEmpty()) {
            return 0;
        }
        if (values.size() == 1) {
            return values.get(0);
        }
        return values.get(random.nextInt(values.size()));
    }

    public static void main(String[] args) {
        int val = 1;
        RandomizedSet obj = new RandomizedSet();
        boolean param1 = obj.insert(val);
        boolean param2 = obj.remove(val);
        int param3 = obj.getRandom();
    }
}
