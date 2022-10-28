package fr.lernejo.umlgrapher;

public class UmlGraph {
    final Class  maClass;

    public UmlGraph(Class maClass) {
        this.maClass = maClass;
    }
    public final String as(GraphType graphType) {
        String res = "";
        if(graphType==GraphType.Mermaid) {
            res = "" + "classDiagram\n" +
                this.maClass.getClass().getSimpleName().toLowerCase() + " " +  this.maClass.getSimpleName() + " {\n" +
                "    <<interface>>\n" +
                "}\n" +
                "";
        }
        return res;
    }
}
