package racing.domain;

public class TryCount {
    private final int tryCount;

    private TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCount from(int tryCount) {
        return new TryCount(tryCount);
    }

    public boolean isPlayable() {
        return this.tryCount > 0;
    }

    public TryCount consume() {
        return new TryCount(this.tryCount - 1);
    }
}
