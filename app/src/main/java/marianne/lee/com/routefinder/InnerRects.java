package marianne.lee.com.routefinder;

/**
 * Created by leesuckgeun on 15/10/22.
 */
/**
 * Created by leesuckgeun on 15/10/21.
 */
public class InnerRects {
    private final int divLvl;
    private float[] innerRectsCoords;
    private float dx;
    private float dy;
    private int nPointsInRow;
    private int nPointsInCol;
    private float[] startingPoint = BoundaryRectangle.BOTTOM_LEFT;
    private float[] endPoint = BoundaryRectangle.TOP_RIGHT;

    public InnerRects(int divLvl) {
        this.divLvl = divLvl;
    }

    public void calculateCoords() {
        nPointsInRow = getnPointsInRow();
        nPointsInCol = getnPointsInCol();
        int numOfPoint = calNumOfPointsNeed();
        innerRectsCoords = createCoordsArray(numOfPoint);
        fillCoords();
    }

    private int getnPointsInCol() {
        return divLvl + 2;
    }

    private int getnPointsInRow() {
        return divLvl + 2;
    }

    private int calNumOfPointsNeed() {
        return nPointsInRow * nPointsInRow;
    }

    private float[] createCoordsArray(int numOfPoint) {
        return new float[numOfPoint * 2];
    }

    private void fillCoords() {
        dx = calDx();
        dy = dx;
        for (int rowNum = 0; rowNum < nPointsInRow; rowNum++) {
            fillCoordsOfRow(rowNum);
        }
    }

    private float calDx() {
        return BoundaryRectangle.WIDTH / (divLvl + 1);
    }

    private void fillCoordsOfRow(int rowNum) {
        for (int colNum = 0; colNum < nPointsInCol; colNum++) {
            fillCoordsByGivenRowCol(rowNum, colNum);
        }
    }

    private void fillCoordsByGivenRowCol(int rowNum, int colNum) {
        float xInCol = calXInCol(colNum);
        float yInRow = calYInRow(rowNum);
        innerRectsCoords[rowNum * 2 *(nPointsInCol) + (2*colNum +0)] = xInCol;
        innerRectsCoords[rowNum * 2 *(nPointsInCol) + (2*colNum +1)] = yInRow;
    }

    private float calXInCol(int colNum) {
        return startingPoint[0] + colNum * dx;
    }

    private float calYInRow(int rowNum) {
        return startingPoint[1] + rowNum * dy;
    }

    public int getDivLvl() {
        return divLvl;
    }

    public float[] getInnerRectsCoords() {
        return innerRectsCoords;
    }
}