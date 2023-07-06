package org.example;


import org.example.interfaces.Block;
import org.example.interfaces.CompositeBlock;
import org.example.interfaces.Structure;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
       return blocks.stream().filter(index->{
           if(index instanceof CompositeBlock compositeBlock){
               return compositeBlock.getBlocks().stream().anyMatch(p->p.getColor().equals(color));
           }else {
               return  index.getColor().equals(color);
           }
        }).findAny();
    }
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream().filter(index->{
            if(index instanceof CompositeBlock compositeBlock){
                return compositeBlock.getBlocks().stream().anyMatch(p->p.getMaterial().equals(material));
            }else {
                return  index.getMaterial().equals(material);
            }
        }).collect(Collectors.toList());
    }
    @Override
    public int count() {
        return blocks.size();
    }
}
