package pkg.exoad.swiggie.tests;

import org.junit.jupiter.api.Test;
import pkg.exoad.swiggie.SwColor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSwColor
{
	@Test public void testConstructorRGB()
	{
		SwColor color = SwColor.acquireFromRGB(0, 128, 255);
		assertEquals(color.getRed(), 0);
		assertEquals(color.getGreen(), 128);
		assertEquals(color.getBlue(), 255);
	}
}
