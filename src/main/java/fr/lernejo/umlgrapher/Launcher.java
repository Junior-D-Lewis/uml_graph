package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

public class Launcher implements Callable<Integer> {
    @Option(names = {"-c", "--classes"}, description = "renseigner les classes d'où faire partir l'analyse", required = true)
    private final Class[] clazz = null;
    @Option(names = {"-g", "--graph-type"}, description = "sélectionner le type de graph que l'on souhaite en sortie ")

    @Override
    public Integer call() {
        UmlGraph graph = new UmlGraph(clazz);
        String res = graph.as(graphType);
        System.out.println(res);
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }
    private final GraphType graphType = GraphType.Mermaid;
}
