package tiempo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GregCalen {

	public static void main(String[] args) {
		GregorianCalendar gc=new GregorianCalendar();
		gc.setLenient(false);
		System.out.println(gc);
		Date d=gc.getTime();
		System.out.println(d);
		System.out.println(gc.getTimeInMillis());
		
		gc.add(Calendar.MONTH, -3);
		d=gc.getTime();
		System.out.println(d);
		
		

	}

}
