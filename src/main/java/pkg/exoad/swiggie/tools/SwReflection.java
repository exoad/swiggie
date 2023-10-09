package pkg.exoad.swiggie.tools;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

public final class SwReflection
{
	private SwReflection()
	{
	}

	public static ArrayList<Class<?>> getClassesInPackage(String packageName)
			throws IOException, ClassNotFoundException
	{
		ClassLoader classLoader = Thread.currentThread()
		                                .getContextClassLoader();
		String path = packageName.replace('.', '/');
		ArrayList<Class<?>> classes = new ArrayList<>();

		Enumeration<URL> resources = classLoader.getResources(path);
		while (resources.hasMoreElements())
		{
			URL resource = resources.nextElement();
			if (resource.getProtocol()
			            .equals("file"))
			{
				String filePath = resource.getFile();
				if (filePath.contains(".class"))
				{
					String className = packageName + '.' + filePath.substring(filePath.lastIndexOf('/') + 1,
							filePath.length() - 6);
					Class<?> clazz = Class.forName(className);
					classes.add(clazz);
				}
			}
		}

		return classes;
	}
}
