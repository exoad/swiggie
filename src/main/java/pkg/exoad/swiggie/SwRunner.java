package pkg.exoad.swiggie;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class SwRunner
{
	private SwRunner()
	{}

	private static final ExecutorService defaultService = Executors.newCachedThreadPool();

	public static void provideAsync(Runnable task)
	{
		defaultService.submit(task);
	}

}
