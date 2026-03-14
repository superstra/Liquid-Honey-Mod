package com.superstra.liquidhoney

import com.superstra.liquidhoney.block.ModBlocks
import com.superstra.liquidhoney.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object LiquidHoney : ModInitializer {
	val MOD_ID = "liquid-honey"
    val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Hello Fabric world!")

		ModItems.registerModItems()
		ModBlocks.registerModBlocks()
	}
}