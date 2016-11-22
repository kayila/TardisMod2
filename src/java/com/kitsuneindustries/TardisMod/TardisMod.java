package com.kitsuneindustries.TardisMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import com.kitsuneindustries.TardisMod.proxy.CommonProxy;

@Mod(modid=TardisMod.MODID, useMetadata=true)
public class TardisMod {

    public static final String MODID = "tardismod2";

    @SidedProxy(clientSide = "com.kitsuneindustries.TardisMod.proxy.ClientProxy", serverSide = "com.kitsuneindustries.TardisMod.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static TardisMod instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
        logger.log(Level.ALL, "STARTING MOD");
        System.out.println("STARTING MOD");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}