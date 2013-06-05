package de.hu_berlin.german.korpling.saltnpepper.salt.graph.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * This list is an unmodifiable implementation of type {@link EList}. It contains a constructor to which
 * you could pass a {@link Collection} object, to which all methods will be delegated. The methods {@link #listIterator()} 
 * and {@link #listIterator(int)} are implemented corresponding to class {@link Vector} referring to the given {@link Collection}
 * object.
 * 
 * @author Florian Zipser
 *
 * @param <E>
 */
public class UnmodifiableEList<E> implements EList<E>, InternalEList<E>{
	/**
	 * {@link Collection} object, to which all methods are delegated
	 */
	private Collection<E> delegatee= null; 
	public UnmodifiableEList(Collection<E> delegatee)
	{
		this.delegatee= Collections.unmodifiableCollection(delegatee);
	}

	@Override
	public int size() {
		return delegatee.size();
	}

	@Override
	public boolean isEmpty() {
		return delegatee.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return delegatee.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return delegatee.iterator();
	}

	@Override
	public Object[] toArray() {
		return delegatee.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return delegatee.toArray(a);
	}

	@Override
	public boolean add(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return delegatee.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return delegatee.retainAll(c);
	}

	@Override
	public void clear() {
		delegatee.clear();
	}

	/**
	 * Caution this method is very slow, because the list is traversed until the index is reached.
	 * When calling this method more often, it is strongly recommended, to copy the items of this 
	 * list into another structure
	 */
	@Override
	public E get(int index) {
		if (index >= delegatee.size())
			throw new IndexOutOfBoundsException();
		
		int i= 0;
		for (E o: this.delegatee)
		{
			if (i== index)
				return(o);
			i++;
		}
		return(null);
	}

	@Override
	public E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException();	
		}

	@Override
	public int indexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator() {
		LinkedList<E> copy = new LinkedList<E>(delegatee);
		return Collections.unmodifiableList(copy).listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		ArrayList<E> copy = new ArrayList<E>(delegatee);
		return Collections.unmodifiableList(copy).listIterator(index);
	}
	
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		List<E> retVal= new Vector<E>();
		int i= 0;
		for (E o: this.delegatee)
		{
			if (	(i>=fromIndex)&&
					(i<=toIndex))
			{
				retVal.add(o);
			}
			i++;
		}
		return(retVal);
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder= new StringBuilder();
		builder.append("[");
		for (E o: delegatee)
		{
			builder.append(o);
			builder.append(", ");
		}
		builder.append("]");
		return(builder.toString());
	}

	@Override
	public void move(int newPosition, E object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E move(int newPosition, int oldPosition) {
		throw new UnsupportedOperationException();
	}

	
	
	
	
	
	@Override
	public E basicGet(int index) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Caution, very slow, because copying of lists.
	 */
	@Override
	public List<E> basicList() {
		System.out.println("--------------> CAUTION VERY SLOW");
		
		List<E> retVal= new Vector<E>();
		for (E o: delegatee)
			retVal.add(o);
		return(retVal);	
	}

	@Override
	public Iterator<E> basicIterator() {
		return(iterator());
	}

	@Override
	public ListIterator<E> basicListIterator() {
		return(listIterator());
	}

	@Override
	public ListIterator<E> basicListIterator(int index) {
		return(listIterator(index));
	}

	@Override
	public Object[] basicToArray() {
		return(toArray());
	}

	@Override
	public <T> T[] basicToArray(T[] array) {
		return(toArray(array));
	}

	@Override
	public int basicIndexOf(Object object) {
		return(indexOf(object));
	}

	@Override
	public int basicLastIndexOf(Object object) {
		return(lastIndexOf(object));
	}

	@Override
	public boolean basicContains(Object object) {
		return(contains(object));
	}

	@Override
	public boolean basicContainsAll(Collection<?> collection) {
		return(containsAll(collection));
	}

	@Override
	public NotificationChain basicRemove(Object object,
			NotificationChain notifications) {
		throw new UnsupportedOperationException();
	}

	@Override
	public NotificationChain basicAdd(E object, NotificationChain notifications) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addUnique(E object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addUnique(int index, E object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAllUnique(Collection<? extends E> collection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAllUnique(int index, Collection<? extends E> collection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E setUnique(int index, E object) {
		throw new UnsupportedOperationException();
	}
}
