package lab.collections.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import lab.collections.ListUtils;

/**
 * Created by nmpacko on 17/11/2019.
 */
@RunWith(JUnit4.class)
public class ListUtilsTest {


	@Test
	public void shouldReturnCorrectPartionList(){
		List<Integer> list= Arrays.asList(1,2,3,4,5);
		int partitionSize=2;
		List<List<Integer>> expectedList= new ArrayList();
		expectedList.add(Arrays.asList(1,2));
		expectedList.add(Arrays.asList(3,4));
		expectedList.add(Arrays.asList(5));

		List<List<Integer>> actualList= ListUtils.partition(list,partitionSize);

		//test partitions number
		assertEquals(Math.ceil(list.size()/partitionSize+ list.size()%partitionSize), actualList.size(),0);
		//test partition correctness
		assertEquals(expectedList,actualList);
		//test partition size
		actualList.stream().forEach(l->assertTrue(l.size()<=partitionSize));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldRejetPartitionSizeLowerThanOne() {
		List<Integer> dummyList= Arrays.asList(1,2,3,4,5);
		int partitionSize=-1;
		List<List<Integer>> actualList= ListUtils.partition(dummyList,partitionSize);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldejectPartitionSizeGreaterThanListSize() {
		List<Integer> dummyList= Arrays.asList(1,2,3,4,5);
		int partitionSize=6;
		List<List<Integer>> actualList= ListUtils.partition(dummyList,partitionSize);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldRejectEmptyList() {
		List<Integer> list= Collections.EMPTY_LIST;
		int dummyPartitionSize=1;
		List<List<Integer>> actualList= ListUtils.partition(list,dummyPartitionSize);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldRejectNullList() {
		List<Integer> list= null;
		int dummyPartitionSize=1;
		List<List<Integer>> actualList= ListUtils.partition(list,dummyPartitionSize);
	}
}
