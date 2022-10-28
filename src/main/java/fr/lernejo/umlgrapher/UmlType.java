package fr.lernejo.umlgrapher;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

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
        this.getChildren(clazz);
        types.add(clazz);
    }
    private void getChildren(Class clazz) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
            .forPackage("")
            .forPackage("", clazz.getClassLoader())
        );
        Set<Class<?>> subTypes = reflections.get(
            Scanners.SubTypes
                .get(clazz)
                .asClass(this.getClass().getClassLoader(), clazz.getClassLoader())
        );
        for (Class cls : subTypes) {
            if (!types.contains(cls)) types.add(cls);
        }
    }

    public Set<Class> getTypes() {
        return this.types;
    }

    private final Set<Class> types = new TreeSet<>(Comparator
        .<Class, String>comparing(Class::getSimpleName)
        .thenComparing(Class::getPackageName));

}
