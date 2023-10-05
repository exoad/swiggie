package pkg.exoad.swiggie;

import lombok.Getter;

import java.net.URI;

public class SwImage
{

	@Getter private URI location;

	private SwImage(URI location)
	{
		this.location = location;
	}
}
