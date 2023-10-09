package pkg.exoad.swiggie.tools;

public final class SwFonts
{
	private SwFonts()
	{
	}

	public enum FontWeight
	{
		W100,
		W200,
		W300,
		W400,
		W500,
		W600,
		W700,
		W800,
		W900
	}

	public static FontWeight normalFontWeight()
	{
		return FontWeight.W400;
	}

	public static FontWeight boldFontWeight()
	{
		return FontWeight.W700;
	}
}

