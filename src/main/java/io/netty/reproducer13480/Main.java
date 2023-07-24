package io.netty.reproducer13480;

import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class Main {

    public static void main(final String[] args) throws Throwable {
        loadClass();
    }

    private static void loadClass() throws Throwable {
        final String[] classpathEntries = System.getProperty("java.class.path").split(File.pathSeparator);
        final URL[] classPathUrls = Arrays.stream(classpathEntries).map(spec -> {
            try {
                return new URL("file://" + spec);
            } catch (final MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }).toArray(URL[]::new);
        URLClassLoader classLoader = new URLClassLoader("wabern", classPathUrls, null);
        final WeakReference<URLClassLoader> classLoaderWeakReference = new WeakReference<>(classLoader);
        Class<?> clazz = classLoader.loadClass("io.netty.resolver.dns.DnsServerAddressStreamProviders");
        clazz.getDeclaredMethod("platformDefault").invoke(null);
        classLoader.close();
        //noinspection UnusedAssignment explicitely free local variable
        clazz = null;
        //noinspection UnusedAssignment explicitely free local variable
        classLoader = null;
        System.gc();
        if (classLoaderWeakReference.get() != null) {
            throw new AssertionError();
        }
    }
}
