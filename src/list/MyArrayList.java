package list;

public class MyArrayList implements MyListInteger {
    private int capacity = 3;
    private int currentIndex = 0;
    int[] array = new int[capacity];

    @Override
    public void add(int element) {

        if (currentIndex >= array.length) {
            int[] temp = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }

            int newCapacity = array.length * 2;
            array = new int[newCapacity];
            for (int i = 0; i < temp.length; i++) {
                array[i] = temp[i];
            }
        }
        array[currentIndex] = element;
        currentIndex++;
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < currentIndex) {
            for (int i = index; i < (currentIndex - 1); i++) {
                array[i] = array[i + 1];
            }
            currentIndex--;
        }

    }

    @Override
    public int get(int index) {
        if (index < currentIndex && index >= 0) {
            return array[index];
        }
        return -1;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return currentIndex;
    }
    public void add(int index, int value){
        if (index >= 0 && index <= currentIndex){
            int[] temp = array;
            array = new int [temp.length + 1];
            for (int i = 0; i < currentIndex + 1; i++){
                if (i < index){
                    array[i] = temp[i];
                }
                else if (i == index){
                    array[i] = value;
                }
               else{
                    array[i] = temp[i - 1];
                }
            }
            currentIndex++;
        }
    }
}
