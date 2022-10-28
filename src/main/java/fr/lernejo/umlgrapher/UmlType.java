package fr.lernejo.umlgrapher;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Use to manage class et super base on the classe to give
 */
public class UmlType {

    public UmlType(Class[] mesClass) {
        this.getClass(mesClass);
    }

    private void getClass(Class[] mesClass) {
        for (Class clazz : mesClass) {
            getParents(clazz);
        }
    }

    private void getParents(Class clazz) {
        Class superClass = clazz.getSuperclass();
        if (superClass != null
            && !superClass.getSimpleName().equals("Object"))
            getParents(superClass);

        for (Class interfass : clazz.getInterfaces()) {
            getParents(interfass);
        }

        types.add(clazz);
    }

    public Set<Class> getTypes() {
        return this.types;
    }

    private final Set<Class> types = new TreeSet<>(Comparator
        .<Class, String>comparing(Class::getSimpleName)
        .thenComparing(Class::getPackageName));

}
