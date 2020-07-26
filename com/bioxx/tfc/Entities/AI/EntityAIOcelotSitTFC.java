/*     */ package com.bioxx.tfc.Entities.AI;
/*     */ 
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityOcelotTFC;
/*     */ import com.bioxx.tfc.TileEntities.TEChest;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockBed;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityAIOcelotSitTFC
/*     */   extends EntityAIBase
/*     */ {
/*     */   private final EntityOcelotTFC ocelot;
/*     */   private final double field_151491_b;
/*     */   private int field_151492_c;
/*     */   private int field_151489_d;
/*     */   private int field_151490_e;
/*     */   private int field_151487_f;
/*     */   private int field_151488_g;
/*     */   private int field_151494_h;
/*     */   
/*     */   public EntityAIOcelotSitTFC(EntityOcelotTFC p_i45315_1_, double p_i45315_2_) {
/*  27 */     this.ocelot = p_i45315_1_;
/*  28 */     this.field_151491_b = p_i45315_2_;
/*  29 */     func_75248_a(5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75250_a() {
/*  37 */     return (this.ocelot.func_70909_n() && !this.ocelot.func_70906_o() && this.ocelot.func_70681_au().nextDouble() <= 0.006500000134110451D && func_151485_f());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/*  45 */     return (this.field_151492_c <= this.field_151490_e && this.field_151489_d <= 60 && func_151486_a(this.ocelot.field_70170_p, this.field_151487_f, this.field_151488_g, this.field_151494_h));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75249_e() {
/*  53 */     this.ocelot.func_70661_as().func_75492_a(this.field_151487_f + 0.5D, (this.field_151488_g + 1), this.field_151494_h + 0.5D, this.field_151491_b);
/*  54 */     this.field_151492_c = 0;
/*  55 */     this.field_151489_d = 0;
/*  56 */     this.field_151490_e = this.ocelot.func_70681_au().nextInt(this.ocelot.func_70681_au().nextInt(1200) + 1200) + 1200;
/*  57 */     this.ocelot.func_70907_r().func_75270_a(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75251_c() {
/*  65 */     this.ocelot.func_70904_g(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75246_d() {
/*  73 */     this.field_151492_c++;
/*  74 */     this.ocelot.func_70907_r().func_75270_a(false);
/*     */     
/*  76 */     if (this.ocelot.func_70092_e(this.field_151487_f, (this.field_151488_g + 1), this.field_151494_h) > 1.0D) {
/*     */       
/*  78 */       this.ocelot.func_70904_g(false);
/*  79 */       this.ocelot.func_70661_as().func_75492_a(this.field_151487_f + 0.5D, (this.field_151488_g + 1), this.field_151494_h + 0.5D, this.field_151491_b);
/*  80 */       this.field_151489_d++;
/*     */     }
/*  82 */     else if (!this.ocelot.func_70906_o()) {
/*     */       
/*  84 */       this.ocelot.func_70904_g(true);
/*     */     }
/*     */     else {
/*     */       
/*  88 */       this.field_151489_d--;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean func_151485_f() {
/*  94 */     int i = (int)this.ocelot.field_70163_u;
/*  95 */     double d0 = 2.147483647E9D;
/*     */     
/*  97 */     for (int j = (int)this.ocelot.field_70165_t - 8; j < this.ocelot.field_70165_t + 8.0D; j++) {
/*     */       
/*  99 */       for (int k = (int)this.ocelot.field_70161_v - 8; k < this.ocelot.field_70161_v + 8.0D; k++) {
/*     */         
/* 101 */         if (func_151486_a(this.ocelot.field_70170_p, j, i, k) && this.ocelot.field_70170_p.func_147437_c(j, i + 1, k)) {
/*     */           
/* 103 */           double d1 = this.ocelot.func_70092_e(j, i, k);
/*     */           
/* 105 */           if (d1 < d0) {
/*     */             
/* 107 */             this.field_151487_f = j;
/* 108 */             this.field_151488_g = i;
/* 109 */             this.field_151494_h = k;
/* 110 */             d0 = d1;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 116 */     return (d0 < 2.147483647E9D);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean func_151486_a(World p_151486_1_, int p_151486_2_, int p_151486_3_, int p_151486_4_) {
/* 121 */     Block block = p_151486_1_.func_147439_a(p_151486_2_, p_151486_3_, p_151486_4_);
/* 122 */     int l = p_151486_1_.func_72805_g(p_151486_2_, p_151486_3_, p_151486_4_);
/*     */     
/* 124 */     if (block == TFCBlocks.chest) {
/*     */       
/* 126 */       TEChest tileentitychest = (TEChest)p_151486_1_.func_147438_o(p_151486_2_, p_151486_3_, p_151486_4_);
/*     */       
/* 128 */       if (tileentitychest.field_145987_o < 1)
/*     */       {
/* 130 */         return true;
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 135 */       if (block == Blocks.field_150470_am)
/*     */       {
/* 137 */         return true;
/*     */       }
/*     */       
/* 140 */       if (block == Blocks.field_150324_C && !BlockBed.func_149975_b(l))
/*     */       {
/* 142 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 146 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\AI\EntityAIOcelotSitTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */