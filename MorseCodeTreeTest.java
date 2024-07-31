import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseCodeTreeTest {

    private MorseCodeTree morseCodeTree;

    @BeforeEach
    public void setUp() {
        morseCodeTree = new MorseCodeTree();
    }

    @Test
    public void testGetRoot() {
        TreeNode<String> root = morseCodeTree.getRoot();
        assertEquals("", root.getData(), "Root data should be an empty string");
    }

    @Test
    public void testSetRoot() {
        TreeNode<String> newRoot = new TreeNode<>("newRoot");
        morseCodeTree.setRoot(newRoot);
        assertEquals("newRoot", morseCodeTree.getRoot().getData(), "Root data should be 'newRoot'");
    }

    @Test
    public void testInsertAndFetch() {
        morseCodeTree.insert("....", "h");
        assertEquals("h", morseCodeTree.fetch("...."), "Inserted value should be 'h'");
    }

    @Test
    public void testFetch() {
        assertEquals("e", morseCodeTree.fetch("."), "Fetched value for '.' should be 'e'");
        assertEquals("t", morseCodeTree.fetch("-"), "Fetched value for '-' should be 't'");
    }

    @Test
    public void testAddNode() {
        morseCodeTree.addNode(morseCodeTree.getRoot(), "...-", "v");
        assertEquals("v", morseCodeTree.fetch("...-"), "Fetched value for '...-' should be 'v'");
    }

    @Test
    public void testFetchNode() {
        assertEquals("e", morseCodeTree.fetchNode(morseCodeTree.getRoot(), "."), "Fetched value for '.' should be 'e'");
        assertEquals("t", morseCodeTree.fetchNode(morseCodeTree.getRoot(), "-"), "Fetched value for '-' should be 't'");
    }

    @Test
    public void testBuildTree() {
        MorseCodeTree tree = new MorseCodeTree();
        tree.buildTree();
        assertEquals("e", tree.fetch("."), "After rebuilding, fetched value for '.' should be 'e'");
        assertEquals("t", tree.fetch("-"), "After rebuilding, fetched value for '-' should be 't'");
    }

    @Test
    public void testDelete() {
        try {
            morseCodeTree.delete("e");
        } catch (UnsupportedOperationException e) {
            assertEquals("class java.lang.UnsupportedOperationException", e.getClass().toString(), "Deleting from MorseCodeTree should throw UnsupportedOperationException");
        }
    }

    @Test
    public void testUpdate() {
        try {
            morseCodeTree.update();
        } catch (UnsupportedOperationException e) {
            assertEquals("class java.lang.UnsupportedOperationException", e.getClass().toString(), "Updating MorseCodeTree should throw UnsupportedOperationException");
        }
    }

    @Test
    public void testToArrayList() {
    	ArrayList<String> list = morseCodeTree.toArrayList();
        assertEquals(27, list.size(), "ArrayList should contain 26 elements for each letter in the alphabet and a empty space");

        String[] expectedOrder = {"h", "s", "v", "i", "f", "u", "e", "l", "r", "a", "p", "w", "j", "", "b", "d", "x", "n", "c", "k", "y", "t", "z", "g", "q", "m", "o"};
        for (int i = 0; i < expectedOrder.length; i++) {
            assertEquals(expectedOrder[i], list.get(i), "Element at index " + i + " should be '" + expectedOrder[i] + "'");
        }
    }

    @Test
    public void testLNRoutputTraversal() {
    	ArrayList<String> list = new ArrayList<>();
        morseCodeTree.LNRoutputTraversal(morseCodeTree.getRoot(), list);
        assertEquals(27, list.size(), "ArrayList should contain 26 elements and a space after traversal");

        String[] expectedOrder = {"h", "s", "v", "i", "f", "u", "e", "l", "r", "a", "p", "w", "j", "", "b", "d", "x", "n", "c", "k", "y", "t", "z", "g", "q", "m", "o"};
        for (int i = 0; i < expectedOrder.length; i++) {
            assertEquals(expectedOrder[i], list.get(i), "Element at index " + i + " should be '" + expectedOrder[i] + "'");
        }
    }
}
