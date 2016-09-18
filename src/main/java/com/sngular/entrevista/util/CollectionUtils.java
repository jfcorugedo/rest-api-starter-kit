package com.sngular.entrevista.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class CollectionUtils {

	private CollectionUtils(){
		
	}
	
	public static <T> List<T> arrayToList(T[] array){
		List<T> list = new ArrayList<>(array.length);
		for(T element : array){
			list.add(element);
		}
		
		return list;
	}

	/**
	 * Return true if this map is null or it's empty.
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Map<? extends Object, ? extends Object> map) {
		return map == null || map.size() == 0;
	}
	
	public static boolean isEmpty(Collection<? extends Object> list) {
		return list == null || list.isEmpty();
	}
	
	/**
	 * Return true if this map contains one value at least
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isNotEmpty(Map<? extends Object, ? extends Object> map) {
		return !isEmpty(map);
	}
	
	public static boolean isNotEmpty(Collection<? extends Object> collection) {
		return !isEmpty(collection);
	}
	
	/**
	 * Converts the given list of Double objects into an array of primitive doubles.
	 * 
	 * If the list is null or empty, an empty array will be returned
	 * 
	 * @param inputList List of Double object to be converted in a primitive array
	 * @return
	 */
	public static double[] listToPrimitiveArray(List<Double> inputList) {
		
		if(isEmpty(inputList)){
			return new double[0];
		} else {
			return inputList.stream().mapToDouble(Double::new).toArray();
		}
	}
	
	/**
	 * This method creates a new list and store in it all the objects contained in the
	 * given list.
	 * 
	 * @param targetList Source list used to create a new one
	 * @return New list containing all the objects of the primitive list
	 */
	public static <T> List<T> cloneList(List<T> targetList) {
		return targetList.stream().collect(Collectors.toList());
	}
	
	/**
	 * Transform a list of objects into an array of primitives
	 * 
	 * @param listOfObject
	 * @return
	 */
	public static double[] convertToPrimitives(List<Double> listOfObjects) {
		return listOfObjects.stream().mapToDouble(Double::doubleValue).toArray();
	}
	
	/**
	 * Creates a new list with the given elements
	 * @param values
	 * @return
	 */
	@SafeVarargs
	public static <T> List<T> newList(T... values) {
		List<T> arrayList = new ArrayList<>(values.length);
		for(T element : values) {
			arrayList.add(element);
		}
		
		return arrayList;
	}
	
	/**
	 * Creates a new list with the given elements
	 * @param values
	 * @return
	 */
	@SafeVarargs
	public static <T> Set<T> newSet(T... values) {
		HashSet<T> set = new HashSet<>(values.length);
		for(T element : values) {
			set.add(element);
		}
		
		return set;
	}
	
	/**
	 * it returns an ordered Map implementation
	 * 
	 * @return
	 */
	public static <T, D> Map<T, D> newOrderedMap() {
		return new LinkedHashMap<>();
	}
	
	/**
	 * it returns an ordered Map implementation with the specified initial capacity
	 * 
	 * @return
	 */
	public static <T, D> Map<T, D> newOrderedMap(int initialCapacity) {
		return new LinkedHashMap<>(initialCapacity);
	}
	
	/**
     * it returns an ordered Set implementation with the specified initial capacity
     * 
     * @return
     */
    public static <T> Set<T> newOrderedSet(int initialCapacity) {
        return new LinkedHashSet<>(initialCapacity);
    }
    
    /**
     * it returns an ordered Set implementation
     * 
     * @return
     */
    public static <T> Set<T> newOrderedSet() {
        return new LinkedHashSet<>();
    }
	
	/**
	 * it returns a Map implementation
	 * 
	 * @return
	 */
	public static <T, D> Map<T, D> newMap() {
		return new HashMap<>();
	}
	
	/**
	 * It returns a Map implementation using the given initial capacity
	 * 
	 * @param initialCapacity
	 * @return
	 */
	public static <T, D> Map<T, D> newMap(int initialCapacity) {
		return new HashMap<>(initialCapacity);
	}
	
	/**
	 * It returns a Map implementation using the given elements
	 * 
	 * @param initialCapacity
	 * @return
	 */
	public static <T, D> Map<T, D> newMap(Map<T, D> initialValues) {
		return new HashMap<>(initialValues);
	}
	
	/**
	 * It returns a Map implementation and initializes it with the given element
	 * 
	 * @param initialCapacity
	 * @return
	 */
	public static <T, D> Map<T, D> newMap(T key, D value) {
		Map<T, D> result = new HashMap<>();
		result.put(key, value);
		return result;
	}
}
