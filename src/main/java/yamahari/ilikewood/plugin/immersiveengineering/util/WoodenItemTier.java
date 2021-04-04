package yamahari.ilikewood.plugin.immersiveengineering.util;

import com.google.common.collect.ImmutableMap;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import yamahari.ilikewood.registry.woodenitemtier.IWoodenItemTier;
import yamahari.ilikewood.registry.woodtype.IWoodType;
import yamahari.ilikewood.util.objecttype.tiered.WoodenTieredObjectType;
import yamahari.ilikewood.util.objecttype.tiered.WoodenTieredObjectTypes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class WoodenItemTier implements IWoodenItemTier {
    private static final Map<String, Float> DEFAULT_TIERED_ATTACK_SPEED =
        ImmutableMap.of(WoodenTieredObjectTypes.AXE.getName(),
            -3.2F,
            WoodenTieredObjectTypes.HOE.getName(),
            -3.0F,
            WoodenTieredObjectTypes.PICKAXE.getName(),
            -2.8F,
            WoodenTieredObjectTypes.SHOVEL.getName(),
            -3.0F,
            WoodenTieredObjectTypes.SWORD.getName(),
            -2.4F);

    private static final Map<String, Float> DEFAULT_TIERED_ATTACK_DAMAGE =
        ImmutableMap.of(WoodenTieredObjectTypes.AXE.getName(),
            6.0F,
            WoodenTieredObjectTypes.HOE.getName(),
            0.0F,
            WoodenTieredObjectTypes.PICKAXE.getName(),
            1.0F,
            WoodenTieredObjectTypes.SHOVEL.getName(),
            1.5F,
            WoodenTieredObjectTypes.SWORD.getName(),
            3.0F);

    private final IWoodType woodType;
    private final String name;
    private final LazyValue<Ingredient> repairMaterial;
    private final Map<WoodenTieredObjectType, Properties> properties;

    public WoodenItemTier(final IWoodType woodType, final String name, final Supplier<Ingredient> repairMaterial) {
        this.woodType = woodType;
        this.name = name;
        this.repairMaterial = new LazyValue<>(repairMaterial);

        final Map<WoodenTieredObjectType, Properties> properties = new HashMap<>();
        WoodenTieredObjectTypes.get().forEach(tieredObjectType -> {
            final String type = tieredObjectType.getName();
            properties.put(tieredObjectType,
                new WoodenItemTier.Properties(DEFAULT_TIERED_ATTACK_SPEED.get(type),
                    DEFAULT_TIERED_ATTACK_DAMAGE.get(type),
                    200));
        });
        this.properties = Collections.unmodifiableMap(properties);
    }

    @Override
    public IWoodType getWoodType() {
        return this.woodType;
    }

    @Override
    public String getModId() {
        return Constants.IE_MOD_ID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isWood() {
        return true;
    }

    @Override
    public int getHarvestLevel() {
        return 0;
    }

    @Override
    public int getMaxUses() {
        return 59;
    }

    @Override
    public float getEfficiency() {
        return 2.0F;
    }

    @Override
    public float getAttackDamage() {
        return 0.0F;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }

    @Override
    public Properties getProperties(final WoodenTieredObjectType woodenTieredObjectType) {
        return properties.get(woodenTieredObjectType);
    }
}
