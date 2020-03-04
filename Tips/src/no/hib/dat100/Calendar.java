package no.hib.dat100;


	import java.text.SimpleDateFormat;
	import java.util.Date;
	  
	public class Calendar {
	   public static void main(String[] args) {
	      Date now = new Date();
	      System.out.println("toString(): " + now);  // dow mon dd hh:mm:ss zzz yyyy
	      //for more eks see ---Java Tutorial #2 - Working with Java - YouTube (last eks)
	      // SimpleDateFormat can be used to control the date/time display format:
	      //   E (day of week): 3E or fewer (in text xxx), >3E (in full text)
	      //   M (month): M (in number), MM (in number with leading zero)
	      //              3M: (in text xxx), >3M: (in full text full)
	      //   h (hour): h, hh (with leading zero)
	      //   m (minute)
	      //   s (second)
	      //   a (AM/PM)
	      //   H (hour in 0 to 23)
	      //   z (time zone)
	      SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
	      System.out.println("Format 1:   " + dateFormatter.format(now));

	      dateFormatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	      System.out.println("Format 2:   " + dateFormatter.format(now));
	      
	      dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
	      System.out.println("Format 3:   " + dateFormatter.format(now));
	      System.out.println("2" + 7 + 3);
			System.out.println(5 * 6 + "7");
			System.out.println(2 + 3 / 4);
			System.out.println(11 % 2);
			System.out.println(!(7 == 2));
			System.out.println((4 < 3) || ("abc".equals("def")));

	   }
	}