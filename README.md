# Vectors

![JitPack](https://img.shields.io/jitpack/version/com.github.dLRWee/vectors)
![Test Coverage](https://img.shields.io/badge/coverage-95%25-orange)
![GitHub License](https://img.shields.io/github/license/dLRWee/vectors)
![GitHub repo size](https://img.shields.io/github/repo-size/dLRWee/vectors)

A simple library for working with 2D and 3D vectors. 
This is a **learning project** aimed at practicing writing clean and well-structured code.
Despite its lightweight nature, this library contains an optimal set of tools and can be used for mathematical calculations.

## 📦 Dependencies

### Maven

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```

```xml
<dependency>
  <groupId>com.github.dLRWee</groupId>
  <artifactId>vectors</artifactId>
  <version>v1.0.0</version>
</dependency>
```

### Gradle

```gradle
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
  }
}
```

```gradle
dependencies {
  implementation 'com.github.dLRWee:vectors:v1.0.0'
}
```

## 🏗️ Architecture

- `Vector2` - A record representing a vector in 2D space.
- `Vector3` - A record representing a vector in 3D space.
- `Vectors` - A utility class that provides methods for performing mathematical operations on vectors (e.g., `dotProduct()`, `isCollinear()`, `normalize()`).
- `VectorsConstants` - A utility class storing the global offset value used for comparing `double` values.

## 💡 Usage

Here are a few examples of how to use the library.

### Vector Initialization

```java
Vector2 v2A = new Vector2(3.0, 4.0);
Vector2 v2B = new Vector2(1.0, 2.0);

Vector3 v3A = new Vector3(1.0, 0.0, 0.0);
Vector3 v3B = new Vector3(0.0, 1.0, 0.0);
```

### Basic Arithmetic Operations

```java
// Addition & Subtraction
Vector3 sum = Vectors.add(v3A, v3B);
Vector2 difference = Vectors.subtract(v2A, v2B);

// Multiplication & Division by a scalar
Vector2 scaledMul = Vectors.multiply(v2A, 2.5);
Vector3 scaledDiv = Vectors.divide(v3A, 2.0);

// Negation
Vector2 inverted = Vectors.negate(v2A);
```

### Geometric Products & Length

```java
// Dot Product
double dot = Vectors.dotProduct(v2A, v2B);

// Cross Product
Vector3 cross = Vectors.crossProduct(v3A, v3B);

// Vector Length
double magnitude = Vectors.length(v2A);

// Normalization
Vector3 unitVector = Vectors.normalize(v3A);
```

### Comparison & Checks

```java
// Checking for equality with an tolerance value
boolean equal = Vectors.isEqual(v2A, v2B, 0.001);

// Orthogonality check
boolean perpendicular = Vectors.isOrthogonal(v3A, v3B);

// Collinearity check
boolean parallel = Vectors.isCollinear(v2A, v2B);

// Check if it is a zero vector
boolean zero = Vectors.isZero(v2A);
```

## ✔️ Testing

The project has **95%** line coverage. 
For convenience, custom `ArgumentConverter` classes and annotations were implemented to parse input parameters from `.csv` files into vector objects.

### Vector2ArgumentConverter

```java
public final class Vector2ArgumentConverter implements ArgumentConverter {
    private static final String SPLITERATOR = ";";

    @Override
    public Object convert(Object source, ParameterContext context)
            throws ArgumentConversionException {
        if (!(source instanceof String)) {
            throw new ArgumentConversionException("Argument must be an instance of String");
        }

        try {
            String[] parts = ((String) source).split(SPLITERATOR);
            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);
            return new Vector2(x, y);
        } catch (Exception e) {
            String message = String.format("Could not convert '%s' to Vector2", source);
            throw new ArgumentConversionException(message);
        }
    }
}
```

### CsvToVector2

```java
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@ConvertWith(Vector2ArgumentConverter.class)
public @interface CsvToVector2 {
}
```

### Usage example

```java
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
```
