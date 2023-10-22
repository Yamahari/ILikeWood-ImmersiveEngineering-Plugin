package yamahari.ilikewood.plugin.immersiveengineering.util;

import yamahari.ilikewood.registry.objecttype.WoodenBlockType;
import yamahari.ilikewood.registry.objecttype.WoodenEntityType;
import yamahari.ilikewood.registry.objecttype.WoodenItemType;
import yamahari.ilikewood.registry.objecttype.WoodenTieredItemType;
import yamahari.ilikewood.registry.woodtype.DefaultWoodType;
import yamahari.ilikewood.registry.woodtype.IWoodType;

import java.util.Set;

public final class WoodType implements IWoodType {
    private static final Set<WoodenBlockType> BLOCK_TYPES = createBlockTypesSet();

    private static final Set<WoodenEntityType> ENTITY_TYPES = createEntityTypesSet();
    private final String name;
    private final IWoodType.Colors colors;

    public WoodType(final String name, final IWoodType.Colors colors) {
        this.name = name;
        this.colors = colors;
    }

    private static Set<WoodenBlockType> createBlockTypesSet() {
        return Set.of(WoodenBlockType.PANELS,
            WoodenBlockType.PANELS_STAIRS,
            WoodenBlockType.PANELS_SLAB,
            WoodenBlockType.BARREL,
            WoodenBlockType.WHITE_BED,
            WoodenBlockType.ORANGE_BED,
            WoodenBlockType.MAGENTA_BED,
            WoodenBlockType.LIGHT_BLUE_BED,
            WoodenBlockType.YELLOW_BED,
            WoodenBlockType.LIME_BED,
            WoodenBlockType.PINK_BED,
            WoodenBlockType.GRAY_BED,
            WoodenBlockType.LIGHT_GRAY_BED,
            WoodenBlockType.CYAN_BED,
            WoodenBlockType.PURPLE_BED,
            WoodenBlockType.BLUE_BED,
            WoodenBlockType.BROWN_BED,
            WoodenBlockType.GREEN_BED,
            WoodenBlockType.RED_BED,
            WoodenBlockType.BLACK_BED,
            WoodenBlockType.BOOKSHELF,
            WoodenBlockType.COMPOSTER,
            WoodenBlockType.CRAFTING_TABLE,
            WoodenBlockType.CHEST,
            WoodenBlockType.LECTERN,
            WoodenBlockType.LADDER,
            WoodenBlockType.SCAFFOLDING,
            WoodenBlockType.SOUL_TORCH,
            WoodenBlockType.TORCH,
            WoodenBlockType.WALL_TORCH,
            WoodenBlockType.WALL_SOUL_TORCH,
            WoodenBlockType.CRATE);
    }

    private static Set<WoodenEntityType> createEntityTypesSet() {
        return Set.of(WoodenEntityType.PAINTING, WoodenEntityType.ITEM_FRAME);
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
    public Set<WoodenEntityType> getEntityTypes() {
        return ENTITY_TYPES;
    }

    @Override
    public Colors getColors() {
        return this.colors;
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
