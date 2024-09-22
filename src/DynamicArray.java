public class DynamicArray {
    private int[] array;
    private int size;
    private int capacity;

    // Constructor with default capacity
    public DynamicArray() {
        this.capacity = 10;
        this.array = new int[capacity];
        this.size = 0;
    }

    // Get size of the array
    public int size() {
        return this.size;
    }

    // Get capacity of the array
    public int capacity() {
        return this.capacity;
    }

    // Add element to the array
    public void add(int element) {
        if (size == capacity) {
            grow();
        }
        array[size] = element;
        size++;
    }

    // Get element by index
    public int get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    // Remove element by index
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = 0;  // Clear last element
        size--;
        if (size > 0 && size == capacity / 3) {
            shrink();
        }
    }

    // Double the capacity when array is full
    private void grow() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    // Reduce the capacity when array is sparse
    private void shrink() {
        capacity /= 2;
        int[] newArray = new int[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    // Print elements
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        // Add elements
        for (int i = 1; i <= 15; i++) {
            dynamicArray.add(i);
        }
        System.out.println("Array after adding elements:");
        dynamicArray.printArray();

        // Get element at index 5
        System.out.println("Element at index 5: " + dynamicArray.get(5));

        // Remove element at index 3
        dynamicArray.remove(3);
        System.out.println("Array after removing element at index 3:");
        dynamicArray.printArray();

        // Remove more elements to trigger shrinking
        for (int i = 0; i < 10; i++) {
            dynamicArray.remove(0);
        }
        System.out.println("Array after removing multiple elements:");
        dynamicArray.printArray();
    }
}
