package sif3.au.naplan.sif;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import sif.dd.au30.model.ObjectFactory;

public class ObjectFactoryHelper {
    private static final ObjectFactory objectFactory = new ObjectFactory();

    private ObjectFactoryHelper() {
        // static only
    }

    protected static final Map<Class<?>, Method> CREATE_METHODS = new HashMap<>();

    public static JAXBElement<?> createObject(Object object, Class<?> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = CREATE_METHODS.get(clazz);
        return (JAXBElement<?>) method.invoke(objectFactory, object);
    }

    public static void assignCreateMethod(Class<?> clazz, String name) {
        if (CREATE_METHODS.get(clazz) == null) {
            assignCreateMethodSync(clazz, name);
        }
    }

    private static synchronized void assignCreateMethodSync(Class<?> clazz, String name) {
        if (CREATE_METHODS.get(clazz) == null) {
            Method method = null;
            try {
                method = ObjectFactory.class.getMethod("create" + name, clazz);
            } catch (Exception ignore) {
            } // will recover
            if (method != null) {
                CREATE_METHODS.put(clazz, method);
            } else {
                // Pre-Load all. Perhaps just do this anyway?
                Method[] methods = ObjectFactory.class.getMethods();
                for (int i = 0; methods != null && i < methods.length; i++) {
                    Method createMethod = methods[i];
                    if ((createMethod != null) && (createMethod.getParameterTypes() != null) && (createMethod.getParameterTypes().length == 1)
                            && (createMethod.getReturnType().equals(JAXBElement.class))) {
                        CREATE_METHODS.put(createMethod.getParameterTypes()[0], method);
                    }
                }
            }
        }
    }
}
