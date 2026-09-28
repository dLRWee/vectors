package io.dlrwee.vectors.vector;

import io.dlrwee.vectors.CsvResources;
import io.dlrwee.vectors.VectorsConstants;
import io.dlrwee.vectors.annotation.CsvToVector2;
import io.dlrwee.vectors.annotation.CsvToVector3;
import org.assertj.core.data.Offset;
import org.assertj.core.util.DoubleComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class VectorsTest {
    // === ADD ===

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvFileSource(resources = CsvResources.VECTOR2_ADD, numLinesToSkip = 1)
    @DisplayName("Vector2 add")
    void vector2Add(
            @CsvToVector2 Vector2 a,
            @CsvToVector2 Vector2 b,
            @CsvToVector2 Vector2 expected) {
        Vector2 got = Vectors.add(a, b);
        assertThatVector2Equal(got, expected);
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvFileSource(resources = CsvResources.VECTOR3_ADD, numLinesToSkip = 1)
    @DisplayName("Vector3 add")
    void vector3Add(
            @CsvToVector3 Vector3 a,
            @CsvToVector3 Vector3 b,
            @CsvToVector3 Vector3 expected) {
        Vector3 got = Vectors.add(a, b);
        assertThatVector3Equal(got, expected);
    }

    // === SUBTRACT ===

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvFileSource(resources = CsvResources.VECTOR2_SUBTRACT, numLinesToSkip = 1)
    @DisplayName("Vector2 subtract")
    void vector2Subtract(
            @CsvToVector2 Vector2 a,
            @CsvToVector2 Vector2 b,
            @CsvToVector2 Vector2 expected) {
        Vector2 got = Vectors.subtract(a, b);
        assertThatVector2Equal(got, expected);
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvFileSource(resources = CsvResources.VECTOR3_SUBTRACT, numLinesToSkip = 1)
    @DisplayName("Vector3 subtract")
    void Vector3Subtract(
            @CsvToVector3 Vector3 a,
            @CsvToVector3 Vector3 b,
            @CsvToVector3 Vector3 expected) {
        Vector3 got = Vectors.subtract(a, b);
        assertThatVector3Equal(got, expected);
    }

    // === MULTIPLY ===

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvFileSource(resources = CsvResources.VECTOR2_MULTIPLY, numLinesToSkip = 1)
    @DisplayName("Vector2 multiply")
    void vector2Multiply(
            @CsvToVector2 Vector2 vector,
            double scalar,
            @CsvToVector2 Vector2 expected) {
        Vector2 got = Vectors.multiply(vector, scalar);
        assertThatVector2Equal(got, expected);
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvFileSource(resources = CsvResources.VECTOR3_MULTIPLY, numLinesToSkip = 1)
    @DisplayName("Vector3 multiply")
    void vector3Multiply(
            @CsvToVector3 Vector3 vector,
            double scalar,
            @CsvToVector3 Vector3 expected) {
        Vector3 got = Vectors.multiply(vector, scalar);
        assertThatVector3Equal(got, expected);
    }

    // === DIVIDE ===

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvFileSource(resources = CsvResources.VECTOR2_DIVIDE, numLinesToSkip = 1)
    @DisplayName("Vector2 divide")
    void vector2Divide(
            @CsvToVector2 Vector2 vector,
            double scalar,
            @CsvToVector2 Vector2 expected) {
        Vector2 got = Vectors.divide(vector, scalar);
        assertThatVector2Equal(got, expected);
    }

    @Test
    @DisplayName("Vector2 divide should throw an exception if scalar is 0")
    void Vector2DivideShouldThrowAnExceptionIfScalarIsZero() {
        Vector2 vector = new Vector2(1, 2);
        double scalar = 0;

        assertThatThrownBy(() -> Vectors.divide(vector, scalar))
                .isInstanceOf(ArithmeticException.class);
    }

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvFileSource(resources = CsvResources.VECTOR3_DIVIDE, numLinesToSkip = 1)
    @DisplayName("Vector3 divide")
    void vector3Divide(
            @CsvToVector3 Vector3 vector,
            double scalar,
            @CsvToVector3 Vector3 expected) {
        Vector3 got = Vectors.divide(vector, scalar);
        assertThatVector3Equal(got, expected);
    }

    @Test
    @DisplayName("Vector3 divide should throw an exception if scalar is 0")
    void Vector3DivideShouldThrowAnExceptionIfScalarIsZero() {
        Vector3 vector = new Vector3(1, 2, 3);
        double scalar = 0;

        assertThatThrownBy(() -> Vectors.divide(vector, scalar))
                .isInstanceOf(ArithmeticException.class);
    }

    // === NEGATE ===

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvFileSource(resources = CsvResources.VECTOR2_NEGATE, numLinesToSkip = 1)
    @DisplayName("Vector2 negate")
    void vector2Negate(
            @CsvToVector2 Vector2 vector,
            @CsvToVector2 Vector2 expected) {
        Vector2 got = Vectors.negate(vector);
        assertThatVector2Equal(got, expected);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvFileSource(resources = CsvResources.VECTOR3_NEGATE, numLinesToSkip = 1)
    @DisplayName("Vector3 negate")
    void vector3Negate(
            @CsvToVector3 Vector3 vector,
            @CsvToVector3 Vector3 expected) {
        Vector3 got = Vectors.negate(vector);
        assertThatVector3Equal(got, expected);
    }

    // === DOT PRODUCT ===

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvFileSource(resources = CsvResources.VECTOR2_DOT_PRODUCT, numLinesToSkip = 1)
    @DisplayName("Vector2 dot product")
    void vector2DotProduct(
            @CsvToVector2 Vector2 a,
            @CsvToVector2 Vector2 b,
            double expected) {
        double got = Vectors.dotProduct(a, b);
        assertThatDoubleEqualWithOffset(got, expected);
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvFileSource(resources = CsvResources.VECTOR3_DOT_PRODUCT, numLinesToSkip = 1)
    @DisplayName("Vector3 dot product")
    void vector3DotProduct(
            @CsvToVector3 Vector3 a,
            @CsvToVector3 Vector3 b,
            double expected) {
        double got = Vectors.dotProduct(a, b);
        assertThatDoubleEqualWithOffset(got, expected);
    }

    // === CROSS PRODUCT ===

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvFileSource(resources = CsvResources.VECTOR3_CROSS_PRODUCT, numLinesToSkip = 1)
    @DisplayName("Vector3 cross product")
    void vector3CrossProduct(
            @CsvToVector3 Vector3 a,
            @CsvToVector3 Vector3 b,
            @CsvToVector3 Vector3 expected) {
        Vector3 got = Vectors.crossProduct(a, b);
        assertThatVector3Equal(got, expected);
    }

    // === LENGTH ===

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvFileSource(resources = CsvResources.VECTOR2_LENGTH, numLinesToSkip = 1)
    @DisplayName("Vector2 length")
    void vector2Length(
            @CsvToVector2 Vector2 vector,
            double expected) {
        double got = Vectors.length(vector);
        assertThatDoubleEqualWithOffset(got, expected);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvFileSource(resources = CsvResources.VECTOR3_LENGTH, numLinesToSkip = 1)
    @DisplayName("Vector3 length")
    void vector3Length(
            @CsvToVector3 Vector3 vector,
            double expected) {
        double got = Vectors.length(vector);
        assertThatDoubleEqualWithOffset(got, expected);
    }

    // === NORMALIZE ===

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvFileSource(resources = CsvResources.VECTOR2_NORMALIZE, numLinesToSkip = 1)
    @DisplayName("Vector2 normalize")
    void vector2Normalize(
            @CsvToVector2 Vector2 vector,
            @CsvToVector2 Vector2 expected) {
        Vector2 got = Vectors.normalize(vector);
        assertThatVector2Equal(got, expected);
    }

    @Test
    @DisplayName("Vector2 normalize should throw an exception if vector is 0")
    void Vector2NormalizeShouldThrowAnExceptionIfVectorIsZero() {
        assertThatThrownBy(() -> Vectors.normalize(Vector2.ZERO))
                .isInstanceOf(ArithmeticException.class);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvFileSource(resources = CsvResources.VECTOR3_NORMALIZE, numLinesToSkip = 1)
    @DisplayName("Vector3 normalize")
    void vector3Normalize(
            @CsvToVector3 Vector3 vector,
            @CsvToVector3 Vector3 expected) {
        Vector3 got = Vectors.normalize(vector);
        assertThatVector3Equal(got, expected);
    }

    @Test
    @DisplayName("Vector3 normalize should throw an exception if vector is 0")
    void Vector3NormalizeShouldThrowAnExceptionIfVectorIsZero() {
        assertThatThrownBy(() -> Vectors.normalize(Vector3.ZERO))
                .isInstanceOf(ArithmeticException.class);
    }

    // === DISTANCE ===

    @ParameterizedTest(name = "{0}, {1} -> {2}")
    @CsvFileSource(resources = CsvResources.VECTOR2_DISTANCE, numLinesToSkip = 1)
    @DisplayName("Vector2 distance")
    void vector2Distance(
            @CsvToVector2 Vector2 a,
            @CsvToVector2 Vector2 b,
            double expected) {
        double got = Vectors.distance(a, b);
        assertThatDoubleEqualWithOffset(got, expected);
    }

    @ParameterizedTest(name = "{0}, {1} -> {2}")
    @CsvFileSource(resources = CsvResources.VECTOR3_DISTANCE, numLinesToSkip = 1)
    @DisplayName("Vector3 distance")
    void vector3Distance(
            @CsvToVector3 Vector3 a,
            @CsvToVector3 Vector3 b,
            double expected) {
        double got = Vectors.distance(a, b);
        assertThatDoubleEqualWithOffset(got, expected);
    }

    // === ANGLE ===

    @ParameterizedTest(name = "{0}, {1} -> {2}")
    @CsvFileSource(resources = CsvResources.VECTOR2_ANGLE, numLinesToSkip = 1)
    @DisplayName("Vector2 angle")
    void vector2Angle(
            @CsvToVector2 Vector2 a,
            @CsvToVector2 Vector2 b,
            double expected) {
        double got = Vectors.angle(a, b);
        assertThatDoubleEqualWithOffset(got, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "0;0,1;1",
            "1;1,0;0"
    })
    @DisplayName("Vector2 angle should throw an exception if vector is zero")
    void Vector2AngleShouldThrowAnExceptionIfVectorIsZero(
            @CsvToVector2 Vector2 a,
            @CsvToVector2 Vector2 b) {
        assertThatThrownBy(() -> Vectors.angle(a, b))
                .isInstanceOf(ArithmeticException.class);
    }

    @ParameterizedTest(name = "{0}, {1} -> {2}")
    @CsvFileSource(resources = CsvResources.VECTOR3_ANGLE, numLinesToSkip = 1)
    @DisplayName("Vector3 angle")
    void vector3Angle(
            @CsvToVector3 Vector3 a,
            @CsvToVector3 Vector3 b,
            double expected) {
        double got = Vectors.angle(a, b);
        assertThatDoubleEqualWithOffset(got, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "0;0;0,1;1;1",
            "1;1;1,0;0;0"
    })
    @DisplayName("Vector3 angle should throw an exception if vector is zero")
    void Vector3AngleShouldThrowAnExceptionIfVectorIsZero(
            @CsvToVector3 Vector3 a,
            @CsvToVector3 Vector3 b) {
        assertThatThrownBy(() -> Vectors.angle(a, b))
                .isInstanceOf(ArithmeticException.class);
    }

    // === PROJECT ===

    @ParameterizedTest(name = "{0}, {1} -> {2}")
    @CsvFileSource(resources = CsvResources.VECTOR2_PROJECT, numLinesToSkip = 1)
    @DisplayName("Vector2 project")
    void vector2Project(
            @CsvToVector2 Vector2 a,
            @CsvToVector2 Vector2 b,
            @CsvToVector2 Vector2 expected) {
        Vector2 got = Vectors.project(a, b);
        assertThatVector2Equal(got, expected);
    }

    @Test
    @DisplayName("Vector2 project should throw an exception if second vector is 0")
    void Vector2ProjectShouldThrowAnExceptionIfSecondVectorIsZero() {
        assertThatThrownBy(() -> Vectors.project(new Vector2(1, 1), Vector2.ZERO))
                .isInstanceOf(ArithmeticException.class);
    }

    @ParameterizedTest(name = "{0}, {1} -> {2}")
    @CsvFileSource(resources = CsvResources.VECTOR3_PROJECT, numLinesToSkip = 1)
    @DisplayName("Vector3 project")
    void vector3Project(
            @CsvToVector3 Vector3 a,
            @CsvToVector3 Vector3 b,
            @CsvToVector3 Vector3 expected) {
        Vector3 got = Vectors.project(a, b);
        assertThatVector3Equal(got, expected);
    }

    @Test
    @DisplayName("Vector3 project should throw an exception if second vector is 0")
    void Vector3ProjectShouldThrowAnExceptionIfSecondVectorIsZero() {
        assertThatThrownBy(() -> Vectors.project(new Vector3(1, 1, 1), Vector3.ZERO))
                .isInstanceOf(ArithmeticException.class);
    }

    // === IS EQUAL ===

    @ParameterizedTest(name = "{0} = {1} -> {2}")
    @CsvFileSource(resources = CsvResources.VECTOR2_IS_EQUAL, numLinesToSkip = 1)
    @DisplayName("Vector2 is equal")
    void vector2IsEqual(
            @CsvToVector2 Vector2 a,
            @CsvToVector2 Vector2 b,
            double tolerance,
            boolean expected) {
        boolean got = Vectors.isEqual(a, b, tolerance);
        assertThat(got).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} = {1} -> {2}")
    @CsvFileSource(resources = CsvResources.VECTOR3_IS_EQUAL, numLinesToSkip = 1)
    @DisplayName("Vector3 is equal")
    void vector3IsEqual(
            @CsvToVector3 Vector3 a,
            @CsvToVector3 Vector3 b,
            double tolerance,
            boolean expected) {
        boolean got = Vectors.isEqual(a, b, tolerance);
        assertThat(got).isEqualTo(expected);
    }

    // === IS ORTHOGONAL ===

    @ParameterizedTest(name = "{0}, {1} -> {2}")
    @CsvFileSource(resources = CsvResources.VECTOR2_IS_ORTHOGONAL, numLinesToSkip = 1)
    @DisplayName("Vector2 is orthogonal")
    void vector2IsOrthogonal(
            @CsvToVector2 Vector2 b,
            @CsvToVector2 Vector2 a,
            boolean expected) {
        boolean got = Vectors.isOrthogonal(a, b);
        assertThat(got).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0}, {1} -> {2}")
    @CsvFileSource(resources = CsvResources.VECTOR3_IS_ORTHOGONAL, numLinesToSkip = 1)
    @DisplayName("Vector3 is orthogonal")
    void vector3IsOrthogonal(
            @CsvToVector3 Vector3 b,
            @CsvToVector3 Vector3 a,
            boolean expected) {
        boolean got = Vectors.isOrthogonal(a, b);
        assertThat(got).isEqualTo(expected);
    }

    // === IS COLLINEAR ===

    @ParameterizedTest(name = "{0}, {1} -> {2}")
    @CsvFileSource(resources = CsvResources.VECTOR2_IS_COLLINEAR, numLinesToSkip = 1)
    @DisplayName("Vector2 is collinear")
    void vector2IsCollinear(
            @CsvToVector2 Vector2 b,
            @CsvToVector2 Vector2 a,
            boolean expected) {
        boolean got = Vectors.isCollinear(a, b);
        assertThat(got).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0}, {1} -> {2}")
    @CsvFileSource(resources = CsvResources.VECTOR3_IS_COLLINEAR, numLinesToSkip = 1)
    @DisplayName("Vector3 is collinear")
    void vector3IsCollinear(
            @CsvToVector3 Vector3 b,
            @CsvToVector3 Vector3 a,
            boolean expected) {
        boolean got = Vectors.isCollinear(a, b);
        assertThat(got).isEqualTo(expected);
    }

    // === IS ZERO ===

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvFileSource(resources = CsvResources.VECTOR2_IS_ZERO, numLinesToSkip = 1)
    @DisplayName("Vector2 is zero")
    void vector2IsZero(
            @CsvToVector2 Vector2 vector,
            boolean expected) {
        boolean got = Vectors.isZero(vector);
        assertThat(got).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvFileSource(resources = CsvResources.VECTOR3_IS_ZERO, numLinesToSkip = 1)
    @DisplayName("Vector3 is zero")
    void vector3IsZero(
            @CsvToVector3 Vector3 vector,
            boolean expected) {
        boolean got = Vectors.isZero(vector);
        assertThat(got).isEqualTo(expected);
    }

    // === HELPERS ===

    private static void assertThatVector2Equal(Vector2 actual, Vector2 expected) {
        assertThat(actual)
                .usingRecursiveComparison()
                .withComparatorForType(new DoubleComparator(VectorsConstants.OFFSET), Double.class)
                .isEqualTo(expected);
    }

    private static void assertThatVector3Equal(Vector3 actual, Vector3 expected) {
        assertThat(actual)
                .usingRecursiveComparison()
                .withComparatorForType(new DoubleComparator(VectorsConstants.OFFSET), Double.class)
                .isEqualTo(expected);
    }

    private static void assertThatDoubleEqualWithOffset(double actual, double expected) {
        Offset<Double> offset = Offset.offset(VectorsConstants.OFFSET);
        assertThat(actual).isCloseTo(expected, offset);
    }
}