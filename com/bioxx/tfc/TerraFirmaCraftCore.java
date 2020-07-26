/*    */ package com.bioxx.tfc;
/*    */ 
/*    */ import com.google.common.eventbus.EventBus;
/*    */ import cpw.mods.fml.common.DummyModContainer;
/*    */ import cpw.mods.fml.common.LoadController;
/*    */ import cpw.mods.fml.common.Mod.EventHandler;
/*    */ import cpw.mods.fml.common.Mod.Instance;
/*    */ import cpw.mods.fml.common.ModMetadata;
/*    */ import cpw.mods.fml.common.SidedProxy;
/*    */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLServerStartingEvent;
/*    */ import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MCVersion("1.7.10")
/*    */ public class TerraFirmaCraftCore
/*    */   extends DummyModContainer
/*    */ {
/*    */   @Instance("tfc_coremod")
/*    */   public static TerraFirmaCraftCore instance;
/*    */   @SidedProxy(clientSide = "com.bioxx.tfc.ClientProxy", serverSide = "com.bioxx.tfc.CommonProxy")
/*    */   public static CommonProxy proxy;
/*    */   
/*    */   public TerraFirmaCraftCore() {
/* 34 */     super(new ModMetadata());
/* 35 */     ModMetadata meta = getMetadata();
/* 36 */     meta.modId = "tfc_coremod";
/* 37 */     meta.name = "TFC[coremod]";
/* 38 */     meta.version = "0.79.37TFR";
/* 39 */     meta.credits = "";
/* 40 */     meta.authorList = Arrays.asList(new String[] { "Bioxx", "Dunkleosteus" });
/* 41 */     meta.description = "";
/* 42 */     meta.url = "www.terrafirmacraft.com";
/* 43 */     meta.updateUrl = "";
/* 44 */     meta.screenshots = new String[0];
/* 45 */     meta.logoFile = "";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean registerBus(EventBus bus, LoadController controller) {
/* 50 */     bus.register(this);
/* 51 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void preInit(FMLPreInitializationEvent event) {
/* 57 */     instance = this;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void initialize(FMLInitializationEvent evt) {}
/*    */   
/*    */   @EventHandler
/*    */   public void modsLoaded(FMLPostInitializationEvent evt) {}
/*    */   
/*    */   @EventHandler
/*    */   public void serverStarting(FMLServerStartingEvent evt) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TerraFirmaCraftCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */