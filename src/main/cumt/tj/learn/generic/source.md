# 令人困惑的泛型

## 参数化类型是不可变的

对于任何两个截然不同的类型Type1与Type2而言，List<Type1>既不是List<Type2>的子类型，也不是它的超类型。虽然List<String>不是List<Object>的子类型，这与直觉相悖，但是实际上很有意义。但是对于实际类型参数Object，在使用的时候是可以以正常的逻辑，传入它的子类的，你可以将任何对象放进一个List<Object>中，但由于String是final的，却只能将字符串放进List<String>中(当然，这与泛型的东东无关)。

### 不可变带来的困惑

参数化类型的不可变虽然很有意义，却影响了编程过程中的灵活性。

正如在[程序](./InvariantParameterizedType.java)中看到的那样，对于一个存储Number的栈，如果我插入一个Integer类型的数，就没有任何问题，因为Integer是Number的子类。但是如果我想利用pushAll插入一堆Integer数，于是，我创建了一个Iterator<Integer>，用来装入一堆Integer，然后利用pushAll插进去，这在逻辑上没有问题，但是就会出现问题，根本通不过编译，因为虽然Integer是Number的子类，但是Iterator<Integer>并不是Iterator<Number>的子类。这时候就需要使用有限制的通配符来解决这个问题了
