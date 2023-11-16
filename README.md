# ZParser
## 公式计算服务

## 对外提供 日期函数、逻辑函数、文本函数、数字函数等公式计算能力

## 调度方式
ExecutionCenter eval = ExecutionCenter.getInstance();
eval.getNumberResult("2*3-5/(3-1)+9-1*22+222-22");


## 日期函数  NEXTDAY()
NEXTDAY()
获取下一天
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
NEXTDAY() = 2023-07-12

## 日期函数 NEXTDAYTIME()
NEXTDAYTIME()
获取下一天 时分秒
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
NEXTDAYTIME()=2023-07-12 11:43:07

## 日期函数 GETDAY()
GETDAY(整数)
获取指定天,整数表示之后天数，负数表示之前天数
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
GETDAY(-2) = 2023-07-09

## 日期函数 GETDAYTIME()
GETDAYTIME(整数)
获取指定天 时分秒
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
GETDAYTIME(-2) = 2023-07-09 11:43:07

## 日期函数 TIMEMILLIS()
TIMEMILLIS(整数)
获取指定天时间戳函数,返回文本
示例：
TIMEMILLIS(-2) = 1688874187423

## 日期函数 WEEK()
WEEK(整数)
获取指定天是周几,返回文本
示例：
WEEK(1)=Wednesday

## 日期函数 CURRENTWEEK()
CURRENTWEEK()
获取获取当前时间是周几,返回文本
示例：
CURRENTWEEK()=Tuesday

## 日期函数 CURRENTDAYTIME()
CURRENTDAYTIME()
获取当天日期 时分秒
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
CURRENTDAYTIME() = 2023-07-12 11:43:07

## 日期函数 SEASONSTARTDATE()
SEASONSTARTDATE(文本)
计算某日期所在季度开始日期
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
SEASONSTARTDATE('2023-07-08 15:11:01')=2023-07-01

## 日期函数 SEASONENDDATE()
SEASONENDDATE(文本)
返回日期格式的当前日期和时间
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
SEASONENDDATE('2023-07-08 15:11:01')=2023-09-30

## 日期函数 MONTHSTARTDATE()
MONTHSTARTDATE()
计算某日期所在月份开始日期
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
MONTHSTARTDATE()=2023-07-01

## 日期函数 MONTHENDDATE()
MONTHENDDATE()
计算某日期所在月份结束日期
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
MONTHENDDATE() = 2023-07-31

## 日期函数 CURRENTDAY()
CURRENTDAY()
获取当天
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
CURRENTDAY()= 2023-07-11

## 日期函数 DAYMILLIS()
DAYMILLIS(文本，整数) 
根据指定日期获取日期时分秒
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
DAYMILLIS(CURRENTDAYTIME(),1) = 2023-07-12 14:31:48

## 日期函数 DAYMILLISM()
DAYMILLISM(整数，整数) 或 DAYMILLIS(日期字段，整数)
根据指定日期时间戳获取日期时分秒
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
DAYMILLISM(1689042334000,1)=2023-07-12 14:31:48

## 日期函数 DAYMILLISMP()
DAYMILLISMP(整数，整数 ，文本) 或 DAYMILLISMP(日期字段，整数，文本)
根据指定日期时间戳获取日期时分秒，可指定单位
"D": 单位是天
"H": 单位是小时
"M": 单位是分钟
"S": 单位是秒
"MI": 单位是毫秒
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
DAYMILLISMP(1697436777193,20,'M')=2023-10-16 14:32:57

## 日期函数 DAYM()
DAYM(整数，整数) 或 DAYM(日期字段，整数)
根据指定日期时间戳获取日期
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
DAYM(1689042334000,1)=2023-07-12


## 日期函数 DAY()
DAY(文本，整数)
根据指定日期获取日期
返回值根据接收字段区别：若接收字段为文本字段，则返回文本；若接收字段为日期字段，则返回日期
示例：
DAY('2023-07-30',-1)=2023-07-29

## 日期函数 DAYS()
DAYS(文本，文本)
获取两个时间的差值，返回整数
示例：
DAYS('2023-07-08','2023-07-10')=2

## 日期函数 DAYTSP()
DAYTSP(整数，整数， 文本， 文本) 或 DAYTSP(日期字段，日期字段，文本， 文本)
获取两个时间戳的差值，返回整数，可指定单位,并可指定是否向上取整
第三个参数（时间单位）说明：
"D": 单位是天
"H": 单位是小时
"M": 单位是分钟
"S": 单位是秒
"MI": 单位是毫秒
第四个参数（是否向上取整）说明：
"0":否
"1":是
示例：
DAYTSP(1699515284116,1699516785949,'M','0')=25

## 日期函数 DAYMS
DAYMS(文本，文本)
获取两个时间时分秒的差值，返回整数
示例：
DAYMS('2023-07-08  15:11:01','2023-07-10  05:11:01')=1



## 日期函数 DAYTS()
DAYTS(整数，整数) 或 DAYTS(日期字段，日期字段)
获取两个时间戳的差值，返回整数
示例：
DAYTS(1689042334000,1689387934000)=4

## 日期函数 DATEFORMAT()
DATEFORMAT(整数,文本 ,文本)
日期格式化函数，可以指定格式进行格式化
第一个参数必须为毫秒单位的整数
第二个参数（格式化格式）
第三个参数（是否为内置格式）说明：
0：表示内置格式，内置格式即SimpleDateFormat官方支持格式
1：表示自定义格式（D天H小时M分钟S秒）,此处 D、H、M、S为占位符，会被替换计算后数值，天、小时、分钟、秒为固定文本。
示例：
DATEFORMAT(1700104866156,'yyyy-MM-dd HH:mm:ss','0')=2023-11-16 11:21:06
或
DATEFORMAT(1501833,'D天H小时M分钟S秒','1')=0天0小时25分钟1秒

## 逻辑函数 AND()
AND(逻辑表达式1, [逻辑表达式2, ...])
当所有参数均为逻辑 TRUE 时，返回 TRUE；当参数中任何一个为逻辑 FALSE，返回 FALSE
示例：
AND(1==1,2<3) = false

## 逻辑函数 CONTAIN()
CONTAIN(查找范围, [要查找的值, ...])
判断查找范围是否包含要查找的内容 
示例：
CONTAIN('Bob is a boy','2','boy')=true

## 逻辑函数 IF()
IF(判断条件, 为 TRUE 时的返回值, [为 FALSE 时的返回值])
当判断条件为 TRUE 时返回一个值，为 FALSE 时返回另一个值
示例：
IF(1==2, '相同', '不相同')

## 逻辑函数 IFBLANK()
IFBLANK(值, 空值情况的返回值)
检查目标值是否为空，非空时返回该值本身，否则返回第二个参数的值
示例：
IFBLANK('Bob is a boy','2')=2

## 逻辑函数 OR()
OR(逻辑表达式1, [逻辑表达式2, ...])
只要提供的参数中任何一个为逻辑真就返回 TRUE，如果提供的所有参数均为逻辑假则返回 FALSE。
示例：
OR(1!=1,2>3)

## 文本函数 INDEX()
INDEX( 字符串1, 字符串2,整型)
字符串1：原始字符串
字符串2：查找字符串
整型：指定的索引
用于返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。如果它不作为一个子字符串出现，则返回-1
示例：
INDEX('asdfdsf','f',5)=6

## 文本函数 LASTINDEX()
LASTINDEX( 字符串1, 字符串2,整型)
字符串1：原始字符串
字符串2：查找字符串
整型：指定的索引
用于返回指定子字符串在此字符串中最后出现处的索引，从指定的索引开始。如果它不作为一个子字符串出现，则返回-1
示例：
LASTINDEX('asdfdsf','f',4)=3

## 文本函数 CHAR()
CHAR(字符串,数字)
用于获取字符串中指定位置的字符
示例：
【示例】：CHAR('TOM',2) =M

## 文本函数 CONCAT()
CONCAT(字符串1, [字符串2, ...])
将多个字符串串联
示例：
CONCAT('AQF','bW') = AQFbW

## 文本函数 LENGTH()
LENGTH(文本)
返回给定字符串的长度。
示例：
LENGTH('job') = 3

## 文本函数 SUBSTRING()
SUBSTRING([值, ...])
返回一个列表，可以包含值，也可以嵌套列表。
示例：
SUBSTRING('will',1,3)=il

## 文本函数 LOWERCASE()
LOWERCASE(文本)
将指定字符串中的字母转换为小写。
示例：
LOWERCASE('Money')=money

## 文本函数 REPLACE()
REPLACE(字符串, 字符, 新字符)
将文本字符串的一部分替换为其他文本字符串。
示例：
REPLACE('will','i','a') = wall

