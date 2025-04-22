public class MedianCalculator {

    public double findMedian(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 && b.length == 0) return 0.0;
        if (a.length > b.length) return findMedian(b, a);

        int x = a.length;
        int y = b.length;
        int low = 0, high = x;

        while (low <= high) {
            int cutX = (low + high) / 2;
            int cutY = (x + y + 1) / 2 - cutX;

            int maxX = (cutX == 0) ? Integer.MIN_VALUE : a[cutX - 1];
            int minX = (cutX == x) ? Integer.MAX_VALUE : a[cutX];

            int maxY = (cutY == 0) ? Integer.MIN_VALUE : b[cutY - 1];
            int minY = (cutY == y) ? Integer.MAX_VALUE : b[cutY];

            if (maxX <= minY && maxY <= minX) {
                return (x + y) % 2 == 0
                        ? (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0
                        : Math.max(maxX, maxY);
            } else if (maxX > minY) {
                high = cutX - 1;
            } else {
                low = cutX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays not sorted properly.");
    }
}
