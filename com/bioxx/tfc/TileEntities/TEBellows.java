/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.api.TileEntities.TEFireEntity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TEBellows
/*     */   extends NetworkTileEntity
/*     */ {
/*  16 */   private static final int[][] BLOCK_MAP = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
/*     */   
/*     */   public boolean shouldBlow;
/*     */   
/*     */   public int blowTimer;
/*     */   
/*     */   public int blowDirection;
/*     */   
/*     */   public void func_145845_h() {
/*  25 */     if (this.shouldBlow)
/*     */     {
/*  27 */       if (this.blowDirection == 0) {
/*     */         
/*  29 */         this.blowTimer++;
/*  30 */         if (this.field_145850_b.field_72995_K)
/*  31 */           generateSmoke(); 
/*  32 */         if (this.blowTimer == 5) {
/*     */           
/*  34 */           this.blowDirection = 1;
/*  35 */           if (!this.field_145850_b.field_72995_K) {
/*  36 */             giveAir();
/*     */           }
/*     */         } 
/*     */       } else {
/*     */         
/*  41 */         this.blowTimer--;
/*  42 */         if (this.blowTimer == -3) {
/*     */           
/*  44 */           this.blowDirection = 0;
/*  45 */           this.shouldBlow = false;
/*  46 */           this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/*  56 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateSmoke() {
/*  61 */     int meta = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*  62 */     int x = BLOCK_MAP[meta][0];
/*  63 */     int z = BLOCK_MAP[meta][1];
/*  64 */     Random random = new Random();
/*     */     
/*  66 */     float f = this.field_145851_c + x + 0.5F;
/*  67 */     float f1 = this.field_145848_d + 0.1F + random.nextFloat() * 6.0F / 16.0F;
/*  68 */     float f2 = this.field_145849_e + z + 0.5F;
/*     */     
/*  70 */     float f4 = random.nextFloat() * 0.6F;
/*  71 */     float f5 = random.nextFloat() * -0.6F;
/*     */     
/*  73 */     this.field_145850_b.func_72869_a("smoke", (f + f4 - 0.3F), f1, (f2 + f5 + 0.3F), 0.0D, 0.0D, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void giveAir() {
/*  78 */     int meta = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*  79 */     int x = BLOCK_MAP[meta][0];
/*  80 */     int z = BLOCK_MAP[meta][1];
/*  81 */     if (this.field_145850_b.func_72899_e(this.field_145851_c + x, this.field_145848_d, this.field_145849_e + z)) {
/*     */       
/*  83 */       TileEntity te = this.field_145850_b.func_147438_o(this.field_145851_c + x, this.field_145848_d, this.field_145849_e + z);
/*  84 */       TileEntity te2 = this.field_145850_b.func_147438_o(this.field_145851_c + x, this.field_145848_d - 1, this.field_145849_e + z);
/*  85 */       TEFireEntity tileentityfirepit = null;
/*     */       
/*  87 */       if (te instanceof TEFireEntity) {
/*  88 */         tileentityfirepit = (TEFireEntity)te;
/*  89 */       } else if (te2 instanceof TEForge) {
/*  90 */         tileentityfirepit = (TEFireEntity)te2;
/*     */       } 
/*  92 */       if (tileentityfirepit != null) {
/*  93 */         tileentityfirepit.receiveAirFromBellows();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 100 */     super.func_145839_a(nbt);
/* 101 */     this.shouldBlow = nbt.func_74767_n("shouldBlow");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 107 */     super.func_145841_b(nbt);
/* 108 */     nbt.func_74757_a("shouldBlow", this.shouldBlow);
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 113 */     this.shouldBlow = nbt.func_74767_n("shouldBlow");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createDataNBT(NBTTagCompound nbt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 130 */     nbt.func_74757_a("shouldBlow", this.shouldBlow);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEBellows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */