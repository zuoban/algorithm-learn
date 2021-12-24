package segmenttree;

@FunctionalInterface
public interface Merger<E> {
    E merge(E a, E b);
}
