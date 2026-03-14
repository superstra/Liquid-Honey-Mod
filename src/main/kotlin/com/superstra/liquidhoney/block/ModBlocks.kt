package com.superstra.liquidhoney.block

import com.superstra.liquidhoney.LiquidHoney
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.MapColor
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier

object ModBlocks {
    val CRYSTALLIZED_HONEY_BLOCK: Block = registerBlock("crystallized_honey_block", Block(
        AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).strength(0.6F).sounds(BlockSoundGroup.CORAL))
    )

    fun registerModBlocks() {
        LiquidHoney.LOGGER.info("Registering Mod Blocks for " + LiquidHoney.MOD_ID)

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ItemGroupEvents.ModifyEntries { entries ->
            entries.add(CRYSTALLIZED_HONEY_BLOCK)
        })
    }

    private fun registerBlockItem(name: String, block: Block) {
        Registry.register(Registries.ITEM, Identifier.of(LiquidHoney.MOD_ID, name),
            BlockItem(block, Item.Settings())
        )
    }

    private fun registerBlock(name: String, block: Block): Block {
        registerBlockItem(name, block)
        return Registry.register(Registries.BLOCK, Identifier.of(LiquidHoney.MOD_ID, name), block)
    }
}