package ru.otus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

public class ProxyBuilder {
    static TestLogging createMyClass() {
        InvocationHandler handler = new MyInvocationHandler(new TestLoggingImpl());
        return (TestLogging) Proxy.newProxyInstance(ProxyBuilder.class.getClassLoader(),
                new Class<?>[]{TestLogging.class}, handler);
    }

    static class MyInvocationHandler implements InvocationHandler {
        private final TestLogging myClass;
        private final List<Method> annotatedMethods;

        MyInvocationHandler(TestLogging myClass) {
            this.myClass = myClass;
            this.annotatedMethods = Arrays.stream(myClass.getClass().getDeclaredMethods())
                    .filter(m -> m.isAnnotationPresent(Log.class))
                    .toList();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            annotatedMethods.stream().filter(currMethod -> currMethod.getName().equals(method.getName())
                    && Arrays.stream(currMethod.getParameterTypes()).allMatch(p -> Arrays.asList(method.getParameterTypes()).contains(p))
                    && currMethod.getParameterCount() == method.getParameterCount())
                    .forEach(currMethod -> System.out.printf("executed method: %s, params: %s%n", method.getName(), Arrays.asList(args)));
            return method.invoke(myClass, args);
        }

        @Override
        public String toString() {
            return "MyInvocationHandler{" +
                    "myClass=" + myClass +
                    '}';
        }
    }
}
