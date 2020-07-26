/*    */ package com.bioxx.tfc.Core.Config;
/*    */ 
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import com.bioxx.tfc.api.TFCOptions;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.Collection;
/*    */ import net.minecraft.item.crafting.CraftingManager;
/*    */ import net.minecraft.item.crafting.IRecipe;
/*    */ import net.minecraftforge.common.config.Configuration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class SyncingOption
/*    */ {
/*    */   public final String name;
/*    */   public final Field field;
/*    */   public final boolean defaultValue;
/*    */   public final Configuration cfg;
/*    */   public final String cat;
/*    */   protected boolean ourConfigValue;
/*    */   protected boolean currentValue;
/*    */   
/*    */   public SyncingOption(String name, Class<?> clazz, Configuration cfg, String cat) throws NoSuchFieldException, IllegalAccessException {
/* 35 */     if (TFC_ConfigFiles.SYNCING_OPTION_MAP.containsKey(name)) throw new IllegalArgumentException("Duplicate key: " + name); 
/* 36 */     TFC_ConfigFiles.SYNCING_OPTION_MAP.put(name, this);
/* 37 */     this.name = name;
/* 38 */     this.field = clazz.getDeclaredField(name);
/* 39 */     this.cfg = cfg;
/* 40 */     this.cat = cat;
/* 41 */     this.defaultValue = this.field.getBoolean(null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void apply(boolean enabled) throws IllegalAccessException {
/* 47 */     if (this.currentValue != enabled) {
/*    */       
/* 49 */       boolean result = enabled ? CraftingManager.func_77594_a().func_77592_b().addAll((Collection<? extends IRecipe>)getRecipes()) : CraftingManager.func_77594_a().func_77592_b().removeAll((Collection<?>)getRecipes());
/* 50 */       if (TFCOptions.enableDebugMode) TerraFirmaCraft.LOG.info("Conversion option {} changed from {} to {}. Result: {}", new Object[] { this.name, Boolean.valueOf(this.currentValue), Boolean.valueOf(enabled), Boolean.valueOf(result) }); 
/* 51 */       this.field.setBoolean(null, enabled);
/* 52 */       this.currentValue = enabled;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean inConfig() {
/* 58 */     return this.ourConfigValue;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isAplied() {
/* 63 */     return this.currentValue;
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadFromConfig() throws IllegalAccessException {
/* 68 */     this.ourConfigValue = this.cfg.getBoolean(this.name, this.cat, this.defaultValue, "");
/* 69 */     apply(this.ourConfigValue);
/*    */   }
/*    */   
/*    */   public abstract ImmutableList<IRecipe> getRecipes();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Config\SyncingOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */