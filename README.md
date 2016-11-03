# QST_1103
11.03 Java+Hadoop练习

## 练习部分

### 练习前准备：

1. Fork这个仓库

### 练习1

题目要求：

0. 在个人仓库下，创建分支yourname_ex1
1. 在个人分支下，修改README.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是
2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
3. 创建pull request，与主仓库的master分支对比

Input:

`2016-11-11 11:11:11`

Output:2016/11/11 11:11:11 to 1478833871000



### 练习2

题目要求：

0. 在个人仓库下，创建分支yourname_ex2
1. 修改代码，使程序在输入『31/Dec/2015:00:02:09』的时候，转化为时间戳并输出，把结果填写到README.md当中
2. 和ex1对比，对多出来的代码进行注释
3. 提交代码到分支下，创建pull request，与主仓库的master分支对比

Input:

`31/Dec/2015:00:02:09`

Output:1451491329000

### 练习3
题目要求：

0. 在个人仓库下，创建分支yourname_ex3
1. 编写代码完成以下功能：
    1. 从access.log中读入数据，获取IP和Time
    2. 输出在时间区间[beginTime, endTime]内的IP和Time，以tab分割
2. 提交代码到分支下，创建pull request，与主仓库的master分支对比

### 练习4

题目要求：

0. 在个人仓库下，创建分支yourname_ex4
1. 使用Streaming框架完成一下功能
    0. 通过参数args，指定beginTime和endTime
    1. 每次运行，计算[beginTime, endTime]之内的IP数
2. 完成代码，并添加适量注释
3. 提交代码到分支，创建pull request与主仓库的master对比

### 练习5

题目要求：

0. 在个人仓库下，创建分支yourname_ex5
1. 设计方案，满足以下功能，把方案添加到README.md当中
    0. 在用户输入一个时间段[beginTime, endTime]之后，返回该时间段内访问的IP数。其中时间以分钟为单位
    1. 存储只能使用HBase
2. 编写代码实现
3. 提交代码到分支，创建pull request与主仓库的master对比

方案：

Input:
`2016-12-31 01:00:01 2016-12-31 11:11:11`

Output:
`10`

### 练习6

题目要求：

0. 把练习5当中，访问HBase的部分，使用HTTP接口实现


    






