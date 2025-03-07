# 📱 Kotlin for Mobile Development - Cheat Sheet

A handy reference for learning Kotlin while building Android apps!

## 🟢 1. Basics

### 1.1 Variables
- **`val`**: Immutable (cannot be changed, like `readonly` in C#).
- **`var`**: Mutable (can be changed).

```kotlin
val name: String = "Kotlin"   // Immutable
var age: Int = 25             // Mutable
```

### 1.2 Type Inference
- Kotlin can automatically infer the type from the value.

```kotlin
val greeting = "Hello"  // Type is automatically String
```

### 1.3 Null Safety
- Use `?` to allow null values and avoid `NullPointerException` errors.

```kotlin
var nullable: String? = null
```

### 1.4 String Interpolation
- Embed variables inside strings using `$`.

```kotlin
println("Hello, $name! You are $age years old.")
```

### 1.5 Functions
- Define functions using the `fun` keyword.

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}

// Single-expression function
fun subtract(a: Int, b: Int) = a - b
```

## 🔄 2. Control Flow

### 2.1 If-Else Expression
- Acts as both a statement and an expression.

```kotlin
val max = if (a > b) a else b
```

### 2.2 When Expression (Better Switch)
- More flexible than `switch` in other languages.

```kotlin
when (age) {
    in 0..17 -> println("Minor")
    18 -> println("Just 18!")
    else -> println("Adult")
}
```

### 2.3 For Loops
- Iterate through ranges and collections.

```kotlin
for (i in 1..5) println(i)        // Inclusive range (1 to 5)
for (i in 1 until 5) println(i)   // Exclusive range (1 to 4)
```

### 2.4 While Loops
- Loop while a condition is true.

```kotlin
var x = 5
while (x > 0) {
    println(x--)
}
```

## 🧱 3. Classes & Objects

### 3.1 Class Declaration
- Classes in Kotlin are declared using the `class` keyword.

```kotlin
class Person(val name: String, var age: Int) {
    fun greet() = println("Hi, I'm $name!")
}

val person = Person("Alice", 30)
person.greet()
```

### 3.2 Data Classes
- Automatically generates useful methods like `equals()`, `hashCode()`, and `toString()`.

```kotlin
data class User(val id: Int, val name: String)
```

### 3.3 Inheritance
- Use `open` to make a class inheritable.

```kotlin
open class Animal { open fun sound() = println("Animal sound") }
class Dog : Animal() { override fun sound() = println("Woof!") }
```

## 📱 4. Android Essentials

### 4.1 Activity Basics
- An `Activity` represents a screen in your app.

```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.myButton)
        button.setOnClickListener {
            Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}
```

### 4.2 Navigation Between Activities
- Use `Intent` to move from one activity to another.

```kotlin
val intent = Intent(this, SecondActivity::class.java)
intent.putExtra("KEY", "Value")
startActivity(intent)
```

## 📊 5. Collections

### 5.1 Lists
- Ordered collections of elements.

```kotlin
val numbers = listOf(1, 2, 3)       // Immutable
val mutableNumbers = mutableListOf(1, 2, 3) // Mutable
```

### 5.2 Maps
- Key-value pairs.

```kotlin
val map = mapOf("name" to "Kotlin", "year" to 2011)
```

### 5.3 Looping Through Collections
- Use `forEach` for cleaner iteration.

```kotlin
numbers.forEach { println(it) }
```

## 🔥 6. Coroutines (Asynchronous Work)

- Coroutines let you write asynchronous code in a simple way.

```kotlin
GlobalScope.launch {
    delay(1000L)  // Suspend function (pauses coroutine)
    println("Coroutine done!")
}
```

# 🧰 Android XML Layouts & Components Cheat Sheet

## 📐 1. Common Layout Types

### 1.1 LinearLayout
- Arranges child views **vertically** or **horizontally**.

```xml
<LinearLayout
    android:orientation="vertical">

    <TextView
        android:text="Hello LinearLayout!" />

</LinearLayout>
```

### 1.2 ConstraintLayout
- Flexible layout with powerful constraints for advanced designs.

```xml
<androidx.constraintlayout.widget.ConstraintLayout>

    <TextView
        android:id="@+id/titleText"
        android:text="Hello ConstraintLayout!"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

## 📊 2. Common XML UI Components

### 2.1 TextView
- Displays **text** on the screen.

```xml
<TextView
    android:text="Hello, World!"
    android:textSize="20sp" />
```

### 2.2 Button
- Triggers actions when clicked.

```xml
<Button
    android:text="Submit" />
```

### 2.3 EditText
- Allows **user input**.

```xml
<EditText
    android:hint="Enter your name" />
```

## 🔍 3. Useful XML Attributes

| Attribute            | Description                        |
|----------------------|------------------------------------|
| `android:id`         | Unique identifier for the view     |
| `android:text`       | Text content for views             |
| `android:textSize`   | Font size (e.g., `20sp`)           |
| `android:layout_width`| Width of the view (`match_parent`) |
| `android:layout_height`| Height of the view (`wrap_content`) |
| `android:padding`    | Inner spacing (e.g., `16dp`)       |
| `android:gravity`    | Content alignment (`center`)       |

## 📚 Resources

- [Kotlin Official Documentation](https://kotlinlang.org/docs/home.html)
- [Android Developer Guide](https://developer.android.com/docs)

🚀 Happy Coding with Kotlin!
