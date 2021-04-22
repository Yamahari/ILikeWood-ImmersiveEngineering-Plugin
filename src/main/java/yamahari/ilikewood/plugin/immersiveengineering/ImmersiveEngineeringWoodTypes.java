package yamahari.ilikewood.plugin.immersiveengineering;

import yamahari.ilikewood.plugin.immersiveengineering.util.Constants;
import yamahari.ilikewood.plugin.immersiveengineering.util.WoodType;
import yamahari.ilikewood.registry.woodtype.IWoodType;

import java.util.stream.Stream;

public final class ImmersiveEngineeringWoodTypes {
    public static final IWoodType TREATED_WOOD = new WoodType(Constants.TREATED_WOOD);

    private ImmersiveEngineeringWoodTypes() {
    }

    public static Stream<IWoodType> getAll() {
        return Stream.of(ImmersiveEngineeringWoodTypes.TREATED_WOOD);
    }
}
