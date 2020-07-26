/*     */ package com.bioxx.tfc;
/*     */ 
/*     */ import codechicken.nei.api.API;
/*     */ import codechicken.nei.guihook.GuiContainerManager;
/*     */ import codechicken.nei.guihook.IContainerTooltipHandler;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.gui.inventory.GuiContainer;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NEIIntegration
/*     */ {
/*     */   public static void hideNEIItems() {
/*  29 */     GuiContainerManager.addTooltipHandler(new IContainerTooltipHandler()
/*     */         {
/*     */           
/*     */           public List<String> handleTooltip(GuiContainer gui, int mousex, int mousey, List<String> currenttip)
/*     */           {
/*  34 */             return currenttip;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public List<String> handleItemDisplayName(GuiContainer gui, ItemStack itemstack, List<String> currenttip) {
/*  40 */             return currenttip;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public List<String> handleItemTooltip(GuiContainer gui, ItemStack itemstack, int mousex, int mousey, List<String> currenttip) {
/*  46 */             if (gui instanceof com.bioxx.tfc.GUI.GuiLargeVessel || gui instanceof com.bioxx.tfc.GUI.GuiBarrel) {
/*     */               
/*  48 */               Slot slot = gui.func_146975_c(mousex, mousey);
/*  49 */               if (slot != null && !slot.func_111238_b()) currenttip.clear(); 
/*     */             } 
/*  51 */             return currenttip;
/*     */           }
/*     */         });
/*     */     
/*  55 */     if (TFCOptions.enableNEIHiding) {
/*     */       
/*  57 */       API.hideItem(new ItemStack(TFCBlocks.bloom));
/*     */       
/*  59 */       API.hideItem(new ItemStack(TFCBlocks.charcoal));
/*     */       
/*  61 */       API.hideItem(new ItemStack(TFCBlocks.crops));
/*  62 */       API.hideItem(new ItemStack(TFCBlocks.detailed));
/*  63 */       API.hideItem(new ItemStack(TFCBlocks.worldItem));
/*  64 */       for (Block door : TFCBlocks.doors)
/*     */       {
/*  66 */         API.hideItem(new ItemStack(door));
/*     */       }
/*  68 */       API.hideItem(new ItemStack(TFCBlocks.firepit));
/*  69 */       API.hideItem(new ItemStack(TFCItems.flatClay, 1, 32767));
/*  70 */       API.hideItem(new ItemStack(TFCItems.flatLeather));
/*  71 */       API.hideItem(new ItemStack(TFCItems.flatRock, 1, 32767));
/*  72 */       API.hideItem(new ItemStack(TFCBlocks.foodPrep));
/*  73 */       API.hideItem(new ItemStack(TFCBlocks.forge));
/*  74 */       API.hideItem(new ItemStack(TFCBlocks.fruitTreeLeaves, 1, 32767));
/*  75 */       API.hideItem(new ItemStack(TFCBlocks.fruitTreeLeaves2, 1, 32767));
/*  76 */       API.hideItem(new ItemStack(TFCBlocks.fruitTreeWood, 1, 32767));
/*     */       
/*  78 */       API.hideItem(new ItemStack(TFCBlocks.ingotPile));
/*  79 */       API.hideItem(new ItemStack(TFCBlocks.leatherRack));
/*  80 */       API.hideItem(new ItemStack(TFCBlocks.leaves, 1, 32767));
/*  81 */       API.hideItem(new ItemStack(TFCBlocks.leaves2, 1, 32767));
/*  82 */       API.hideItem(new ItemStack(TFCBlocks.logNatural, 1, 32767));
/*  83 */       API.hideItem(new ItemStack(TFCBlocks.logNatural2, 1, 32767));
/*  84 */       API.hideItem(new ItemStack(TFCBlocks.logPile));
/*  85 */       API.hideItem(new ItemStack(TFCBlocks.woodConstruct));
/*  86 */       API.hideItem(new ItemStack(TFCBlocks.metalSheet));
/*  87 */       API.hideItem(new ItemStack(TFCBlocks.molten));
/*  88 */       API.hideItem(new ItemStack(TFCBlocks.moss));
/*     */       
/*  90 */       API.hideItem(new ItemStack(TFCBlocks.ore));
/*  91 */       API.hideItem(new ItemStack(TFCBlocks.ore2));
/*  92 */       API.hideItem(new ItemStack(TFCBlocks.ore3));
/*  93 */       API.hideItem(new ItemStack(TFCBlocks.pottery));
/*     */       
/*  95 */       API.hideItem(new ItemStack(TFCBlocks.reeds));
/*  96 */       API.hideItem(new ItemStack(TFCItems.salad, 1, 32767));
/*  97 */       API.hideItem(new ItemStack(TFCItems.sandwich, 1, 32767));
/*  98 */       API.hideItem(new ItemStack(TFCBlocks.sluice));
/*  99 */       API.hideItem(new ItemStack(TFCBlocks.smoke));
/* 100 */       API.hideItem(new ItemStack(TFCBlocks.smokeRack));
/*     */       
/* 102 */       API.hideItem(new ItemStack(TFCBlocks.stoneSlabs));
/* 103 */       API.hideItem(new ItemStack(TFCBlocks.stoneStairs));
/* 104 */       API.hideItem(new ItemStack(TFCBlocks.stoneStalac));
/* 105 */       API.hideItem(new ItemStack(TFCBlocks.strawHideBed));
/* 106 */       API.hideItem(new ItemStack(TFCBlocks.sulfur));
/* 107 */       API.hideItem(new ItemStack(TFCBlocks.torchOff));
/* 108 */       API.hideItem(new ItemStack(TFCBlocks.waterPlant));
/* 109 */       API.hideItem(new ItemStack(TFCBlocks.woodHoriz, 1, 32767));
/* 110 */       API.hideItem(new ItemStack(TFCBlocks.woodHoriz2, 1, 32767));
/* 111 */       API.hideItem(new ItemStack(TFCBlocks.woodHoriz3, 1, 32767));
/* 112 */       API.hideItem(new ItemStack(TFCBlocks.woodHoriz4, 1, 32767));
/* 113 */       API.hideItem(new ItemStack(TFCBlocks.woodSupportH, 1, 32767));
/* 114 */       API.hideItem(new ItemStack(TFCBlocks.woodSupportH2, 1, 32767));
/* 115 */       API.hideItem(new ItemStack(TFCBlocks.woodVert, 1, 32767));
/* 116 */       API.hideItem(new ItemStack(TFCBlocks.woodVert2, 1, 32767));
/* 117 */       API.hideItem(new ItemStack(TFCBlocks.freshWater));
/* 118 */       API.hideItem(new ItemStack(TFCBlocks.freshWaterStationary));
/* 119 */       API.hideItem(new ItemStack(TFCBlocks.saltWater));
/* 120 */       API.hideItem(new ItemStack(TFCBlocks.saltWaterStationary));
/* 121 */       API.hideItem(new ItemStack(TFCBlocks.hotWater));
/* 122 */       API.hideItem(new ItemStack(TFCBlocks.hotWaterStationary));
/* 123 */       API.hideItem(new ItemStack(TFCBlocks.lava));
/* 124 */       API.hideItem(new ItemStack(TFCBlocks.lavaStationary));
/* 125 */       API.hideItem(new ItemStack(TFCBlocks.freshWater));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\NEIIntegration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */