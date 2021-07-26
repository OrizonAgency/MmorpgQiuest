package fr.augma.questmod;

import fr.augma.questmod.common.MMOCommon;
import fr.augma.questmod.init.ItemInit;
import fr.augma.questmod.utils.MMORef;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = MMORef.MODID, name = MMORef.NAME, version = MMORef.VERSION)
public class MMOQuest {

    private static Logger logger;

    @Mod.Instance
    private static MMOQuest  INSTANCE;

    @SidedProxy(serverSide = MMORef.SERVER_PROXY)
    private static MMOCommon PROXY;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        INSTANCE = this;
        PROXY.preinit(event.getSuggestedConfigurationFile());
        ItemInit.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        PROXY.init();
    }

    public static Logger getLogger() {
        return logger;
    }

    public static MMOQuest getInstance() {
        return INSTANCE;
    }
}
