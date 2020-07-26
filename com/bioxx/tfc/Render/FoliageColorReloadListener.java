/*    */ package com.bioxx.tfc.Render;
/*    */ 
/*    */ import com.bioxx.tfc.Core.ColorizerFoliageTFC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.client.renderer.texture.TextureUtil;
/*    */ import net.minecraft.client.resources.IResourceManager;
/*    */ import net.minecraft.client.resources.IResourceManagerReloadListener;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class FoliageColorReloadListener
/*    */   implements IResourceManagerReloadListener
/*    */ {
/* 18 */   private static final ResourceLocation TEXTURE = new ResourceLocation("textures/colormap/foliage.png");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_110549_a(IResourceManager par1ResourceManager) {
/*    */     try {
/* 25 */       ColorizerFoliageTFC.setFoliageBiomeColorizer(TextureUtil.func_110986_a(par1ResourceManager, TEXTURE));
/*    */     }
/* 27 */     catch (IOException iOException) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\FoliageColorReloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */