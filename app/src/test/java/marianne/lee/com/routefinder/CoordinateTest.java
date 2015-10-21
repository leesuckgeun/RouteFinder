package marianne.lee.com.routefinder;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by leesuckgeun on 15/10/21.
 */
public class CoordinateTest {

    private final float DELTA = 0.0001f;

    @Test
    public void outline_rectangle_defined() {
        float[] bottomLeft = {0.f, 0.f};
        float[] topRight = {1.f, 1.f};
        float width = 1.f;
        assertArrayEquals(bottomLeft, BoundaryRectangle.BOTTOM_LEFT, DELTA);
        assertArrayEquals(topRight, BoundaryRectangle.TOP_RIGHT, DELTA);
        assertEquals(width, BoundaryRectangle.WIDTH, DELTA);
    }

    @Test
    public void inner_coords_divLvl0() {
        int divLvl = 0;
        InnerRects innerRects = new InnerRects(divLvl);
        innerRects.calculateCoords();

        float[] rectsCoords = innerRects.getInnerRectsCoords();
        int coordsLength = rectsCoords.length;

        assertEquals(divLvl, innerRects.getDivLvl());
        assertEquals(8, coordsLength);
        assertEquals(0.f, rectsCoords[0], DELTA);
        assertEquals(0.f, rectsCoords[1], DELTA);

        assertEquals(1.f, rectsCoords[2], DELTA);
        assertEquals(0.f, rectsCoords[3], DELTA);

        assertEquals(0.f, rectsCoords[4], DELTA);
        assertEquals(1.f, rectsCoords[5], DELTA);

        assertEquals(1, rectsCoords[coordsLength - 2], DELTA);
        assertEquals(1, rectsCoords[coordsLength - 1], DELTA);
    }

    @Test
    public void inner_coords_divLvl1() {
        int divLvl = 1;
        InnerRects innerRects = new InnerRects(divLvl);
        innerRects.calculateCoords();

        float[] rectsCoords = innerRects.getInnerRectsCoords();
        int coordsLength = rectsCoords.length;

        assertEquals(divLvl, innerRects.getDivLvl());
        assertEquals(18, coordsLength);
        assertEquals(0.f, rectsCoords[0], DELTA);
        assertEquals(0.f, rectsCoords[1], DELTA);

        assertEquals(0.5f, rectsCoords[2], DELTA);
        assertEquals(0.f, rectsCoords[3], DELTA);

        assertEquals(1.f, rectsCoords[4], DELTA);
        assertEquals(0.f, rectsCoords[5], DELTA);

        assertEquals(0.f, rectsCoords[6], DELTA);
        assertEquals(0.5f, rectsCoords[7], DELTA);

        assertEquals(0.5f, rectsCoords[8], DELTA);
        assertEquals(0.5f, rectsCoords[9], DELTA);

        assertEquals(1.f, rectsCoords[10], DELTA);
        assertEquals(0.5f, rectsCoords[11], DELTA);

        assertEquals(0.f, rectsCoords[12], DELTA);
        assertEquals(1.f, rectsCoords[13], DELTA);

        assertEquals(0.5f, rectsCoords[14], DELTA);
        assertEquals(1.f, rectsCoords[15], DELTA);

        assertEquals(1, rectsCoords[coordsLength - 2], DELTA);
        assertEquals(1, rectsCoords[coordsLength - 1], DELTA);
    }
}