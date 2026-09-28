package io.dlrwee.vectors.vector;

/**
 * An immutable data structure representing a two-dimensional vector
 * with double-precision floating-point coordinates.
 *
 * @param x the x-coordinate of the vector
 * @param y the y-coordinate of the vector
 *
 * @author dlrwee
 * @version 1.0
 */
public record Vector2(double x, double y) {

    /**
     * A statically initialized immutable zero vector.
     */
    public static final Vector2 ZERO = new Vector2(0, 0);

    /**
     * Returns a string representation of the vector formatted to two decimal places.
     * <p>
     * Example output for a vector with {@code x = 1.234} and {@code y = 5.0}:
     * <pre>
     * {1.23, 5.00}
     * </pre>
     *
     * @return a formatted string representing this vector
     */
    @Override
    public String toString() {
        return String.format("{%.2f, %.2f}", x, y);
    }
}
