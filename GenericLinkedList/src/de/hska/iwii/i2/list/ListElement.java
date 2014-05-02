package de.hska.iwii.i2.list;
/**
 * Representing an element for a linked list. 
 * @author Fabio
 *
 * @param <T>  Describes the type parameter.
 */
public class ListElement<T> {
	
	private T value;
	private ListElement<T> next;
	private ListElement<T> prev;
	
	/**
	 * Sets the value of an element.
	 * @param value The value of the element.
	 */
	public ListElement(T value) {
		this.value = value;
	}
	
	public void setNext(ListElement<T> newLE) {
		this.next = newLE;
	}
		
	public void setPrev(ListElement<T> prev) {
		this.prev = prev;
	}

	public T getValue() {
		return value;
	}

	public ListElement<T> getPrev() {
		return prev;
	}

	public ListElement<T> getNext() {
		return next;
	}
	
	
}
