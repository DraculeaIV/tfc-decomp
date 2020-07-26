/*    */ package com.bioxx.tfc.Render.Models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class ModelStand
/*    */   extends ModelBiped
/*    */ {
/*    */   public ModelStand() {
/* 11 */     super(0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public ModelStand(float par1) {
/* 16 */     super(par1, 0.0F, 64, 32);
/*    */   }
/*    */ 
/*    */   
/*    */   public ModelStand(float par1, float par2, int par3, int par4) {
/* 21 */     super(par1, par2, par3, par4);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
/* 27 */     this.field_78114_d.field_78796_g = 0.0F;
/* 28 */     this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
/* 29 */     this.field_78112_f.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F + 0.001F;
/* 30 */     this.field_78113_g.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F + 0.001F;
/* 31 */     this.field_78112_f.field_78808_h = 0.0F;
/* 32 */     this.field_78113_g.field_78808_h = 0.0F;
/* 33 */     this.field_78123_h.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2 + 0.001F;
/* 34 */     this.field_78124_i.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 35 */     this.field_78123_h.field_78796_g = 0.0F;
/* 36 */     this.field_78124_i.field_78796_g = 0.0F;
/*    */     
/* 38 */     if (this.field_78119_l != 0)
/*    */     {
/* 40 */       this.field_78113_g.field_78795_f = this.field_78113_g.field_78795_f * 0.5F - 0.31415927F * this.field_78119_l;
/*    */     }
/*    */     
/* 43 */     if (this.field_78120_m != 0)
/*    */     {
/* 45 */       this.field_78112_f.field_78795_f = this.field_78112_f.field_78795_f * 0.5F - 0.31415927F * this.field_78120_m;
/*    */     }
/*    */     
/* 48 */     this.field_78112_f.field_78796_g = 0.0F;
/* 49 */     this.field_78113_g.field_78796_g = 0.0F;
/*    */ 
/*    */ 
/*    */     
/* 53 */     if (this.field_78095_p > -9990.0F) {
/*    */ 
/*    */       
/* 56 */       this.field_78115_e.field_78796_g = 0.0F;
/* 57 */       this.field_78112_f.field_78798_e = MathHelper.func_76126_a(this.field_78115_e.field_78796_g) * 5.0F;
/* 58 */       this.field_78112_f.field_78800_c = -MathHelper.func_76134_b(this.field_78115_e.field_78796_g) * 5.0F;
/* 59 */       this.field_78113_g.field_78798_e = -MathHelper.func_76126_a(this.field_78115_e.field_78796_g) * 5.0F;
/* 60 */       this.field_78113_g.field_78800_c = MathHelper.func_76134_b(this.field_78115_e.field_78796_g) * 5.0F;
/*    */       
/* 62 */       this.field_78123_h.field_78798_e = MathHelper.func_76126_a(this.field_78115_e.field_78796_g) * 1.9F;
/* 63 */       this.field_78123_h.field_78800_c = -MathHelper.func_76134_b(this.field_78115_e.field_78796_g) * 1.9F;
/* 64 */       this.field_78124_i.field_78798_e = -MathHelper.func_76126_a(this.field_78115_e.field_78796_g) * 1.9F;
/* 65 */       this.field_78124_i.field_78800_c = MathHelper.func_76134_b(this.field_78115_e.field_78796_g) * 1.9F;
/*    */       
/* 67 */       this.field_78123_h.field_78796_g += this.field_78115_e.field_78796_g;
/* 68 */       this.field_78124_i.field_78796_g += this.field_78115_e.field_78796_g;
/*    */       
/* 70 */       this.field_78112_f.field_78796_g += this.field_78115_e.field_78796_g;
/* 71 */       this.field_78113_g.field_78796_g += this.field_78115_e.field_78796_g;
/*    */     } 
/*    */ 
/*    */     
/* 75 */     this.field_78115_e.field_78795_f = 0.0F;
/* 76 */     this.field_78123_h.field_78797_d = 12.0F;
/* 77 */     this.field_78124_i.field_78797_d = 12.0F;
/* 78 */     this.field_78116_c.field_78797_d = 0.0F;
/* 79 */     this.field_78114_d.field_78797_d = 0.0F;
/*    */     
/* 81 */     this.field_78116_c.field_78796_g = 0.0F;
/* 82 */     this.field_78114_d.field_78796_g = 0.0F;
/* 83 */     this.field_78124_i.field_78795_f += 0.01F;
/* 84 */     this.field_78123_h.field_78795_f += 0.01F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelStand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */