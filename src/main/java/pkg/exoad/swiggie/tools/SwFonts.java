package pkg.exoad.swiggie.tools;

public final class SwFonts
{
	private SwFonts()
	{
	}

	/**
	 * Font weight as defined by the CSS specification.
	 *
	 * @see <a href="https://www.w3.org/TR/css-fonts-3/#font-weight-prop">CSS Fonts Level 3</a>
	 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/font-weight">MDN</a>
	 */
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

	/**
	 * @return the normal font weight
	 */
	public static FontWeight normalFontWeight()
	{
		return FontWeight.W400;
	}

	/**
	 * @return the bold font weight
	 */
	public static FontWeight boldFontWeight()
	{
		return FontWeight.W700;
	}

	/**
	 * Font decoration as defined by the CSS specification.
	 * <p>
	 *     Note: {@link #NONE} is not part of the CSS specification.
	 *     It is used to indicate that no decoration should be applied.
	 *     This is the default value.
	 *     It is also used to indicate that the decoration should be removed.
	 *     This is used when a decoration is set on a range of text and the decoration is removed from part of the range.
	 */
	public enum FontDecoration
	{
		NONE,
		UNDERLINE,
		STRIKE_THROUGH
	}

	/**
	 * Font style as defined by the CSS specification.
	 *
	 * @see <a href="https://www.w3.org/TR/css-fonts-3/#font-style-prop">CSS Fonts Level 3</a>
	 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/font-style">MDN</a>
	 */
	public enum FontStyle
	{
		NORMAL,
		ITALIC,
		OBLIQUE
	}

	/**
	 * Text alignment as defined by the CSS specification.
	 */
	public enum TextAlignment
	{
		LEFT,
		CENTER,
		RIGHT,
		JUSTIFY
	}

}

