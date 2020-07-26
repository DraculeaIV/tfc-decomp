/*     */ package com.bioxx.tfc.WAILA;
/*     */ import com.bioxx.tfc.Core.Metal.Alloy;
/*     */ import com.bioxx.tfc.Core.Metal.AlloyMetal;
/*     */ import com.bioxx.tfc.Core.Metal.MetalPair;
/*     */ import com.bioxx.tfc.Core.Metal.MetalRegistry;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TECrucible;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Metal;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mcp.mobius.waila.api.IWailaConfigHandler;
/*     */ import mcp.mobius.waila.api.IWailaDataAccessor;
/*     */ import mcp.mobius.waila.api.IWailaDataProvider;
/*     */ import mcp.mobius.waila.api.IWailaRegistrar;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ 
/*     */ public class WCrucible implements IWailaDataProvider {
/*  27 */   private Map<String, MetalPair> metals = new HashMap<String, MetalPair>();
/*     */   
/*     */   private Alloy currentAlloy;
/*     */ 
/*     */   
/*     */   public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  33 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  39 */     return currenttip;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  46 */     this.metals.clear();
/*  47 */     this.currentAlloy = null;
/*     */     
/*  49 */     if (accessor.getTileEntity() instanceof TECrucible) {
/*     */       
/*  51 */       NBTTagCompound tag = accessor.getNBTData();
/*  52 */       NBTTagList taglist = tag.func_150295_c("Metals", 10);
/*     */ 
/*     */       
/*  55 */       for (int i = 0; i < taglist.func_74745_c(); i++) {
/*     */         
/*  57 */         NBTTagCompound nbt = taglist.func_150305_b(i);
/*  58 */         int id = nbt.func_74762_e("ID");
/*  59 */         float amount = nbt.func_74765_d("Amount");
/*  60 */         float amountF = amount + nbt.func_74760_g("AmountF");
/*  61 */         Metal metal = MetalRegistry.instance.getMetalFromItem(Item.func_150899_d(id));
/*  62 */         addMetal(metal, amountF);
/*     */       } 
/*     */ 
/*     */       
/*  66 */       if (this.currentAlloy != null) {
/*     */         
/*  68 */         String metalTypeUnits = EnumChatFormatting.UNDERLINE + TFC_Core.translate("gui.metal.Unknown");
/*  69 */         if (this.currentAlloy.outputType != null)
/*     */         {
/*  71 */           metalTypeUnits = EnumChatFormatting.UNDERLINE + TFC_Core.translate("gui.metal." + this.currentAlloy.outputType.name.replace(" ", ""));
/*     */         }
/*     */         
/*  74 */         int output = Math.round(this.currentAlloy.outputAmount);
/*  75 */         metalTypeUnits = metalTypeUnits + "· " + TFC_Core.translate("gui.units") + " : " + output;
/*     */         
/*  77 */         currenttip.add(metalTypeUnits);
/*     */         
/*  79 */         for (int c = 0; c < this.currentAlloy.alloyIngred.size(); c++) {
/*     */           
/*  81 */           double m = ((AlloyMetal)this.currentAlloy.alloyIngred.get(c)).metal;
/*  82 */           m = Math.round(m * 100.0D) / 100.0D;
/*  83 */           if (((AlloyMetal)this.currentAlloy.alloyIngred.get(c)).metalType != null)
/*     */           {
/*  85 */             currenttip.add("· " + TFC_Core.translate("gui.metal." + ((AlloyMetal)this.currentAlloy.alloyIngred.get(c)).metalType.name.replace(" ", "")) + " : " + m + "%");
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  92 */       int temperature = tag.func_74762_e("temp");
/*  93 */       String temp = TFC_ItemHeat.getHeatColor(temperature, 2.14748365E9F);
/*  94 */       if (temperature > 0)
/*     */       {
/*  96 */         currenttip.add(temp);
/*     */       }
/*     */     } 
/*     */     
/* 100 */     return currenttip;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 106 */     return currenttip;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {
/* 112 */     if (te != null)
/* 113 */       te.func_145841_b(tag); 
/* 114 */     return tag;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void callbackRegister(IWailaRegistrar reg) {
/* 119 */     reg.registerBodyProvider(new WCrucible(), TECrucible.class);
/* 120 */     reg.registerNBTProvider(new WCrucible(), TECrucible.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addMetal(Metal m, float amt) {
/* 125 */     if (getTotalMetal() + amt <= 3000.0F && !"Unknown".equals(m.name)) {
/*     */       
/* 127 */       if (this.metals.containsKey(m.name)) {
/* 128 */         ((MetalPair)this.metals.get(m.name)).amount += amt;
/*     */       } else {
/* 130 */         this.metals.put(m.name, new MetalPair(m, amt));
/*     */       } 
/* 132 */       updateCurrentAlloy();
/* 133 */       return true;
/*     */     } 
/* 135 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTotalMetal() {
/* 140 */     Iterator<MetalPair> iter = this.metals.values().iterator();
/* 141 */     float totalAmount = 0.0F;
/* 142 */     while (iter.hasNext()) {
/*     */       
/* 144 */       MetalPair m = iter.next();
/* 145 */       if (m != null)
/* 146 */         totalAmount += m.amount; 
/*     */     } 
/* 148 */     return totalAmount;
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateCurrentAlloy() {
/* 153 */     List<AlloyMetal> a = new ArrayList<AlloyMetal>();
/* 154 */     Iterator<MetalPair> iter = this.metals.values().iterator();
/* 155 */     float totalAmount = getTotalMetal();
/* 156 */     while (iter.hasNext()) {
/*     */       
/* 158 */       MetalPair m = iter.next();
/* 159 */       if (m != null) {
/* 160 */         a.add(new AlloyMetal(m.type, m.amount / totalAmount * 100.0F));
/*     */       }
/*     */     } 
/* 163 */     Metal match = AlloyManager.INSTANCE.matchesAlloy(a, Alloy.EnumTier.TierV);
/* 164 */     if (match != null) {
/*     */       
/* 166 */       this.currentAlloy = new Alloy(match, totalAmount);
/* 167 */       this.currentAlloy.alloyIngred = a;
/*     */     }
/*     */     else {
/*     */       
/* 171 */       this.currentAlloy = new Alloy(Global.UNKNOWN, totalAmount);
/* 172 */       this.currentAlloy.alloyIngred = a;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WAILA\WCrucible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */