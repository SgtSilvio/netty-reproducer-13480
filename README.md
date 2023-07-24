# Reproducer for [Netty Issue 13480](https://github.com/netty/netty/issues/13480)

1. Needs to be run on MacOS
2. Run `io.netty.reproducer13480.Main`
3. If JNI global GC root prevents the garbage collection of the classloader, throws an `AssertionError`
