package kumar.amit.datastructure.array;

import java.util.Arrays;
import java.util.Iterator;

public class Array<T> implements Iterable<T> {

	private T[] arr;
	public int length = 0;
	public int capacity = 16; // default cpacity

	public Array() {
		this(16);
	}

	public Array(int capacity) {
		this.capacity = capacity;
		this.length = 0;
		arr = (T[]) new Object[capacity];
	}

	public boolean isEmpty() {
		return this.length == 0;
	}

	public boolean isFull() {
		return this.length + 1 >= this.capacity;
	}

	private void set(int index, T t) {
		this.arr[index] = t;
	}

	public T get(int index) {
		return this.arr[index];
	}

	public void clear() {
		for (int i = 0; i < length; i++) {
			arr[i] = null;
		}
		length = 0;
	}

	public void add(T t) {

		if (isFull()) {
			// increase the capacity by 2
			this.capacity = this.capacity * 2;
			// create new static array
			T[] newArr = (T[]) new Object[this.capacity];
			// copy the old values in new static array.
			for (int i = 0; i < arr.length; i++) { // O(n)
				newArr[i] = arr[i];
			}
			this.arr = newArr;
		}
		this.arr[this.length++] = t;

	}

	public T removeAt(int index) {
		if (index < 0 || index > length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		T data = arr[index];
		T[] newArr = (T[]) new Object[length - 1];

		// shift the old data to new array
		for (int i = 0, j = 0; i < length; i++, j++) {// O(1)
			if (index == i) {
				--j;
			} else {
				newArr[j] = arr[i];
			}
		}
		arr = newArr;
		capacity = --length;
		return data;
	}

	public boolean remove(Object data) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(data)) {
				removeAt(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				return index < length;
			}

			@Override
			public T next() {
				return arr[index++];
			}

		};
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] a = (T[]) new Object[length];
		for (int i = 0; i < length; i++) {
			a[i] = arr[i];

		}
		return a;
	}

	@Override
	public String toString() {
		if (length == 0) {
			return "[]";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("[ ");
		for (int i = 0; i < length - 1; i++) {
			sb.append(arr[i] + ", ");
		}
		sb.append(arr[length - 1] + " ]");
		return sb.toString();
	}

}
