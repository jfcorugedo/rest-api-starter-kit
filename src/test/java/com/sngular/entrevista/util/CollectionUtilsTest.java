package com.sngular.entrevista.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class CollectionUtilsTest {

	@Test
	public void testCloneList() {
		List<Object> firstList = new ArrayList<Object>();
		firstList.add(1);
		firstList.add("test");
		firstList.add(3.5);
		
		List<Object> secondList = CollectionUtils.cloneList(firstList);
		
		firstList.add("another");
		secondList.remove(1);
		
		assertThat(firstList).hasSize(4);
		assertThat(firstList).containsExactly(1,"test",3.5,"another");
		assertThat(secondList).hasSize(2);
		assertThat(secondList).containsExactly(1,3.5);
	}
	
	
	@Test
	public void testConvertToPrimitives() {
		List<Double> listOfObjects = new ArrayList<Double>();
		listOfObjects.add(Double.valueOf(1.0));
		listOfObjects.add(Double.valueOf(2.0));
		listOfObjects.add(Double.valueOf(3.0));
		
		double[] arrayOfPrimitives = CollectionUtils.convertToPrimitives(listOfObjects);
		
		assertThat(arrayOfPrimitives).hasSize(3);
		assertThat(arrayOfPrimitives).containsExactly(1.0,2.0,3.0);
	}
	
	@Test
	public void testArrayToList() {
		Double[] array = new Double[]{1d,2d,3d,4d};
		
		List<Double> list = CollectionUtils.arrayToList(array);
		
		assertThat(list).hasSize(4);
		assertThat(list).containsExactly(1d,2d,3d,4d);
	}
	
	@Test
	public void testIsEmptyMapReturnsTrueWhenNull() {
		
		Map<Object, Object> nullMap = null;
		
		boolean result = CollectionUtils.isEmpty(nullMap);
		
		assertThat(result).isTrue();
		assertThat(CollectionUtils.isNotEmpty(nullMap)).isFalse();
	}
	
	@Test
	public void testIsEmptyMapReturnsTrueWhenThereIsNoElements() {
		
		Map<Object, Object> emptyMap = new HashMap<Object, Object>();
		
		boolean result = CollectionUtils.isEmpty(emptyMap);
		
		assertThat(result).isTrue();
		assertThat(CollectionUtils.isNotEmpty(emptyMap)).isFalse();
	}
	
	@Test
	public void testIsEmptyMapReturnsFalseWhenThereIsAtLeastOneElements() {
		
		Map<Object, Object> notEmptyMap = new HashMap<Object, Object>();
		notEmptyMap.put(new Object(), null);
		
		boolean result = CollectionUtils.isEmpty(notEmptyMap);
		
		assertThat(result).isFalse();
		assertThat(CollectionUtils.isNotEmpty(notEmptyMap)).isTrue();
	}
	
	@Test
	public void testIsEmptyListReturnsTrueWhenNull() {
		
		List<Object> nullList = null;
		
		boolean result = CollectionUtils.isEmpty(nullList);
		
		assertThat(result).isTrue();
		assertThat(CollectionUtils.isNotEmpty(nullList)).isFalse();
	}
	
	@Test
	public void testIsEmptyListReturnsTrueWhenThereIsNoElements() {
		
		List<Object> emptyList = new ArrayList<Object>();
		
		boolean result = CollectionUtils.isEmpty(emptyList);
		
		assertThat(result).isTrue();
		assertThat(CollectionUtils.isNotEmpty(emptyList)).isFalse();
	}
	
	@Test
	public void testIsEmptyListReturnsFalseWhenThereIsAtLeastOneElements() {
		
		List<Object> notEmptyList = new ArrayList<Object>();
		notEmptyList.add(null);
		
		boolean result = CollectionUtils.isEmpty(notEmptyList);
		
		assertThat(result).isFalse();
		assertThat(CollectionUtils.isNotEmpty(notEmptyList)).isTrue();
	}
	
	@Test
	public void testListToArray() {
		
		List<Double> list = CollectionUtils.newList(1d, 2d, 3d, 4d);
		
		double[] array = CollectionUtils.listToPrimitiveArray(list);
		
		assertThat(array).hasSize(list.size());
		assertThat(array).containsExactly(1d,2d,3d,4d);
	}
	
	@Test
	public void testListToArrayReturnsEmptyArray() {
		
		List<Double> list = null;
		
		double[] array = CollectionUtils.listToPrimitiveArray(list);
		
		assertThat(array).hasSize(0);
	}
	
	@Test
	public void newSet() {
		
		Set<Integer> set = CollectionUtils.newSet(1, 2, 3, 4);
		
		assertThat(set).containsOnly(1, 2, 3, 4);
	}
	
	@Test
	public void newMap() {
		
		Map<String, Double> map = CollectionUtils.newMap();
		map.put("test", 1.0);
		
		assertThat(map).hasSize(1);
	}
	
	@Test
	public void newMapWithInitialCapacity() {
		
		Map<String, Double> map = CollectionUtils.newMap(10);
		map.put("test", 1.0);
		
		assertThat(map).hasSize(1);
	}
	
	@Test
	public void newMapWithInitialValues() {
		
		Map<String, Double> initialValues = new HashMap<>(1);
		initialValues.put("test", 1.0);
		
		Map<String, Double> map = CollectionUtils.newMap(initialValues);
		
		assertThat(map).hasSize(1);
		assertThat(map.get("test")).isEqualTo(1.0);
	}
	
	@Test
	public void newMapWithInitialValue() {
		
		Map<String, Double> map = CollectionUtils.newMap("test", 1.0);
		
		assertThat(map).hasSize(1);
		assertThat(map.get("test")).isEqualTo(1.0);
	}
	
	@Test
	public void newOrderedMap() {
		
		Map<String, Integer> orderedMap = CollectionUtils.newOrderedMap();
		orderedMap.put("1", 1);
		orderedMap.put("2", 2);
		orderedMap.put("3", 3);
		
		assertThat(orderedMap.keySet()).containsExactly("1", "2", "3");
		assertThat(orderedMap.values()).containsExactly(1, 2, 3);
	}
	
	@Test
	public void newOrderedMapWithInitialCapacity() {
		
		Map<String, Double> map = CollectionUtils.newOrderedMap(10);
		map.put("test", 1.0);
		
		assertThat(map).hasSize(1);
	}
}
