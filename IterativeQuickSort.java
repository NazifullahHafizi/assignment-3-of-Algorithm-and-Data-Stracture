public class IterativeQuickSort {

    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;

        int[] tempStack = new int[data.length];
        int stackPointer = -1;

        tempStack[++stackPointer] = 0;
        tempStack[++stackPointer] = data.length - 1;

        while (stackPointer >= 0) {
            int end = tempStack[stackPointer--];
            int start = tempStack[stackPointer--];

            int pivotIndex = divide(data, start, end);

            if (pivotIndex - 1 > start) {
                tempStack[++stackPointer] = start;
                tempStack[++stackPointer] = pivotIndex - 1;
            }

            if (pivotIndex + 1 < end) {
                tempStack[++stackPointer] = pivotIndex + 1;
                tempStack[++stackPointer] = end;
            }
        }
    }

    private int divide(int[] data, int low, int high) {
        int pivot = data[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (data[j] <= pivot) {
                i++;
                swap(data, i, j);
            }
        }

        swap(data, i + 1, high);
        return i + 1;
    }

    private void swap(int[] data, int i, int j) {
        if (i != j) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }
}
