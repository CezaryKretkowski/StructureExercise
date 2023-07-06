package org.example;

import org.example.interfaces.Block;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Block> blocks = Arrays.asList(
                new BlockImpl("Blue","Wood"),
                new BlockImpl("Green","stone"),
                new BlockImpl("Red","brick"));
        var compBlock= new CompositeBlockImpl(blocks);
        System .out.println(compBlock.getColor());
        List<Block> structure =  Arrays.asList(
                compBlock,
                new BlockImpl("Blue","Wood"),
                new BlockImpl("Green","stone"),
                new BlockImpl("Red","brick"));
        Wall wall=  new Wall(structure);
        var optional = wall.findBlocksByMaterial("stone");
        System.out.println(optional);
    }
}