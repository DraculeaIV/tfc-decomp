/*    */ package com.bioxx.tfc.Render;
/*    */ 
/*    */ import com.bioxx.tfc.Entities.Mobs.EntitySkeletonTFC;
/*    */ import com.bioxx.tfc.Items.ItemQuiver;
/*    */ import com.bioxx.tfc.Render.Models.ModelSkeletonTFC;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.renderer.entity.RenderBiped;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSkeletonTFC
/*    */   extends RenderBiped
/*    */ {
/* 23 */   private static final ResourceLocation SKELETON_TEXTURE = new ResourceLocation("textures/entity/skeleton/skeleton.png");
/* 24 */   private static final ResourceLocation WITHER_TEXTURE = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
/* 25 */   public static final RenderQuiver QUIVER_RENDER = new RenderQuiver();
/* 26 */   public static ItemStack quiver = new ItemStack(TFCItems.quiver, 1, 1);
/* 27 */   public static ItemStack ammo = ((ItemQuiver)TFCItems.quiver).addItem(quiver, new ItemStack(TFCItems.arrow, 16, 0));
/*    */ 
/*    */   
/*    */   public RenderSkeletonTFC() {
/* 31 */     super((ModelBiped)new ModelSkeletonTFC(), 0.5F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void scaleRender(EntitySkeletonTFC par1EntitySkeleton, float par2) {
/* 36 */     if (par1EntitySkeleton.getSkeletonType() == 1) {
/* 37 */       GL11.glScalef(1.2F, 1.2F, 1.2F);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_82422_c() {
/* 43 */     GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation getTextureLocation(EntitySkeletonTFC par1EntitySkeleton) {
/* 48 */     return (par1EntitySkeleton.getSkeletonType() == 1) ? WITHER_TEXTURE : SKELETON_TEXTURE;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityLiving par1EntityLiving) {
/* 54 */     return getTextureLocation((EntitySkeletonTFC)par1EntityLiving);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityLivingBase par1EntityLivingBase, float par2) {
/* 65 */     QUIVER_RENDER.render(par1EntityLivingBase, quiver);
/* 66 */     scaleRender((EntitySkeletonTFC)par1EntityLivingBase, par2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity par1Entity) {
/* 72 */     return getTextureLocation((EntitySkeletonTFC)par1Entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderSkeletonTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */