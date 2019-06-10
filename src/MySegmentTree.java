import java.util.Arrays;

public class MySegmentTree {
    public static void showArray( int[] data )
    {
        for( int i=0; i<data.length; ++i )
            System.out.print( data[i] + " " );
    }
    public static int[] buildTree( int idx, int left, int right, int[] data, int[] tree )
    {
        if( left == right )
        {
            tree[idx] = data[left];
            return tree;
        }

        int leftInd = idx*2 + 1; 
        int rightInd = idx*2 + 2;
        int mid = left + (right - left)/2;
        buildTree(leftInd, left, mid, data, tree);
        buildTree(rightInd, mid + 1, right, data, tree);
        tree[idx] = tree[ leftInd ] + tree[ rightInd ];
        return tree;
    }
    public static int rangeSum( int start, int end, int[] tree, int treeIdx, int left, int right )
    {
        int ans = 0;
        if( left == start && right == end )
        {
            ans = tree[ treeIdx ];
            return ans;
        }
        int leftIdx = treeIdx*2 + 1; 
        int rightIdx = treeIdx*2 + 2;
        int mid = left + (right - left)/2;

        if( end <= mid )
        {
            ans = rangeSum( start, end, tree, leftIdx, left, mid );
            return ans;
        }
        if( start >= mid+1 )
        {
            ans = rangeSum( start, end, tree, rightIdx, mid+1, right );
            return ans;
        }
        ans = rangeSum( start, mid, tree, leftIdx, left, mid );
        ans += rangeSum( mid+1, end, tree, rightIdx, mid+1, right );
        return ans;
    }
    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4 };
        int[] tree = new int[ data.length*4 ];
        tree = buildTree( 0, 0, data.length-1, data, tree );
        System.out.print("Data: ");
        showArray( data );
        System.out.print("\nTree: ");
        showArray( tree );
        System.out.print("\n");
        System.out.println( rangeSum( 0, 0, tree, 0, 0, data.length-1 ) );
        System.out.println( rangeSum( 0, 1, tree, 0, 0, data.length-1 ) );
        System.out.println( rangeSum( 0, 2, tree, 0, 0, data.length-1 ) );
        System.out.println( rangeSum( 0, 3, tree, 0, 0, data.length-1 ) );
        System.out.println( rangeSum( 1, 1, tree, 0, 0, data.length-1 ) );
        System.out.println( rangeSum( 1, 2, tree, 0, 0, data.length-1 ) );
        System.out.println( rangeSum( 1, 3, tree, 0, 0, data.length-1 ) );
        System.out.println( rangeSum( 2, 2, tree, 0, 0, data.length-1 ) );
        System.out.println( rangeSum( 2, 3, tree, 0, 0, data.length-1 ) );
        System.out.println( rangeSum( 3, 3, tree, 0, 0, data.length-1 ) );
    }
}
