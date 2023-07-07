package org.example;


import org.example.interfaces.Block;
import org.example.interfaces.CompositeBlock;
import org.example.interfaces.Structure;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }



    @Override
    public Optional<Block> findBlockByColor(String color) {
       return blocks.stream().flatMap(index->{
            if(index instanceof CompositeBlock compositeBlock){
                return compositeBlock.getBlocks().stream();
            }else
                return Stream.of(index);
        }).toList().stream().filter(w -> w.getColor().equals(color)).findAny();
    }
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream().flatMap(index->{
            if(index instanceof CompositeBlock compositeBlock){
                return compositeBlock.getBlocks().stream();
            }else
                return Stream.of(index);
        }).toList().stream().filter(w -> w.getMaterial().equals(material)).toList();
    }
    @Override
    public int count() {
        return blocks.stream().flatMap(
                index-> {
                    if (index instanceof CompositeBlock compositeBlock) {
                        return compositeBlock.getBlocks().stream();
                    } else
                        return Stream.of(index);
                }).toList().size();
    }

}
