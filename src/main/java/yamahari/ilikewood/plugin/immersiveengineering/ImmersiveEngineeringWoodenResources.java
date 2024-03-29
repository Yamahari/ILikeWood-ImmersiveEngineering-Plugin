package yamahari.ilikewood.plugin.immersiveengineering;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.client.model.generators.ModelProvider;
import yamahari.ilikewood.plugin.immersiveengineering.util.Constants;
import yamahari.ilikewood.plugin.immersiveengineering.util.Util;
import yamahari.ilikewood.plugin.immersiveengineering.util.resources.WoodenPlanksResource;
import yamahari.ilikewood.plugin.immersiveengineering.util.resources.WoodenSlabResource;
import yamahari.ilikewood.registry.resource.resources.IWoodenPlanksResource;
import yamahari.ilikewood.registry.resource.resources.IWoodenSlabResource;
import yamahari.ilikewood.registry.woodtype.IWoodType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ImmersiveEngineeringWoodenResources {
    public static final Map<IWoodType, IWoodenPlanksResource> PLANKS;
    public static final Map<IWoodType, IWoodenSlabResource> SLABS;

    static {
        final Map<IWoodType, IWoodenPlanksResource> planks = new HashMap<>();
        final Map<IWoodType, IWoodenSlabResource> slabs = new HashMap<>();

        final ResourceLocation planksResource = new ResourceLocation(Constants.IE_MOD_ID, Util.toRegistryName(ImmersiveEngineeringWoodTypes.TREATED_WOOD.getName(), "horizontal"));

        final ResourceLocation slabResource = new ResourceLocation(Constants.IE_MOD_ID,
            Util.toRegistryName("slab", ImmersiveEngineeringWoodTypes.TREATED_WOOD.getName(), "horizontal"));

        final ResourceLocation planksTexture = new ResourceLocation(planksResource.getNamespace(),
            Util.toPath(ModelProvider.BLOCK_FOLDER, "wooden_decoration", Util.toRegistryName(ImmersiveEngineeringWoodTypes.TREATED_WOOD.getName(), "horizontal")));

        planks.put(ImmersiveEngineeringWoodTypes.TREATED_WOOD,
            new WoodenPlanksResource(planksTexture, planksResource, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.f, 5.f).instrument(NoteBlockInstrument.BASS)));

        slabs.put(ImmersiveEngineeringWoodTypes.TREATED_WOOD, new WoodenSlabResource(planksTexture, planksTexture, planksTexture, slabResource));

        PLANKS = Collections.unmodifiableMap(planks);
        SLABS = Collections.unmodifiableMap(slabs);
    }

    private ImmersiveEngineeringWoodenResources() {
    }
}
