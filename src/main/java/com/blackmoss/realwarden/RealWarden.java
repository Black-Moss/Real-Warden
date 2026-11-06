package com.blackmoss.realwarden;

import com.blackmoss.averylooongmodname.data.ModBlockLootSubProvider;
import com.blackmoss.averylooongmodname.data.ModModelProvider;
import com.blackmoss.averylooongmodname.data.ModRecipeProvider;
import com.blackmoss.averylooongmodname.data.lang.EnUsProvider;
import com.blackmoss.averylooongmodname.data.lang.ZhCnProvider;
import com.blackmoss.averylooongmodname.data.lang.ZhTwProvider;
import com.blackmoss.averylooongmodname.data.tag.ModBlockTagsProvider;
import com.blackmoss.averylooongmodname.data.tag.ModItemTagsProvider;
import com.blackmoss.averylooongmodname.registry.ALMNBlocks;
import com.mojang.logging.LogUtils;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

import java.util.List;
import java.util.Set;

@Mod(RealWarden.MODID)
public class RealWarden {
    public static final String MODID = "realwarden";
    public static final Logger LOGGER = LogUtils.getLogger();

    public RealWarden(IEventBus modEventBus, ModContainer modContainer) {
    }

    public static Identifier identifier(String path) {
        return Identifier.fromNamespaceAndPath(MODID, path);
    }
}
