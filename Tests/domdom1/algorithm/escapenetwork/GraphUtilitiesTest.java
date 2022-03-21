package domdom1.algorithm.escapenetwork;

import domdom1.algorithm.io.Exceptions.LoopException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphUtilitiesTest {

    @Test
    @DisplayName("This test case checks if the hasLoop() method works correctly")
    void hasLoops() {
        final String graphWithLoops = "a1a;a1b;b1c";
        List<String> edges = GraphUtilities.createEdgeList(graphWithLoops);
        Assertions.assertEquals(List.of("a1a", "a1b", "b1c"), edges);
    }

}