public class Main {
    public static void main(String[] args) {
        int[] sampleArray = {42, 12, 33, 9, 27};
        IterativeQuickSort quickSorter = new IterativeQuickSort();
        quickSorter.sort(sampleArray);
        System.out.print("Sorted with Iterative QuickSort: ");
        for (int val : sampleArray) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] sortedA = {2, 6, 9};
        int[] sortedB = {1, 3, 7, 10};
        MedianCalculator medianTool = new MedianCalculator();
        double computedMedian = medianTool.findMedian(sortedA, sortedB);
        System.out.println("Median between arrays: " + computedMedian);

        ListNode firstList = new ListNode(5);
        firstList.next = new ListNode(7);
        firstList.next.next = new ListNode(10);

        ListNode secondList = new ListNode(7);
        secondList.next = new ListNode(8);

        LinkedListUtils helper = new LinkedListUtils();
        ListNode sortedFirst = helper.sort(firstList);
        ListNode sortedSecond = helper.sort(secondList);
        ListNode result = helper.subtract(sortedFirst, sortedSecond);

        System.out.print("Linked List Difference: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
