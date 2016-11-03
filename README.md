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

Output:



### 练习2

题目要求：

0. 在个人仓库下，创建分支yourname_ex2
1. 修改代码，使程序在输入『31/Dec/2015:00:02:09』的时候，转化为时间戳并输出，把结果填写到README.md当中
2. 和ex1对比，对多出来的代码进行注释
3. 提交代码到分支下，创建pull request，与主仓库的master分支对比

Input:

`31/Dec/2015:00:02:09`

Output:

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

方案：package yuid.senid;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * 设计方案，满足以下功能，把方案添加到README.md当中
在用户输入一个时间段[beginTime, endTime]之后，返回该时间段内访问的IP数。其中时间以分钟为单位
存储只能使用HBase
编写代码实现
提交代码到分支，创建pull request与主仓库的master对比
方案：

Input: 2016-12-31 01:00:01 2016-12-31 11:11:11

Output: 10
 * @author Administrator
 *
 */
public class yuxingsen_5 {
	private static Configuration conf = null;
	private static HBaseAdmin admin= null;
	private static Logger log = Logger.getLogger(App.class);
	private static String hTableName = "userIP_Count";
	private static String[] families = {"cf1", "cf2"};
	
public static void main(String[] args) throws ParseException, IOException {
	conf=new Configuration();
    conf.set("hbase.zookeeper.property.clientport", "2181");
	conf.set("hbase.zookeeper.quorum", "master");
	log.info("Log in");
	admin=new  HBaseAdmin(conf);
	Ex3();
	SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	System.out.println("请输入一个开始时间，精确为分钟格式为：2015-12-31 18:00:00");
	Scanner sc1=new Scanner(System.in);
	String  sc1_tre=sc1.nextLine();
	Date beginDate = regularFormat.parse(sc1_tre);
	System.out.println("请输入一个结束时间，精确为分钟格式为：2015-12-31 18:20:00");
	Scanner sc2=new Scanner(System.in);
	//String sc2="2015-12-31 18:33:00";
	String  sc2_tre=sc2.nextLine();
	Date endDate = regularFormat.parse(sc2_tre);
	String filePath = "I:\\spark\\log.txt";
	BufferedReader bw=new BufferedReader(new FileReader(filePath));//通过文件路径来创建一个FileInputStream对象
	 String line=null;//构造一个新的 Scanner，它生成的值是从指定的输入流扫描的。
	 HashSet<String> values = new HashSet<String>();
	 while((line=bw.readLine())!=null){
		// 切分获取IP，Time
		 String pattern="(\\d+\\.\\d+\\.\\d+\\.\\d+).{5}\\[(\\d+\\/[a-zA-Z]+\\/\\d+\\:\\d+\\:\\d+\\:\\d+)";  
		 Pattern r = Pattern.compile(pattern);
		 Matcher m = r.matcher(line);
		 if (m.find()){
				String strTime = m.group(2);
				Date date=paseTime(strTime);
				if(date.after(beginDate)&&date.before(endDate)){
					 String strIp = m.group(1);
					// 对在时间区间内的数据进行输出
					 values.add(strIp);
				}
				
		 }
		 }	
	 HTable table=new HTable(conf, Bytes.toBytes(hTableName));
	 Date newdata=new Date();
	 Put put=new Put(Bytes.toBytes(newdata.toString()));	
	 put.add(Bytes.toBytes("cf1"), Bytes.toBytes("beginDate"), Bytes.toBytes(beginDate.toString()));
	 table.put(put);
	 Put put1=new Put(Bytes.toBytes(newdata.toString()));	
	 put1.add(Bytes.toBytes("cf1"), Bytes.toBytes("endDate"), Bytes.toBytes(endDate.toString()));
	 table.put(put1);
	 Put put2=new Put(Bytes.toBytes(newdata.toString()));	
	 put2.add(Bytes.toBytes("cf2"), Bytes.toBytes("count"), Bytes.toBytes(values.size()+""));
	 table.put(put2);
	 System.out.println("在"+beginDate.toString()+"-"+endDate.toString()+"范围内IP数" + "\t" + values.size());
	admin.close();
}
private static Date paseTime(String line) throws ParseException{
	 SimpleDateFormat format = new SimpleDateFormat("d/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
	 SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String times = line.trim();
		String data=(dateformat1.format(format.parse(times)));
		Date data1=dateformat1.parse(data);	
	return data1;
}
private static void Ex3() throws IOException {
	if(tableExist("hTableName")){
		return ;
	}
	CreateTable("hTableName",families);
}
private static boolean tableExist(String tableName) throws IOException {
	// TODO Auto-generated method stub
	return admin.tableExists(hTableName);
}
private static void CreateTable(String tableName,String []families) throws IOException{
	HTableDescriptor desc = new HTableDescriptor("userIP_Count");
	for(int iFamily = 0; iFamily < families.length; iFamily++){
		HColumnDescriptor columnDescriptor = new HColumnDescriptor(families[iFamily]);
		columnDescriptor.setVersions(1, 100);
		desc.addFamily(columnDescriptor);
	}
    
	admin.createTable(desc);
}
private static void initLog() {
	BasicConfigurator.configure();
	log.setLevel(Level.INFO);
	
}
}

Input:
`2016-12-31 01:00:01 2016-12-31 11:11:11`

Output:
`10`

### 练习6

题目要求：

0. 把练习5当中，访问HBase的部分，使用HTTP接口实现


    






