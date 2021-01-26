# 设计模式-可复用面向对象软件的基础

## 推荐网站
    https://refactoring.guru/design-patterns

## 设计模式基础
### 1.什么是设计模式
#### 1.1 模式四要素
    模式名称        pattern name
    问题           problem
    解决方案        solution
    效果           consequences
    
### 2.怎样选择设计模式
#### 考虑设计模式是怎样解决设计问题的
#### 浏览模式的意图（intent）部分    
#### 研究模式怎样相互关联    
#### 研究目的相似的模式    
#### 检查重新设计的原因
    通过显式地指定一个类来创建对象
    对特殊操作的依赖
    对硬件和软件平台的依赖
    对对象表示或实现的依赖
    算法依赖
    紧耦合
    通过生成子类来扩展功能
    不能方便的对类进行修改   
    
##设计模式编目

### 创建型Creational
    与对象的创建有关
### 结构型
    处理类或对象的组合
### 行为型
    对类或对象怎样交互和怎样分配职责进行描述
### 类模式
    处理类和子类之间的关系。这些关系通过继承建立，是静态的，在编译时刻便确定下来了
### 对象模式
    处理对象间的关系   
    
### Abstract Factory 抽象工厂 , 别名Kit   --对象创建型模式
    提供创建一系列相关或者相互依赖对象的接口，而无需指定它们具体的类。
#### 意图
    提供一个创建一系列相关的或者相互依赖对象的接口,而无需指定它们具体的类.
#### 适用性
    1.一个系统要独立于它的产品的创建\组合和表示时.
    2.一个系统要由多个产品系列中的一个来配置时.
    3.当你要强调一系列相关的产品对象的设计以便进行联合使用时.
    4.当你提供一个产品类库,而只想显示它们的接口而不是实现时.
    
    
### Adapter 适配器模式， 别名包装器 Wrapper   --类对象结构型模式  
    将一个类的接口转成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
    转换匹配，复用功能
#### 意图
    
#### 结构
    Client
        客户端，调用自己需要的领域接口Target。
    Target
        定义客户端需要的跟特定领域相关的接口。
    Adaptee
        已经存在的接口，通常能满足客户端的需求，但是接口与客户端要求的特定领域接口不一致，需要被适配。
    Adapter
        适配器。把Adaptee适配成Client需要Target。
#### 实现
##### 类适配器
    这一实现使用了继承机制： 适配器同时继承两个对象的接口。 请注意， 
    这种方式仅能在支持多重继承的编程语言中实现， 例如 C++。
    类适配器不需要封装任何对象， 因为它同时继承了客户端和服务的行为。 适配功能在重写的方法中完成。 
    最后生成的适配器可替代已有的客户端类进行使用。
##### 对象适配器
    实现时使用了构成原则： 适配器实现了其中一个对象的接口， 并对另一个对象进行封装。 
    所有流行的编程语言都可以实现适配器。
#### 适用场景
    1.当你希望使用某个类， 但是其接口与其他代码不兼容时， 可以使用适配器类。
      适配器模式允许你创建一个中间层类， 其可作为代码与遗留类、 第三方类或提供怪异接口的类之间的转换器。
    2.如果您需要复用这样一些类， 他们处于同一个继承体系， 并且他们又有了额外的一些共同的方法， 
    但是这些共同的方法不是所有在这一继承体系中的子类所具有的共性。
    
#### 源码示例
    There are some standard Adapters in Java core libraries:
    
    java.util.Arrays#asList()
    java.util.Collections#list()
    java.util.Collections#enumeration()
    java.io.InputStreamReader(InputStream) (returns a Reader object)
    java.io.OutputStreamWriter(OutputStream) (returns a Writer object)
    javax.xml.bind.annotation.adapters.XmlAdapter#marshal() and #unmarshal()

### Bridge 
    将抽象部分与它的实现部分分离，使它们都可以独立地变化。

### Builder 
#### 意图
    将一个复杂对象的构建和它的表示分离，使得同样的构建过程可以创建不同的表示。
#### 源码举例
        Builder is widely used in Java core libraries:
        
        java.lang.StringBuilder#append() (unsynchronized)
        java.lang.StringBuffer#append() (synchronized)
        java.nio.ByteBuffer#put() (also in CharBuffer, ShortBuffer, IntBuffer, LongBuffer,  FloatBuffer and DoubleBuffer)
        javax.swing.GroupLayout.Group#addComponent()
        All implementations java.lang.Appendable

### Chain of Responsibility  
    为解除请求的发送者和接收者之间耦合，而使多个对象都有机会处理这个请求。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它。

### Command 
    将一个请求封装为一个对象，从而是你可以用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可取消的操作。
    
### Decorator
    动态地给一个对象添加一些额外的职责。就扩展功能而言，Decorator模式比生成子类方式更为灵活。
 
### Facade
    为子系统中的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
    
### Factory Method
    定义一个用于对象对象的接口，让子类决定将哪一个类实例化。Factory Method使一个类的实例化延迟到了其子类。
#### 意图（intent)或者动机（motivation）
    Factory method is a creational design pattern which solves the problem of creating product objects 
    without specifying their concrete classes.
    工厂方法是一种创建设计模式，它提供了在超类中创建对象的接口，但允许子类更改将要创建的对象的类型。
#### 应用场景
    当您事先不知道代码应该处理的对象的确切类型和依赖关系时，可以使用Factory方法。
    当您希望为库或框架的用户提供扩展其内部组件的方法时，请使用Factory方法。
    当您希望通过重用现有对象而不是每次都重新构建它们来节省系统资源时，请使用Factory方法。
