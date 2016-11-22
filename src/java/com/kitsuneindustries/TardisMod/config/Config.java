package com.kitsuneindustries.TardisMod.config;

import org.apache.logging.log4j.Level;

import com.kitsuneindustries.TardisMod.TardisMod;
import com.kitsuneindustries.TardisMod.proxy.CommonProxy;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	private static final String CATEGORY_GENERAL = "general";

	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			// initGeneralConfig(cfg)
		} catch (Exception e) {
			TardisMod.logger.log(Level.ERROR, "Problem loading config file!", e);
		} finally {
			if (cfg.hasChanged()) {
				cfg.save();
			}
		}
	}
	
	private static void initGeneralConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration options");
	}
}
