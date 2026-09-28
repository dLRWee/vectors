package io.dlrwee.vectors.vector;

/**
 * An immutable data structure representing a three-dimensional vector
 * with double-precision floating-point coordinates.
 *
 * @param x the x-coordinate of the vector
 * @param y the y-coordinate of the vector
 * @param z the z-coordinate of the vector
 *
 * @author dlrwee
 * @version 1.0
 */
public record Vector3(double x, double y, double z) {

    /**
     * A statically initialized immutable zero vector.
     */
    public static final Vector3 ZERO = new Vector3(0, 0, 0);

    /**
     * Returns a string representation of the vector formatted to two decimal places.
     * <p>
     * Example output for a vector with {@code x = 1.0}, {@code y = 2.345}, and {@code z = 6.0}:
     * <pre>
     * {1.00, 2.35, 6.00}
     * </pre>
     *
     * @return a formatted string representing this vector
     */
    @Override
    public String toString() {
        return String.format("{%.2f, %.2f, %.2f}", x, y, z);
    }
}
