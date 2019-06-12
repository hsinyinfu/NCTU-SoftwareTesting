import java.util.Arrays;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

public class TestMySegmentTree {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

	/* ************************
	 * Unittest for buildTree()
	 * ************************/

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

	/* ************************
	 * Unittest for rangeSum()
	 * ************************/
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

	/* ************************
	 * Predicate Coverage for rangeSum()
	 * @a = if( start < left || end < left || start > right || end > right )
	 * @b = if( left == start && right == end )
	 * @c = if( end <= mid )
	 * @d = if( start >= mid+1 )
	 * ************************/
	// a = T, b = F, c = F, d = F
	@Test
    public void preCovRangeSum1() throws Exception{
        thrown.expect( IllegalArgumentException.class );
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int result = MySegmentTree.rangeSum( -1, 4, tree, 0, 0, 3 );
    }
	// a = F, b = T, c = T, d = F
    @Test
    public void preCovRangeSum2() throws Exception{
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int ans = 2+3+4 ;
        int result = MySegmentTree.rangeSum( 1, 3, tree, 0, 0, 3 );
        assertEquals( ans, result );
    }
	// a = F, b = T, c = F, d = T
    @Test
    public void preCovRangeSum3() throws Exception{
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int ans = 1+2+3 ;
        int result = MySegmentTree.rangeSum( 0, 2, tree, 0, 0, 3 );
        assertEquals( ans, result );
    }

	/* ************************
	 * Clause Coverage for Predicate "a" in rangeSum()
	 * @e = (start < left)
	 * @f = (end < left)
	 * @g = (start > right)
	 * @h = (end > right)
	 * ************************/

	// e = T, f = T, g = F, h = F
	@Test
    public void clauCovRangeSum1() throws Exception{
        thrown.expect( IllegalArgumentException.class );
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int result = MySegmentTree.rangeSum( -2, -1, tree, 0, 0, 3 );
    }

	// e = F, f = F, g = T, h = T
	@Test
    public void clauCovRangeSum2() throws Exception{
        thrown.expect( IllegalArgumentException.class );
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int result = MySegmentTree.rangeSum( 4, 5, tree, 0, 0, 3 );
    }

	/* ************************
	 * Clause Coverage for Predicate "b" in rangeSum()
	 * @b = if( left == start && right == end )
	 * @i = (left == start)
	 * @j = (right == end)
	 * ************************/

	// i = T, j = T
    @Test
    public void clauCovRangeSum3() throws Exception{
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int ans = 1+2+3+4 ;
        int result = MySegmentTree.rangeSum( 0, 3, tree, 0, 0, 3 );
        assertEquals( ans, result );
    }

	// i = F, j = F
	@Test
    public void clauCovRangeSum4() throws Exception{
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int ans = 2+3 ;
        int result = MySegmentTree.rangeSum( 1, 2, tree, 0, 0, 3 );
        assertEquals( ans, result );
    }

	/* ************************
	 * Correlated Action Clause Coverage (CACC) for Predicate "a" in rangeSum()
	 * @a = if( start < left || end < left || start > right || end > right )
	 * @e = (start < left)
	 * @f = (end < left)
	 * @g = (start > right)
	 * @h = (end > right)
	 * ************************/

	// Major clause: e
	// e = T, f = g = h = F  =>  a = T
	@Test
    public void corActClauCovRangeSum1() throws Exception{
        thrown.expect( IllegalArgumentException.class );
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int result = MySegmentTree.rangeSum( -2, 2, tree, 0, 0, 3 );
    }

	// Major clause: f
	// f = T, e = g = h = F  =>  a = T
	@Test
    public void corActClauCovRangeSum2() throws Exception{
        thrown.expect( IllegalArgumentException.class );
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int result = MySegmentTree.rangeSum( 2, -2, tree, 0, 0, 3 );
    }

	// Major clause: g
	// g = T, e = f = h = F  =>  a = T
	@Test
    public void corActClauCovRangeSum3() throws Exception{
        thrown.expect( IllegalArgumentException.class );
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int result = MySegmentTree.rangeSum( 4, 2, tree, 0, 0, 3 );
    }

	// Major clause: h
	// h = T, e = f = g = F  =>  a = T
	@Test
    public void corActClauCovRangeSum4() throws Exception{
        thrown.expect( IllegalArgumentException.class );
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int result = MySegmentTree.rangeSum( 1, 4, tree, 0, 0, 3 );
    }

	// e = f = g = h = F  =>  a = F
	@Test
    public void corActClauCovRangeSum5() throws Exception{
        //int[] data = { 1, 2, 3, 4};
		int ans = 1+2+3;
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int result = MySegmentTree.rangeSum( 0, 2, tree, 0, 0, 3 );
    }

	/* ************************
	 * Correlated Active Clause Coverage (CACC) for Predicate "b" in rangeSum()
	 * @b = if( left == start && right == end )
	 * @i = (left == start)
	 * @j = (right == end)
	 * ************************/

	// Major clause: i
	// i = F, j = T  =>  b = F
	// i = T, j = T is tested in the predicate coverage
    @Test
    public void corActClauCovRangeSum6() throws Exception{
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int ans = 3+4 ;
        int result = MySegmentTree.rangeSum( 2, 3, tree, 0, 0, 3 );
        assertEquals( ans, result );
    }

	// Major clause: j
	// j = F, i = T  =>  b = F
	// j = T, i = T is tested in the predicate coverage
    @Test
    public void corActClauCovRangeSum7() throws Exception{
        //int[] data = { 1, 2, 3, 4};
        int[] tree = { 10, 3, 7, 1, 2, 3, 4 };
        int ans = 1+2 ;
        int result = MySegmentTree.rangeSum( 0, 1, tree, 0, 0, 3 );
        assertEquals( ans, result );
    }
}

