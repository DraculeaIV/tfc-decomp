/*    */ package com.bioxx.tfc.Render.Models;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelIngotPile
/*    */   extends ModelBase
/*    */ {
/* 11 */   public ModelRendererTFC[] renderer = new ModelRendererTFC[64];
/*    */ 
/*    */   
/*    */   public ModelIngotPile() {
/* 15 */     for (int n = 0; n < 64; n++) {
/* 16 */       this.renderer[n] = new ModelRendererTFC(this, 0, 0);
/* 17 */       int m = (n + 8) / 8;
/* 18 */       float x = (n % 4) * 0.25F;
/* 19 */       float y = (m - 1) * 0.125F;
/* 20 */       float z = 0.0F;
/*    */       
/* 22 */       if (n % 8 >= 4) z = 0.5F;
/*    */       
/* 24 */       (this.renderer[n]).field_78804_l.add(new ModelIngot(this.renderer[n], (this.renderer[n]).field_78803_o, (this.renderer[n]).field_78813_p));
/* 25 */       (this.renderer[n]).field_82908_p = y;
/* 26 */       if (m % 2 == 1) {
/* 27 */         (this.renderer[n]).field_78796_g = 1.56F;
/* 28 */         (this.renderer[n]).field_82906_o = x;
/* 29 */         (this.renderer[n]).field_82907_q = z + 0.5F;
/*    */       } else {
/* 31 */         (this.renderer[n]).field_82906_o = z;
/* 32 */         (this.renderer[n]).field_82907_q = x;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderIngots(int i) {
/* 39 */     for (int n = 0; n < i; n++)
/*    */     {
/* 41 */       this.renderer[n].func_78785_a(0.03125F);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelIngotPile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */