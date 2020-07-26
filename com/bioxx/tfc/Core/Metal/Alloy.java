/*     */ package com.bioxx.tfc.Core.Metal;
/*     */ 
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Metal;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Alloy
/*     */ {
/*     */   public Alloy(Metal type, EnumTier tier) {
/*  25 */     this();
/*  26 */     this.outputType = type;
/*  27 */     this.outputAmount = 0.0F;
/*  28 */     this.furnaceTier = tier;
/*     */   }
/*     */ 
/*     */   
/*     */   public Alloy(Metal type, float am) {
/*  33 */     this();
/*  34 */     this.outputType = type;
/*  35 */     this.outputAmount = am;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  40 */   public List<AlloyMetal> alloyIngred = new ArrayList<AlloyMetal>();
/*     */   public Metal outputType;
/*     */   public float outputAmount;
/*     */   
/*     */   public void addIngred(AlloyMetal am) {
/*  45 */     this.alloyIngred.add(am);
/*     */   }
/*     */   protected EnumTier furnaceTier;
/*     */   public Alloy() {}
/*     */   public void addIngred(Metal e, float m) {
/*  50 */     this.alloyIngred.add(new AlloyMetal(e, m));
/*     */   }
/*     */ 
/*     */   
/*     */   public void addIngred(Metal e, float min, float max) {
/*  55 */     this.alloyIngred.add(new AlloyMetalCompare(e, min, max));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matches(Alloy a) {
/*  60 */     Iterator<AlloyMetal> iter = a.alloyIngred.iterator();
/*  61 */     boolean matches = true;
/*  62 */     while (iter.hasNext() && matches) {
/*     */       
/*  64 */       AlloyMetal am = iter.next();
/*  65 */       matches = searchForAlloyMetal(am);
/*     */     } 
/*  67 */     return matches;
/*     */   }
/*     */ 
/*     */   
/*     */   public Alloy matches(List<AlloyMetal> a) {
/*  72 */     Iterator<AlloyMetal> iter = a.iterator();
/*  73 */     boolean matches = true;
/*  74 */     int amount = 0;
/*  75 */     while (iter.hasNext() && matches) {
/*     */       
/*  77 */       AlloyMetal am = iter.next();
/*  78 */       matches = searchForAlloyMetal(am);
/*  79 */       amount = (int)(amount + am.metal);
/*     */     } 
/*     */     
/*  82 */     if (!matches) {
/*  83 */       return null;
/*     */     }
/*  85 */     return new Alloy(this.outputType, amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean searchForAlloyMetal(AlloyMetal am) {
/*  90 */     Iterator<AlloyMetal> iter = this.alloyIngred.iterator();
/*  91 */     while (iter.hasNext()) {
/*     */       
/*  93 */       AlloyMetalCompare amc = (AlloyMetalCompare)iter.next();
/*  94 */       if (amc.compare(am))
/*  95 */         return true; 
/*     */     } 
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPercentForMetal(Metal m) {
/* 102 */     Iterator<AlloyMetal> iter = this.alloyIngred.iterator();
/*     */     
/* 104 */     while (iter.hasNext()) {
/*     */       
/* 106 */       AlloyMetal amc = iter.next();
/* 107 */       if (amc.metalType == m)
/* 108 */         return amc.metal; 
/*     */     } 
/* 110 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public enum EnumTier
/*     */   {
/* 115 */     TierI(1, "Pit Kiln"),
/* 116 */     TierII(2, "Beehive Kiln"),
/* 117 */     TierIII(3, "Bloomery"),
/* 118 */     TierIV(4, "Blast Furnace"),
/* 119 */     TierV(5, "Crucible"),
/* 120 */     TierVI(6), TierVII(7), TierVIII(8), TierIX(9), TierX(10);
/*     */     
/*     */     public final int tier;
/*     */     
/*     */     public final String name;
/*     */     
/*     */     EnumTier(int t) {
/* 127 */       this.tier = t;
/* 128 */       this.name = name();
/*     */     }
/*     */ 
/*     */     
/*     */     EnumTier(int t, String n) {
/* 133 */       this.tier = t;
/* 134 */       this.name = n;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 140 */       return this.name;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void toPacket(DataOutputStream dos) {
/*     */     try {
/* 148 */       if (this.outputType != null) {
/* 149 */         dos.writeUTF(this.outputType.name);
/*     */       } else {
/* 151 */         dos.writeUTF("Unknown");
/*     */       } 
/* 153 */       dos.writeFloat(this.outputAmount);
/* 154 */       dos.writeInt(this.alloyIngred.size());
/* 155 */       for (int i = 0; i < this.alloyIngred.size(); i++)
/*     */       {
/* 157 */         AlloyMetal am = this.alloyIngred.get(i);
/* 158 */         dos.writeUTF(am.metalType.name);
/* 159 */         dos.writeFloat(am.metal);
/*     */       }
/*     */     
/* 162 */     } catch (IOException e) {
/*     */       
/* 164 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Alloy fromPacket(DataInputStream dis) {
/*     */     try {
/* 172 */       this.outputType = MetalRegistry.instance.getMetalFromString(dis.readUTF());
/* 173 */       this.outputAmount = dis.readFloat();
/* 174 */       int size = dis.readInt();
/* 175 */       for (int i = 0; i < size; i++)
/*     */       {
/* 177 */         AlloyMetal am = new AlloyMetal(MetalRegistry.instance.getMetalFromString(dis.readUTF()), dis.readFloat());
/* 178 */         this.alloyIngred.add(am);
/*     */       }
/*     */     
/* 181 */     } catch (IOException e) {
/*     */       
/* 183 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/* 185 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toNBT(NBTTagCompound nbt) {
/* 190 */     nbt.func_74778_a("outputType", this.outputType.name);
/* 191 */     nbt.func_74776_a("outputAmount", this.outputAmount);
/* 192 */     NBTTagList nbtlist = new NBTTagList();
/* 193 */     for (int i = 0; i < this.alloyIngred.size(); i++) {
/*     */       
/* 195 */       NBTTagCompound nbt1 = new NBTTagCompound();
/* 196 */       AlloyMetal am = this.alloyIngred.get(i);
/* 197 */       nbt1.func_74778_a("metalType", am.metalType.name);
/* 198 */       nbt1.func_74776_a("amount", am.metal);
/* 199 */       nbtlist.func_74742_a((NBTBase)nbt1);
/*     */     } 
/* 201 */     nbt.func_74782_a("metalList", (NBTBase)nbtlist);
/*     */   }
/*     */ 
/*     */   
/*     */   public Alloy fromNBT(NBTTagCompound nbt) {
/* 206 */     this.outputType = MetalRegistry.instance.getMetalFromString(nbt.func_74779_i("outputType"));
/* 207 */     this.outputAmount = nbt.func_74760_g("outputAmount");
/* 208 */     NBTTagList nbtlist = nbt.func_150295_c("metalList", 10);
/* 209 */     for (int i = 0; i < nbtlist.func_74745_c(); i++) {
/*     */       
/* 211 */       NBTTagCompound nbt1 = nbtlist.func_150305_b(i);
/* 212 */       AlloyMetal am = new AlloyMetal(MetalRegistry.instance.getMetalFromString(nbt1.func_74779_i("metalType")), nbt1.func_74760_g("amount"));
/* 213 */       this.alloyIngred.add(am);
/*     */     } 
/* 215 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumTier getFurnaceTier() {
/* 220 */     return this.furnaceTier;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Metal\Alloy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */