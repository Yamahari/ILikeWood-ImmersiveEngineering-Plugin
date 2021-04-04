package yamahari.ilikewood.plugin.immersiveengineering.util;

import yamahari.ilikewood.registry.woodtype.IWoodType;
import yamahari.ilikewood.util.objecttype.WoodenObjectType;
import yamahari.ilikewood.util.objecttype.WoodenObjectTypes;
import yamahari.ilikewood.util.objecttype.tiered.WoodenTieredObjectType;
import yamahari.ilikewood.util.objecttype.tiered.WoodenTieredObjectTypes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class WoodType implements IWoodType {
    private static final Set<WoodenObjectType> OBJECT_TYPES = Collections.unmodifiableSet(WoodenObjectTypes
        .get()
        .filter(objectType -> !objectType.requiresLog() && !objectType.requiresStrippedLog())
        .collect(Collectors.toSet()));

    private static final Set<WoodenTieredObjectType> TIERED_OBJECT_TYPES =
        Collections.unmodifiableSet(WoodenTieredObjectTypes.get().collect(Collectors.toSet()));

    private final String name;
    private final Map<WoodenObjectType, Properties> properties;

    public WoodType(final String name) {
        this.name = name;

        final Map<WoodenObjectType, Properties> properties = new HashMap<>();

        Stream
            .of(WoodenObjectTypes.BARREL,
                WoodenObjectTypes.CHEST,
                WoodenObjectTypes.LECTERN,
                WoodenObjectTypes.PANELS,
                WoodenObjectTypes.BOOKSHELF,
                WoodenObjectTypes.COMPOSTER,
                WoodenObjectTypes.WALL,
                WoodenObjectTypes.LADDER,
                WoodenObjectTypes.POST,
                WoodenObjectTypes.STRIPPED_POST,
                WoodenObjectTypes.CRAFTING_TABLE,
                WoodenObjectTypes.STAIRS,
                WoodenObjectTypes.BOW,
                WoodenObjectTypes.CROSSBOW,
                WoodenObjectTypes.SAWMILL,
                WoodenObjectTypes.FISHING_ROD)
            .forEach(woodenObjectType -> properties.put(woodenObjectType, new Properties(300)));

        Stream
            .of(WoodenObjectTypes.STICK, WoodenObjectTypes.SCAFFOLDING)
            .forEach(woodenObjectType -> properties.put(woodenObjectType, new Properties(100)));

        Stream
            .of(WoodenObjectTypes.TORCH,
                WoodenObjectTypes.BED,
                WoodenObjectTypes.LOG_PILE,
                WoodenObjectTypes.SOUL_TORCH)
            .forEach(woodenObjectType -> properties.put(woodenObjectType, new Properties(400)));

        Stream
            .of(WoodenObjectTypes.SLAB)
            .forEach(woodenObjectType -> properties.put(woodenObjectType, new Properties(150)));

        this.properties = Collections.unmodifiableMap(properties);
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
    public Set<WoodenObjectType> getObjectTypes() {
        return OBJECT_TYPES;
    }

    @Override
    public Set<WoodenTieredObjectType> getTieredObjectTypes() {
        return TIERED_OBJECT_TYPES;
    }

    @Override
    public Properties getProperties(final WoodenObjectType woodenObjectType) {
        return this.properties.get(woodenObjectType);
    }
}
