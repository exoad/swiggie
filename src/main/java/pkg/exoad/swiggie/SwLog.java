package pkg.exoad.swiggie;

import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;
import pkg.exoad.swiggie.err.SwUnexpectedReferenceTypingException;
import pkg.exoad.swiggie.stx.SwWrapper;

import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

@Getter public final class SwLog
{
	public enum LogType
	{
		DBG,
		LOG,
		ERR,
		RUN
	}

	private final SwWrapper<Long> errors = SwWrapper.acquire(0L);

	private static SwLog logger;

	public static SwLog getLogger()
	{
		if (logger == null)
			logger = new SwLog();
		return logger;
	}

	public void emitError(Class<? extends RuntimeException> ref, String reason)
	{
		RuntimeException e;
		try
		{
			e = ref.getConstructor(String.class)
			       .newInstance(reason);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException |
		         NoSuchMethodException err)
		{
			throw new SwUnexpectedReferenceTypingException(
					"A required constructor of type: [String] was not found for " + ref.getCanonicalName()
							+ "as a exception reference", err);
		}
		if (e != null)
			throw e;
		errors.setValue(errors.getValue() + 1);
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
		if (key == LogType.ERR)
			errors.setValue(errors.getValue() + 1);
		stream.println("[" + key.name() + "]\t> " + content);
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
