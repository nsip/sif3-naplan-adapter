package sif3.au.naplan.sif;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollectionHelper {
    private static final Logger L = LoggerFactory.getLogger(CollectionHelper.class);

    private CollectionHelper() {
        // static only
    }

    protected static final Map<Class<?>, Method> GET_COLLECTION_METHODS = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <SC, SE> List<SE> getCollection(SC eventCollection, Class<SC> collectionClass, Class<SE> entityClass)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return (List<SE>) GET_COLLECTION_METHODS.get(collectionClass).invoke(eventCollection);
    }

    public static void assignCollectionMethod(Class<?> collectionClass, String singleName) {
        if (GET_COLLECTION_METHODS.get(collectionClass) == null) {
            assignCollectionMethodSync(collectionClass, singleName);
        }
    }

    private static synchronized void assignCollectionMethodSync(Class<?> collectionClass, String singleName) {
        if (GET_COLLECTION_METHODS.get(collectionClass) == null) {
            try {
                Method method = collectionClass.getMethod("get" + singleName, new Class[] {});
                GET_COLLECTION_METHODS.put(collectionClass, method);
            } catch (Exception e) {
                L.error("Unable to determine get collection method. - get" + singleName, e);
            }
        }
    }
}
