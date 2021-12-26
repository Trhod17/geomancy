package net.codersdownunder.gemmod.world.decorators;

import java.util.Random;
import java.util.stream.Stream;

import com.mojang.serialization.Codec;

import net.codersdownunder.gemmod.GemMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class RNGPlacement extends PlacementModifier {
	public static final Codec<RNGPlacement> CODEC;
	public static final RNGPlacement INSTANCE = new RNGPlacement();

	static {
		CODEC = Codec.unit(() -> {
			return INSTANCE;
		});
	}

	@Override
	public Stream<BlockPos> getPositions(PlacementContext context, Random random, BlockPos pos) {
		long a = random.nextLong() | 1L;
		long b = random.nextLong() | 1L;
		random.setSeed(((pos.getX() * a * 341873128712L + 12412146) * (pos.getZ() * b * 132897987541L + 5813717)) ^ 423487234);
		return Stream.of(pos);
	}

	@Override
	public PlacementModifierType<?> type() {
		return GemMod.RNG_DECORATOR;
	}
}