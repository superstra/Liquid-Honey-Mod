package com.superstra.liquidhoney.item

import com.superstra.liquidhoney.LiquidHoney
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModItems {
    val HONEY_BUCKET: Item = registerItem("honey_bucket", Item(Item.Settings()))

    fun registerModItems() {
        LiquidHoney.LOGGER.info("Registering Mod Items for " + LiquidHoney.MOD_ID)

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ItemGroupEvents.ModifyEntries { entries ->
            entries.add(HONEY_BUCKET)
        })
    }

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier.of(LiquidHoney.MOD_ID, name), item)
    }

}