import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    // Binary Search to find insertion index
    private int findInsertIndex(String s) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = s.compareTo(list.get(mid));
            if (cmp == 0) return mid;       // exact match
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return low; // insertion point
    }

    public void add(String s) {
        int index = findInsertIndex(s);
        list.add(index, s);
    }

    public int search(String s) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = s.compareTo(list.get(mid));
            if (cmp == 0) return mid;       // found
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return low; // location where it would be
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
