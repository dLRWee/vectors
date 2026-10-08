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

## 💡 Usage

Here are a few examples of how you can use the library.

### Vector Initialization

```java
Vector2 vector2 = new Vector2(3.0, 4.0);
Vector3 vector3 = Vector3.ZERO;
```

### Products

```java
double dot = Vectors.dotProduct(a, b);
Vector3 cross = Vectors.crossProduct(a, b);
```

### Length

```java
double magnitude = Vectors.length(vector);
Vector3 unitVector = Vectors.normalize(vector);
```

## 🏗️ Architecture

- `Vector2` - A record representing a vector in 2D space.
- `Vector3` - A record representing a vector in 3D space.
- `Vectors` - A utility class that provides methods for performing mathematical operations on vectors.
- `VectorsConstants` - A utility class storing the global offset value used for comparing `double` values.

## ✔️ Testing

The project has **95%** line coverage. 
For convenience, custom `ArgumentConverter` classes and annotations were implemented to parse input parameters from `.csv` files into vector objects.

### Test example

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
