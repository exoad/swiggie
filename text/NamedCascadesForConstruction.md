# Named Cascades for Object Construction

This documents the overall direction that the SwiggieLib uses to make itself more usable
in the verbosity that is Java.

## General Motive

SwiggieLib is intended to be a Java oriented programming, but with the nature of Java's default conventions creating heaps of Objects 
can become very very tedious. Furthermore, it is suggested to not have a huge list of parameters in one's
constructor, but sometimes, this cannot be mitigated. You can kind of work around the problem by separating the fields
into data classes or records, but that creates additional verbosity in the code:

```java
import java.nio.ByteBuffer;
public class A
{
	public A(int x, 
            int y, 
            int b,
            float t,
            String m,
            ByteBuffer[] ee,
            byte[][][] index,
            char[] s 
    )
	{
        // assign variables here
    }
}
```
Working around the problem, would result in combining meaningful parameters together. For example, in a class that requires an $x$ and $y$, you might 
separate those parameters into another class that is named $Point$ for more meaningful declarations. However, the downside is just
more code you have to write and the developer using your code will have to read more documentation trying to understand.

## Other Languages : "Named Parameters"

In many modern languages, named parameters is a popular choice for developers
whom want to enjoy a declarative way to specify attributes.

Take Google's Dart for example:

```dart
class Point {
    final int x;
    final int y;
    
    const Point({
        this.x,
        this.y
    });
}

void main() {
    Point p = Point(x: 3, y: 6);
}
```

However, in Java, we have to guess the parameters by ordering and by IDE hints that tell us
which parameter is going to what. This can be extremely hard to use when there are a lot of parameters we have to take care of or
when our IDE is unable to provide such a feature.

## Swiggie Conventions : "Named Cascades"

Let us first define what is cascading is:

> Cascading is the means by which to call methods on a single object multiple times
> in a chained fashion:
> 
> ```java
> MyObj r = new MyObj().f1().g1().a1();
> ```
> 
> In many other languages like Dart, there are inbuilt operators that can achieve this
> functionality (Dart has its `..` operator for doing this)

Ok, but how can we use it, well because cascading is intended to keep the same object reference
passed down throughout the chained calls, we can use it to catch the individual values.

This would look something like this in a code wise implementation:

```java
public class MyObj
{
	public MyObj()
	{}
    
    public MyObj a()
    {
		// ...
        return this;
    }
	
	public MyObj b()
	{
		// ...
        return this;
    }
	
	public MyObj c()
	{
		// ...
        return this;
    }
	
	// ...
}
```

And to construct this object and call of the defining functions:

```java
MyObj o = new MyObj().a().b().c();
```

This however sounds pretty natural for many, as it is what is called a builder
pattern, but Swiggie is aimed at reducing this verbosity and providing soundness in code.

Here is where the real trick comes in: **Eliminating the New Keyword**.

The `new` keyword is a very ugly keyword and takes up a lot of character space. Thus, by eliminating it, we can
achieve something where most modern languages do where the constructor is just a very special
method. 

Now, how do we get rid of it? We use a class bound `acquire` function. This can be thought of as
named factory methods:

```java
public class MyObj
{
	public static MyObj acquire()
	{
		return new MyObj();
    }
	
	public static WeakReference<MyObj> acquireWeakly()
	{
		return new WeakReference(new MyObj());
    }
	
	protected MyObj()
	{}

	// Same implementation as above
}
```

This method allows us to remove the new keyword and makes our code to be more sound, resulting in 
the following pattern:

```java
MyObj e = MyObj.acquire().a().b().c();
```

The next thing is to turn these into actual usable named cascades:

```java
public class MyObj
{
	public static MyObj acquire()
	{
		return new MyObj();
    }
	
	public static WeakReference<MyObj> acquireWeakly()
	{
		return new WeakReference(new MyObj());
    }
	
	private int a;
	
	protected MyObj()
	{}
    
    public MyObj a(int a)
    {
		this.a = a;
		return this;
    }
    
	// Same implementation as above
}
```

This pattern enables the end developer to type less code and removing the verbosity from view!

Now it would be pretty tiresome to write all the time, but we can employ `Lombok` to help us:

```java
@Accessors(chained = true, fluent = true) @Setter @Getter public class MyObj
{
	public static MyObj acquire()
	{
		return new MyObj();
    }
	
	public static WeakReference<MyObj> acquireWeakly()
	{
		return new WeakReference(new MyObj());
    }
	
	private int a;
	
	protected MyObj()
	{}
    
	// Same implementation as above
}
```

`chained` - Makes the supplied methods all return the current object reference; "cascading"
`fluent` - Instructs Lombok to not use prefixing, meaning there will be no `get` or `set` infront.

## Usage in SwiggieLib

Not all components in Swiggie abides by this pattern, most of the time, they have a word prefixed infront of them, with the most common
one being `with`. You will find most of them in Graphical Components, with the first being `SwWindow`. The reason is because a lot of these base
components are based on either an OpenGL implementation or Swing's implementation. Due to this interop between these two and one already provides the basis
such as Window title, there is no point to hold another reference to the same content.

### `with` prefix
Found most commonly for Graphical Components is used to signify that a component has internal implementation that may or may not hold a second
reference to the data provided.

An example is `SwWindow` where SwWindow has a Java Swing port using JFrame. JFrame has an internal functionality
to hold information on the window name, but because Swiggie also has an OpenGL implementation which does not have this
prebuilt functionality and thus Swiggie must determine if it should save this second reference provided to it.

### `arm`
This word is used to signify that the object instance should NOT be cascaded anymore. This is especially useful if the object
is immutable after creation, but this rule does not have to apply. If arm is never called, the operations carried out will not be run.

One example is LaunchFlags found under the Swiggie class which cannot be mutated after Swiggie observes the first
Graphical Component to be shown.

### `collate` prefix
This is an alternative to the `arm` prefix but insteads denotes that only some functionality should be made immutable and finalized.

For example, most Graphics Components have a `collateChildren` which tells Swiggie that it should now optimize the 
component tree and prepare the Graphics Component for drawing on screen.


### `add` prefix
Used to denote that you want to add a single thing if the current component has some kind of list backing it.

This is commonly seen with the MVC pattern, where you can attach listeners to components to events being dispatched by them.
