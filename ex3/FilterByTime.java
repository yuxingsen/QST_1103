package No3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex3
 * 1. 编写代码完成以下功能：
 * 		a. 从access.log中读入数据，获取IP和Time
 * 		b. 输出在时间区间[beginTime, endTime]内的IP和Time，以tab分割
 * 2. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class FilterByTime {
	
	public static void main(String[] args) throws ParseException, FileNotFoundException{
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = regularFormat.parse("2015-12-31 18:00:00");
		Date endDate = regularFormat.parse("2015-12-31 19:00:00");
		String filePath = "./access.log";
		BufferedReader bw=new BufferedReader(new FileReader(filePath));//通过bufferedreader读取文件信息，
	        String line=null;//
	        while((line=bw.readLine())!=null){
		// 切分获取IP，Time
			//通过正则匹配出ip与时间
		     String pattern="(\\d+\\.\\d+\\.\\d+\\.\\d+).{5}\\[(\\d+\\/[a-zA-Z]+\\/\\d+\\:\\d+\\:\\d+\\:\\d+).{13}\\/((show|musicians).\\d+)";  
		     Pattern r = Pattern.compile(pattern);//定义一个匹配器
		     Matcher m = r.matcher(line);//进行匹配
		     if (m.find()){
			        String strIp = m.group(1);//把ipg赋给
				String strTime = m.group(2)//把时间赋给
					Date date=paseTime(strTime);//把时间字符串进行转换s成date格式
					if(date.after(beginDate)&&date.before(endDate)){//判断时间是否在范围内
					// 对在时间区间内的数据进行输出
					System.out.println(strIp + "\t" + strTime);
				}
			
		         }
		 }
	}
	private static Date paseTime(String line) throws ParseException{
	 SimpleDateFormat format = new SimpleDateFormat("d/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
	 SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String times = line.trim();
		String data=(dateformat1.format(format.parse(times)));
		Date data1=dateformat1.parse(data);	
	return data1;
}
	
}
