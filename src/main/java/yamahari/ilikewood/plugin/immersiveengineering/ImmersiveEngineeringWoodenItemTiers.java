package yamahari.ilikewood.plugin.immersiveengineering;

import net.minecraft.item.crafting.Ingredient;
import yamahari.ilikewood.plugin.immersiveengineering.util.Constants;
import yamahari.ilikewood.plugin.immersiveengineering.util.WoodenItemTier;
import yamahari.ilikewood.registry.WoodenBlocks;
import yamahari.ilikewood.registry.woodenitemtier.IWoodenItemTier;
import yamahari.ilikewood.util.objecttype.WoodenObjectTypes;

public final class ImmersiveEngineeringWoodenItemTiers {
    public static final IWoodenItemTier TREATED_WOOD = new WoodenItemTier(ImmersiveEngineeringWoodTypes.TREATED_WOOD,
        Constants.TREATED_WOOD,
        () -> Ingredient.fromItems(WoodenBlocks.getBlock(WoodenObjectTypes.PANELS,
            ImmersiveEngineeringWoodTypes.TREATED_WOOD)));

    private ImmersiveEngineeringWoodenItemTiers() {
    }
}
