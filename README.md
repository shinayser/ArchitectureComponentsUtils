# ArchitectureComponentsUtils

This library contains a set of utility classes and extension methods (Kotlin) to use with the Architecture Components (currently, only LiveData) libraries for Android.

# Get it

Add to your Gradle file:

    repositories {
      maven {
         url "https://jitpack.io"
      }
    }       


Then add this to your "depedencies":
   
    implementation 'com.github.shinayser:ArchitectureComponentsUtils:1.1.2'


# Features

- There is one LiveData class for every primitive type:
1. IntLiveData, DoubleLiveData, FloatLiveData, LongLiveData, BooleanLvieData
2. All of them (except boolean) have convention methods to increment, decrement, multiply and divide. Those methods calls the setValue() method wich notifies every Observer they have:
```
    @JvmOverloads
    fun increment(amount: Int = 1): Int {
        this.value = this.value + amount
        return this.value
    }

    @JvmOverloads
    fun decrement(amount: Int = 1): Int {
        this.value = this.value - amount
        return this.value
    }

    fun multiply(amount: Int): Int {
        this.value = this.value * amount
        return this.value
    }

    fun divide(amount: Int): Int {
        this.value = this.value / amount
        return this.value
    }
```
    
- There is a extension method (Kotlin) for the LiveData class called "observe" wich receives a lambda expression, making easier to observe data changes. So you can do something like that:
```
 testViewModel.id.observe(this@MyActivity) { aValue ->
            myTextView.text = "The current value is: $aValue"
        }
```

