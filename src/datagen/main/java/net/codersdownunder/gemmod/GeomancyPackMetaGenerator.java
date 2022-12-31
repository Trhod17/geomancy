package net.codersdownunder.gemmod;

import com.google.common.collect.ImmutableMap;
import com.mojang.bridge.game.PackType;
import net.codersdownunder.gemmod.text.GeomancyLang;
import net.minecraft.DetectedVersion;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;

import static net.minecraft.server.packs.PackType.CLIENT_RESOURCES;
import static net.minecraft.server.packs.PackType.SERVER_DATA;

public class GeomancyPackMetaGenerator {
    public static PackMetadataGenerator create(final PackOutput output) {
        return new PackMetadataGenerator(output)
                .add(
                        PackMetadataSection.TYPE,
                        new PackMetadataSection(Component.translatable(GeomancyLang.PACK_DESCRIPTION_GEOMANCY.getTranslationKey()),
                                DetectedVersion.BUILT_IN.getPackVersion(PackType.RESOURCE),
                                ImmutableMap.<net.minecraft.server.packs.PackType, Integer>builder()
                                        .put(SERVER_DATA, DetectedVersion.BUILT_IN.getPackVersion(PackType.DATA))
                                        .put(CLIENT_RESOURCES, DetectedVersion.BUILT_IN.getPackVersion(PackType.RESOURCE))
                                        .build()
                        )
                );
    }
}
