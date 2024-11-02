package implementations;

import interfaces.AbstractTree;

import java.util.*;
import java.util.stream.Collectors;

public class Tree<E> implements AbstractTree<E> {

    private E key;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E key) { // Tree<E>... children
        this.key = key;
        this.children = new ArrayList<>();
//        this.children.addAll(Arrays.asList(children));
//        for (int i = 0; i < children.length; i++) {
//            children[i].setParent(this);
//        }
    }

    public Tree() {
        this.children = new ArrayList<>();
    }

    @Override
    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(Tree<E> child) {
        this.children.add(child);
    }

    @Override
    public Tree<E> getParent() {
        return this.parent;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public String getAsString() {
        StringBuilder builder = new StringBuilder();

        traverseTreeWithRecursionWithIndent(builder, 0, this);

        return builder.toString().trim();
    }

    public String traverseWithBFS() {
        StringBuilder builder = new StringBuilder();

        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.offer(this);

        int indent = 0;

        while (!queue.isEmpty()) {
            Tree<E> tree = queue.poll();

            if (tree.getParent() != null && tree.getParent().getKey().equals(this.getKey())) {
                indent = 2;
            } else if (tree.children.size() == 0) {
                indent = 4;
            }

            builder.append(getPadding(indent))
                    .append(tree.getKey())
                    .append(System.lineSeparator());

            for (Tree<E> child : tree.children) {
                queue.offer(child);
            }
        }

        return builder.toString().trim();
    }

    public List<Tree<E>> traverseWithBFSGetAllNodes() {
        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.offer(this);

        int indent = 0;

        List<Tree<E>> allNodes = new ArrayList<>();

        while (!queue.isEmpty()) {
            Tree<E> tree = queue.poll();
            allNodes.add(tree);

            for (Tree<E> child : tree.children) {
                queue.offer(child);
            }
        }

        return allNodes;
    }

    private void traverseTreeWithRecursionWithIndent(StringBuilder builder, int indent, Tree<E> tree) {

        builder
                .append(this.getPadding(indent))
                .append(tree.getKey())
                .append(System.lineSeparator());

        for (Tree<E> child : tree.children) {
            traverseTreeWithRecursionWithIndent(builder, indent + 2, child);
        }
    }

    private void traverseTreeWithRecursionWithIndent(List<Tree<E>> collection, Tree<E> tree) {
        collection.add(tree);

        for (Tree<E> child : tree.children) {
            traverseTreeWithRecursionWithIndent(collection ,child);
        }
    }

    private String getPadding(int size) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            builder.append(" ");
        }

        return builder.toString();
    }

    @Override
    public List<E> getLeafKeys() {
        return traverseWithBFSGetAllNodes()
                .stream()
                .filter(tree -> tree.children.isEmpty())
                .map(Tree::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<E> getMiddleKeys() {
         List<Tree<E>> allNodes = new ArrayList<>();
         this.traverseTreeWithRecursionWithIndent(allNodes, this);

        return allNodes.stream()
                .filter(tree -> tree.parent != null && tree.children.size() > 0)
                .map(Tree::getKey)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        List<Tree<E>> trees = traverseWithBFSGetAllNodes();

        int maxPath = 0;

        Tree<E> deepestLeftMostNode = null;

        for (Tree<E> tree : trees) {
            if (tree.isLeaf()) {
                int currentPath = getStepFromLeafToRoot(tree);
                if (currentPath > maxPath) {
                    maxPath = currentPath;
                    deepestLeftMostNode = tree;
                }
            }
        }
        return deepestLeftMostNode;
    }

    public Tree<E> getDeepestLeftmostNodeWithDFS() {
        List<Tree<E>> deepestLeftMostNode = new ArrayList<>();
        int maxPath[] = new int[1];

        deepestLeftMostNode.add(new Tree<E>());
        int max = 0;

        findDeepestNodeDFS(deepestLeftMostNode, maxPath, max, this);

         return deepestLeftMostNode.get(0);
    }

    private void findDeepestNodeDFS(List<Tree<E>> deepestLeftMostNode, int[] maxPath, int max, Tree<E> tree) {

        if (max > maxPath[0]) {
            maxPath[0] = max;
            deepestLeftMostNode.set(0, tree);
        }

        for (Tree<E> child : tree.children) {
            findDeepestNodeDFS(deepestLeftMostNode, maxPath, max + 1, child);
        }
    }

    private int getStepFromLeafToRoot(Tree<E> tree) {
        int counter = 0;
        Tree<E> current = tree;

        while (current.parent != null) {
            counter++;
            current = current.parent;
        }

        return counter;
    }

    private boolean isLeaf() {
            return this.parent != null && this.children.isEmpty();
    }

    @Override
    public List<E> getLongestPath() {
        Tree<E> deepestLeftmostNode = getDeepestLeftmostNode();


        return reversedList(deepestLeftmostNode);
    }

    private List<E> reversedList(Tree<E> tree) {
        List<E> list = new ArrayList<>();

        while (tree.parent != null) {
            list.add(tree.key);
            tree = tree.parent;
        }

        list.add(tree.key);
        Collections.reverse(list);

        return list;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        return null;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        return null;
    }
}



