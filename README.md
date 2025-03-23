# ZParser

[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/com.unionhole/zparser.svg)](https://search.maven.org/search?q=g:com.unionhole%20AND%20a:zparser)
[![Java Support](https://img.shields.io/badge/Java-8+-green.svg)](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)

## 简介

ZParser 是一个功能强大的 Java 公式计算引擎，提供了丰富的日期函数、逻辑函数、文本函数、数字函数等计算能力。该项目旨在简化复杂的公式计算，使开发者能够轻松处理各种计算需求。

## 特性

- 🚀 高性能的计算引擎
- 📅 丰富的日期处理函数（20+ 种日期操作）
- 🔄 强大的逻辑运算函数
- 📝 灵活的文本处理函数
- 🔢 精确的数学计算函数
- 💡 简单易用的 API 接口
- ⚡️ 轻量级设计，易于集成
- 📚 完善的文档和示例

## 快速开始

### Maven 依赖

```xml
<dependency>
    <groupId>com.unionhole</groupId>
    <artifactId>zparser</artifactId>
    <version>最新版本</version>
</dependency>
```

### 基础使用

```java
// 获取计算引擎实例
ExecutionCenter eval = ExecutionCenter.getInstance();

// 数学计算
double result = eval.getNumberResult("2*3-5/(3-1)+9-1*22+222-22");

// 日期计算
String nextDay = eval.getDateResult("NEXTDAY()");
String currentTime = eval.getDateResult("CURRENTDAYTIME()");

// 逻辑运算
boolean logicResult = eval.getBooleanResult("AND(1==1,2<3)");

// 文本处理
String text = eval.getStringResult("CONCAT('Hello', ' World')");
```

## 详细文档

- [函数总览](./docs/README.md)
- [日期函数](./docs/date-functions.md)
- [逻辑函数](./docs/logic-functions.md)
- [文本函数](./docs/text-functions.md)
- [数字函数](./docs/number-functions.md)
- [使用示例](./examples/README.md)

## 示例代码

查看 [examples](./examples/) 目录获取更多使用示例：

- 基础计算示例
- 日期处理示例
- 复杂公式示例
- 实际应用场景

## 版本历史

查看 [CHANGELOG.md](CHANGELOG.md) 了解详细的版本更新历史。

## 性能优化

- 使用单例模式实现计算引擎
- 函数调用采用反射优化
- 支持表达式缓存
- 高效的字符串处理

## 贡献指南

欢迎提交 Issue 和 Pull Request 来帮助改进项目。在提交代码前，请确保：

1. 代码符合项目的编码规范
2. 添加了必要的单元测试
3. 更新了相关文档
4. 所有测试用例通过

## 开源协议

本项目采用 [Apache License 2.0](LICENSE) 协议开源。

## 作者

- 作者：James Zou
- 邮箱：18301545237@163.com
- 项目地址：[https://github.com/James-Zou/ZParser](https://github.com/James-Zou/ZParser)

## 致谢

- 感谢所有为这个项目做出贡献的开发者
- 特别感谢 [jeval](https://jeval.cvs.sourceforge.net/jeval/) 项目的启发

## 相关链接

- [详细文档](./docs/README.md)
- [示例代码](./examples/)
