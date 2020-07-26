/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ public class TEWoodConstruct
/*     */   extends NetworkTileEntity
/*     */ {
/*  15 */   public byte[] woodTypes = new byte[192];
/*     */   public BitSet data;
/*  17 */   public static int plankDetailLevel = 8;
/*     */ 
/*     */   
/*  20 */   public boolean[] solidCheck = new boolean[48];
/*     */ 
/*     */   
/*     */   public TEWoodConstruct() {
/*  24 */     this.data = new BitSet(192);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canUpdate() {
/*  59 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/*  64 */     for (int i = 0; i < 192; i++) {
/*     */       
/*  66 */       if (this.data.get(i)) {
/*     */         
/*  68 */         this.data.clear(i);
/*  69 */         ItemStack stack = new ItemStack(TFCItems.singlePlank, 1, this.woodTypes[i]);
/*  70 */         EntityItem e = new EntityItem(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e, stack);
/*  71 */         e.field_145804_b = 5;
/*  72 */         this.field_145850_b.func_72838_d((Entity)e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ItemStack> getDrops() {
/*  79 */     List<ItemStack> list = new ArrayList<ItemStack>();
/*  80 */     for (int i = 0; i < 192; i++) {
/*     */       
/*  82 */       if (this.data.get(i)) {
/*     */         
/*  84 */         ItemStack stack = new ItemStack(TFCItems.singlePlank, 1, this.woodTypes[i]);
/*  85 */         list.add(stack);
/*     */       } 
/*     */     } 
/*  88 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public static BitSet fromByteArray(byte[] bytes) {
/*  93 */     BitSet bits = new BitSet(192);
/*  94 */     for (int i = 0; i < bytes.length * 8; i++) {
/*     */       
/*  96 */       if ((bytes[bytes.length - i / 8 - 1] & 1 << i % 8) > 0)
/*  97 */         bits.set(i); 
/*     */     } 
/*  99 */     return bits;
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] toByteArray(BitSet bits) {
/* 104 */     byte[] bytes = new byte[bits.length() / 8 + 1];
/* 105 */     for (int i = 0; i < bits.length(); i++) {
/*     */       
/* 107 */       if (bits.get(i))
/* 108 */         bytes[bytes.length - i / 8 - 1] = (byte)(bytes[bytes.length - i / 8 - 1] | 1 << i % 8); 
/*     */     } 
/* 110 */     return bytes;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 116 */     super.func_145839_a(nbt);
/* 117 */     this.woodTypes = nbt.func_74770_j("woodTypes");
/* 118 */     this.data = new BitSet(192);
/* 119 */     this.data.or(fromByteArray(nbt.func_74770_j("data")));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 126 */     super.func_145841_b(nbt);
/* 127 */     nbt.func_74773_a("woodTypes", this.woodTypes);
/* 128 */     nbt.func_74773_a("data", toByteArray(this.data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 135 */     this.woodTypes = nbt.func_74770_j("woodTypes");
/* 136 */     this.data = new BitSet(192);
/* 137 */     this.data.or(fromByteArray(nbt.func_74770_j("data")));
/* 138 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {
/* 144 */     int index = nbt.func_74762_e("index");
/* 145 */     byte meta = nbt.func_74771_c("meta");
/* 146 */     this.data.flip(index);
/* 147 */     this.woodTypes[index] = meta;
/*     */     
/* 149 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 155 */     nbt.func_74773_a("woodTypes", this.woodTypes);
/* 156 */     nbt.func_74773_a("data", toByteArray(this.data));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEWoodConstruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */