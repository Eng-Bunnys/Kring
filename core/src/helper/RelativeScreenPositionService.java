package helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.GdxRuntimeException;

import static com.badlogic.gdx.Gdx.graphics;
import static com.badlogic.gdx.math.MathUtils.floor;

public class RelativeScreenPositionService {
    private static float AbsoluteScreenWidth = Gdx.graphics.getWidth();
    private static float AbsoluteScreenHeight = Gdx.graphics.getHeight();

    public static void UpdateAbsoluteResolution(float width, float height) {
        AbsoluteScreenWidth = width;
        AbsoluteScreenHeight = height;
    }

    /**
     * Takes relative width and height values and converts them to absolute
     * @author Abdelrahman Fathy
     * @throws GdxRuntimeException if either relative value is outside the [0-100] range
     * @param RelativeWidth Relative Width of a shape in the range [0-100]
     * @param RelativeHeight Relative Height of a shape in the range [0-100]
     * @return absolute value of both Width and Height
     */
    public static float[] getAbsoluteScreenMeasurements(float RelativeWidth, float RelativeHeight) throws GdxRuntimeException {
        if(RelativeWidth>1000 || RelativeHeight>1000){
            throw new GdxRuntimeException("Relative Width and Height must be less than 100");
        }
        if (RelativeWidth < 0 || RelativeHeight < 0) {
            throw new GdxRuntimeException("Relative Width and Height must be greater than 0");
        }
        float WidthRatio = AbsoluteScreenWidth/100;
        float HeightRatio = AbsoluteScreenHeight/100;
        return new float[]{(RelativeWidth * WidthRatio), (RelativeHeight * HeightRatio)};
    }

}