#### 如何实现
    1.Make all products follow the same interface. This interface should declare methods that make sense in every product.
    
    2.Add an empty factory method inside the creator class. The return type of the method should match the common product interface.
    
    3.In the creator’s code find all references to product constructors. One by one, replace them with calls to the factory method, 
    while extracting the product creation code into the factory method.
    
        You might need to add a temporary parameter to the factory method to control the type of returned product.
    
        At this point, the code of the factory method may look pretty ugly. It may have a large switch operator 
        that picks which product class to instantiate. But don’t worry, we’ll fix it soon enough.
    
    4.Now, create a set of creator subclasses for each type of product listed in the factory method. 
        Override the factory method in the subclasses and extract the appropriate bits of construction code from the base method.
    
    5.If there are too many product types and it doesn’t make sense to create subclasses for all of them, 
        you can reuse the control parameter from the base class in subclasses.
      
      For instance, imagine that you have the following hierarchy of classes: the base Mail class with a couple of subclasses: 
      AirMail and GroundMail; the Transport classes are Plane, Truck and Train. While the AirMail class only uses Plane objects, 
      GroundMail may work with both Truck and Train objects. You can create a new subclass (say TrainMail) to handle both cases, 
      but there’s another option. The client code can pass an argument to the factory method of the GroundMail class to control which product it wants to receive.
      
    6.If, after all of the extractions, the base factory method has become empty, you can make it abstract. 
        If there’s something left, you can make it a default behavior of the method.
#### Pros and Cons
    优点
    1.您避免了创建者和具体产品之间的紧密耦合。
    2.单一责任原则。您可以将产品创建代码移动到程序中的一个位置，使代码更容易支持。
    3.打开/关闭原则。您可以在不破坏现有客户机代码的情况下将新类型的产品引入程序。
    
    缺点
    代码可能会变得更加复杂，因为您需要引入许多新的子类来实现模式。最好的情况是将模式引入到现有的创建者类层次结构中。
    
#### 源码举例
    java.util.Calendar#getInstance()
    java.util.ResourceBundle#getBundle()
    java.text.NumberFormat#getInstance()
    java.nio.charset.Charset#forName()
    java.util.EnumSet#of()    

#### Simple factory pattern 

    并不算一个严格的设计模式。
    简单工厂模式描述了一个具有一个创建方法和一个大型条件的类，该条件基于方法参数选择实例化哪个产品类并返回。
    本质-->选择实现！ 负责创建接口对象。 选择合适的实现类来创建接口的对象。
    
### Flyweight
    运用共享技术有效地支持大量细粒度的对象。  

### Interpreter
    给定一个语言，定义它的文法的一种表示，并定义一个解释器，该解释器使用该表示来解释语言中的句子。

### Iterator
    提供一种方法顺序访问一个聚合对象中各个元素，而又不暴露该对象的内部表示。
    
### Mediator
    用一个中介对象来封装一系列的对象交互。中介者使各个对象不需要显式地相互引用，从而时期耦合松散，而且可以独立改变它们之间的交互。

### Memento
    在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后以后就可以将该对象恢复到保存的状态。

### Observer
    定义对象间的一种一对多的依赖关系，以便当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并自动更新。

### Prototype  Also known as: Clone
    用原型实例指定创建对象的种类，并且通过拷贝这个原型来创建新的对象。
#### Intent 
    Prototype is a creational design pattern that lets you copy existing objects 
    without making your code dependent on their classes.
        
    
    原型模式将克隆过程委托给正在被克隆的实际对象。该模式为所有支持克隆的对象声明了一个公共接口。
    该接口允许您克隆对象，而无需将代码耦合到该对象的类。通常，这样的接口只包含一个克隆方法。

#### Structure
    1.Prototype
        Prototype接口声明了克隆方法。在大多数情况下，这是一个单一的克隆方法。
    2.ConcretePrototype
        具体的原型类实现了克隆方法。除了将原始对象的数据复制到克隆对象之外，该方法还可以处理
        克隆过程中与克隆链接对象相关的一些边缘情况，解缠递归依赖关系等。
    3.Client
        客户端可以生成遵循prototype接口的任何对象的副本

### Proxy
    为其他对象提供一个代理以控制对这个对象的访问。

### Singleton
#### 定义
    
    保证一个类仅有一个实例，并提供一个访问它的全局访问点。
#### 四大原则
    1.构造私有器。
    2.以静态方法或者枚举返回实例。
    3.确保实例只有一个，尤其是多线程环境。
    4.确保反序列换时不会重新构建对象。
#### 最佳实践
    推荐枚举、 饿汉式（单线程环境）、双重检查锁、静态内部类方式实现单例模式。
    利用枚举来实现单例模式是最佳实践！！！ 还能防止反序列化重新创建新的对象！
#### 使用场景
    单例模式保证了系统内存中只存在一个对象，节省了系统资源。
    对于一些需要频繁创建或销毁的对象，使用单例模式可以提供系统性能。
    
    当实例化一个单例类的对象，必须记住要使用相应的获取对象的方法，而不是会用new关键字。
    
    需要频繁创建和销毁的对象、创建对象耗时过多或者耗费资源过多（即：重量级对象），
    但又经常用到的对象、工具类对象、频繁访问数据库或者文件的对象（比如数据源、session工厂等）。

#### 源码举例
    JDK java.lang.Runtime就是经典的用饿汉式实现的单例模式。
#### 深度阅读
    https://www.infoq.cn/article/double-checked-locking-with-delay-initialization/

### State
    允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它所属的类。

### Strategy
    定义一系列的算法，把它们一个个封装起来，并且使它们可以相互替换。本模式使得算法的变化可以独立于使用它的客户。

### Template Method
    定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。Template Method使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。

### Visitor
    表示一个作用于某对象结构中的各元素的操作。它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。