## 文本函数 TRIM()
TRIM(文本)
移除文本中的前导、结尾和重复空格。
示例：
TRIM('   Money  ')=Money

## 文本函数 UPPERCASE()
UPPERCASE(文本)
将指定字符串中的字母转换为大写。
示例：
UPPERCASE('Money')=MONEY

## 文本函数 VALUE()
VALUE(文本)
计算当前文本中的表达式
示例：
VALUE(MIN(MAX(2,3),1)+3) = 4


## 文本函数 COMPARE()
COMPARE(字符,字符)
比较两个对象之间的大小
* 它返回一个整数值，表示两个对象的大小关系。
* 如果第一个对象比第二个对象小，则返回一个小于0的值；
* 如果第一个对象比第二个对象大，则返回一个大于0的值；
* 如果两个对象相等，则返回0。
示例：
COMPARE('A','B')=-1
COMPARE('9','3')=6



## 文本函数 COMPAREIGNORE()
COMPAREIGNORE(字符,字符)
比较两个对象之间的大小 忽略大小写
示例：
COMPARE('A','b')=-33

## 文本函数 ENDS()
ENDS(字符,字符)
如果字符串以指定字符串结尾，则该函数返回1，否则返回0
示例：
ENDS('AQF','F')=1


## 文本函数 EQUALS()
EQUALS(字符,字符)
字符串比较是否相等, 相等则该函数返回1，否则返回0
示例：EQUALS('AQF','AQF')=1

## 文本函数 EQUALSIGNORE()
EQUALSIGNORE(字符,字符)
字符串比较是否相等,忽略大小写， 相等则该函数返回1，否则返回0
示例：EQUALS('AQF','aQF')=1

## 文本函数 STARTS()
STARTS(字符串1, 字符串2,整型)
用于判断一个字符串是否以指定的字符或字符串开头的函数，满足则该函数返回1，否则返回0
示例：STARTS('will','wi',0)=1


## 数字函数 ABS()
ABS(数值)
返回数值的绝对值
示例：
ABS(-2) = 2


## 数字函数 ACOS()
ACOS(数值)
返回数值的反余弦值，以弧度表示
示例：
ACOS(-0.5)= 2.09

## 数字函数 ASIN()
ASIN(数值)
返回数值的反正弦值，以弧度表示
示例：
ASIN(-0.5) = -0.52

## 数字函数 ATAN()
ATAN(数值)
返回数值的反正切值，以弧度表示
示例：
ATAN(1) = 0.78

## 数字函数 ATAN2()
ATAN2(X坐标值, Y坐标值)
返回给定的 X 轴及 Y 轴坐标值的反正切值
示例：
ATAN2(-1, -1) = -2.35

## 数字函数 COS()
COS(角度)
返回角度的余弦值（角度以弧度表示）
示例：
COS(30) = 0.15

## 数字函数 MAX()
MAX(值1, [值2, ...])
返回数值数据集中的最大值。
示例：
MAX(2, 100) = 100


## 数字函数 MIN()
MIN(值1, [值2, ...])
返回数值数据集中的最小值。
示例：
MIN(2, 100) = 2

## 数字函数 SIN()
SIN(角度)
给定角度（以弧度表示），返回其正弦值
示例：
SIN(30) = 0.5

## 数字函数 SUM()
SUM(值1, [值2, ...])
SUM(1, 2) = 3
示例：
返回目标数组所有数值的总和

## 数字函数 TAN()
TAN(角度)
返回给定角度的正切值（以弧度表示）
示例：
TAN(45*PI()/180) = 1

## 数字函数 CEIL()
CEIL(数值)
用于将一个浮点数向上取整到最接近的整数
示例：CEIL(10.12)=11.0

## 数字函数 EXP()
EXP(数值)
通常被表示为exp(x)或e^x，其中e是自然对数的底数
示例：EXP(2)=7.38


## 数字函数 FLOOR()
FLOOR(数值)
向下取整。即不论小数部分的值为多少，都直接舍去，只保留整数部分。
示例：FLOOR(3.89)=3


## 数字函数 LOG()
LOG(数值)
对数函数
示例：LOG(10)=2.3


## 数字函数 POW()
POW(数值)
返回一个数的幂
示例：POW(2,3)=8


## 数字函数 RANDOM()
RANDOM()
随机数函数，返回随机数

## 数字函数 SQRT()
SQRT()
平方根函数
示例：SQRT(4)=2

