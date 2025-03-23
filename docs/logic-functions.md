# 逻辑函数

ZParser 提供了一系列逻辑运算函数，用于处理条件判断和布尔运算。

## 函数列表

### AND(expr1, expr2, ...)
逻辑与运算。

- **参数**: 
  - expr1, expr2, ...: 逻辑表达式
- **返回值**: 布尔值
- **说明**: 当所有参数均为 TRUE 时返回 TRUE，否则返回 FALSE
- **示例**:
  ```java
  AND(1==1, 2<3) = true
  AND(1==1, 2>3) = false
  ```

### OR(expr1, expr2, ...)
逻辑或运算。

- **参数**: 
  - expr1, expr2, ...: 逻辑表达式
- **返回值**: 布尔值
- **说明**: 只要有一个参数为 TRUE 就返回 TRUE，全部为 FALSE 才返回 FALSE
- **示例**:
  ```java
  OR(1!=1, 2>3) = false
  OR(1==1, 2>3) = true
  ```

### IF(condition, trueValue, falseValue)
条件判断。

- **参数**: 
  - condition: 判断条件
  - trueValue: 条件为 TRUE 时的返回值
  - falseValue: 条件为 FALSE 时的返回值
- **返回值**: 根据条件返回相应的值
- **示例**:
  ```java
  IF(1==2, '相同', '不相同') = '不相同'
  IF(100>50, '大于', '小于') = '大于'
  ```

### IFBLANK(value, defaultValue)
空值判断。

- **参数**: 
  - value: 要检查的值
  - defaultValue: 值为空时的返回值
- **返回值**: 如果 value 不为空则返回 value，否则返回 defaultValue
- **示例**:
  ```java
  IFBLANK('', '默认值') = '默认值'
  IFBLANK('有值', '默认值') = '有值'
  ```

### CONTAIN(text, searchValue1, [searchValue2, ...])
包含判断。

- **参数**: 
  - text: 要搜索的文本
  - searchValue1, searchValue2, ...: 要查找的值
- **返回值**: 布尔值
- **说明**: 判断文本中是否包含指定的搜索值
- **示例**:
  ```java
  CONTAIN('Bob is a boy', '2', 'boy') = true
  CONTAIN('Hello World', 'hi') = false
  ```

## 注意事项

1. 逻辑表达式支持以下运算符：
   - 比较运算符：==, !=, >, <, >=, <=
   - 逻辑运算符：&&, ||, !
2. 字符串比较区分大小写
3. 数值比较会自动进行类型转换
4. 空值处理：
   - null 值会被视为 false
   - 空字符串会被视为 false
   - 0 不会被视为 false

## 使用建议

1. 复杂的逻辑判断建议使用括号明确优先级
2. 多个条件的逻辑运算建议使用 AND/OR 函数而不是 && / ||
3. 处理可能为空的值时，建议使用 IFBLANK 函数
4. 字符串比较时注意大小写敏感性 