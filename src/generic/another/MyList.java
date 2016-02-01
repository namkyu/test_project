package generic.another;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @FileName : MyList.java
 * @Project : test_project
 * @Date : 2016. 1. 8.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public interface MyList<E, T> extends List<E> {

}

class TestChild implements MyList<String, Object> {

	/**
	 * <pre>
	 * size
	 *
	 * <pre>
	 * @return
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * <pre>
	 * isEmpty
	 *
	 * <pre>
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * <pre>
	 * contains
	 *
	 * <pre>
	 * @param o
	 * @return
	 */
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * <pre>
	 * iterator
	 *
	 * <pre>
	 * @return
	 */
	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * toArray
	 *
	 * <pre>
	 * @return
	 */
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * toArray
	 *
	 * <pre>
	 * @param a
	 * @return
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * add
	 *
	 * <pre>
	 * @param e
	 * @return
	 */
	@Override
	public boolean add(String e) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * <pre>
	 * remove
	 *
	 * <pre>
	 * @param o
	 * @return
	 */
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * <pre>
	 * containsAll
	 *
	 * <pre>
	 * @param c
	 * @return
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * <pre>
	 * addAll
	 *
	 * <pre>
	 * @param c
	 * @return
	 */
	@Override
	public boolean addAll(Collection<? extends String> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * <pre>
	 * addAll
	 *
	 * <pre>
	 * @param index
	 * @param c
	 * @return
	 */
	@Override
	public boolean addAll(int index, Collection<? extends String> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * <pre>
	 * removeAll
	 *
	 * <pre>
	 * @param c
	 * @return
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * <pre>
	 * retainAll
	 *
	 * <pre>
	 * @param c
	 * @return
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * <pre>
	 * clear
	 *
	 * <pre>
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	/**
	 * <pre>
	 * get
	 *
	 * <pre>
	 * @param index
	 * @return
	 */
	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * set
	 *
	 * <pre>
	 * @param index
	 * @param element
	 * @return
	 */
	@Override
	public String set(int index, String element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * add
	 *
	 * <pre>
	 * @param index
	 * @param element
	 */
	@Override
	public void add(int index, String element) {
		// TODO Auto-generated method stub

	}

	/**
	 * <pre>
	 * remove
	 *
	 * <pre>
	 * @param index
	 * @return
	 */
	@Override
	public String remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * indexOf
	 *
	 * <pre>
	 * @param o
	 * @return
	 */
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * <pre>
	 * lastIndexOf
	 *
	 * <pre>
	 * @param o
	 * @return
	 */
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * <pre>
	 * listIterator
	 *
	 * <pre>
	 * @return
	 */
	@Override
	public ListIterator<String> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * listIterator
	 *
	 * <pre>
	 * @param index
	 * @return
	 */
	@Override
	public ListIterator<String> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * subList
	 *
	 * <pre>
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	@Override
	public List<String> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}



}