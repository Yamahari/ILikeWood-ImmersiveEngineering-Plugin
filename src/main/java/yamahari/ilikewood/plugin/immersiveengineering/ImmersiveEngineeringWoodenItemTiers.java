package yamahari.ilikewood.plugin.immersiveengineering;

import net.minecraft.item.crafting.Ingredient;
import yamahari.ilikewood.plugin.immersiveengineering.util.Constants;
import yamahari.ilikewood.registry.objecttype.WoodenBlockType;
import yamahari.ilikewood.registry.woodenitemtier.DefaultWoodenItemTier;
import yamahari.ilikewood.registry.woodenitemtier.IWoodenItemTier;

public final class ImmersiveEngineeringWoodenItemTiers {
    public static final IWoodenItemTier TREATED_WOOD =
        new DefaultWoodenItemTier(ImmersiveEngineeringWoodTypes.TREATED_WOOD,
            Constants.MOD_ID,
            "treated_wood",
            () -> Ingredient.fromItems(ImmersiveEngineeringPlugin.BLOCK_REGISTRY.getObject(ImmersiveEngineeringWoodTypes.TREATED_WOOD,
                WoodenBlockType.PANELS)));

    private ImmersiveEngineeringWoodenItemTiers() {
    }
}
