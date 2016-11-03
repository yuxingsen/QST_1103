package No2;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex2
 * 1. 修改代码，使程序在输入『31/Dec/2015:00:02:09』的时候，转化为时间戳并输出，把结果填写到README.md当中
 * 2. 和ex1对比，对多出来的代码进行注释
 * 3. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class DifferentFormat {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Locale locale = Locale.US; //创建一个美国的locale的对象的有用常量
		SimpleDateFormat inputFormat = new SimpleDateFormat("d/MMM/yyyy:HH:mm:ss", locale); //给定格式与语言环境进行时间转换 
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			Date lineDate = null;
			long lineTimestamp;
			try {
				lineDate = inputFormat.parse(line);//转格式
				lineTimestamp = lineDate.getTime();//得到时间戳
				System.out.println(lineTimestamp);//打印时间戳
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
