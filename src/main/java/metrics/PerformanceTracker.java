package metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public void incrementArrayAccesses() {
        arrayAccesses++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getArrayAccesses() {
        return arrayAccesses;
    }

    public double getElapsedTimeMillis() {
        return (endTime - startTime) / 1_000_000.0;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        startTime = 0;
        endTime = 0;
    }

    @Override
    public String toString() {
        return String.format(
                "Time: %.3f ms | Comparisons: %d | Swaps: %d | Array Accesses: %d",
                getElapsedTimeMillis(), comparisons, swaps, arrayAccesses
        );
    }
}
