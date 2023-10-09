package pkg.exoad.swiggie.laf;

import lombok.*;
import pkg.exoad.swiggie.SwColor;
import pkg.exoad.swiggie.tools.SwFonts;

@Getter @Setter @AllArgsConstructor(access = AccessLevel.PRIVATE) @NoArgsConstructor(access = AccessLevel.PRIVATE) public class SwTextTheme
{
	public static SwTextTheme acquire()
	{
		return new SwTextTheme();
	}

	private float fontSize;
	private SwFonts.FontWeight fontWeight;
	private SwFonts.FontStyle fontStyle;
	private SwFonts.FontDecoration fontDecoration;
	private SwFonts.TextAlignment textAlignment;
	private SwColor textColor;
	private SwColor textBackgroundColor;
	private SwColor textSelectionColor;
	private SwColor textSelectionBackgroundColor;
	private SwColor textDisabledColor;
	private SwColor textDisabledBackgroundColor;
}
