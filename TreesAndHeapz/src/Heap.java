import java.util.ArrayList;
import java.util.List;

public class Heap {

    public ArrayList<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void addVotes(int votes) {
        heap.add(votes);
        maxHeapify(heap.size()-1);
    }

    public int getAtIndex(int i) {
        return heap.get(i);
    }

    public void remove(int i) {
        heap.remove(i);
    }

    public int getLeftChild(int i) {
        return 2 * i + 1;
    }
    public int getRightChild(int i) {
        return 2 * i + 2;
    }

    public int getSize() {
        return heap.size();
    }
    public void moveInHeap(int c1, int c2) {
        int temp = heap.get(c1);
        heap.set(c1,heap.get(c2));
        heap.set(c2, temp);
    }

    public void maxHeapify(int index) {
        int size = heap.size();
        int left = getLeftChild(index);
        int right = getRightChild(index);
        int largest = index;

        if (left < size && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        if (right < size && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != index) {
            moveInHeap(largest, index);
            maxHeapify(largest);
        }
    }


}
