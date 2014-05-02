package de.hska.iwii.i2.list;

/**
 * LinkedList represents a generic doubled linked list. It's functionality can
 * be seen as a queue, pushing in elements either from one end of the queue, or
 * by inserting elements to a given index (and shifting the subsequent elements
 * rightwards).
 * 
 * @author Fabio
 *
 * @param <T>
 *            This describes the type parameter.
 */
public class LinkedList<T> {
	private ListElement<T> first;
	private ListElement<T> last;
	private int size;
	private ListElement<T> newLE;

	/**
	 * Adds one element to the beginning of the list, no matter if it's empty or
	 * filled.
	 * 
	 * @param value
	 *            The value of the element to be added.
	 */
	public void addFirst(T value) {
		newLE = new ListElement<T>(value);
		if (listEmpty()) {
			doListEmpty();
		} else {
			first.setPrev(newLE);
			newLE.setNext(first);
			first = newLE;
			size++;
		}

	}

	/**
	 * Adds one element to the end of the list, no matter if it's empty or
	 * filled.
	 * 
	 * @param value
	 *            The value of the element to be added.
	 */
	public void addLast(T value) {
		newLE = new ListElement<T>(value);
		if (listEmpty()) {
			doListEmpty();
		} else {
			last.setNext(newLE);
			newLE.setPrev(last);
			last = newLE;
			size++;
		}

	}

	/**
	 * Creates an element with the given value and inserts it at the index
	 * position. All subsequent elements will be shifted rightwards.
	 * 
	 * @param index
	 *            The position (zero based) where the element will be inserted.
	 * @param value
	 *            The value of the element to be added.
	 */
	void add(int index, T value) {
		assert index >= 0 && index <= size;
		if (index == 0) {
			addFirst(value);
		} else if (index == size) {
			addLast(value);
		} else if (index > 0 && index < size) {
			newLE = new ListElement<T>(value);
			ListElement<T> pointerLE = getElementAt(index);
			newLE.setNext(pointerLE);
			pointerLE.getPrev().setNext(newLE);
			newLE.setPrev(pointerLE.getPrev());
			pointerLE.setPrev(newLE);
			size++;
		}

	}

	/**
	 * Returns an element of the given position.
	 * 
	 * @param index
	 *            The elements position (zero based).
	 * @return Returns the value of the element.
	 */
	public T get(int index) {
		ListElement<T> element = getElementAt(index);
		return element.getValue();
	}

	/**
	 * Searches for the element in the list. For optimization, the list is split
	 * into two halfs and then determined in which half it might be better to
	 * search for the index.
	 * 
	 * @param index
	 *            The elements position (zero based).
	 * @return Returns the element.
	 */
	private ListElement<T> getElementAt(int index) {
		assert index >= 0 && index <= size;
		ListElement<T> current;
		if (index <= size / 2) {
			current = first;
			while (index > 0) {
				index--;
				current = current.getNext();
			}
		} else {
			current = last;
			while (index < size - 1) { // zero based
				index++;
				current = current.getPrev();
			}
		}

		return current;
	}

	/**
	 * Removes the first element of the list. In case the list is empty an
	 * assertion error will be thrown.
	 * 
	 * @return Returns the value of the removed element.
	 */
	public T removeFirst() {
		assert !listEmpty();
		T value;
		value = first.getValue();
		first = first.getNext();
		
		if(size == 1) {
			last = null;
		}
		
		size--;
		return value;

	}

	/**
	 * Removes the last element of the list. In case the list is empty an
	 * assertion error will be thrown.
	 * 
	 * @return Returns the value of the removed element.
	 */
	public T removeLast() {
		assert !listEmpty();
		T value;
		value = last.getValue();
		last = last.getPrev();
		
		if( size == 0 ) {
			first = null;
		}
		
		size--;
		return value;
	}

	/**
	 * Removes the element to a given position. In case the list is empty an
	 * assertion error will be thrown.
	 * 
	 * @param index
	 *            The position of the element. Must be between zero and
	 *            list.size.
	 * @return Returns the value of the removed element.
	 */
	public T remove(int index) {
		assert index >= 0 && index <= size;
		T value = null;
		if (index == 0) {
			value = removeFirst();
		} else if (index == size-1) {
			value = removeLast();
		} else if (index > 0 && index < size) {
			ListElement<T> pointerLE = getElementAt(index);
			value = pointerLE.getValue();
			pointerLE.getPrev().setNext(pointerLE.getNext());
			pointerLE.getNext().setPrev(pointerLE.getPrev());
			size--;
		}
		return value;
	}

	/**
	 * Determines if the list is empty or not.
	 * 
	 * @return true: list is empty. false: list is not empty.
	 */
	public boolean listEmpty() {
		return size == 0;
	}

	/**
	 * Recurring code snippet. Sets first and last element and increments the
	 * list size.
	 */
	private void doListEmpty() {
		first = newLE;
		last = newLE;
		size++;
	}

	/**
	 * 
	 * @return Returns the list size as an integer.
	 */
	public int length() {
		return size;
	}
}
