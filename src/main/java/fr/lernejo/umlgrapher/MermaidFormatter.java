package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Set;

public class MermaidFormatter {

    public String format(InternalGraphRepresentation internalGraphRepresentation) {
        return typeRepresentation(internalGraphRepresentation.getUmlType()
            .getTypes()) + relationRepresentation(internalGraphRepresentation.getUmlRelation()
            .getRelations());
    }

    private String typeRepresentation(Set<Class> mesClass) {
        String format = "classDiagram\n";
        for (Class clazz : mesClass) {
            format += "class " + clazz.getSimpleName();
            if (Modifier.isInterface(clazz.getModifiers())) {
                format +=" {\n    <<interface>>\n}";
            }
            format += "\n";
        }
        return format;
    }

    private String relationRepresentation(List<String[]> relations) {
        String format = "";

        for (String[] rel : relations) {
            format += rel[0];
            if (rel[2].equals("implements"))
                format += " <|.. ";
            else format += " <|-- ";
            format += rel[1] + " : " + rel[2];
            format += "\n";
        }
        return format;
    }
}
