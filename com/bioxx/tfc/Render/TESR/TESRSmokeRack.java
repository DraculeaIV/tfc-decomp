/*    */ package com.bioxx.tfc.Render.TESR;
/*    */ 
/*    */ import com.bioxx.tfc.TileEntities.TESmokeRack;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import org.lwjgl.opengl.GL11;
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
/*    */ public class TESRSmokeRack
/*    */   extends TESRBase
/*    */ {
/*    */   public void renderAt(TESmokeRack te, double d, double d1, double d2, float f) {
/* 24 */     if (te.func_145831_w() != null) {
/*    */       
/* 26 */       EntityItem customitem = new EntityItem(this.field_147501_a.field_147550_f);
/* 27 */       customitem.field_70290_d = 0.0F;
/* 28 */       float blockScale = 1.0F;
/* 29 */       int meta = te.func_145831_w().func_72805_g(te.field_145851_c, te.field_145848_d, te.field_145849_e);
/* 30 */       float offsetX = 0.0F;
/* 31 */       float offsetZ = 0.0F;
/* 32 */       if ((meta & 0x1) == 0) {
/* 33 */         offsetZ = 0.25F;
/*    */       } else {
/* 35 */         offsetX = 0.25F;
/* 36 */       }  if (te.func_70301_a(0) != null) {
/*    */         
/* 38 */         GL11.glPushMatrix();
/* 39 */         GL11.glTranslatef((float)d + 0.5F - offsetX, (float)d1 + 0.0F, (float)d2 + 0.5F - offsetZ);
/*    */         
/* 41 */         if ((meta & 0x1) == 0) {
/* 42 */           GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/*    */         } else {
/* 44 */           GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
/*    */         } 
/* 46 */         GL11.glScalef(blockScale, blockScale, blockScale);
/* 47 */         customitem.func_92058_a(te.func_70301_a(0));
/* 48 */         itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/* 49 */         GL11.glPopMatrix();
/*    */       } 
/* 51 */       if (te.func_70301_a(1) != null) {
/*    */         
/* 53 */         GL11.glPushMatrix();
/* 54 */         GL11.glTranslatef((float)d + 0.5F + offsetX, (float)d1 + 0.0F, (float)d2 + 0.5F + offsetZ);
/*    */         
/* 56 */         if ((meta & 0x1) == 0) {
/* 57 */           GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/*    */         } else {
/* 59 */           GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
/*    */         } 
/* 61 */         GL11.glScalef(blockScale, blockScale, blockScale);
/* 62 */         customitem.func_92058_a(te.func_70301_a(1));
/* 63 */         itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/* 64 */         GL11.glPopMatrix();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawItem(TESmokeRack te, int index, double minX, double maxX, double minZ, double maxZ) {
/* 71 */     if (te.storage[index] != null) {
/*    */       
/* 73 */       float minU = te.storage[index].func_77954_c().func_94209_e();
/* 74 */       float maxU = te.storage[index].func_77954_c().func_94212_f();
/* 75 */       float minV = te.storage[index].func_77954_c().func_94206_g();
/* 76 */       float maxV = te.storage[index].func_77954_c().func_94210_h();
/* 77 */       Tessellator tessellator = Tessellator.field_78398_a;
/* 78 */       tessellator.func_78382_b();
/* 79 */       tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 80 */       tessellator.func_78374_a(minX, 0.0D, maxZ, minU, maxV);
/* 81 */       tessellator.func_78374_a(maxX, 0.0D, maxZ, maxU, maxV);
/* 82 */       tessellator.func_78374_a(maxX, 0.0D, minZ, maxU, minV);
/* 83 */       tessellator.func_78374_a(minX, 0.0D, minZ, minU, minV);
/* 84 */       tessellator.func_78381_a();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147500_a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
/* 91 */     renderAt((TESmokeRack)par1TileEntity, par2, par4, par6, par8);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRSmokeRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */