package jaspion;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ListUtil {
	
	public static <T, E> List<T> map(Function<E, T> func, List<E> list, Class<T> clazz) {
		return list.stream()
				   .map(func)
				   .collect(Collectors.toList());
	}
	
	public static <T> List<T> map(Function<T, T> func, List<T> list) {
		return list.stream()
				   .map(func)
				   .collect(Collectors.toList());
	}
	
	public static <T, E> List<T> map(Function<E, T> func, List<E> list, Class<T> clazz, Supplier<List<T>> c) {
		return list.stream()
				   .map(func)
				   .collect(Collectors.toCollection(c));
	}
	
	public static <T> List<T> map(Function<T, T> func, List<T> list, Supplier<List<T>> c) {
		return list.stream()
				   .map(func)
				   .collect(Collectors.toCollection(c));
	}
	
	public static <T> List<T> filter(Predicate<T> predicate, List<T> list) {
		return list.stream()
				   .filter(predicate)
				   .collect(Collectors.toList());
	}
	
	@SuppressWarnings("unchecked")
	public static <T, E> List<T> filter(Predicate<E> predicate, List<E> list, Class<T> clazz) {
		return list.stream()
				   .filter(predicate)
				   .map(x -> (T) x)
				   .collect(Collectors.toList());
	}
	
	public static <T> List<T> filter(Predicate<T> predicate, List<T> list, Supplier<List<T>> c) {
	    return list.stream()
	               .filter(predicate)
	               .collect(Collectors.toCollection(c));
	}
	
	@SuppressWarnings("unchecked")
    public static <E, T> List<T> filter(Predicate<E> predicate, List<E> list, Class<T> clazz, Supplier<List<T>> c) {
	    return list.stream()
	               .filter(predicate)
	               .map(x -> (T) x)
	               .collect(Collectors.toCollection(c));
	}
}
