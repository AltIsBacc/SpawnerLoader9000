package com.thatmg393.spawnerloader.block.impl;

import com.thatmg393.spawnerloader.SpawnerLoader9000;
import com.thatmg393.spawnerloader.block.base.BlockExt;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class SpawnerLoaderBlock extends BlockExt implements PolymerTexturedBlock {
    public static final Identifier BLOCK_ID = Identifier.of(SpawnerLoader9000.MOD_ID, "spawner_loader_block");

	private PolymerBlockModel polymerBlockModel = PolymerBlockModel.of(BLOCK_ID, 0, 1);

	public SpawnerLoaderBlock() {
        super(AbstractBlock.Settings.copy(Blocks.BEACON)
		        .allowsSpawning((state, world, pos, type) -> false)
				.solid()
				.resistance(8)
				.hardness(8)
				.requiresTool()
				.sounds(BlockSoundGroup.ANVIL)
				.luminance((state) -> 0));
    }

    @Override
    public Identifier getBlockID() {
        return BLOCK_ID;
    }
	
	@Override
	public BlockState getPolymerBlockState(BlockState state) {
		return PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, polymerBlockModel);
	}


	@Override
	public BlockState getPolymerBlockState(BlockState state, ServerPlayerEntity player) {
		return getPolymerBlockState(state);
	}

	@Override
	public boolean handleMiningOnServer(ItemStack tool, BlockState state, BlockPos pos, ServerPlayerEntity player) {
		return true;
	}

}
