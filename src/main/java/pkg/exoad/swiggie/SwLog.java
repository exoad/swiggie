package pkg.exoad.swiggie;

import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.io.OutputStream;
import java.io.PrintStream;

@Getter public final class SwLog
{
	public enum LogType
	{
		DBG,
		LOG,
		ERR,
		RUN
	}

	private static SwLog logger;

	public static SwLog getLogger()
	{
		if (logger == null)
			logger = new SwLog();
		return logger;
	}

	private PrintStream stream;
	@Nullable private OutputStream otherStream;

	private SwLog()
	{
		stream = System.out;
		otherStream = null;
	}

	public void setStream(@NonNull PrintStream stream)
	{
		this.stream = stream;
	}

	public void setOtherStream(@Nullable OutputStream otherStream)
	{
		this.otherStream = otherStream;
	}

	public void log(@NonNull LogType key, @NonNull Object content)
	{
		stream.println("[" + key.name() + "]\t> " + content.toString());
	}

	public void debug(@NonNull Object content)
	{
		log(LogType.DBG, content);
	}

	public void error(@NonNull Object content)
	{
		log(LogType.ERR, content);
	}
}
