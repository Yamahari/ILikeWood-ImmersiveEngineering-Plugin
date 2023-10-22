package yamahari.ilikewood.plugin.immersiveengineering;

import yamahari.ilikewood.plugin.immersiveengineering.util.Constants;
import yamahari.ilikewood.plugin.immersiveengineering.util.WoodType;
import yamahari.ilikewood.registry.woodtype.IWoodType;

import java.util.stream.Stream;

public final class ImmersiveEngineeringWoodTypes {
    public static final int[] TREATED_WOOD_COLORS = {
        color(59, 31, 18), color(66, 35, 20), color(69, 34, 24), color(75, 42, 27), color(85, 46, 30), color(89, 50, 32), color(91, 53, 36), color(95, 55, 38)};
    public static final IWoodType TREATED_WOOD = new WoodType(Constants.TREATED_WOOD, new IWoodType.Colors(TREATED_WOOD_COLORS));

    private static int color(int r, int g, int b) {
        return 255 << 24 | (b & 255) << 16 | (g & 255) << 8 | (r & 255);
    }

    private ImmersiveEngineeringWoodTypes() {
    }

    public static Stream<IWoodType> getAll() {
        return Stream.of(ImmersiveEngineeringWoodTypes.TREATED_WOOD);
    }
}
