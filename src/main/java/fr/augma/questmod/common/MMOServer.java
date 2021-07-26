package fr.augma.questmod.common;

import fr.augma.questmod.MMOQuest;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.apache.logging.log4j.Level;

import java.io.File;
import java.io.IOException;

public class MMOServer extends MMOCommon {

    @Override
    public void preinit(File configFile) {

    }

    @Override
    public void init() {
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        File f = new File(server.getDataDirectory().getAbsolutePath() + "/world");

        File fQuest = new File(f.getAbsolutePath() + "/quest");
        if(!fQuest.exists()) {
            fQuest.mkdir();
            MMOQuest.getLogger().log(Level.INFO, "Création du dossier quest");
        }

        File fQPlayerData = new File(fQuest.getAbsolutePath() + "/playerdata");
        if(!fQPlayerData.exists()) {
            fQPlayerData.mkdir();
            MMOQuest.getLogger().log(Level.INFO, "Création du dossier quest/playerdata");
        }

        File fJsonPD = new File(fQPlayerData.getAbsolutePath() + "/test.json");
        if(!fJsonPD.exists()) {
            try {
                fJsonPD.createNewFile();
                MMOQuest.getLogger().log(Level.INFO, "Création du fichier quest/playerdata/test.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
