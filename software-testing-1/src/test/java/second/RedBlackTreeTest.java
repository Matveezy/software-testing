package second;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.IllformedLocaleException;

import static org.junit.jupiter.api.Assertions.*;

public class RedBlackTreeTest {

    RedBlackTree redBlackTree;

    @BeforeEach
    void setUp() {
        redBlackTree = new RedBlackTree();
    }

    @Test
    void findRootNode() {
        redBlackTree.insertNode(2);
        Node node = redBlackTree.searchNode(2);
        int data = node.getData();
        assertEquals(2, data);
    }

    @Test
    void findRootNodeSpecialMethod() {
        fillTree();
        Node maybeRoot = redBlackTree.getRoot();
        assertEquals(3, maybeRoot.getData());
    }

    @Test
    void deleteNode() {
        redBlackTree.insertNode(1);
        redBlackTree.insertNode(2);
        redBlackTree.insertNode(3);
        redBlackTree.insertNode(4);
        redBlackTree.deleteNode(2);
        Node node = redBlackTree.searchNode(2);
        assertNull(node);
    }

    @Test
    void findMinimum() {
        fillTree();
        Node minimum = redBlackTree.findMinimum(redBlackTree.searchNode(3));
        assertEquals(1, minimum.getData());
    }

    @Test
    void nodeIsBlack() {
        fillTree();
        boolean isBlack = redBlackTree.isBlack(redBlackTree.searchNode(10));
        assertTrue(isBlack);
    }

    @Test
    void insertDuplicate() {
        redBlackTree.insertNode(3);
        assertThrows(IllegalArgumentException.class, () -> {
            redBlackTree.insertNode(3);
        });
    }

    @Test
    void nodeIsRed() {
        fillTree();
        boolean isRed = redBlackTree.isRed(redBlackTree.searchNode(4));
        assertTrue(isRed);
    }

    @Test
    void siblingNode() {
        fillTree();
        Node node = redBlackTree.searchNode(75);
        Node maybeLeftSibling = redBlackTree.getSibling(node);
        Node node1 = redBlackTree.searchNode(2);
        Node maybeRightSibling = redBlackTree.getSibling(node1);
        assertEquals(4, maybeLeftSibling.getData());
        assertEquals(10, maybeRightSibling.getData());
    }

    @Test
    void findLeftUncle() {
        fillTree();
        Node nephew = redBlackTree.searchNode(4);
        Node maybeUncle = redBlackTree.getUncle(nephew.gerParent());
        assertEquals(2, maybeUncle.getData());
    }

    @Test
    void findRightUncle() {
        fillTree();
        Node nephew = redBlackTree.searchNode(1);
        Node maybeUncle = redBlackTree.getUncle(nephew.gerParent());
        assertEquals(10, maybeUncle.getData());
    }

    @Test
    void printTree() {
        fillTree();
        System.out.println(redBlackTree);
        assertTrue(true);
    }

    private void fillTree() {
        redBlackTree.insertNode(2);
        redBlackTree.insertNode(3);
        redBlackTree.insertNode(10);
        redBlackTree.insertNode(4);
        redBlackTree.insertNode(75);
        redBlackTree.insertNode(1);
    }

}
