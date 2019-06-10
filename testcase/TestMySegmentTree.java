import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

public class TestMySegmentTree {

    @Test
    public void testBuildTree1() {
        int[] data = { 1 };
        int[] ans = { 1 };
        int[] tree = new int[1];
        tree = MySegmentTree.buildTree( 0, 0, data.length-1, data, tree );
        assertArrayEquals( ans, tree );
    }


}

