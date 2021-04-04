package yamahari.ilikewood.plugin.immersiveengineering.util;

import org.apache.commons.lang3.StringUtils;

public final class Util {
    private Util() {
    }

    public static String toRegistryName(final String... elements) {
        return StringUtils.join(elements, "_");
    }

    public static String toPath(final String... elements) {
        return StringUtils.join(elements, "/");
    }
}
