package io.dlrwee.vectors.vector;

public record Vector3(double x, double y, double z) {
    public static final Vector3 ZERO = new Vector3(0, 0, 0);

    @Override
    public String toString() {
        return String.format("{%.2f, %.2f, %.2f}", x, y, z);
    }
}
