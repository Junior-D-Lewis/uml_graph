package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class UmlRelation {

    private final List<String[]> relations = new ArrayList<>();

    public UmlRelation(UmlType umlType) {
        this.searchRelations(umlType);
    }

    public void searchRelations(UmlType umlType) {
        for (Class clazz : umlType.getTypes()) {
            Class superClass = clazz.getSuperclass();
            if (superClass != null && !superClass.getSimpleName().equals("Object")) {
                relations.add(getParents(superClass.getSimpleName(), clazz.getSimpleName(), "extends"));
            }
            for (Class inter : clazz.getInterfaces()) {
                relations.add(getParents(inter.getSimpleName(), clazz.getSimpleName(), !Modifier.isInterface(clazz.getModifiers()) ? "implements" : "extends"));
            }
        }
    }

    private String[] getParents(String tab1, String tab2, String tab3) {
        String[] tab = {tab1, tab2, tab3};
        return tab;
    }

    public List<String[]> getRelations() {
        return relations;
    }
}
