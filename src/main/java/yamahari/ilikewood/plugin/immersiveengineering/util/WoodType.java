package yamahari.ilikewood.plugin.immersiveengineering.util;

import yamahari.ilikewood.registry.objecttype.WoodenBlockType;
import yamahari.ilikewood.registry.objecttype.WoodenItemType;
import yamahari.ilikewood.registry.objecttype.WoodenTieredItemType;
import yamahari.ilikewood.registry.woodtype.DefaultWoodType;
import yamahari.ilikewood.registry.woodtype.IWoodType;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class WoodType implements IWoodType {
    private static final Set<WoodenBlockType> BLOCK_TYPES = createBlockTypesSet();
    private final String name;

    public WoodType(final String name) {
        this.name = name;
    }

    private static Set<WoodenBlockType> createBlockTypesSet() {
        final Set<WoodenBlockType> blockTypes = new HashSet<>();

        blockTypes.add(WoodenBlockType.PANELS);
        blockTypes.add(WoodenBlockType.PANELS_STAIRS);
        blockTypes.add(WoodenBlockType.PANELS_SLAB);
        blockTypes.add(WoodenBlockType.BARREL);
        blockTypes.add(WoodenBlockType.WHITE_BED);
        blockTypes.add(WoodenBlockType.ORANGE_BED);
        blockTypes.add(WoodenBlockType.MAGENTA_BED);
        blockTypes.add(WoodenBlockType.LIGHT_BLUE_BED);
        blockTypes.add(WoodenBlockType.YELLOW_BED);
        blockTypes.add(WoodenBlockType.LIME_BED);
        blockTypes.add(WoodenBlockType.PINK_BED);
        blockTypes.add(WoodenBlockType.GRAY_BED);
        blockTypes.add(WoodenBlockType.LIGHT_GRAY_BED);
        blockTypes.add(WoodenBlockType.CYAN_BED);
        blockTypes.add(WoodenBlockType.PURPLE_BED);
        blockTypes.add(WoodenBlockType.BLUE_BED);
        blockTypes.add(WoodenBlockType.BROWN_BED);
        blockTypes.add(WoodenBlockType.GREEN_BED);
        blockTypes.add(WoodenBlockType.RED_BED);
        blockTypes.add(WoodenBlockType.BLACK_BED);
        blockTypes.add(WoodenBlockType.BOOKSHELF);
        blockTypes.add(WoodenBlockType.COMPOSTER);
        blockTypes.add(WoodenBlockType.CRAFTING_TABLE);
        blockTypes.add(WoodenBlockType.CHEST);
        blockTypes.add(WoodenBlockType.LECTERN);
        blockTypes.add(WoodenBlockType.LADDER);
        blockTypes.add(WoodenBlockType.SCAFFOLDING);
        blockTypes.add(WoodenBlockType.SOUL_TORCH);
        blockTypes.add(WoodenBlockType.TORCH);
        blockTypes.add(WoodenBlockType.WALL_TORCH);
        blockTypes.add(WoodenBlockType.WALL_SOUL_TORCH);

        return Collections.unmodifiableSet(blockTypes);
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
    public Properties getProperties(final WoodenBlockType woodenBlockType) {
        return DefaultWoodType.DEFAULT_BLOCK_PROPERTIES.get(woodenBlockType);
    }

    @Override
    public Properties getProperties(final WoodenItemType woodenItemType) {
        return DefaultWoodType.DEFAULT_ITEM_PROPERTIES.get(woodenItemType);
    }

    @Override
    public Set<WoodenBlockType> getBlockTypes() {
        return BLOCK_TYPES;
    }

    @Override
    public Set<WoodenItemType> getItemTypes() {
        return DefaultWoodType.DEFAULT_ITEM_TYPES;
    }

    @Override
    public Set<WoodenTieredItemType> getTieredItemTypes() {
        return DefaultWoodType.DEFAULT_TIERED_ITEM_TYPES;
    }

    @Override
    public Set<WoodenBlockType> getBuiltinBlockTypes() {
        return DefaultWoodType.DEFAULT_BUILTIN_BLOCK_TYPES;
    }

    @Override
    public Set<WoodenItemType> getBuiltinItemTypes() {
        return DefaultWoodType.DEFAULT_BUILTIN_ITEM_TYPES;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final WoodType woodType = (WoodType) o;

        return name.equals(woodType.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
