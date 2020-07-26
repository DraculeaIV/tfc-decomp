/*    */ package com.bioxx.tfc.Render;
/*    */ 
/*    */ import com.bioxx.tfc.Entities.EntityFallingBlockTFC;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class RenderFallingBlock
/*    */   extends Render
/*    */ {
/* 18 */   private final RenderBlocks field_147920_a = new RenderBlocks();
/*    */ 
/*    */   
/*    */   public RenderFallingBlock() {
/* 22 */     this.field_76989_e = 0.5F;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void doRender(EntityFallingBlockTFC entity, double x, double y, double z, float f, float f1) {
/* 32 */     World world = entity.getWorld();
/* 33 */     Block block = entity.getBlock();
/* 34 */     int i = MathHelper.func_76128_c(entity.field_70165_t);
/* 35 */     int j = MathHelper.func_76128_c(entity.field_70163_u);
/* 36 */     int k = MathHelper.func_76128_c(entity.field_70161_v);
/*    */     
/* 38 */     if (block != null && block != world.func_147439_a(i, j, k)) {
/*    */       
/* 40 */       GL11.glPushMatrix();
/* 41 */       GL11.glTranslatef((float)x, (float)y, (float)z);
/* 42 */       func_110777_b((Entity)entity);
/* 43 */       GL11.glDisable(2896);
/*    */       
/* 45 */       this.field_147920_a.func_147775_a(block);
/* 46 */       this.field_147920_a.func_147749_a(block, world, i, j, k, entity.blockMeta);
/*    */       
/* 48 */       GL11.glEnable(2896);
/* 49 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(EntityFallingBlockTFC entity) {
/* 58 */     return TextureMap.field_110575_b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 67 */     return getEntityTexture((EntityFallingBlockTFC)entity);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_76986_a(Entity entity, double x, double y, double z, float f, float f1) {
/* 79 */     doRender((EntityFallingBlockTFC)entity, x, y, z, f, f1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderFallingBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */