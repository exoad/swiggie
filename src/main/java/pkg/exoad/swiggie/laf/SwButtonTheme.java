package pkg.exoad.swiggie.laf;

import lombok.*;
import lombok.experimental.Accessors;
import pkg.exoad.swiggie.SwColor;

@Getter @Accessors(fluent = true, chain = true) @Setter @AllArgsConstructor(access = AccessLevel.PRIVATE) @NoArgsConstructor(access = AccessLevel.PRIVATE) public class SwButtonTheme
{
	public static SwButtonTheme acquire() // we do not provide direct construction
	{
		return new SwButtonTheme();
	}

	private SwColor focusColor;
	private SwColor highlightColor;
	private SwColor pressedColor;
	private SwColor hoverColor;
	private SwColor disabledFilledColor;
	private SwColor disabledBorderColor;
	private SwColor disabledTextColor;
	private SwColor textColor;
	private SwColor borderColor;
	private SwColor filledColor;

	private SwTextTheme labelTheme;
}
