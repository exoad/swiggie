package pkg.exoad.swiggie.laf;

import lombok.*;
import lombok.experimental.Accessors;
import pkg.exoad.swiggie.SwColor;

@Getter @Accessors(fluent = true, chain = true) @Setter @AllArgsConstructor(access = AccessLevel.PRIVATE) @NoArgsConstructor(access = AccessLevel.PRIVATE) public class SwButtonTheme
{

	public static SwButtonTheme acquire()
	{
		return new SwButtonTheme();
	}

	public static SwButtonTheme acquire(
			SwColor focusColor,
			SwColor highlightColor,
			SwColor pressedColor,
			SwColor hoverColor,
			SwColor disabledFilledColor,
			SwColor disabledBorderColor,
			SwColor disabledTextColor,
			SwColor textColor,
			SwColor borderColor,
			SwColor filledColor,
			SwTextTheme labelTheme
	)
	{
		return new SwButtonTheme(
				focusColor,
				highlightColor,
				pressedColor,
				hoverColor,
				disabledFilledColor,
				disabledBorderColor,
				disabledTextColor,
				textColor,
				borderColor,
				filledColor,
				labelTheme
		);
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
