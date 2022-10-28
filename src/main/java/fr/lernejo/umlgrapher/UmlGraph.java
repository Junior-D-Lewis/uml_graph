package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;

public class UmlGraph {

    public UmlGraph(Class[] mesClass) {
        this.mesClass = mesClass;
    }
    public final String as(GraphType graphType) {
        String format = "";
        if (graphType == GraphType.Mermaid) {
            InternalGraphRepresentation graph = new InternalGraphRepresentation(mesClass);
            format = new MermaidFormatter().format(graph);
        }
        return format;
    }
    final Class[] mesClass;
}
