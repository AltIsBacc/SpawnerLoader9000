package com.thatmg393.spawnerloader;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.Item;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Rarity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thatmg393.spawnerloader.block.impl.SpawnerLoaderBlock;
import com.thatmg393.spawnerloader.block.impl.blockitem.SpawnerLoaderBlockItem;
import com.thatmg393.spawnerloader.block.registry.BlockRegistry;

public class SpawnerLoader9000 implements ModInitializer {
	public static final String MOD_ID = "spawnerloader9000";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("what is this name T-T /\\");

		BlockRegistry.<SpawnerLoaderBlock, SpawnerLoaderBlockItem>register(
			new BlockRegistry.Entry<>(
				new SpawnerLoaderBlock(
					AbstractBlock.Settings.create()
						.allowsSpawning((state, world, pos, type) -> false)
						.hardness(30)
						.resistance(1)
						.solid()
						.sounds(BlockSoundGroup.ANVIL)
				),
				(block) -> {
					return new SpawnerLoaderBlockItem(
						block,
						new Item.Settings()
							.rarity(Rarity.UNCOMMON)
					);
				}
			)
		);
	}
}