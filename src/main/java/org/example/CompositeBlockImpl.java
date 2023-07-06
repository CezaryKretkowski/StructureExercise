package org.example;

import org.example.interfaces.Block;
import org.example.interfaces.CompositeBlock;

import java.util.List;

public class CompositeBlockImpl implements CompositeBlock {

    public CompositeBlockImpl(List<Block> blocks) {
        this.blocks = blocks;
    }
    List<Block> blocks;
    @Override
    public String getColor() {
        return blocks.stream().map(Block::getColor).toList().toString();
    }

    @Override
    public String getMaterial() {
        return  blocks.stream().map(Block::getMaterial).toList().toString();
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
