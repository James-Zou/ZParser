# ZParser 函数文档

本文档详细介绍了 ZParser 提供的所有函数及其用法。

## 目录

- [日期函数](date-functions.md)
- [逻辑函数](logic-functions.md)
- [文本函数](text-functions.md)
- [数字函数](number-functions.md)

## 快速导航

### [日期函数](date-functions.md)
处理日期和时间的相关函数，包括日期计算、格式转换等。

### [逻辑函数](logic-functions.md)
处理布尔逻辑运算的相关函数，包括条件判断、逻辑运算等。

### [文本函数](text-functions.md)
处理字符串操作的相关函数，包括字符串连接、查找、替换等。

### [数字函数](number-functions.md)
处理数值计算的相关函数，包括数学运算、统计函数等。

## 使用说明

所有函数都可以通过 `ExecutionCenter` 实例调用，例如：

```java
ExecutionCenter eval = ExecutionCenter.getInstance();
String result = eval.getStringResult("函数名(参数1, 参数2, ...)");
```

函数返回值类型根据具体函数的功能决定，主要有以下几种：

- `getStringResult()`: 返回字符串类型结果
- `getNumberResult()`: 返回数值类型结果
- `getBooleanResult()`: 返回布尔类型结果
- `getDateResult()`: 返回日期类型结果

## 注意事项

1. 所有函数名称都是大写的
2. 函数参数类型必须匹配要求
3. 日期格式默认为 "yyyy-MM-dd" 或 "yyyy-MM-dd HH:mm:ss"
4. 数值计算保持精确度 