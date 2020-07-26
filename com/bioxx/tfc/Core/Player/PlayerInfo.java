/*     */ package com.bioxx.tfc.Core.Player;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.Tools.ChiselManager;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerInfo
/*     */ {
/*     */   public String playerName;
/*     */   public UUID playerUUID;
/*     */   public byte chiselMode;
/*     */   public int hoeMode;
/*  22 */   public int lockX = -9999999;
/*  23 */   public int lockY = -9999999;
/*  24 */   public int lockZ = -9999999;
/*     */   
/*     */   public ItemStack specialCraftingType;
/*     */   
/*     */   public ItemStack specialCraftingTypeAlternate;
/*     */   private long lastChange;
/*  30 */   public short moldTransferTimer = 1000;
/*     */   
/*     */   public boolean guishowFoodRestoreAmount;
/*     */   
/*     */   public float guiFoodRestoreAmount;
/*     */   
/*     */   public boolean[] knappingInterface;
/*     */   public SkillStats tempSkills;
/*  38 */   public ItemStack[] tempEquipment = new ItemStack[TFC_Core.getExtraEquipInventorySize()];
/*     */ 
/*     */   
/*     */   public PlayerInfo(String name, UUID uuid) {
/*  42 */     this.playerName = name;
/*  43 */     this.playerUUID = uuid;
/*  44 */     this.chiselMode = 0;
/*  45 */     this.specialCraftingType = null;
/*  46 */     this.specialCraftingTypeAlternate = null;
/*  47 */     this.lastChange = 0L;
/*  48 */     this.hoeMode = 0;
/*  49 */     this.knappingInterface = new boolean[25];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void switchHoeMode(EntityPlayer player) {
/*  55 */     int MODE_NUTRIENT = 1;
/*     */     
/*  57 */     SkillStats.SkillRank agRank = TFC_Core.getSkillStats(player).getSkillRank("skill.agriculture");
/*     */ 
/*     */     
/*  60 */     if (this.lastChange + 3L < TFC_Time.getTotalTicks()) {
/*     */       
/*  62 */       boolean isMetalHoe = true;
/*     */       
/*  64 */       if (player.func_71045_bC() != null && (player
/*  65 */         .func_71045_bC().func_77973_b() == TFCItems.igInHoe || player
/*  66 */         .func_71045_bC().func_77973_b() == TFCItems.igExHoe || player
/*  67 */         .func_71045_bC().func_77973_b() == TFCItems.sedHoe || player
/*  68 */         .func_71045_bC().func_77973_b() == TFCItems.mMHoe))
/*     */       {
/*  70 */         isMetalHoe = false;
/*     */       }
/*     */       
/*  73 */       this.hoeMode = (this.hoeMode == 3) ? 0 : ++this.hoeMode;
/*  74 */       if (this.hoeMode == 1 && (!isMetalHoe || (isMetalHoe && agRank != SkillStats.SkillRank.Expert && agRank != SkillStats.SkillRank.Master))) {
/*  75 */         this.hoeMode++;
/*     */       }
/*  77 */       this.lastChange = TFC_Time.getTotalTicks();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void switchChiselMode() {
/*  83 */     if (this.lastChange + 3L < TFC_Time.getTotalTicks()) {
/*     */ 
/*     */ 
/*     */       
/*  87 */       if (this.chiselMode == ChiselManager.getInstance().getSize() - 1) {
/*     */         
/*  89 */         this.chiselMode = 0;
/*     */       }
/*     */       else {
/*     */         
/*  93 */         this.chiselMode = (byte)(this.chiselMode + 1);
/*     */       } 
/*  95 */       this.lastChange = TFC_Time.getTotalTicks();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setChiselMode(byte mode) {
/* 101 */     this.chiselMode = mode;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean lockMatches(int x, int y, int z) {
/* 106 */     return ((this.lockX == -9999999 || this.lockX == x) && (this.lockY == -9999999 || this.lockY == y) && (this.lockZ == -9999999 || this.lockZ == z));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Player\PlayerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */