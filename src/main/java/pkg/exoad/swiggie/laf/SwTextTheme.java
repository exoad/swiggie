package pkg.exoad.swiggie.laf;

import lombok.*;
import pkg.exoad.swiggie.tools.SwFonts;

@Getter @Setter @AllArgsConstructor(access = AccessLevel.PRIVATE) @NoArgsConstructor(access = AccessLevel.PRIVATE) public class SwTextTheme
{
	public static SwTextTheme acquire()
	{
		return new SwTextTheme();
	}



	private float fontSize;
	private SwFonts.FontWeight fontWeight;

}
