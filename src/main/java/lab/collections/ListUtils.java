package lab.collections;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Created by nmpacko on 17/11/2019.
 */
public class ListUtils {

	/**
	 * Return a List of subList. Each subList represents a partition of the original list.
	 * the size of each sublist is lower or equal than the partition size. 
	 * @param <T> - The  Parameteritzed type of the list
	 * @param list - The list to be partitionated
	 * @param partitionSize - the max size of each partition
	 * @return the list of  partitions
	 * @throws IllegalArgumentException for an illegal partition size : lower than 1 or greater than list size<br/>
	 * 									  For an illegal  list: null or empty
	 */
	public static <T>  List<List<T>> partition(List<T> list, int partitionSize){

		if (list==null || list.isEmpty()) throw new IllegalArgumentException("The list cannot be empty or null");
		if (partitionSize<1 || partitionSize>list.size()) throw new IllegalArgumentException("Partition size must greater than 0 and lower than list size");
		
		int finalIndex=list.size()-1;
		List<List<T>> partitionsList=
				//get all list index
				IntStream.range(0,finalIndex+1)
				// extract all partitions start index
				.filter(index-> {return (index==0||index%partitionSize==0);})
				// build each partition from its start index to the next start index
				.mapToObj(startIndex->{
					int nextStartIndex=startIndex+partitionSize;
					return list.subList(startIndex,nextStartIndex<=finalIndex?nextStartIndex:finalIndex+1);})
				// collect all partitions
				.collect(Collectors.toList());
		return partitionsList;
	}
}
