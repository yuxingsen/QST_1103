package No4;

import java.util.Scanner;

public class ReducerOfIPFilter {
	public static void main(String[] args) throws ParseException{
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = regularFormat.parse("2015-12-31 18:00:00");//查询的开始的时间
		Date endDate = regularFormat.parse("2015-12-31 19:00:00");//查询的接触时间
		Scanner scanner = new Scanner(System.in);
		 String key=null;
		 String value=null;
		 HashSet<String> values = new HashSet<String>();
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			String[] word = line.split("\t",2);
			if (word.length >1){
				Date date=paseTime(word[1]);//把时间转成date格式，方面后面的比较
				if(date.after(beginDate)&&date.before(endDate)){
						value=word[0];
						values.add(value);	//把ip房间set里面进行去重，可以方面统计ip
						continue;
						}
				}
		}	
			System.out.println("between"+beginDate+"and"+endDate+"IP："+"\t"+values.size());
		}
	//把日记的时间转为UTIL.date类的date
	private static Date paseTime(String line) throws ParseException{
		 SimpleDateFormat format = new SimpleDateFormat("d/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
		 SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String times = line.trim();
			String data=(dateformat1.format(format.parse(times)));
			Date data1=dateformat1.parse(data);	
		return data1;
	}
}
