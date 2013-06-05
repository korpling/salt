package de.hu_berlin.german.korpling.saltnpepper.salt.graph.util;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

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
public class UnmodifiableEList<E> implements EList<E>{
	
	public static void main(String[] args)
	{
		org.eclipse.emf.common.util.BasicEList.UnmodifiableEList<Object> list= new BasicEList.UnmodifiableEList<Object>(0, null);
		list.add(new String("d"));
	}
	
	private Collection<E> delegatee= null; 
	public UnmodifiableEList(Collection<E> delegatee)
	{
		this.delegatee= delegatee;
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
		return delegatee.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return delegatee.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return delegatee.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return delegatee.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return delegatee.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return delegatee.retainAll(c);
	}

	@Override
	public void clear() {
		delegatee.clear();
	}

	@Override
	public E get(int index) {
		throw new UnsupportedOperationException();
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
		return new ListItr(0);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
     * An optimized version of AbstractList.Itr
     */
    private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = 0;

        public boolean hasNext() {
            // Racy but within spec, since modifications are checked
            // within or after synchronization in next/previous
            return cursor != delegatee.size();
        }

        @SuppressWarnings("unchecked")
		public E next() {
            synchronized (UnmodifiableEList.this) {
                checkForComodification();
                int i = cursor;
                if (i >= delegatee.size())
                    throw new NoSuchElementException();
                cursor = i + 1;
//                return elementData(lastRet = i);
                return (E)delegatee.toArray()[lastRet = i];
            }
        }

        public void remove() {
            if (lastRet == -1)
                throw new IllegalStateException();
            synchronized (UnmodifiableEList.this) {
                checkForComodification();
                UnmodifiableEList.this.remove(lastRet);
                expectedModCount = 0;
            }
            cursor = lastRet;
            lastRet = -1;
        }

        final void checkForComodification() {
            if (0 != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
    
	/**
     * An optimized version of AbstractList.ListItr
     */
    final class ListItr extends Itr implements ListIterator<E> {
        ListItr(int index) {
            super();
            cursor = index;
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        @SuppressWarnings("unchecked")
		public E previous() {
            synchronized (UnmodifiableEList.this) {
                checkForComodification();
                int i = cursor - 1;
                if (i < 0)
                    throw new NoSuchElementException();
                cursor = i;
//                return elementData(lastRet = i);
                return (E)delegatee.toArray()[lastRet = i];
            }
        }

        public void set(E e) {
            if (lastRet == -1)
                throw new IllegalStateException();
            synchronized (UnmodifiableEList.this) {
                checkForComodification();
                UnmodifiableEList.this.set(lastRet, e);
            }
        }

        public void add(E e) {
            int i = cursor;
            synchronized (UnmodifiableEList.this) {
                checkForComodification();
                UnmodifiableEList.this.add(i, e);
                expectedModCount = 0;
            }
            cursor = i + 1;
            lastRet = -1;
        }
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
	public void move(int newPosition, E object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E move(int newPosition, int oldPosition) {
		throw new UnsupportedOperationException();
	}
}
