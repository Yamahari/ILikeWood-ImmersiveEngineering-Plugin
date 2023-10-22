package yamahari.ilikewood.plugin.immersiveengineering;

import net.minecraft.world.level.block.Block;
import yamahari.ilikewood.ILikeWoodPlugin;
import yamahari.ilikewood.IModPlugin;
import yamahari.ilikewood.plugin.immersiveengineering.util.Constants;
import yamahari.ilikewood.registry.IWoodenObjectRegistry;
import yamahari.ilikewood.registry.objecttype.WoodenBlockType;
import yamahari.ilikewood.registry.resource.IWoodenResourceRegistry;
import yamahari.ilikewood.registry.woodenitemtier.IWoodenItemTierRegistry;
import yamahari.ilikewood.registry.woodtype.IWoodTypeRegistry;

@ILikeWoodPlugin
public final class ImmersiveEngineeringPlugin implements IModPlugin {
    public static IWoodenObjectRegistry<Block, WoodenBlockType> BLOCK_REGISTRY;

    @Override
    public String getModId() {
        return Constants.IE_MOD_ID;
    }

    @Override
    public String getPluginModId() {
        return Constants.MOD_ID;
    }

    @Override
    public void registerWoodTypes(final IWoodTypeRegistry registry) {
        ImmersiveEngineeringWoodTypes.getAll().forEach(registry::register);
    }

    @Override
    public void registerWoodenItemTiers(final IWoodenItemTierRegistry registry) {
        registry.register(ImmersiveEngineeringWoodenItemTiers.TREATED_WOOD);
    }

    @Override
    public void registerWoodenResources(final IWoodenResourceRegistry registry) {
        ImmersiveEngineeringWoodTypes.getAll().forEach(woodType -> {
            registry.registerPlanksResource(woodType, ImmersiveEngineeringWoodenResources.PLANKS.get(woodType));
            registry.registerSlabResource(woodType, ImmersiveEngineeringWoodenResources.SLABS.get(woodType));
        });
    }

    @Override
    public void acceptBlockRegistry(final IWoodenObjectRegistry<Block, WoodenBlockType> registry) {
        BLOCK_REGISTRY = registry;
    }
}