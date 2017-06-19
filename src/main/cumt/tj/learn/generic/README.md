#  令人困惑的泛型

- 参考*Effective Java*
- 参考*Java编程思想*

## 1. 参数化类型是不可变的

对于任何两个截然不同的类型Type1与Type2而言，List\<Type1>既不是List\<Type2>的子类型，也不是它的超类型。虽然List\<String>
不是List\<Object>的子类型，这与直觉相悖，但是实际上很有意义。但是对于实际类型参数Object，在使用的时候是可以以正常的逻辑，
传入它的子类的，你可以将任何对象放进一个List\<Object>中，但由于String是final的，却只能将字符串放进List\<String>中
(当然，这与泛型的东东无关)。

### 1.1. 不可变带来的困惑

参数化类型的不可变虽然很有意义，却影响了编程过程中的灵活性。

正如在[程序](./InvariantParameterizedType.java)中看到的那样，对于一个存储Number的栈，如果我插入一个Integer类型的数，就没
有任何问题，因为Integer是Number的子类。但是如果我想利用pushAll插入一堆Integer数，于是，我创建了一个Iterator\<Integer>，
用来装入一堆Integer，然后利用pushAll插进去，这在逻辑上没有问题，但是就会出现问题，根本通不过编译，因为虽然Integer是Number
的子类，但是Iterator\<Integer>并不是Iterator\<Number>的子类。这时候就需要使用[有限制的通配符](BoundedWildcardType.java)解决这个问题了。

正如在[程序](./InvariantParameterizedType.java)中看到的那样，
如果我想利用popAll弹出所有元素到Collection\<Number>，于是，我创建了一个Collection\<Object>，
从逻辑上讲，Collection\<Object>装的是Object，它是Number的超类，根据多态，Collection\<Object>是可以传入popAll()中的，但是事实就是
这么无情，它又不能通过编译，这又需要使用[有限制的通配符](BoundedWildcardType.java)来解决这个问题了。

## 2. 有限制的通配符

- \<? extends E> 配置E及其子类
- \<? super E> 配置E及其超类
- PECS原则，producer-extends，consumer-super，如果传入方法的参数是一个生产E，供方法内部使用的，就要使用\<? extends E>，
如[BoundedWildcardType](./BoundedWildcardType.java)中的pushAll方法
如果方法内部生产E，供传入方法的参数消费的，就要使用\<? super E>，如[BoundedWildcardType](./BoundedWildcardType.java)中的popAll方法

对于Comparable与Comparator，传入参数始终是消费者，所以使用他们的使用，需要使用Comparable\<? super E>

## 3. 泛型与数组

### 3.1. 泛型数组

正如[GenericArray](./GenericArray.java)中看到的那样，对于类型参数T，由于擦除，不能创建关于它的数组T[]，这是不能通过编译的
```
F[] fs=new F[20];
```
所以，想要创建泛型数组T[]，就需要先创建一个Object[]，然后对其进行强制转换
```
F[] fs=(F[])new Object[20];
```

### 3.2. 参数化类型的数组

正如[GenericArray](./GenericArray.java)中看到的那样，不能创建带有参数化类型的数组，这是不能编译通过的，因为擦除会擦掉泛型的类型信息，而数组必须知道确切的类型信息，以保证类型安全
```
//这句话是不能通过编译的
List<String>[] stringList=new List<String>[10];
```
虽然不能创建带有参数化类型的数组，但是可以创建这种数组的引用，也创建一个非泛型的原生类型数组：
```
List<String>[] stringList;
List[] lists=new List[20];
```
利用这一特点，可以将原生类型数组进行强制转换，得到参数化类型的数组：
```
stringList=(List<String>[])lists;
```
