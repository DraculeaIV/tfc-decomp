/*     */ package com.bioxx.tfc.WAILA;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityCowTFC;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import java.util.List;
/*     */ import mcp.mobius.waila.api.IWailaConfigHandler;
/*     */ import mcp.mobius.waila.api.IWailaEntityAccessor;
/*     */ import mcp.mobius.waila.api.IWailaEntityProvider;
/*     */ import mcp.mobius.waila.api.IWailaRegistrar;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WMobs
/*     */   implements IWailaEntityProvider
/*     */ {
/*     */   public Entity getWailaOverride(IWailaEntityAccessor accessor, IWailaConfigHandler config) {
/*  27 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getWailaHead(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor, IWailaConfigHandler config) {
/*  33 */     String head = currenttip.get(0);
/*     */     
/*  35 */     if (entity instanceof IAnimal) {
/*     */       
/*  37 */       IAnimal animal = (IAnimal)entity;
/*     */       
/*  39 */       if (config.getConfig("tfc.baby"))
/*     */       {
/*  41 */         if (!animal.isAdult()) {
/*  42 */           head = EnumChatFormatting.WHITE + TFC_Core.translate("gui.baby") + " " + head;
/*     */         }
/*     */       }
/*  45 */       if (config.getConfig("tfc.gender"))
/*     */       {
/*  47 */         if (animal.getGender() == IAnimal.GenderEnum.MALE) {
/*  48 */           head = head + " ♂";
/*  49 */         } else if (animal.getGender() == IAnimal.GenderEnum.FEMALE) {
/*  50 */           head = head + " ♀";
/*     */         } 
/*     */       }
/*     */     } 
/*  54 */     currenttip.set(0, head);
/*     */     
/*  56 */     return currenttip;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getWailaBody(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor, IWailaConfigHandler config) {
/*  62 */     IAnimal animal = (IAnimal)entity;
/*  63 */     NBTTagCompound nbt = accessor.getNBTData();
/*     */     
/*  65 */     int familiarity = nbt.func_74762_e("Familiarity");
/*  66 */     boolean familiarizedToday = animal.getFamiliarizedToday();
/*  67 */     boolean pregnant = animal.isPregnant();
/*     */     
/*  69 */     if (pregnant)
/*     */     {
/*  71 */       currenttip.add(TFC_Core.translate("entity.pregnant") + " : " + TFC_Time.getDateStringFromHours(animal.getDueDay() * 24));
/*     */     }
/*     */     
/*  74 */     if (config.getConfig("tfc.familiarToday") && animal.canFamiliarize())
/*     */     {
/*  76 */       if (familiarizedToday) {
/*  77 */         currenttip.add(TFC_Core.translate("gui.familiarized") + EnumChatFormatting.GREEN.toString() + " ✔");
/*     */       } else {
/*  79 */         currenttip.add(TFC_Core.translate("gui.familiarized") + EnumChatFormatting.RED.toString() + " ✘");
/*     */       } 
/*     */     }
/*  82 */     if (config.getConfig("tfc.familiarity"))
/*     */     {
/*  84 */       currenttip.add(TFC_Core.translate("gui.familiarity") + " : " + familiarity + "%");
/*     */     }
/*     */     
/*  87 */     if (animal instanceof EntityCowTFC && animal.getGender() == IAnimal.GenderEnum.FEMALE && animal.isAdult()) {
/*     */       
/*  89 */       EntityCowTFC cow = (EntityCowTFC)entity;
/*  90 */       if (cow.isMilkable()) {
/*  91 */         currenttip.add(TFC_Core.translate("fluid.milk") + EnumChatFormatting.GREEN.toString() + " ✔");
/*     */       } else {
/*  93 */         currenttip.add(TFC_Core.translate("fluid.milk") + EnumChatFormatting.RED.toString() + " ✘");
/*     */       } 
/*     */     } 
/*  96 */     return currenttip;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getWailaTail(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor, IWailaConfigHandler config) {
/* 102 */     return currenttip;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTTagCompound getNBTData(EntityPlayerMP player, Entity ent, NBTTagCompound tag, World world) {
/* 108 */     return tag;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void callbackRegister(IWailaRegistrar reg) {
/* 113 */     reg.addConfig("TerraFirmaCraft", "tfc.baby");
/* 114 */     reg.addConfig("TerraFirmaCraft", "tfc.gender");
/* 115 */     reg.addConfig("TerraFirmaCraft", "tfc.familiarToday");
/* 116 */     reg.addConfig("TerraFirmaCraft", "tfc.familiarity", false);
/*     */     
/* 118 */     reg.registerHeadProvider(new WMobs(), IAnimal.class);
/* 119 */     reg.registerBodyProvider(new WMobs(), IAnimal.class);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WAILA\WMobs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */