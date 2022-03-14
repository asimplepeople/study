## 更新

#### JEP 181: 嵌套访问控制
#### JEP 309: 类文件常量
#### JEP 315: 改进arch64虚拟机执行效率 docker容器中执行也在变快
#### JEP 318: 垃圾收集器用于测试\实验 没有一个真正收集垃圾的GC
#### JEP 320: 移除了java EE和CORBA 模块 用处不大
#### JEP 321: http客户端 使用流式操作
#### JEP 323: 局部变量的语法 lambda表达式  var 语法调整
#### JEP 324: 两个加密算法
#### JEP 327: unicode10
#### JEP 328: 飞行记录仪
#### JEP 329: 两个加密算法
#### JEP 330: 单文件源程序 可以直接运行
#### JEP 331: 低成本的堆分析
#### JEP 332: 安全方面的更新
#### JEP 333: ZGC 低延迟
#### JEP 335: 废弃 nashorn javascript引擎
#### JEP 336: 废弃 pack200 tool 压缩工具


## 笔记
### var语法: 局部变量推断
注意点: 
    1. var a; 这样不可以,因为无法推断.
    2. 类的属性的数据类型不可以使用var.

有参数的lambda表达式中:
函数式接口:
    Consumer<T>: 消费性函数式接口
        public void accept(T t);
Consumer<String> consumer = t -> System.out.printf(t.toUpperCase(Locale.ROOT));
Consumer<String> consumer1 = (var t) -> System.out.printf(t.toUpperCase(Locale.ROOT));
错误的形式:必须要有类型,可以加上var
Consumer<String> consumer2 = (@NonNull  t) -> System.out.printf(t.toUpperCase(Locale.ROOT));
正确的形式
Consumer<String> consumer2 = (@NonNull var t) -> System.out.printf(t.toUpperCase(Locale.ROOT));



       