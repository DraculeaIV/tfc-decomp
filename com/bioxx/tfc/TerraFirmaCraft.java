/*     */ package com.bioxx.tfc;
/*     */ import com.bioxx.tfc.Commands.CommandTime;
/*     */ import com.bioxx.tfc.Commands.DebugModeCommand;
/*     */ import com.bioxx.tfc.Commands.GetBioTempCommand;
/*     */ import com.bioxx.tfc.Commands.GetBodyTemp;
/*     */ import com.bioxx.tfc.Commands.GetRocksCommand;
/*     */ import com.bioxx.tfc.Core.Config.TFC_ConfigFiles;
/*     */ import com.bioxx.tfc.Core.ItemHeat;
/*     */ import com.bioxx.tfc.Core.TFC_Achievements;
/*     */ import com.bioxx.tfc.Food.TFCPotion;
/*     */ import com.bioxx.tfc.Handlers.AnvilCraftingHandler;
/*     */ import com.bioxx.tfc.Handlers.ChunkEventHandler;
/*     */ import com.bioxx.tfc.Handlers.CraftingHandler;
/*     */ import com.bioxx.tfc.Handlers.EntitySpawnHandler;
/*     */ import com.bioxx.tfc.Handlers.FoodCraftingHandler;
/*     */ import com.bioxx.tfc.Handlers.Network.PacketPipeline;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenFissure;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenForests;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenLooseRocks;
/*     */ import com.bioxx.tfc.WorldGen.TFCProvider;
/*     */ import com.bioxx.tfc.WorldGen.TFCWorldType;
/*     */ import com.bioxx.tfc.api.SkillsManager;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.client.event.ConfigChangedEvent;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.IFuelHandler;
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import cpw.mods.fml.common.Mod.EventHandler;
/*     */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLServerStartingEvent;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraftforge.common.DimensionManager;
/*     */ import net.minecraftforge.common.ForgeModContainer;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @Mod(modid = "terrafirmacraft", name = "TerraFirmaCraft", version = "0.79.37TFR", dependencies = "required-after:tfc_coremod", guiFactory = "com.bioxx.tfc.Core.Config.TFC_GuiFactory")
/*     */ public class TerraFirmaCraft {
/*  46 */   public static final Logger LOG = LogManager.getLogger("TerraFirmaCraft");
/*     */ 
/*     */   
/*     */   @Instance("terrafirmacraft")
/*     */   public static TerraFirmaCraft instance;
/*     */   
/*     */   @SidedProxy(clientSide = "com.bioxx.tfc.ClientProxy", serverSide = "com.bioxx.tfc.CommonProxy")
/*     */   public static CommonProxy proxy;
/*     */   
/*  55 */   public static final PacketPipeline PACKET_PIPELINE = new PacketPipeline();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void preInit(FMLPreInitializationEvent event) {
/*  64 */     TFC_ConfigFiles.preInit(event.getModConfigurationDirectory());
/*  65 */     TFC_ConfigFiles.reloadGeneral();
/*     */ 
/*     */     
/*  68 */     proxy.registerTickHandler();
/*     */     
/*  70 */     proxy.registerFluids();
/*     */     
/*  72 */     BlockSetup.loadBlocks();
/*  73 */     BlockSetup.registerBlocks();
/*  74 */     BlockSetup.setupFire();
/*     */ 
/*     */ 
/*     */     
/*  78 */     proxy.registerKeys();
/*     */     
/*  80 */     proxy.registerKeyBindingHandler();
/*     */     
/*  82 */     proxy.registerHandlers();
/*     */     
/*  84 */     proxy.registerTileEntities(true);
/*     */     
/*  86 */     proxy.registerSoundHandler();
/*     */     
/*  88 */     proxy.registerPlayerRenderEventHandler();
/*     */     
/*  90 */     SkillsManager.instance.registerSkill("skill.gensmith", 250);
/*  91 */     SkillsManager.instance.registerSkill("skill.toolsmith", 100);
/*  92 */     SkillsManager.instance.registerSkill("skill.armorsmith", 100);
/*  93 */     SkillsManager.instance.registerSkill("skill.weaponsmith", 100);
/*  94 */     SkillsManager.instance.registerSkill("skill.agriculture", 300);
/*  95 */     SkillsManager.instance.registerSkill("skill.cooking", 200);
/*  96 */     SkillsManager.instance.registerSkill("skill.prospecting", 1500);
/*  97 */     SkillsManager.instance.registerSkill("skill.butchering", 100);
/*     */ 
/*     */     
/* 100 */     ItemSetup.setup();
/*     */ 
/*     */     
/* 103 */     proxy.registerGuiHandler();
/*     */ 
/*     */ 
/*     */     
/* 107 */     GameRegistry.registerWorldGenerator((IWorldGenerator)(new WorldGenFissure(TFCBlocks.lava, 2, true, TFCOptions.lavaFissureRarity)).setUnderground(true, 20).setSeed(1), 0);
/* 108 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGenFissure(TFCBlocks.freshWaterStationary, 2, false, TFCOptions.waterFissureRarity), 0);
/*     */     
/* 110 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGenFissureCluster(), 1);
/* 111 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGenOre(), 2);
/* 112 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGenCaveDecor(), 3);
/* 113 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGenForests(), 4);
/* 114 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGenLooseRocks(), 5);
/* 115 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGenSoilPits(), 6);
/* 116 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGenLargeRock(), 7);
/* 117 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGenPlants(), 8);
/*     */     
/* 119 */     WorldType.field_77137_b = (WorldType)new TFCWorldType(0, "TFCDefault");
/* 120 */     WorldType.field_77138_c = (WorldType)new TFCWorldType(1, "TFCFlat");
/* 121 */     WorldType.field_77135_d = (WorldType)new TFCWorldType(2, "TFCLargeBiomes");
/* 122 */     WorldType.field_151360_e = (WorldType)new TFCWorldType(3, "TFCAmplified");
/*     */     
/* 124 */     DimensionManager.unregisterDimension(-1);
/* 125 */     DimensionManager.unregisterDimension(0);
/* 126 */     DimensionManager.unregisterDimension(1);
/*     */     
/* 128 */     DimensionManager.unregisterProviderType(-1);
/* 129 */     DimensionManager.unregisterProviderType(0);
/* 130 */     DimensionManager.unregisterProviderType(1);
/* 131 */     DimensionManager.registerProviderType(-1, TFCProviderHell.class, false);
/* 132 */     DimensionManager.registerProviderType(0, TFCProvider.class, true);
/* 133 */     DimensionManager.registerProviderType(1, TFCProvider.class, false);
/*     */     
/* 135 */     DimensionManager.registerDimension(-1, -1);
/* 136 */     DimensionManager.registerDimension(0, 0);
/* 137 */     DimensionManager.registerDimension(1, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void initialize(FMLInitializationEvent event) {
/* 144 */     PACKET_PIPELINE.initalise();
/*     */ 
/*     */     
/* 147 */     FMLCommonHandler.instance().bus().register(new PlayerTracker());
/*     */ 
/*     */     
/* 150 */     proxy.registerToolClasses();
/*     */ 
/*     */     
/* 153 */     TFC_Achievements.init();
/*     */ 
/*     */     
/* 156 */     FMLCommonHandler.instance().bus().register(new CraftingHandler());
/* 157 */     FMLCommonHandler.instance().bus().register(new FoodCraftingHandler());
/* 158 */     FMLCommonHandler.instance().bus().register(instance);
/*     */ 
/*     */     
/* 161 */     MinecraftForge.EVENT_BUS.register(new PlayerInteractHandler());
/*     */ 
/*     */     
/* 164 */     MinecraftForge.EVENT_BUS.register(new EntitySpawnHandler());
/*     */ 
/*     */     
/* 167 */     MinecraftForge.EVENT_BUS.register(new EntityDamageHandler());
/*     */ 
/*     */     
/* 170 */     MinecraftForge.EVENT_BUS.register(new ChatListenerTFC());
/*     */ 
/*     */     
/* 173 */     MinecraftForge.EVENT_BUS.register(new ChunkEventHandler());
/*     */ 
/*     */     
/* 176 */     MinecraftForge.EVENT_BUS.register(new EnteringChunkHandler());
/*     */ 
/*     */     
/* 179 */     MinecraftForge.EVENT_BUS.register(new AnvilCraftingHandler());
/*     */ 
/*     */     
/* 182 */     MinecraftForge.EVENT_BUS.register(new EntityLivingHandler());
/*     */ 
/*     */     
/* 185 */     proxy.registerRenderInformation();
/*     */     
/* 187 */     proxy.registerBiomeEventHandler();
/* 188 */     proxy.setupGuiIngameForge();
/*     */ 
/*     */     
/* 191 */     proxy.setupFluids();
/* 192 */     proxy.registerFluidIcons();
/*     */ 
/*     */     
/* 195 */     TFCPotion.setup();
/*     */ 
/*     */     
/* 198 */     TFC_OreDictionary.registerOreDict();
/* 199 */     Recipes.registerRecipes();
/*     */     
/* 201 */     ItemHeat.setupItemHeat();
/*     */     
/* 203 */     TFC_Climate.initCache();
/*     */ 
/*     */ 
/*     */     
/* 207 */     ItemSetup.registerFurnaceFuel();
/* 208 */     GameRegistry.registerFuelHandler((IFuelHandler)new TFCFuelHandler());
/*     */ 
/*     */     
/* 211 */     proxy.registerChiselModes();
/*     */ 
/*     */     
/* 214 */     proxy.registerWailaClasses();
/* 215 */     proxy.hideNEIItems();
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void postInit(FMLPostInitializationEvent evt) {
/* 221 */     PACKET_PIPELINE.postInitialise();
/*     */ 
/*     */     
/* 224 */     TFC_ConfigFiles.reloadOres();
/*     */     
/* 226 */     ForgeModContainer.zombieBabyChance = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void serverStarting(FMLServerStartingEvent evt) {
/* 232 */     evt.registerServerCommand((ICommand)new GetBioTempCommand());
/* 233 */     evt.registerServerCommand((ICommand)new GetTreesCommand());
/* 234 */     evt.registerServerCommand((ICommand)new GetRocksCommand());
/* 235 */     evt.registerServerCommand((ICommand)new GetSpawnProtectionCommand());
/* 236 */     evt.registerServerCommand((ICommand)new SetPlayerStatsCommand());
/* 237 */     evt.registerServerCommand((ICommand)new GetBodyTemp());
/* 238 */     evt.registerServerCommand((ICommand)new RemoveChunkCommand());
/* 239 */     evt.registerServerCommand((ICommand)new StripChunkCommand());
/* 240 */     evt.registerServerCommand((ICommand)new ClearChunkCommand());
/* 241 */     evt.registerServerCommand((ICommand)new GSPVisualCommand());
/* 242 */     evt.registerServerCommand((ICommand)new RemoveAreaCommand());
/* 243 */     evt.registerServerCommand((ICommand)new DebugModeCommand());
/* 244 */     evt.registerServerCommand((ICommand)new CommandTime());
/* 245 */     evt.registerServerCommand((ICommand)new GenCommand());
/* 246 */     evt.registerServerCommand((ICommand)new PrintImageMapCommand());
/* 247 */     evt.registerServerCommand((ICommand)new GiveSkillCommand());
/* 248 */     evt.registerServerCommand((ICommand)new CommandTransferTamed());
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
/* 254 */     if (eventArgs.modID.equals("terrafirmacraft")) TFC_ConfigFiles.reloadAll(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TerraFirmaCraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */