package basic.test;
import static java.lang.System.out;

/*Object.hashCode()方法不能保证2个不同的对象返回不同的hashCode。
 * 只保证2个对象equals 返回true的时候，这2个对象的hashCode返回的值一样。 
 * 
 * */

import java.util.HashMap;
import java.util.Map;

/**
 *  Utility for assigning a unique ID to objects and fetching objects given
 *  a specified ID
 */
class ObjectIDBank {

    /**Singleton instance*/
    private static ObjectIDBank instance;

    /**Counting value to ensure unique incrementing IDs*/
    private long nextId = 1;

    /** Map from ObjectEntry to the objects corresponding ID*/
    private Map<ObjectEntry, Long> ids = new HashMap<ObjectEntry, Long>();

    /** Map from assigned IDs to their corresponding objects */
    private Map<Long, Object> objects = new HashMap<Long, Object>();

    /**Private constructor to ensure it is only instantiated by the singleton pattern*/
    private ObjectIDBank(){}

    /**Fetches the singleton instance of ObjectIDBank */
    public static ObjectIDBank instance() {
        if(instance == null)
            instance = new ObjectIDBank();

        return instance;
    }

    /** Fetches a unique ID for the specified object. If this method is called multiple
     * times with the same object, it is guaranteed to return the same value. It is also guaranteed
     * to never return the same value for different object instances (until we run out of IDs that can
     * be represented by a long of course)
     * @param obj The object instance for which we want to fetch an ID
     * @return Non zero unique ID or 0 if obj == null
     */
    public long getId(Object obj) {

        if(obj == null)
            return 0;

        ObjectEntry objEntry = new ObjectEntry(obj);

        if(!ids.containsKey(objEntry)) {
            ids.put(objEntry, nextId);
            objects.put(nextId++, obj);
        }

        return ids.get(objEntry);
    }

    /**
     * Fetches the object that has been assigned the specified ID, or null if no object is
     * assigned the given id
     * @param id Id of the object
     * @return The corresponding object or null
     */
    public Object getObject(long id) {
        return objects.get(id);
    }


    /**
     * Wrapper around an Object used as the key for the ids map. The wrapper is needed to
     * ensure that the equals method only returns true if the two objects are the same instance
     * and to ensure that the hash code is always the same for the same instance.
     */
    private class ObjectEntry {
        private Object obj;

        /** Instantiates an ObjectEntry wrapper around the specified object*/
        public ObjectEntry(Object obj) {
            this.obj = obj;
        }


        /** Returns true if and only if the objects contained in this wrapper and the other
         * wrapper are the exact same object (same instance, not just equivalent)*/
        @Override
        public boolean equals(Object other) {
            return obj == ((ObjectEntry)other).obj;
        }


        /**
         * Returns the contained object's identityHashCode. Note that identityHashCode values
         * are not guaranteed to be unique from object to object, but the hash code is guaranteed to
         * not change over time for a given instance of an Object.
         */
        @Override
        public int hashCode() {
            return System.identityHashCode(obj);
        }
    }
}