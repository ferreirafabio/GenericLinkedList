package de.hska.iwii.i2.list;

/**
 * This class describes a overwriting (queue) ring buffer implemented with a
 * doubled linked list.
 * 
 * @author Fabio
 *
 * @param <T>
 *            Describes the type parameter.
 */
public class RingBuffer<T> {
	private LinkedList<T> buffer;
	// private int writePointer;
	// private int readPointer;
	private int size;

	public RingBuffer(int size) {
		buffer = new LinkedList<>();
		// writePointer = 0;
		// readPointer = 0;
		this.size = size;
	}

	/**
	 * Checks if the buffer is full.
	 * 
	 * @return true: buffer full. false: still free space available.
	 */
	public boolean bufferFull() {
		return buffer.length() >= size;
	}

	/**
	 * Writes a new element to the buffer. In case it's full, the last value
	 * will be removed and the new value added to the beginning.
	 * 
	 * @param value
	 *            The value of the element.
	 */
	public void write(T value) {

		if (!bufferFull()) {
			buffer.addLast(value);
		} else {
			buffer.removeFirst();
			buffer.addLast(value);
		}

		// cyclic ring buffer implementation
		// if (!bufferFull()) {
		// buffer.add(writePointer++, value);
		// writePointer %= size;
		// } else if(bufferFull()) {
		// writePointer %= size;
		// buffer.remove(writePointer);
		// buffer.add(writePointer++, value);
		// }
	}

	/**
	 * Reads out the oldest element and removes it at the same time.
	 * 
	 * @return The value of the removed element.
	 */
	public T read() {
		T value = null;

		if (!buffer.listEmpty()) {
			value = buffer.removeLast();
		}

		return value;
		// cyclic ring buffer implementation
		// String value = null;
		//
		// if (!buffer.listEmpty()) {
		// value = buffer.removeFirst();
		// }
		// return value;
	}

	public static void main(String[] args) {
		int size = 4;
		RingBuffer<String> buffer = new RingBuffer<>(size);
		buffer.write("1");
		buffer.write("2");
		buffer.write("3");
		buffer.write("4");
		buffer.write("5");
		buffer.write("6");

		for (int i = 0; i < size; i++) {
			System.out.println(buffer.read());
		}

	}
}
