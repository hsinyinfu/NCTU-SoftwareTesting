import java.util.Arrays;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

public class TestMySegmentTree {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

	// Predicate coverage for buildTree(): True
    @Test
    public void testBuildTree1() {
        int[] data = { 1 };
        int[] ans = { 1 };
        int[] tree = new int[1];
        tree = MySegmentTree.buildTree( 0, 0, data.length-1, data, tree );
        assertArrayEquals( ans, tree );
    }

	// Predicate coverage for buildTree(): False
    @Test
    public void testBuildTree2() {
        int[] data = { 1, 2 };
        int[] ans = { 3, 1, 2 };
        int[] tree = new int[3];
        tree = MySegmentTree.buildTree( 0, 0, data.length-1, data, tree );
        assertArrayEquals( ans, tree );
    }
    @Test
    public void testBuildTree3() {
        int[] data = { 1, 2, 3, 4 };
        int[] ans = { 10, 3, 7, 1, 2, 3, 4 };
        int[] tree = new int[7];
        tree = MySegmentTree.buildTree( 0, 0, data.length-1, data, tree );
        assertArrayEquals( ans, tree );
    }

    @Test
    public void testRangeSum1() throws Exception{
        int[] tree = { 1 };
        int ans = 1 ;
        int result = MySegmentTree.rangeSum( 0, 0, tree, 0, 0, 0 );
        assertEquals( ans, result );
    }
    @Test
    public void testRangeSum2() throws Exception{
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int ans = 10 ;
        int result = MySegmentTree.rangeSum( 0, 3, tree, 0, 0, 3 );
        assertEquals( ans, result );
    }
    @Test
    public void testRangeSum3() throws Exception{
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int ans = 1+2 ;
        int result = MySegmentTree.rangeSum( 0, 1, tree, 0, 0, 3 );
        assertEquals( ans, result );
    }
    @Test
    public void testRangeSum4() throws Exception{
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int ans = 3+4 ;
        int result = MySegmentTree.rangeSum( 2, 3, tree, 0, 0, 3 );
        assertEquals( ans, result );
    }
    @Test
    public void testRangeSum5() throws Exception{
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int ans = 2+3 ;
        int result = MySegmentTree.rangeSum( 1, 2, tree, 0, 0, 3 );
        assertEquals( ans, result );
    }
	@Test
    public void testRangeSum6() throws Exception{
        thrown.expect( IllegalArgumentException.class );
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int result = MySegmentTree.rangeSum( 0, 4, tree, 0, 0, 3 );
    }

}

