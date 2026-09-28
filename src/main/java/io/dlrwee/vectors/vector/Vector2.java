package io.dlrwee.vectors.vector;

public record Vector2(double x, double y) {
    public static final Vector2 ZERO = new Vector2(0, 0);

    @Override
    public String toString() {
        return String.format("{%.2f, %.2f}", x, y);
    }
}
