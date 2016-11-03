package No1;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		//输进来时间，
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		while (scanner.hasNext()){
			String line = scanner.nextLine();//获取输进来的时间
			Date lineDate = null;
			long lineTimestamp;
			try {
				lineDate = inputFormat.parse(line);//转成'yyyy-MM-dd HH:mm:ss'格式
				lineTimestamp = lineDate.getTime();//得到时间戳
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);//输出‘yyyy/MM/dd HH:mm:ss'格式的时间和这个时间的时间戳
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
