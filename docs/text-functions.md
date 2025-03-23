# 文本函数

ZParser 提供了丰富的文本处理函数，用于字符串的操作和处理。

## 函数列表

### CONCAT(str1, [str2, ...])
连接多个字符串。

- **参数**: 
  - str1, str2, ...: 要连接的字符串
- **返回值**: 字符串
- **示例**:
  ```java
  CONCAT('AQF', 'bW') = 'AQFbW'
  CONCAT('Hello', ' ', 'World') = 'Hello World'
  ```

### TRIM(text)
去除字符串前后的空格。

- **参数**: 
  - text: 要处理的字符串
- **返回值**: 处理后的字符串
- **示例**:
  ```java
  TRIM('   Money  ') = 'Money'
  ```

### UPPERCASE(text)
将字符串转换为大写。

- **参数**: 
  - text: 要转换的字符串
- **返回值**: 转换后的字符串
- **示例**:
  ```java
  UPPERCASE('Money') = 'MONEY'
  ```

### LOWERCASE(text)
将字符串转换为小写。

- **参数**: 
  - text: 要转换的字符串
- **返回值**: 转换后的字符串
- **示例**:
  ```java
  LOWERCASE('Money') = 'money'
  ```

### INDEX(text, searchStr, startIndex)
查找子字符串第一次出现的位置。

- **参数**: 
  - text: 原始字符串
  - searchStr: 要查找的子字符串
  - startIndex: 开始查找的位置（从0开始）
- **返回值**: 整数，找不到返回-1
- **示例**:
  ```java
  INDEX('asdfdsf', 'f', 5) = 6
  ```

### LASTINDEX(text, searchStr, startIndex)
查找子字符串最后一次出现的位置。

- **参数**: 
  - text: 原始字符串
  - searchStr: 要查找的子字符串
  - startIndex: 开始查找的位置（从0开始）
- **返回值**: 整数，找不到返回-1
- **示例**:
  ```java
  LASTINDEX('asdfdsf', 'f', 4) = 3
  ```

### CHAR(text, position)
获取字符串中指定位置的字符。

- **参数**: 
  - text: 字符串
  - position: 位置（从0开始）
- **返回值**: 字符
- **示例**:
  ```java
  CHAR('TOM', 2) = 'M'
  ```

### LENGTH(text)
获取字符串的长度。

- **参数**: 
  - text: 字符串
- **返回值**: 整数
- **示例**:
  ```java
  LENGTH('job') = 3
  ```

### SUBSTRING(text, start, [length])
截取字符串的一部分。

- **参数**: 
  - text: 原始字符串
  - start: 开始位置（从0开始）
  - length: 可选，要截取的长度
- **返回值**: 字符串
- **示例**:
  ```java
  SUBSTRING('will', 1, 3) = 'il'
  ```

### REPLACE(text, oldStr, newStr)
替换字符串中的内容。

- **参数**: 
  - text: 原始字符串
  - oldStr: 要替换的字符串
  - newStr: 替换后的字符串
- **返回值**: 字符串
- **示例**:
  ```java
  REPLACE('will', 'i', 'a') = 'wall'
  ```

### VALUE(expression)
计算文本表达式的值。

- **参数**: 
  - expression: 要计算的表达式
- **返回值**: 根据表达式类型返回相应的值
- **示例**:
  ```java
  VALUE('MIN(MAX(2,3),1)+3') = 4
  ```

### COMPARE(str1, str2)
比较两个字符串。

- **参数**: 
  - str1: 第一个字符串
  - str2: 第二个字符串
- **返回值**: 整数
  - 小于0：str1 < str2
  - 等于0：str1 = str2
  - 大于0：str1 > str2
- **示例**:
  ```java
  COMPARE('A', 'B') = -1
  COMPARE('9', '3') = 6
  ```

### COMPAREIGNORE(str1, str2)
忽略大小写比较两个字符串。

- **参数**: 
  - str1: 第一个字符串
  - str2: 第二个字符串
- **返回值**: 整数
- **示例**:
  ```java
  COMPAREIGNORE('A', 'a') = 0
  ```

### ENDS(text, suffix)
判断字符串是否以指定后缀结尾。

- **参数**: 
  - text: 要检查的字符串
  - suffix: 后缀字符串
- **返回值**: 整数（1表示是，0表示否）
- **示例**:
  ```java
  ENDS('AQF', 'F') = 1
  ```

### EQUALS(str1, str2)
判断两个字符串是否相等。

- **参数**: 
  - str1: 第一个字符串
  - str2: 第二个字符串
- **返回值**: 整数（1表示相等，0表示不相等）
- **示例**:
  ```java
  EQUALS('AQF', 'AQF') = 1
  ```

### EQUALSIGNORE(str1, str2)
忽略大小写判断两个字符串是否相等。

- **参数**: 
  - str1: 第一个字符串
  - str2: 第二个字符串
- **返回值**: 整数（1表示相等，0表示不相等）
- **示例**:
  ```java
  EQUALSIGNORE('AQF', 'aqf') = 1
  ```

### STARTS(text, prefix, offset)
判断字符串是否以指定前缀开始。

- **参数**: 
  - text: 要检查的字符串
  - prefix: 前缀字符串
  - offset: 开始检查的位置
- **返回值**: 整数（1表示是，0表示否）
- **示例**:
  ```java
  STARTS('will', 'wi', 0) = 1
  ```

## 注意事项

1. 字符串索引从0开始计数
2. 字符串比较默认区分大小写
3. 空字符串和 null 的处理：
   - 大多数函数会将 null 转换为空字符串
   - LENGTH 函数对空字符串返回 0
   - 比较函数会将 null 视为最小值
4. 字符串连接时会自动进行类型转换

## 使用建议

1. 处理大量文本时注意性能影响
2. 使用 TRIM 函数处理用户输入
3. 字符串比较时注意使用正确的比较函数
4. 处理可能为 null 的值时做好防御性检查 