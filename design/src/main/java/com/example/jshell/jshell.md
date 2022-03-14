## /help 学习
```shell
 ✘ ⚙ zhaohui@zhaohuideMBP  ~/Library/Java/JavaVirtualMachines/corretto-11.0.14.1/Contents/Home/bin  jshell
|  欢迎使用 JShell -- 版本 11.0.14.1
|  要大致了解该版本, 请键入: /help intro

jshell> class A()
<再次按 Tab 可查看所有可能的输入提示; 可能的输入提示总计: 533>
jshell> class A(
   ...>   private int age = 20;
jshell> class A(
   ...>   private int age = 20;
   ...>   public void setAge(int age){
   ...>      this.age = age;
   ...>  }
   ...> public int getAge(){
   ...> return age;
   ...> }
   ...> );
|  错误:
|  需要'{'
|  class A(
|         ^
|  错误:
|  非法的类型开始
|  );
|  ^
|  错误:
|  进行语法分析时已到达文件结尾
|  );
|    ^

jshell> class A{
   ...>   private int age = 20;
   ...>   public void setAge(int age){
   ...>      this.age = age;
   ...>  }
   ...> public int getAge(){
   ...> return age;
   ...> }
   ...> };
|  已创建 类 A

jshell> A a = new A();
a ==> A@51565ec2

jshell> a.getAge();
$4 ==> 20

jshell>

jshell>
[2]  + 2422 suspended  jshell
 ✘ ⚙ zhaohui@zhaohuideMBP  ~/Library/Java/JavaVirtualMachines/corretto-11.0.14.1/Contents/Home/bin  jobs
[1]  - suspended  jshell

```