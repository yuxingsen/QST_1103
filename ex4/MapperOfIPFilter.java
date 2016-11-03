package No4;

import java.util.Scanner;

public class MapperOfIPFilter {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String pattern="(\\d+\\.\\d+\\.\\d+\\.\\d+).{5}\\[(\\d+\\/[a-zA-Z]+\\/\\d+\\:\\d+\\:\\d+\\:\\d+).{13}\\/((show|musicians).\\d+)";  
		Pattern r = Pattern.compile(pattern);
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			Matcher m = r.matcher(line);
			if (m.find()){
				System.out.println(m.group(1)+"\t"+m.group(2));//把ip与时间输出
			}
		}
	}
}
