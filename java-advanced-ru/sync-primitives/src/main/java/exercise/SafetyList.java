package exercise;

class SafetyList {
    // BEGIN
    int[] array;
    int size;

    SafetyList() {
        array = new int[2100];
        size = 0;
    }

    synchronized void add(int number) {
        array[size] = number;
        size++;
    }

    public int get(int index) {
        return index > size ? 0 : array[index];
    }

    public int getSize() {
        return this.size;
    }
    // END
}
