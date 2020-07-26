/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import net.minecraft.client.model.ModelSheep1;
/*     */ import net.minecraft.entity.Entity;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelSheep1TFC
/*     */   extends ModelSheep1
/*     */ {
/*     */   public void func_78088_a(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/* 207 */     func_78087_a(par2, par3, par4, par5, par6, par7, entity);
/*     */     
/* 209 */     float percent = TFC_Core.getPercentGrown((IAnimal)entity);
/* 210 */     float ageScale = 2.0F - percent;
/* 211 */     float ageHeadScale = (float)Math.pow((1.0F / ageScale), 0.66D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     GL11.glPushMatrix();
/*     */     
/* 220 */     GL11.glTranslatef(0.0F, 0.75F - 0.75F * percent, 0.0F);
/* 221 */     GL11.glScalef(ageHeadScale, ageHeadScale, ageHeadScale);
/* 222 */     GL11.glTranslatef(0.0F, (ageScale - 1.0F) * -0.125F, 0.1875F - 0.1875F * percent);
/*     */ 
/*     */     
/* 225 */     this.field_78150_a.func_78785_a(par7);
/*     */     
/* 227 */     GL11.glPopMatrix();
/* 228 */     GL11.glPushMatrix();
/* 229 */     GL11.glTranslatef(0.0F, 0.75F - 0.75F * percent, 0.0F);
/* 230 */     GL11.glScalef(1.0F / ageScale, 1.0F / ageScale, 1.0F / ageScale);
/* 231 */     this.field_78148_b.func_78785_a(par7);
/* 232 */     this.field_78149_c.func_78785_a(par7);
/* 233 */     this.field_78146_d.func_78785_a(par7);
/* 234 */     this.field_78147_e.func_78785_a(par7);
/* 235 */     this.field_78144_f.func_78785_a(par7);
/* 236 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelSheep1TFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */