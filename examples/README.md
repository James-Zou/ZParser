# ZParser 使用示例

本目录包含了 ZParser 的各种使用示例，帮助你快速上手和深入理解如何使用 ZParser。

## 示例目录

### 基础示例
- [基础计算示例](BasicExample.java) - 展示最基本的数学计算
- [日期处理示例](DateExample.java) - 展示日期相关函数的使用
- [逻辑运算示例](LogicExample.java) - 展示逻辑函数的使用
- [文本处理示例](TextExample.java) - 展示文本函数的使用

### 进阶示例
- [复杂公式示例](ComplexExample.java) - 展示如何组合多个函数使用

## 运行示例

1. 确保已经安装了 Java 8 或更高版本
2. 将 ZParser 添加到项目依赖中
3. 编译并运行示例代码

```bash
javac -cp zparser.jar examples/*.java
java -cp zparser.jar:examples BasicExample
```

## 示例说明

### 基础计算示例
```java
ExecutionCenter eval = ExecutionCenter.getInstance();
double result = eval.getNumberResult("2*3-5/(3-1)+9-1*22+222-22");
System.out.println("计算结果: " + result);
```

### 日期处理示例
```java
ExecutionCenter eval = ExecutionCenter.getInstance();
String nextDay = eval.getDateResult("NEXTDAY()");
String currentTime = eval.getDateResult("CURRENTDAYTIME()");
System.out.println("下一天: " + nextDay);
System.out.println("当前时间: " + currentTime);
```

### 逻辑运算示例
```java
ExecutionCenter eval = ExecutionCenter.getInstance();
boolean result = eval.getBooleanResult("AND(1==1, 2<3)");
System.out.println("逻辑运算结果: " + result);
```

### 文本处理示例
```java
ExecutionCenter eval = ExecutionCenter.getInstance();
String result = eval.getStringResult("CONCAT('Hello', ' ', 'World')");
System.out.println("文本处理结果: " + result);
```

### 复杂示例
```java
ExecutionCenter eval = ExecutionCenter.getInstance();
String result = eval.getStringResult(
    "IF(DAYS(CURRENTDAY(), '2024-12-31') > 180, " +
    "'距离年底超过180天', " +
    "CONCAT('距离年底还有', DAYS(CURRENTDAY(), '2024-12-31'), '天'))"
);
System.out.println("复杂示例结果: " + result);
```

## 注意事项

1. 示例代码仅供参考，实际使用时请根据具体需求调整
2. 确保使用正确的函数返回类型（getNumberResult/getDateResult/getBooleanResult/getStringResult）
3. 注意函数参数的格式和类型要求
4. 在处理日期时注意日期格式的一致性 