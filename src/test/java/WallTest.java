import org.example.BlockImpl;
import org.example.CompositeBlockImpl;
import org.example.Wall;
import org.example.interfaces.Block;
import org.example.interfaces.CompositeBlock;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class WallTest {

    private final List<Block> testData;

    public WallTest(){
        CompositeBlockImpl compositeBlock = new CompositeBlockImpl( Arrays.asList(
                new BlockImpl("Blue","wood"),
                new BlockImpl("Green","stone"),
                new BlockImpl("Red","brick")));
        testData = Arrays.asList(
                compositeBlock,
                new BlockImpl("Yellow","wood"),
                new BlockImpl("Green","stone"),
                new BlockImpl("Red","brick")
        );
    }


    @Test
    public void WallCountTest(){
        Wall wall = new Wall(testData);

        assertEquals("Expected Count ",wall.count(),4);

    }

    @Test
    public void WallFindByColorBlockTest(){
        Wall wall = new Wall(testData);
        Optional<Block> block = wall.findBlockByColor("Yellow");
        assertTrue(block.isPresent());
        assertEquals("Expected color: Yellow", block.get().getColor(),"Yellow");
    }

    @Test
    public void WallFindByColorCompositeBlockTest(){
        Wall wall = new Wall(testData);
        Optional<Block> block = wall.findBlockByColor("Red");
        assertTrue(block.isPresent());
        assertTrue(block.get() instanceof CompositeBlock);
        assertTrue("Expected color contains: Red", block.get().getColor().contains("Red"));
    }
    @Test
    public void WallFindByColorEmptyTest(){
        Wall wall = new Wall(testData);
        Optional<Block> block = wall.findBlockByColor("Grey");
        assertTrue(block.isEmpty());

    }
    @Test
    public void WallFindByMaterialTest(){
        Wall wall = new Wall(testData);
        var block = wall.findBlocksByMaterial("wood");
        assertEquals("Expected size: 2",block.size(),2);


    }
    @Test
    public void WallFindByMaterialEmptyTest(){
        Wall wall = new Wall(testData);
        var block = wall.findBlocksByMaterial("plastic");
        assertTrue("Expected empty list",block.isEmpty());


    }

}
