package superdas.practice.leetcode;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class Problem695_MaxAreaOfIslandTest {

    @Test
    public void testExample1() {
        assertThat(new Problem695_MaxAreaOfIsland().maxAreaOfIsland(
                new int[][]{
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                })).isEqualTo(6);
    }

    @Test
    public void testExample2() {
        assertThat(new Problem695_MaxAreaOfIsland().maxAreaOfIsland(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0}
                })).isEqualTo(0);
    }
}