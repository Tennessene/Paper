package org.bukkit.entity;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Locale;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.util.OldEnum;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A Frog.
 */
public interface Frog extends Animals {

    /**
     * Gets the tongue target of this frog.
     *
     * @return tongue target or null if not set
     */
    @Nullable
    Entity getTongueTarget();

    /**
     * Sets the tongue target of this frog.
     *
     * @param target tongue target or null to clear
     */
    void setTongueTarget(@Nullable Entity target);

    /**
     * Get the variant of this frog.
     *
     * @return frog variant
     */
    @NotNull
    Variant getVariant();

    /**
     * Set the variant of this frog.
     *
     * @param variant frog variant
     */
    void setVariant(@NotNull Variant variant);

    /**
     * Represents the variant of a frog - ie its color.
     */
    interface Variant extends OldEnum<Variant>, Keyed {

        // Paper start - Generated/FrogVariant
        // @GeneratedFrom 1.21
        Variant COLD = getVariant("cold");

        Variant TEMPERATE = getVariant("temperate");

        Variant WARM = getVariant("warm");
        // Paper end - Generated/FrogVariant

        @NotNull
        private static Variant getVariant(@NotNull String key) {
            NamespacedKey namespacedKey = NamespacedKey.minecraft(key);
            Variant variant = Registry.FROG_VARIANT.get(namespacedKey);

            Preconditions.checkNotNull(variant, "No frog variant found for %s. This is a bug.", namespacedKey);
            return variant;
        }

        /**
         * @param name of the frog variant.
         * @return the frog variant with the given name.
         * @deprecated only for backwards compatibility, use {@link Registry#get(NamespacedKey)} instead.
         */
        @NotNull
        @Deprecated(since = "1.21")
        static Variant valueOf(@NotNull String name) {
            Variant variant = Registry.FROG_VARIANT.get(NamespacedKey.fromString(name.toLowerCase(Locale.ROOT)));
            Preconditions.checkArgument(variant != null, "No frog variant found with the name %s", name);
            return variant;
        }

        /**
         * @return an array of all known frog variants.
         * @deprecated use {@link Registry#iterator()}.
         */
        @NotNull
        @Deprecated(since = "1.21")
        static Variant[] values() {
            return Lists.newArrayList(Registry.FROG_VARIANT).toArray(new Variant[0]);
        }
    }
}
