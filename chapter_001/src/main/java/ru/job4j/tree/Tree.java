package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

/**
 * Class for exploring tree data structure
 * @param <E>
 * @author Dmitrii Chizhov (dimachig@gmail.com)
 * @version 1.00
 * @since 19.12.21
 */

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    /*
    Root node
    */

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    /**
     * Method add() for adding a child to the parent node
     *
     * @param parent - parent node
     * @param child  - child node
     * @return - adding result
     */

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> p = findBy(parent);
        Optional<Node<E>> c = findBy(child);
        if (p.isPresent()) {
            if (c.isEmpty()) {
                Node<E> newChild = new Node<>(child);
                p.get().getChildren().add(newChild);
                rsl = true;
            }
        }
        return rsl;
    }

    /**
     * is Binary tree?
     *
     * @return result
     */

    public Optional<Node<E>> isBinary() {
        return findByPredicate(e -> e.children.size() > 2);
    }

    /**
     * The method findBy() implements search by value in the tree data structure.
     * @param value - input parameter
     * @return - result
     */

    @Override
    public Optional<Node<E>> findBy(E value) {
       return findByPredicate(x -> x.value.equals(value));
    }

    /**
     * The method findByPredicate() search for a value by a given function
     * @param condition - predicate
     * @return - result
     */

    public Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
