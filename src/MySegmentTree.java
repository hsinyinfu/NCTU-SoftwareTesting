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
        return tree;
    }
    public static void main(String[] args) {
        int[] data = { 1 };
        int[] tree = new int[ data.length*4 ];
        tree = buildTree( 0, 0, data.length-1, data, tree );
        System.out.print("Data: ");
        showArray( data );
        System.out.print("\nTree: ");
        showArray( tree );
        System.out.print("\n");
    }
}
